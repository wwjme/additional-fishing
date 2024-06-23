package net.wix3y.additionalfishing.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.wix3y.additionalfishing.AdditionalFishing;
import net.wix3y.additionalfishing.entity.custom.BassEntity;

public class BassRenderer extends MobEntityRenderer<BassEntity, BassModel<BassEntity>> {
    private static final Identifier TEXTURE = new Identifier(AdditionalFishing.MOD_ID, "textures/entity/bass_texture.png");

    public BassRenderer(EntityRendererFactory.Context context) {
        super(context, new BassModel<>(context.getPart(FishModelLayers.BASS)), 0.3f);
    }

    @Override
    public Identifier getTexture(BassEntity entity) {
        return TEXTURE;
    }
}
