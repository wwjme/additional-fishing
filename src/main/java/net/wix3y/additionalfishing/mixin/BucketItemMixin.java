package net.wix3y.additionalfishing.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.item.EntityBucketItem;
import net.wix3y.additionalfishing.util.BucketType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(EntityBucketItem.class)
public class BucketItemMixin implements BucketType {

    @Final
    @Shadow
    private EntityType<?> entityType;

    public EntityType<?> getEntityType() {
        return entityType;
    }
}