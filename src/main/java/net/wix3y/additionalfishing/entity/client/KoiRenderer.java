package net.wix3y.additionalfishing.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.wix3y.additionalfishing.AdditionalFishing;
import net.wix3y.additionalfishing.entity.custom.KoiEntity;

public class KoiRenderer extends MobEntityRenderer<KoiEntity, KoiModel<KoiEntity>> {
    private static final Identifier TEXTURE = new Identifier(AdditionalFishing.MOD_ID, "textures/entity/koi_texture.png");

    public KoiRenderer(EntityRendererFactory.Context context) {
        super(context, new KoiModel<>(context.getPart(FishModelLayers.KOI)), 0.3f);
    }

    @Override
    public Identifier getTexture(KoiEntity entity) {
        return TEXTURE;
    }
}
