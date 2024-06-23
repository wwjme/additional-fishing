package net.wix3y.additionalfishing.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.wix3y.additionalfishing.entity.animation.FishAnimations;
import net.wix3y.additionalfishing.entity.custom.BassEntity;

public class BassModel<T extends BassEntity> extends SinglePartEntityModel<T> {
	private final ModelPart bass;
	public BassModel(ModelPart root) {
		this.bass = root.getChild("bass");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bass = modelPartData.addChild("bass", ModelPartBuilder.create().uv(0, 11).cuboid(-1.5F, -5.5F, -8.0F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-2.0F, -6.0F, -5.0F, 4.0F, 5.0F, 6.0F, new Dilation(0.0F))
		.uv(14, 0).cuboid(-2.0F, -5.5F, 1.0F, 4.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 3).cuboid(0.0F, -1.25F, -4.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(9, 11).cuboid(0.0F, -1.5F, -2.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(9, 9).cuboid(0.0F, -7.0F, -3.0F, 0.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(9, 8).cuboid(0.0F, -8.0F, -2.0F, 0.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData tail = bass.addChild("tail", ModelPartBuilder.create().uv(12, 11).cuboid(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(14, 4).cuboid(0.0F, -0.5F, 3.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 10).cuboid(0.0F, -1.5F, 4.0F, 0.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(0.0F, -1.5F, 5.0F, 0.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(13, 12).cuboid(0.0F, -1.5F, 6.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 4).cuboid(0.0F, 0.5F, 6.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.5F, 1.5F));

		ModelPartData left_fin = bass.addChild("left_fin", ModelPartBuilder.create().uv(0, 3).cuboid(-1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 3.0F, new Dilation(0.0F))
		.uv(12, 17).cuboid(-2.0F, 0.0F, -1.0F, 1.0F, 0.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -2.0F, -3.0F));

		ModelPartData right_fin = bass.addChild("right_fin", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, 0.0F, -1.0F, 1.0F, 0.0F, 3.0F, new Dilation(0.0F))
		.uv(10, 17).cuboid(1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -2.0F, -3.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(BassEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.animateMovement(FishAnimations.BASS_SWIMMING, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, FishAnimations.BASS_IDLE, ageInTicks, 1f);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bass.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return bass;
	}
}