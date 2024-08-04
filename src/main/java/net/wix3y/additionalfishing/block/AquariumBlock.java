package net.wix3y.additionalfishing.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.*;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.wix3y.additionalfishing.blockentity.AquariumBlockEntity;
import net.wix3y.additionalfishing.tags.FishingTags;
import org.jetbrains.annotations.Nullable;

public class AquariumBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final IntProperty PLANTS;
    public static final IntProperty FISH;
    public static final DirectionProperty FACING;
    private static final VoxelShape RAYCAST_SHAPE;
    private static final VoxelShape LEVEL_TO_COLLISION_SHAPE;

    public AquariumBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(PLANTS, 0).with(FISH, 0).with(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getRaycastShape(BlockState state, BlockView world, BlockPos pos) {
        return RAYCAST_SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return LEVEL_TO_COLLISION_SHAPE;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AquariumBlockEntity(pos, state);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(PLANTS, FISH, FACING);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)state.with(FACING, rotation.rotate((Direction)state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation((Direction)state.get(FACING)));
    }

    protected boolean isEntityTouchingFluid(BlockState state, BlockPos pos, Entity entity) {
        return entity.getY() < (double)pos.getY() + 0.8 && entity.getBoundingBox().maxY > (double)pos.getY() + 0.25;
    }

    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity.isOnFire() && this.isEntityTouchingFluid(state, pos, entity)) {
            if (!world.isClient) {
                entity.extinguish();
            }
            else {
                world.playSoundAtBlockCenter(pos, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
            }

        }

    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.isOf(newState.getBlock())) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof AquariumBlockEntity) {

                ItemStack fish = ((AquariumBlockEntity) blockEntity).getStack(4);
                if (fish.getItem() instanceof EntityBucketItem) {
                    ((EntityBucketItem) fish.getItem()).onEmptied(null, world, fish, pos);
                }

                ((AquariumBlockEntity) blockEntity).getInventory().set(4, ItemStack.EMPTY);
                ItemScatterer.spawn(world, pos, (AquariumBlockEntity)blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);

        if (world.getBlockEntity(pos) instanceof AquariumBlockEntity blockEntity) {

            if (itemStack.isIn(FishingTags.AQUARIUM_PLANTS) && state.get(PLANTS) < 4) {
                return onUseInsertPlant(blockEntity, itemStack, state, world, pos, player);
            }

            else if (itemStack.getItem() instanceof EntityBucketItem && state.get(FISH) < 1) {
                return onUseInsertFish(blockEntity, itemStack, state, world, pos, player, hand);
            }

            else if (itemStack.isOf(Items.WATER_BUCKET) && state.get(FISH) > 0) {
                ItemStack fish = blockEntity.getStack(4);
                if (fish != null) {
                    return onUseExtractFish(blockEntity, state, world, pos, player, hand);
                }
            }

            else if (itemStack.isEmpty() && state.get(PLANTS) > 0) {
                ItemStack plant = blockEntity.getStack(state.get(PLANTS));
                if (plant != null) {
                    return onUseExtractPlant(blockEntity, state, world, pos, player, hand);
                }
            }
        }
        return ActionResult.PASS;
    }

    private ActionResult onUseInsertPlant(AquariumBlockEntity blockEntity, ItemStack itemStack, BlockState state, World world, BlockPos pos, PlayerEntity player) {
        blockEntity.insertPlant(itemStack, state.get(PLANTS));

        if (!world.isClient()) {
            world.setBlockState(pos, state.with(PLANTS, state.get(PLANTS) + 1), 3);
            world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
        }

        if (world.isClient) {
            world.playSoundAtBlockCenter(pos, SoundEvents.BLOCK_CORAL_BLOCK_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
        }

        return ActionResult.success(world.isClient);
    }

    private ActionResult onUseExtractPlant(AquariumBlockEntity blockEntity, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand) {
        blockEntity.extractPlant(player, hand, state.get(PLANTS)-1);

        if (world.isClient) {
            player.playSound(SoundEvents.BLOCK_CORAL_BLOCK_BREAK, 1.0F, 1.0F);
        }

        if (!world.isClient()) {
            world.setBlockState(pos, state.with(PLANTS, state.get(PLANTS) - 1), 3);
            world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
        }

        return ActionResult.success(world.isClient);
    }

    private ActionResult onUseInsertFish(AquariumBlockEntity blockEntity, ItemStack itemStack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand) {
        blockEntity.insertFish(player, hand, itemStack);

        if (!world.isClient()) {
            world.setBlockState(pos, state.with(FISH, state.get(FISH) + 1), 3);
            world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
        }

        if (world.isClient) {
            player.playSound(SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }

        return ActionResult.success(world.isClient);
    }

    private ActionResult onUseExtractFish(AquariumBlockEntity blockEntity, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand) {
        blockEntity.extractFish(player, hand);

        if (world.isClient) {
            player.playSound(SoundEvents.ITEM_BUCKET_FILL_FISH, 1.0F, 1.0F);
        }

        if (!world.isClient()) {
            world.setBlockState(pos, state.with(FISH, 0), 3);
            world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
        }

        return ActionResult.success(world.isClient);
    }

    static {
        FISH = IntProperty.of("fish", 0, 1);
        PLANTS = IntProperty.of("plants", 0, 4);
        FACING = HorizontalFacingBlock.FACING;

        RAYCAST_SHAPE = VoxelShapes.fullCube();
        LEVEL_TO_COLLISION_SHAPE = VoxelShapes.combineAndSimplify(RAYCAST_SHAPE, Block.createCuboidShape(2.0, (double)Math.max(2, 1), 2.0, 14.0, 16.0, 14.0), BooleanBiFunction.ONLY_FIRST);
    }
}
