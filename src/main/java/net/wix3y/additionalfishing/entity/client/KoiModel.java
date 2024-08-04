package net.wix3y.additionalfishing.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.wix3y.additionalfishing.entity.animation.FishAnimations;
import net.wix3y.additionalfishing.entity.custom.KoiEntity;

public class KoiModel<T extends KoiEntity> extends SinglePartEntityModel<T> {
	private final ModelPart koi;
	public KoiModel(ModelPart root) {
		this.koi = root.getChild("koi");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData koi = modelPartData.addChild("koi", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, -5.5F, -5.0F, 3.0F, 3.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 11).cuboid(-1.0F, -5.5F, -8.0F, 2.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(10, 13).cuboid(-1.0F, -5.5F, 3.0F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 2).cuboid(0.0F, -6.75F, -2.0F, 0.0F, 2.0F, 3.0F, new Dilation(0.0F))
		.uv(14, 1).cuboid(0.0F, -6.25F, -4.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(16, 5).cuboid(0.0F, -6.25F, 1.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 1).cuboid(0.0F, -5.75F, 2.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(7, 11).cuboid(0.0F, -5.75F, -6.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData wisker_r1 = koi.addChild("wisker_r1", ModelPartBuilder.create().uv(0, 10).cuboid(0.0F, -1.5F, -0.5F, 0.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.75F, -2.5F, -6.5F, 1.5104F, -0.3788F, -0.8882F));

		ModelPartData wisker_r2 = koi.addChild("wisker_r2", ModelPartBuilder.create().uv(15, 10).cuboid(0.0F, -1.5F, -0.5F, 0.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.75F, -2.5F, -6.5F, 1.5104F, 0.3788F, 0.8882F));

		ModelPartData tail = koi.addChild("tail", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.25F, -1.0F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 16).cuboid(0.0F, -2.25F, 2.0F, 0.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(2, 16).cuboid(0.0F, -1.75F, 1.0F, 0.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(4, 16).cuboid(0.0F, -2.75F, 3.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(5, 0).cuboid(0.0F, 0.25F, 3.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(14, 5).cuboid(0.0F, -3.25F, 4.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(6, 4).cuboid(0.0F, 0.75F, 4.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(16, 6).cuboid(0.0F, 1.75F, 5.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(6, 16).cuboid(0.0F, -3.25F, 5.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -4.0F, 4.0F));

		ModelPartData left_fin_1 = koi.addChild("left_fin_1", ModelPartBuilder.create().uv(13, 2).cuboid(-1.75F, -1.0F, -1.0F, 3.0F, 0.0F, 1.0F, new Dilation(0.0F))
		.uv(6, 12).cuboid(-3.0F, -1.0F, 0.0F, 4.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, -2.25F, -3.0F, 0.0F, 0.3927F, -0.3927F));

		ModelPartData right_fin_1 = koi.addChild("right_fin_1", ModelPartBuilder.create().uv(6, 11).cuboid(-1.0F, -1.0F, 0.0F, 4.0F, 0.0F, 1.0F, new Dilation(0.0F))
		.uv(13, 1).cuboid(-1.25F, -1.0F, -1.0F, 3.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, -2.25F, -3.0F, 0.0F, -0.3927F, 0.3927F));

		ModelPartData left_fin_2 = koi.addChild("left_fin_2", ModelPartBuilder.create().uv(13, 5).cuboid(-0.5F, 0.5F, -1.0F, 2.0F, 0.0F, 1.0F, new Dilation(0.0F))
		.uv(13, 0).cuboid(-1.0F, 0.5F, 0.0F, 3.0F, 0.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 1).cuboid(-1.5F, 0.5F, 1.0F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, -2.75F, 1.0F, -0.2849F, 0.274F, -0.8249F));

		ModelPartData right_fin_2 = koi.addChild("right_fin_2", ModelPartBuilder.create().uv(13, 4).cuboid(-1.5F, 0.5F, -1.0F, 2.0F, 0.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 7).cuboid(-2.0F, 0.5F, 0.0F, 3.0F, 0.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(0.5F, 0.5F, 1.0F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, -2.75F, 1.0F, -0.2849F, -0.274F, 0.8249F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(KoiEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.animateMovement(FishAnimations.KOI_SWIMMING, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, FishAnimations.KOI_IDLE, ageInTicks, 1f);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		koi.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return koi;
	}
}