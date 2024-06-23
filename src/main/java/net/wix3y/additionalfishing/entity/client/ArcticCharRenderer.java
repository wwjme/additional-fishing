package net.wix3y.additionalfishing.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.wix3y.additionalfishing.AdditionalFishing;
import net.wix3y.additionalfishing.entity.custom.ArcticCharEntity;

public class ArcticCharRenderer extends MobEntityRenderer<ArcticCharEntity, ArcticCharModel<ArcticCharEntity>> {
    private static final Identifier TEXTURE = new Identifier(AdditionalFishing.MOD_ID, "textures/entity/arctic_char_texture.png");

    public ArcticCharRenderer(EntityRendererFactory.Context context) {
        super(context, new ArcticCharModel<>(context.getPart(FishModelLayers.ARCTIC_CHAR)), 0.3f);
    }

    @Override
    public Identifier getTexture(ArcticCharEntity entity) {
        return TEXTURE;
    }
}
