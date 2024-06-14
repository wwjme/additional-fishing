package net.wix3y.additionalfishing.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.wix3y.additionalfishing.AdditionalFishing;
import net.wix3y.additionalfishing.entity.custom.CrabEntity;

public class CrabRenderer extends MobEntityRenderer<CrabEntity, CrabModel<CrabEntity>> {
    private static final Identifier TEXTURE = new Identifier(AdditionalFishing.MOD_ID, "textures/entity/crab_texture.png");

    public CrabRenderer(EntityRendererFactory.Context context) {
        super(context, new CrabModel<>(context.getPart(FishModelLayers.CRAB)), 0.3f);
    }

    @Override
    public Identifier getTexture(CrabEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(CrabEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.6f, 0.6f, 0.6f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
