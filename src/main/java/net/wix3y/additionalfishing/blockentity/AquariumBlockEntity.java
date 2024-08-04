package net.wix3y.additionalfishing.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.collection.DefaultedList;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class AquariumBlockEntity extends BlockEntity implements SidedInventory {
    private DefaultedList<ItemStack> inventory = DefaultedList.ofSize(5, ItemStack.EMPTY);
    private static final int[] SLOTS = new int[]{0, 1, 2, 3, 4};

    public AquariumBlockEntity(BlockPos pos, BlockState state) {
        super(FishBlockEntities.AQUARIUM_BLOCK_ENTITY, pos, state);
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        return SLOTS;
    }

    public DefaultedList<ItemStack> getInventory() {
        return inventory;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
        return this.isValid(slot, stack);
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return false;
    }

    @Override
    public int size() {
        return this.inventory.size();
    }

    @Override
    public boolean isEmpty() {
        for(int i=0; i<size();i++) {
            ItemStack stack = getStack(i);
            if (!stack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getStack(int slot) {
        return this.inventory.get(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        ItemStack result = Inventories.splitStack(this.inventory, slot, amount);
        if (!result.isEmpty()) {
            this.markDirty();
        }
        return result;
    }

    @Override
    public ItemStack removeStack(int slot) {
        return Inventories.removeStack(this.inventory, slot);
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        this.inventory.set(slot, stack);
        if (stack.getCount() > getMaxCountPerStack()) {
            stack.setCount(getMaxCountPerStack());
        }
        this.markDirty();
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return true;
    }

    @Override
    public void clear() {
        this.inventory.clear();
    }

    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, this.inventory);
    }

    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, this.inventory);
    }

    private void updateListeners() {
        this.markDirty();
        Objects.requireNonNull(this.getWorld()).updateListeners(this.getPos(), this.getCachedState(), this.getCachedState(), 3);
    }

    public void insertPlant(ItemStack plant, int slot) {
        ItemStack itemStack = this.inventory.get(slot);
        if (itemStack.isEmpty()) {
            this.inventory.set(slot, plant.split(1));
            this.updateListeners();
        }
    }

    public void extractPlant(PlayerEntity player, Hand hand, int slot) {
        ItemStack itemStack = this.inventory.get(slot);
        if (!itemStack.isEmpty()) {
            player.setStackInHand(hand, itemStack);
            this.inventory.set(slot, ItemStack.EMPTY);
            this.updateListeners();
        }
    }

    public void insertFish(PlayerEntity player, Hand hand, ItemStack fish) {
        ItemStack itemStack = this.inventory.get(4);
        if (itemStack.isEmpty()) {
            this.inventory.set(4, fish.split(1));
            player.setStackInHand(hand, new ItemStack(Items.WATER_BUCKET));
            this.updateListeners();
        }
    }

    public void extractFish(PlayerEntity player, Hand hand) {
        ItemStack itemStack = this.inventory.get(4);
        if (!itemStack.isEmpty()) {
            player.setStackInHand(hand, itemStack);
            this.inventory.set(4, ItemStack.EMPTY);
            this.updateListeners();
        }
    }

    @Override
    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        NbtCompound nbtCompound = new NbtCompound();
        Inventories.writeNbt(nbtCompound, this.inventory, true);
        return nbtCompound;
    }
}
