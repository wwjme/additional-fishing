// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.wix3y.additionalfishing.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.wix3y.additionalfishing.entity.animation.FishAnimations;
import net.wix3y.additionalfishing.entity.custom.CrabEntity;

public class CrabModel<T extends CrabEntity> extends SinglePartEntityModel<T> {
	private final ModelPart crab;
	public CrabModel(ModelPart root) {
		this.crab = root.getChild("crab");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData crab = modelPartData.addChild("crab", ModelPartBuilder.create().uv(0, 0).cuboid(-3.5F, -1.75F, -1.5F, 7.0F, 1.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 5).cuboid(-3.5F, -2.5F, -0.25F, 7.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(11, 16).cuboid(-2.5F, -1.75F, 2.5F, 5.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 15).cuboid(-2.5F, -2.75F, 2.75F, 5.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 22.5F, 0.0F));

		ModelPartData back_right__r1 = crab.addChild("back_right__r1", ModelPartBuilder.create().uv(21, 4).cuboid(-2.0F, -0.5F, 1.5F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 9).cuboid(-2.0F, -0.5F, -3.5F, 4.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(1.75F, -2.5F, 1.5F, 0.0F, 0.0F, 0.2618F));

		ModelPartData back_right_front_r1 = crab.addChild("back_right_front_r1", ModelPartBuilder.create().uv(18, 2).cuboid(-2.0F, -0.5F, -2.5F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, -1.75F, 0.75F, 0.0F, 0.0F, 0.2618F));

		ModelPartData back_left__r1 = crab.addChild("back_left__r1", ModelPartBuilder.create().uv(0, 21).cuboid(-1.0F, -0.5F, 1.5F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(13, 10).cuboid(-2.0F, -0.5F, -3.5F, 4.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-1.75F, -2.5F, 1.5F, 0.0F, 0.0F, -0.2618F));

		ModelPartData back_left_front_r1 = crab.addChild("back_left_front_r1", ModelPartBuilder.create().uv(18, 0).cuboid(-2.0F, -0.5F, -2.5F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, -1.75F, 0.75F, 0.0F, 0.0F, -0.2618F));

		ModelPartData left_eye = crab.addChild("left_eye", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData eye_r1 = left_eye.addChild("eye_r1", ModelPartBuilder.create().uv(26, 20).cuboid(-1.0F, -2.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -3.0F, -1.0F, 0.1745F, 0.0F, -0.1745F));

		ModelPartData right_eye = crab.addChild("right_eye", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData eye_r2 = right_eye.addChild("eye_r2", ModelPartBuilder.create().uv(26, 11).cuboid(0.0F, -2.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -3.0F, -1.0F, 0.1745F, 0.0F, 0.1745F));

		ModelPartData left_claw = crab.addChild("left_claw", ModelPartBuilder.create().uv(17, 6).cuboid(-0.3192F, -0.5F, -2.0736F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(13, 12).cuboid(1.4308F, -0.5F, -3.0736F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -1.5F, -1.0F, 0.3491F, 0.6109F, 0.1745F));

		ModelPartData lower_arm_r1 = left_claw.addChild("lower_arm_r1", ModelPartBuilder.create().uv(23, 24).cuboid(-2.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.6808F, 0.0F, -2.5736F, 0.0F, 0.5236F, 0.0F));

		ModelPartData left_thumb = left_claw.addChild("left_thumb", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData claw_small_r1 = left_thumb.addChild("claw_small_r1", ModelPartBuilder.create().uv(24, 18).cuboid(-0.5F, -0.5F, -0.25F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.1808F, 0.0F, -2.0736F, 0.0F, 0.0873F, 0.0F));

		ModelPartData left_fingers = left_claw.addChild("left_fingers", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData claw_big_r1 = left_fingers.addChild("claw_big_r1", ModelPartBuilder.create().uv(16, 18).cuboid(-0.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.9308F, 0.0F, -3.0736F, 0.0F, -0.0873F, 0.0F));

		ModelPartData right_claw = crab.addChild("right_claw", ModelPartBuilder.create().uv(0, 17).cuboid(-0.6808F, -0.5F, -2.0736F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(0, 12).cuboid(-2.4308F, -0.5F, -3.0736F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -1.5F, -1.0F, 0.3491F, -0.6109F, -0.1745F));

		ModelPartData lower_arm_r2 = right_claw.addChild("lower_arm_r2", ModelPartBuilder.create().uv(14, 21).cuboid(0.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.6808F, 0.0F, -2.5736F, 0.0F, -0.5236F, 0.0F));

		ModelPartData right_thumb = right_claw.addChild("right_thumb", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData claw_small_r2 = right_thumb.addChild("claw_small_r2", ModelPartBuilder.create().uv(8, 21).cuboid(-1.5F, -0.5F, -0.25F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.1808F, 0.0F, -2.0736F, 0.0F, -0.0873F, 0.0F));

		ModelPartData right_fingers = right_claw.addChild("right_fingers", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData claw_big_r2 = right_fingers.addChild("claw_big_r2", ModelPartBuilder.create().uv(8, 18).cuboid(-2.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.9308F, 0.0F, -3.0736F, 0.0F, 0.0873F, 0.0F));

		ModelPartData left_leg_1 = crab.addChild("left_leg_1", ModelPartBuilder.create().uv(26, 8).cuboid(-1.3368F, -0.0076F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(3, 11).cuboid(-1.3368F, 1.9924F, -0.5F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.9132F, -1.4924F, -0.75F, 0.0F, -0.5236F, 0.0F));

		ModelPartData leg_r1 = left_leg_1.addChild("leg_r1", ModelPartBuilder.create().uv(0, 25).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.0868F, 0.4924F, 0.5F, 0.0F, 0.0F, 0.1745F));

		ModelPartData left_leg_2 = crab.addChild("left_leg_2", ModelPartBuilder.create().uv(18, 25).cuboid(-1.3368F, -0.0076F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(3, 8).cuboid(-1.3368F, 1.9924F, -0.5F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.1632F, -1.4924F, 0.5F, 0.0F, -0.1745F, 0.0F));

		ModelPartData leg_r2 = left_leg_2.addChild("leg_r2", ModelPartBuilder.create().uv(18, 23).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.0868F, 0.4924F, 0.5F, 0.0F, 0.0F, 0.1745F));

		ModelPartData left_leg_3 = crab.addChild("left_leg_3", ModelPartBuilder.create().uv(14, 25).cuboid(-1.3368F, -0.0076F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-1.3368F, 1.9924F, -0.5F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.1632F, -1.4924F, 2.0F, 0.0F, 0.1745F, 0.0F));

		ModelPartData leg_r3 = left_leg_3.addChild("leg_r3", ModelPartBuilder.create().uv(23, 16).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.0868F, 0.4924F, 0.5F, 0.0F, 0.0F, 0.1745F));

		ModelPartData left_leg_4 = crab.addChild("left_leg_4", ModelPartBuilder.create().uv(10, 25).cuboid(-1.3368F, -0.0076F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 5).cuboid(-1.3368F, 1.9924F, -0.5F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.4132F, -1.4924F, 3.25F, 0.0F, 0.5236F, 0.0F));

		ModelPartData leg_r4 = left_leg_4.addChild("leg_r4", ModelPartBuilder.create().uv(12, 23).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.0868F, 0.4924F, 0.5F, 0.0F, 0.0F, 0.1745F));

		ModelPartData right_leg_1 = crab.addChild("right_leg_1", ModelPartBuilder.create().uv(6, 25).cuboid(-1.3368F, -0.0076F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 4).cuboid(-1.3368F, 1.9924F, -0.5F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.9132F, -1.4924F, -0.75F, 0.0F, -2.618F, 0.0F));

		ModelPartData leg_r5 = right_leg_1.addChild("leg_r5", ModelPartBuilder.create().uv(6, 23).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.0868F, 0.4924F, 0.5F, 0.0F, 0.0F, 0.1745F));

		ModelPartData right_leg_2 = crab.addChild("right_leg_2", ModelPartBuilder.create().uv(13, 9).cuboid(-1.3368F, -0.0076F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(2, 2).cuboid(-1.3368F, 1.9924F, -0.5F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(4.1632F, -1.4924F, 0.5F, 0.0F, -2.9671F, 0.0F));

		ModelPartData leg_r6 = right_leg_2.addChild("leg_r6", ModelPartBuilder.create().uv(0, 23).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.0868F, 0.4924F, 0.5F, 0.0F, 0.0F, 0.1745F));

		ModelPartData right_leg_3 = crab.addChild("right_leg_3", ModelPartBuilder.create().uv(0, 9).cuboid(-1.3368F, -0.0076F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(11, 14).cuboid(-1.3368F, 1.9924F, -0.5F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(4.1632F, -1.4924F, 2.0F, 0.0F, 2.9671F, 0.0F));

		ModelPartData leg_r7 = right_leg_3.addChild("leg_r7", ModelPartBuilder.create().uv(22, 6).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.0868F, 0.4924F, 0.5F, 0.0F, 0.0F, 0.1745F));

		ModelPartData right_leg_4 = crab.addChild("right_leg_4", ModelPartBuilder.create().uv(0, 0).cuboid(-1.3368F, -0.0076F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 2).cuboid(-1.3368F, 1.9924F, -0.5F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.4132F, -1.4924F, 3.25F, 0.0F, 2.618F, 0.0F));

		ModelPartData leg_r8 = right_leg_4.addChild("leg_r8", ModelPartBuilder.create().uv(20, 21).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.0868F, 0.4924F, 0.5F, 0.0F, 0.0F, 0.1745F));
		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void setAngles(CrabEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.animateMovement(FishAnimations.CRAB_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, FishAnimations.CRAB_IDLE, ageInTicks, 1f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		crab.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return crab;
	}
}