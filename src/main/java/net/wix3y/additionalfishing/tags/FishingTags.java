package net.wix3y.additionalfishing.tags;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.wix3y.additionalfishing.AdditionalFishing;

public class FishingTags {
    public static final TagKey<Item> AQUARIUM_PLANTS = TagKey.of(RegistryKeys.ITEM, new Identifier(AdditionalFishing.MOD_ID, "aquarium_plants"));
}
