package net.wix3y.additionalfishing;

import net.fabricmc.api.ModInitializer;

import net.wix3y.additionalfishing.item.FishingItemGroups;
import net.wix3y.additionalfishing.item.FishingItems;
import net.wix3y.additionalfishing.loot.FishingFishLootTableGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdditionalFishing implements ModInitializer {
	public static final String MOD_ID = "additionalfishing";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Loading " + MOD_ID);
		FishingItemGroups.registerItemGroups();
		FishingItems.registerModItems();
		FishingFishLootTableGenerator.replaceLootTable();
	}
}