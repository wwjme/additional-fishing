package net.wix3y.additionalfishing;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.wix3y.additionalfishing.block.FishBlocks;
import net.wix3y.additionalfishing.blockentity.FishBlockEntities;
import net.wix3y.additionalfishing.blockentity.client.AquariumBlockEntityRenderer;
import net.wix3y.additionalfishing.entity.FishEntities;
import net.wix3y.additionalfishing.entity.client.*;

public class AdditionalFishingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(FishBlocks.AQUARIUM, RenderLayer.getTranslucent());
        BlockEntityRendererFactories.register(FishBlockEntities.AQUARIUM_BLOCK_ENTITY, AquariumBlockEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(FishModelLayers.PIRANHA, PiranhaModel::getTexturedModelData);
        EntityRendererRegistry.register(FishEntities.PIRANHA, PiranhaRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(FishModelLayers.SHRIMP, ShrimpModel::getTexturedModelData);
        EntityRendererRegistry.register(FishEntities.SHRIMP, ShrimpRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(FishModelLayers.CRAB, CrabModel::getTexturedModelData);
        EntityRendererRegistry.register(FishEntities.CRAB, CrabRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(FishModelLayers.ANGLERFISH, AnglerfishModel::getTexturedModelData);
        EntityRendererRegistry.register(FishEntities.ANGLERFISH, AnglerfishRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(FishModelLayers.ARCTIC_CHAR, ArcticCharModel::getTexturedModelData);
        EntityRendererRegistry.register(FishEntities.ARCTIC_CHAR, ArcticCharRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(FishModelLayers.BASS, BassModel::getTexturedModelData);
        EntityRendererRegistry.register(FishEntities.BASS, BassRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(FishModelLayers.KOI, KoiModel::getTexturedModelData);
        EntityRendererRegistry.register(FishEntities.KOI, KoiRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(FishModelLayers.GOLDFISH, GoldfishModel::getTexturedModelData);
        EntityRendererRegistry.register(FishEntities.GOLDFISH, GoldfishRenderer::new);
    }
}
