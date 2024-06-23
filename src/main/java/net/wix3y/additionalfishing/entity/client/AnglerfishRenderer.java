package net.wix3y.additionalfishing.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.wix3y.additionalfishing.AdditionalFishing;
import net.wix3y.additionalfishing.entity.custom.AnglerfishEntity;

public class AnglerfishRenderer extends MobEntityRenderer<AnglerfishEntity, AnglerfishModel<AnglerfishEntity>> {
    private static final Identifier TEXTURE = new Identifier(AdditionalFishing.MOD_ID, "textures/entity/anglerfish_texture.png");

    public AnglerfishRenderer(EntityRendererFactory.Context context) {
        super(context, new AnglerfishModel<>(context.getPart(FishModelLayers.ANGLERFISH)), 0.3f);
    }

    @Override
    public Identifier getTexture(AnglerfishEntity entity) {
        return TEXTURE;
    }
}
