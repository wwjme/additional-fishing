package net.wix3y.additionalfishing;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.wix3y.additionalfishing.entity.FishEntities;
import net.wix3y.additionalfishing.entity.custom.CrabEntity;
import net.wix3y.additionalfishing.entity.custom.PiranhaEntity;
import net.wix3y.additionalfishing.entity.custom.ShrimpEntity;
import net.wix3y.additionalfishing.item.FishingItemGroups;
import net.wix3y.additionalfishing.item.FishingItems;
import net.wix3y.additionalfishing.loot.FishingFishLootTableGenerator;
import net.wix3y.additionalfishing.world.gen.FishEntityGeneration;
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
		FishEntities.registerEntities();
		FabricDefaultAttributeRegistry.register(FishEntities.PIRANHA, PiranhaEntity.createPiranhaAttributes());
		FabricDefaultAttributeRegistry.register(FishEntities.SHRIMP, ShrimpEntity.createShrimpAttributes());
		FabricDefaultAttributeRegistry.register(FishEntities.CRAB, CrabEntity.createCrabAttributes());
		FishEntityGeneration.addSpawns();
	}
}