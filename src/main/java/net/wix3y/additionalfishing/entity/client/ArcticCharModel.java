package net.wix3y.additionalfishing.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.wix3y.additionalfishing.entity.animation.FishAnimations;
import net.wix3y.additionalfishing.entity.custom.ArcticCharEntity;

public class ArcticCharModel<T extends ArcticCharEntity> extends SinglePartEntityModel<T> {
	private final ModelPart arctic_char;
	public ArcticCharModel(ModelPart root) {
		this.arctic_char = root.getChild("arctic_char");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData arctic_char = modelPartData.addChild("arctic_char", ModelPartBuilder.create().uv(14, 13).cuboid(-1.5F, -6.0F, -8.0F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-2.0F, -6.5F, -5.0F, 4.0F, 5.0F, 8.0F, new Dilation(0.0F))
		.uv(16, 0).cuboid(-2.0F, -6.0F, 3.0F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 1).cuboid(0.0F, -7.25F, -3.0F, 0.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(0.0F, -8.0F, -2.0F, 0.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 11).cuboid(0.0F, -1.75F, -3.5F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData bottom_fin_right_r1 = arctic_char.addChild("bottom_fin_right_r1", ModelPartBuilder.create().uv(0, 12).cuboid(0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(1.25F, -1.75F, 1.5F, -0.2618F, 0.5236F, 0.0F));

		ModelPartData bottom_fin_left_r1 = arctic_char.addChild("bottom_fin_left_r1", ModelPartBuilder.create().uv(0, 13).cuboid(0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.25F, -1.75F, 1.5F, -0.2618F, -0.5236F, 0.0F));

		ModelPartData left_fin = arctic_char.addChild("left_fin", ModelPartBuilder.create().uv(9, 13).cuboid(-0.75F, 0.0F, -1.5F, 1.0F, 0.0F, 3.0F, new Dilation(0.0F))
		.uv(7, 13).cuboid(-1.5F, 0.0F, -0.5F, 1.0F, 0.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -2.75F, -2.0F));

		ModelPartData right_fin = arctic_char.addChild("right_fin", ModelPartBuilder.create().uv(2, 0).cuboid(-0.25F, 0.0F, -1.5F, 1.0F, 0.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(0.5F, 0.0F, -0.5F, 1.0F, 0.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -2.75F, -2.0F));

		ModelPartData tail = arctic_char.addChild("tail", ModelPartBuilder.create().uv(0, 13).cuboid(-2.0F, -1.5F, -1.0F, 3.0F, 3.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 4).cuboid(-0.5F, -0.5F, 3.0F, 0.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 3).cuboid(-0.5F, -1.5F, 4.0F, 0.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-0.5F, 0.5F, 4.0F, 0.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, -4.0F, 5.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(ArcticCharEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.animateMovement(FishAnimations.ARCTIC_CHAR_SWIMMING, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, FishAnimations.ARCTIC_CHAR_IDLE, ageInTicks, 1f);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		arctic_char.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return arctic_char;
	}
}