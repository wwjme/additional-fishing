package net.wix3y.additionalfishing.blockentity.client;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AxolotlEntity;
import net.minecraft.entity.passive.CodEntity;
import net.minecraft.entity.passive.SalmonEntity;
import net.minecraft.entity.passive.TropicalFishEntity;
import net.minecraft.item.EntityBucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DyeColor;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.wix3y.additionalfishing.block.AquariumBlock;
import net.wix3y.additionalfishing.blockentity.AquariumBlockEntity;
import net.wix3y.additionalfishing.entity.custom.AnglerfishEntity;
import net.wix3y.additionalfishing.entity.custom.ArcticCharEntity;
import net.wix3y.additionalfishing.entity.custom.BassEntity;
import net.wix3y.additionalfishing.entity.custom.PiranhaEntity;
import net.wix3y.additionalfishing.mixin.TropicalFishMixin;
import net.wix3y.additionalfishing.util.BucketType;

public class AquariumBlockEntityRenderer implements BlockEntityRenderer<AquariumBlockEntity> {
    private final BlockRenderManager manager;
    private final EntityRenderDispatcher dispatcher;
    public AquariumBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        this.manager = context.getRenderManager();
        this.dispatcher = context.getEntityRenderDispatcher();
    }

    @Override
    public void render(AquariumBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        DefaultedList<ItemStack> stack = blockEntity.getInventory();
        World world = blockEntity.getWorld();
        BlockState blockState = blockEntity.getCachedState();

        renderPlants(blockEntity, stack, matrices, vertexConsumers, overlay);
        renderFish(blockState, stack, matrices, vertexConsumers, world, light);
    }

    private float getDirection(BlockState blockState) {
        float rotation = 0;
        if (blockState.getBlock() instanceof AquariumBlock) {
            switch (blockState.get(AquariumBlock.FACING)) {
                case NORTH -> {
                    rotation = 180.0F;
                }
                case SOUTH -> {
                    rotation = 0.0F;
                }
                case EAST -> {
                    rotation = 90.0F;
                }
                case WEST -> {
                    rotation = 270.0F;
                }
            }
        }
        return rotation;
    }

    private Entity getFishEntity(World world, ItemStack itemStack) {
        Item fishBucket = itemStack.getItem();

        if (fishBucket instanceof EntityBucketItem) {
            EntityType<?> type = ((BucketType) fishBucket).getEntityType();
            Entity fish = type.create(world);

            if (fish instanceof AxolotlEntity axolotl && itemStack.getNbt() != null) {
                if (itemStack.getNbt().contains("Variant")) {
                    axolotl.setVariant(AxolotlEntity.Variant.byId(itemStack.getNbt().getInt("Variant")));
                }
            }

            if (fish instanceof TropicalFishEntity && itemStack.getNbt() != null) {
                if (itemStack.getNbt().contains("BucketVariantTag")) {
                    fish.readNbt(itemStack.getOrCreateNbt());

                    int id = itemStack.getNbt().getInt("BucketVariantTag");

                    DyeColor pattern = TropicalFishEntity.getPatternDyeColor(id);
                    DyeColor base = TropicalFishEntity.getBaseDyeColor(id);

                    TropicalFishEntity.Variant variant = new TropicalFishEntity.Variant(TropicalFishEntity.getVariety(id), base, pattern);
                    ((TropicalFishMixin) fish).setTropicalFishVariantMixin(variant.getId());
                }
            }

            return fish;
        }
        return null;
    }

    private void renderPlants(AquariumBlockEntity blockEntity, DefaultedList<ItemStack> stack, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int overlay) {
        BlockPos pos = blockEntity.getPos();
        World world = blockEntity.getWorld();

        for (int i = 0; i < 4; i++) {
            Block plant = Block.getBlockFromItem(stack.get(i).getItem());
            matrices.push();
            if (i==0) {
                matrices.translate(0.05f, 0.15f, 0.05f);
            }
            else if (i==1) {
                matrices.translate(0.05f, 0.15f, 0.45f);
            }
            else if (i==2) {
                matrices.translate(0.45f, 0.15f, 0.45f);
            }
            else {
                matrices.translate(0.45f, 0.15f, 0.05f);
            }
            matrices.scale(0.5f, 0.5f, 0.5f);

            this.manager.getModelRenderer().render(world, this.manager.getModel(plant.getDefaultState()), plant.getDefaultState(), pos, matrices, vertexConsumers.getBuffer(RenderLayer.getCutoutMipped()), false, Random.create(), plant.getDefaultState().getRenderingSeed(pos), overlay);
            matrices.pop();
        }
    }

    private void renderFish(BlockState blockState, DefaultedList<ItemStack> stack, MatrixStack matrices, VertexConsumerProvider vertexConsumers, World world, int light) {
        ItemStack itemStack = stack.get(4);
        if (!itemStack.isEmpty() && world != null) {

            Entity fish = getFishEntity(world, itemStack);

            if (fish != null) {
                matrices.push();
                matrices.translate(0.5F, 0.5F, 0.5F);
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(getDirection(blockState)));

                if (fish instanceof AxolotlEntity){
                    matrices.translate(0.0F, -0.1F, 0.0F);
                    matrices.scale(0.4F, 0.5F, 0.4F);
                }
                else if (fish instanceof SalmonEntity) {
                    matrices.scale(0.4F, 0.4F, 0.4F);
                    matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90.0F));
                }
                else if (fish instanceof CodEntity) {
                    matrices.scale(0.5F, 0.5F, 0.5F);
                    matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90.0F));
                }
                else if (fish instanceof TropicalFishEntity) {
                    matrices.scale(0.7F, 0.7F, 0.7F);
                    matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90.0F));
                }
                else if (fish instanceof ArcticCharEntity || fish instanceof BassEntity || fish instanceof PiranhaEntity || fish instanceof AnglerfishEntity) {
                    matrices.translate(0.0F, -0.1F, 0.0F);
                    matrices.scale(0.5F, 0.5F, 0.5F);
                }
                else {
                    matrices.scale(0.7F, 0.7F, 0.7F);
                }
                
                this.dispatcher.render(fish, 0, 0, 0, 0, 0, matrices, vertexConsumers, light);

                matrices.pop();
            }
        }
    }

}
