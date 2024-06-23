package net.wix3y.additionalfishing.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.wix3y.additionalfishing.entity.FishEntities;
import net.wix3y.additionalfishing.entity.custom.CrabEntity;

public class FishEntityGeneration {
    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.WARM_OCEAN, BiomeKeys.MANGROVE_SWAMP),
            SpawnGroup.WATER_AMBIENT, FishEntities.PIRANHA, 15, 2, 4);
        SpawnRestriction.register(FishEntities.PIRANHA, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, FishEntity::canSpawn);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.DEEP_COLD_OCEAN),
                SpawnGroup.WATER_AMBIENT, FishEntities.SHRIMP, 3, 5, 12);
        SpawnRestriction.register(FishEntities.SHRIMP, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, FishEntity::canSpawn);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.BEACH),
                SpawnGroup.CREATURE, FishEntities.CRAB, 5, 1, 3);
        SpawnRestriction.register(FishEntities.CRAB, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, CrabEntity::canSpawn);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DEEP_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_FROZEN_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN),
                SpawnGroup.WATER_AMBIENT, FishEntities.ANGLERFISH, 5, 1, 2);
        SpawnRestriction.register(FishEntities.ANGLERFISH, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, FishEntity::canSpawn);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.COLD_OCEAN, BiomeKeys.FROZEN_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.DEEP_FROZEN_OCEAN),
                SpawnGroup.WATER_AMBIENT, FishEntities.ARCTIC_CHAR, 15, 1, 5);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_RIVER),
                SpawnGroup.CREATURE, FishEntities.ARCTIC_CHAR, 5, 1, 5);
        SpawnRestriction.register(FishEntities.ARCTIC_CHAR, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, FishEntity::canSpawn);


        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.RIVER),
                SpawnGroup.WATER_AMBIENT, FishEntities.BASS, 10, 1, 5);
        SpawnRestriction.register(FishEntities.BASS, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, FishEntity::canSpawn);
    }
}
