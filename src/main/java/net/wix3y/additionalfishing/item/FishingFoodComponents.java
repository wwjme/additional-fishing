package net.wix3y.additionalfishing.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class FishingFoodComponents {
    public static final FoodComponent ANGLERFISH = new FoodComponent.Builder().hunger(1).saturationModifier(0.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100), 1.0f).build();
    public static final FoodComponent ARCTIC_CHAR = new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build();
    public static final FoodComponent BASS = new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build();
    public static final FoodComponent CATFISH = new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build();
    public static final FoodComponent CRAB_CLAW = new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build();
    public static final FoodComponent FLOUNDER = new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build();
    public static final FoodComponent GOLDFISH = new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build();
    public static final FoodComponent HERRING = new FoodComponent.Builder().hunger(1).saturationModifier(0.2f).build();
    public static final FoodComponent KOI = new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build();
    public static final FoodComponent PIRANHA = new FoodComponent.Builder().hunger(1).saturationModifier(0.2f).build();
    public static final FoodComponent RAINBOWFISH = new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build();
    public static final FoodComponent SHRIMP = new FoodComponent.Builder().hunger(1).saturationModifier(0.2f).build();
    public static final FoodComponent STARFISH = new FoodComponent.Builder().hunger(1).saturationModifier(0.1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 200), 1.0f).build();
    public static final FoodComponent TUNA = new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build();

    public static final FoodComponent GOLDFISH_CRACKER = new FoodComponent.Builder().hunger(2).saturationModifier(0.1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 100), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 100), 1.0f).build();
}
