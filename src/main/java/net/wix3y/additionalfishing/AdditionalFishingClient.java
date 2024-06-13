package net.wix3y.additionalfishing;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.wix3y.additionalfishing.entity.FishEntities;
import net.wix3y.additionalfishing.entity.client.FishModelLayers;
import net.wix3y.additionalfishing.entity.client.PiranhaModel;
import net.wix3y.additionalfishing.entity.client.PiranhaRenderer;
import net.wix3y.additionalfishing.entity.client.ShrimpModel;
import net.wix3y.additionalfishing.entity.client.ShrimpRenderer;

public class AdditionalFishingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(FishModelLayers.PIRANHA, PiranhaModel::getTexturedModelData);
        EntityRendererRegistry.register(FishEntities.PIRANHA, PiranhaRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(FishModelLayers.SHRIMP, ShrimpModel::getTexturedModelData);
        EntityRendererRegistry.register(FishEntities.SHRIMP, ShrimpRenderer::new);
    }
}
