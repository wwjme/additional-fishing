package net.wix3y.additionalfishing.mixin;

import net.minecraft.entity.passive.CatEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.wix3y.additionalfishing.item.FishingItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CatEntity.class)
public abstract class CatMixin {

    @Inject(
            method = "isBreedingItem",
            at = @At("TAIL"),
            cancellable = true)
    private void isBreedingItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (!Boolean.TRUE.equals(cir.getReturnValue())) {
            cir.setReturnValue(Ingredient.ofItems(
                    FishingItems.ARCTIC_CHAR,
                    FishingItems.BASS,
                    FishingItems.CATFISH,
                    FishingItems.FLOUNDER,
                    FishingItems.HERRING,
                    FishingItems.PIRANHA,
                    FishingItems.TUNA).test(stack));
        }
        }
}