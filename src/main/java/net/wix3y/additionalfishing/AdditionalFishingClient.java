package net.wix3y.additionalfishing;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.wix3y.additionalfishing.entity.FishEntities;
import net.wix3y.additionalfishing.entity.client.FishModelLayers;
import net.wix3y.additionalfishing.entity.client.PiranhaModel;
import net.wix3y.additionalfishing.entity.client.PiranhaRenderer;

public class AdditionalFishingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(FishModelLayers.PIRANHA, PiranhaModel::getTexturedModelData);
        EntityRendererRegistry.register(FishEntities.PIRANHA, PiranhaRenderer::new);
    }
}
