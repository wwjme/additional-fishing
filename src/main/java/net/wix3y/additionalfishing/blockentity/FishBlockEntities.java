package net.wix3y.additionalfishing.blockentity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.wix3y.additionalfishing.AdditionalFishing;
import net.wix3y.additionalfishing.block.FishBlocks;

public class FishBlockEntities {
    public static final BlockEntityType<AquariumBlockEntity> AQUARIUM_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE,
                    new Identifier(AdditionalFishing.MOD_ID, "aquarium_block_entity"),
                    FabricBlockEntityTypeBuilder.create(AquariumBlockEntity::new, FishBlocks.AQUARIUM).build());

    public static void registerBlockEntities() {
        AdditionalFishing.LOGGER.info("Registering Block Entities for " + AdditionalFishing.MOD_ID);
    }
}
