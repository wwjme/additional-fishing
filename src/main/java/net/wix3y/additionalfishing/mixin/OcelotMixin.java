package net.wix3y.additionalfishing.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.OcelotEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.world.World;
import net.wix3y.additionalfishing.item.FishingItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OcelotEntity.class)
public abstract class OcelotMixin extends AnimalEntity {
    @Shadow
    @Mutable
    private static Ingredient TAMING_INGREDIENT;

    protected OcelotMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(
            method = "<init>()V",
            at = @At("TAIL"))
    private void addTamingIngredients(CallbackInfo info) {
        TAMING_INGREDIENT = Ingredient.ofItems(new ItemConvertible[]{Items.COD, Items.SALMON, FishingItems.ARCTIC_CHAR, FishingItems.BASS, FishingItems.CATFISH, FishingItems.FLOUNDER, FishingItems.HERRING, FishingItems.PIRANHA, FishingItems.TUNA});
    }
}
