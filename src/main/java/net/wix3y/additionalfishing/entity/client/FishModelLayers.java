package net.wix3y.additionalfishing.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.wix3y.additionalfishing.AdditionalFishing;

public class FishModelLayers {
    public static final EntityModelLayer PIRANHA = new EntityModelLayer(new Identifier(AdditionalFishing.MOD_ID, "piranha"), "main");
    public static final EntityModelLayer SHRIMP = new EntityModelLayer(new Identifier(AdditionalFishing.MOD_ID, "shrimp"), "main");
}
