package net.wix3y.additionalfishing.loot;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.LocationCheckLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.wix3y.additionalfishing.item.FishingItems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FishingFishLootTableGenerator {
    private static final Identifier FISHING_FISH_ID = new Identifier("gameplay/fishing/fish");
    private static final int COD_COMMON = 60;
    private static final int VERY_COMMON = 25;
    private static final int COMMON = 15;
    private static final int UNCOMMON = 10;

    // cold biomes
    public static final LootCondition.Builder NEEDS_SNOWY_PLAINS = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.SNOWY_PLAINS));
    public static final LootCondition.Builder NEEDS_SNOWY_TAIGA = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.SNOWY_TAIGA));
    public static final LootCondition.Builder NEEDS_SNOWY_SLOPES = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.SNOWY_SLOPES));
    public static final LootCondition.Builder NEEDS_SNOWY_BEACH = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.SNOWY_BEACH));
    public static final LootCondition.Builder NEEDS_FROZEN_RIVER = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.FROZEN_RIVER));
    public static final LootCondition.Builder NEEDS_FROZEN_PEAKS = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.FROZEN_PEAKS));
    public static final LootCondition.Builder NEEDS_ICE_SPIKES = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.ICE_SPIKES));
    public static final LootCondition.Builder NEEDS_JAGGED_PEAKS = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.JAGGED_PEAKS));
    public static final LootCondition.Builder NEEDS_STONY_SHORE = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.STONY_SHORE));
    // mangrove & beach
    public static final LootCondition.Builder NEEDS_MANGROVE_SWAMP = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.MANGROVE_SWAMP));
    public static final LootCondition.Builder NEEDS_BEACH = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.BEACH));
    // oceans
    public static final LootCondition.Builder NEEDS_WARM_OCEAN = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.WARM_OCEAN));
    public static final LootCondition.Builder NEEDS_LUKEWARM_OCEAN = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.LUKEWARM_OCEAN));
    public static final LootCondition.Builder NEEDS_OCEAN = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.OCEAN));
    public static final LootCondition.Builder NEEDS_COLD_OCEAN = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.COLD_OCEAN));
    public static final LootCondition.Builder NEEDS_FROZEN_OCEAN = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.FROZEN_OCEAN));
    // deep oceans
    public static final LootCondition.Builder NEEDS_DEEP_LUKEWARM_OCEAN = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.DEEP_LUKEWARM_OCEAN));
    public static final LootCondition.Builder NEEDS_DEEP_OCEAN = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.DEEP_OCEAN));
    public static final LootCondition.Builder NEEDS_DEEP_COLD_OCEAN = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.DEEP_COLD_OCEAN));
    public static final LootCondition.Builder NEEDS_DEEP_FROZEN_OCEAN = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.DEEP_FROZEN_OCEAN));

    public static void replaceLootTable() {
        LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {
            if (id.equals(FISHING_FISH_ID)) {
                List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));

entries.add(ItemEntry.builder(FishingItems.ANGLERFISH).weight(UNCOMMON).conditionally(NEEDS_DEEP_LUKEWARM_OCEAN.or(NEEDS_DEEP_OCEAN).or(NEEDS_DEEP_COLD_OCEAN).or(NEEDS_DEEP_FROZEN_OCEAN)).build());
entries.add(ItemEntry.builder(FishingItems.ARCTIC_CHAR).conditionally(NEEDS_SNOWY_PLAINS.or(NEEDS_SNOWY_TAIGA).or(NEEDS_SNOWY_SLOPES).or(NEEDS_SNOWY_BEACH).or(NEEDS_FROZEN_PEAKS).or(NEEDS_ICE_SPIKES).or(NEEDS_JAGGED_PEAKS).or(NEEDS_STONY_SHORE).or(NEEDS_FROZEN_RIVER).or(NEEDS_COLD_OCEAN).or(NEEDS_FROZEN_OCEAN).or(NEEDS_DEEP_COLD_OCEAN).or(NEEDS_DEEP_FROZEN_OCEAN)).weight(COD_COMMON).build());
entries.add(ItemEntry.builder(FishingItems.BASS).weight(COMMON).build());
entries.add(ItemEntry.builder(FishingItems.CATFISH).weight(UNCOMMON).conditionally(NEEDS_WARM_OCEAN.or(NEEDS_LUKEWARM_OCEAN)).build());
entries.add(ItemEntry.builder(FishingItems.CLAM).weight(UNCOMMON).conditionally(NEEDS_WARM_OCEAN.or(NEEDS_LUKEWARM_OCEAN)).build());
entries.add(ItemEntry.builder(FishingItems.RAW_CRAB_CLAW).weight(UNCOMMON).conditionally(NEEDS_WARM_OCEAN.or(NEEDS_LUKEWARM_OCEAN)).build());
entries.add(ItemEntry.builder(FishingItems.FLOUNDER).weight(UNCOMMON).conditionally(NEEDS_WARM_OCEAN.or(NEEDS_LUKEWARM_OCEAN)).build());
entries.add(ItemEntry.builder(FishingItems.GOLDFISH).weight(COMMON).conditionally(NEEDS_WARM_OCEAN.or(NEEDS_LUKEWARM_OCEAN)).build());
entries.add(ItemEntry.builder(FishingItems.HERRING).weight(COMMON).build());
entries.add(ItemEntry.builder(FishingItems.KOI).weight(COMMON).conditionally(NEEDS_WARM_OCEAN.or(NEEDS_LUKEWARM_OCEAN)).build());
entries.add(ItemEntry.builder(FishingItems.PIRANHA).weight(VERY_COMMON).conditionally(NEEDS_MANGROVE_SWAMP.or(NEEDS_WARM_OCEAN).or(NEEDS_LUKEWARM_OCEAN)).build());
entries.add(ItemEntry.builder(FishingItems.RAINBOWFISH).weight(COMMON).conditionally(NEEDS_WARM_OCEAN.or(NEEDS_LUKEWARM_OCEAN)).build());
entries.add(ItemEntry.builder(Items.TROPICAL_FISH).weight(COMMON).conditionally(NEEDS_WARM_OCEAN.or(NEEDS_LUKEWARM_OCEAN)).build());
entries.add(ItemEntry.builder(Items.PUFFERFISH).weight(COMMON).conditionally(NEEDS_WARM_OCEAN.or(NEEDS_LUKEWARM_OCEAN)).build());
entries.add(ItemEntry.builder(FishingItems.RAW_SHRIMP).weight(UNCOMMON).conditionally(NEEDS_WARM_OCEAN.or(NEEDS_LUKEWARM_OCEAN)).build());
entries.add(ItemEntry.builder(FishingItems.STARFISH).weight(COMMON).conditionally(NEEDS_WARM_OCEAN.or(NEEDS_LUKEWARM_OCEAN).or(NEEDS_OCEAN).or(NEEDS_DEEP_LUKEWARM_OCEAN).or(NEEDS_DEEP_OCEAN).or(NEEDS_BEACH)).build());
entries.add(ItemEntry.builder(FishingItems.TUNA).weight(COMMON).build());


                LootPool.Builder pool = LootPool.builder().with(entries);
                return LootTable.builder().pool(pool).build();
            }

            return null;
        });
    }
}
