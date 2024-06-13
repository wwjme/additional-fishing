package net.wix3y.additionalfishing.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.wix3y.additionalfishing.AdditionalFishing;

public class FishingItemGroups {
    public static final ItemGroup ADDITIONAL_FISHING_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(AdditionalFishing.MOD_ID, "fish"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.additionalfishing"))
                    .icon(() -> new ItemStack(FishingItems.PIRANHA)).entries((displayContext, entries) -> {
                        entries.add(FishingItems.ARCTIC_CHAR);
                        entries.add(FishingItems.COOKED_ARCTIC_CHAR);

                        entries.add(FishingItems.ANGLERFISH);

                        entries.add(FishingItems.BASS);
                        entries.add(FishingItems.COOKED_BASS);

                        entries.add(FishingItems.CATFISH);
                        entries.add(FishingItems.COOKED_CATFISH);

                        entries.add(FishingItems.CLAM);

                        entries.add(FishingItems.RAW_CRAB_CLAW);
                        entries.add(FishingItems.CRAB_CLAW);

                        entries.add(FishingItems.FLOUNDER);
                        entries.add(FishingItems.COOKED_FLOUNDER);

                        entries.add(FishingItems.GOLDFISH);
                        entries.add(FishingItems.GOLDFISH_CRACKER);

                        entries.add(FishingItems.HERRING);
                        entries.add(FishingItems.COOKED_HERRING);
                        entries.add(FishingItems.KOI);

                        entries.add(FishingItems.PIRANHA);
                        entries.add(FishingItems.COOKED_PIRANHA);

                        entries.add(FishingItems.RAINBOWFISH);

                        entries.add(FishingItems.RAW_SHRIMP);
                        entries.add(FishingItems.SHRIMP);

                        entries.add(FishingItems.STARFISH);

                        entries.add(FishingItems.TUNA);
                        entries.add(FishingItems.COOKED_TUNA);

                        entries.add(FishingItems.PIRANHA_BUCKET);
                        entries.add(FishingItems.SHRIMP_BUCKET);

                        entries.add(FishingItems.PIRANHA_SPAWN_EGG);
                        entries.add(FishingItems.SHRIMP_SPAWN_EGG);

                    }).build());
    public static void registerItemGroups() {
        AdditionalFishing.LOGGER.info("Registering item group");
    }
}
