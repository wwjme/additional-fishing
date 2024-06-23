package net.wix3y.additionalfishing;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.wix3y.additionalfishing.entity.FishEntities;
import net.wix3y.additionalfishing.entity.client.*;

public class AdditionalFishingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
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
    }
}
