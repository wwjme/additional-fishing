package net.wix3y.additionalfishing.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.wix3y.additionalfishing.AdditionalFishing;

public class FishingItems {
    public static final Item ANGLERFISH = registerItem("anglerfish", new Item(new FabricItemSettings().food(FishingFoodComponents.ANGLERFISH)));
    public static final Item BASS = registerItem("bass", new Item(new FabricItemSettings().food(FishingFoodComponents.BASS)));
    public static final Item BLOBFISH = registerItem("blobfish", new Item(new FabricItemSettings()));
    public static final Item CATFISH = registerItem("catfish", new Item(new FabricItemSettings().food(FishingFoodComponents.CATFISH)));
    public static final Item CLAM = registerItem("clam", new Item(new FabricItemSettings()));
    public static final Item CRAB_CLAW = registerItem("crab_claw", new Item(new FabricItemSettings().food(FishingFoodComponents.CRAB_CLAW)));
    public static final Item FLOUNDER = registerItem("flounder", new Item(new FabricItemSettings().food(FishingFoodComponents.FLOUNDER)));
    public static final Item GOLDFISH = registerItem("goldfish", new Item(new FabricItemSettings().food(FishingFoodComponents.GOLDFISH)));
    public static final Item HERRING = registerItem("herring", new Item(new FabricItemSettings().food(FishingFoodComponents.HERRING)));
    public static final Item KOI = registerItem("koi", new Item(new FabricItemSettings().food(FishingFoodComponents.KOI)));
    public static final Item PIRANHA = registerItem("piranha", new Item(new FabricItemSettings().food(FishingFoodComponents.PIRANHA)));
    public static final Item SHRIMP = registerItem("shrimp", new Item(new FabricItemSettings().food(FishingFoodComponents.SHRIMP)));
    public static final Item STARFISH = registerItem("starfish", new Item(new FabricItemSettings().food(FishingFoodComponents.STARFISH)));

    public static final Item GOLDFISH_CRACKER = registerItem("goldfish_cracker", new Item(new FabricItemSettings().food(FishingFoodComponents.GOLDFISH_CRACKER)));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(AdditionalFishing.MOD_ID, name), item);
    }
    public static void registerModItems() {
        AdditionalFishing.LOGGER.info("Register mod items for " + AdditionalFishing.MOD_ID);
    }
}
