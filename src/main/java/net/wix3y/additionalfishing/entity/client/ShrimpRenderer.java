package net.wix3y.additionalfishing.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.wix3y.additionalfishing.AdditionalFishing;
import net.wix3y.additionalfishing.entity.custom.ShrimpEntity;

public class ShrimpRenderer extends MobEntityRenderer<ShrimpEntity, ShrimpModel<ShrimpEntity>> {
    private static final Identifier TEXTURE = new Identifier(AdditionalFishing.MOD_ID, "textures/entity/shrimp_texture.png");

    public ShrimpRenderer(EntityRendererFactory.Context context) {
        super(context, new ShrimpModel<>(context.getPart(FishModelLayers.SHRIMP)), 0.3f);
    }

    @Override
    public Identifier getTexture(ShrimpEntity entity) {
        return TEXTURE;
    }
}
