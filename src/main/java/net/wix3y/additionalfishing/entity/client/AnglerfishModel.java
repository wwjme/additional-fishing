package net.wix3y.additionalfishing.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.wix3y.additionalfishing.entity.animation.FishAnimations;
import net.wix3y.additionalfishing.entity.custom.AnglerfishEntity;

public class AnglerfishModel<T extends AnglerfishEntity> extends SinglePartEntityModel<T> {
	private final ModelPart anglerfish;
	public AnglerfishModel(ModelPart root) {
		this.anglerfish = root.getChild("anglerfish");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData anglerfish = modelPartData.addChild("anglerfish", ModelPartBuilder.create().uv(16, 8).cuboid(-2.5F, -6.25F, -2.75F, 5.0F, 1.0F, 5.0F, new Dilation(0.0F))
		.uv(31, 0).cuboid(-1.5F, -6.25F, 2.25F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 21).cuboid(-2.5F, -5.25F, -0.75F, 5.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(28, 30).cuboid(-1.5F, -5.25F, 3.25F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(18, 22).cuboid(-2.5F, -4.25F, 1.25F, 5.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(30, 14).cuboid(-1.5F, -4.25F, 4.25F, 3.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(17, 0).cuboid(-2.5F, -3.25F, 0.25F, 5.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-2.5F, -1.25F, -3.75F, 5.0F, 1.0F, 7.0F, new Dilation(0.0F))
		.uv(30, 18).cuboid(-1.5F, -1.25F, 3.25F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(16, 15).cuboid(-2.0F, -0.75F, -2.75F, 4.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(16, 10).cuboid(1.75F, -5.25F, -0.25F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(16, 8).cuboid(-2.75F, -5.25F, -0.25F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(2, 11).cuboid(-0.5F, -8.25F, -6.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 23.0F, -1.0F));

		ModelPartData top_3_r1 = anglerfish.addChild("top_3_r1", ModelPartBuilder.create().uv(17, 0).cuboid(0.0F, -2.0F, -1.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -9.5F, -5.5F, 2.618F, 0.0F, 0.0F));

		ModelPartData top_2_r1 = anglerfish.addChild("top_2_r1", ModelPartBuilder.create().uv(0, 14).cuboid(0.0F, -3.0F, -1.0F, 0.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -9.5F, -2.5F, 1.5708F, 0.0F, 0.0F));

		ModelPartData top_1_r1 = anglerfish.addChild("top_1_r1", ModelPartBuilder.create().uv(0, 2).cuboid(0.0F, -4.0F, -1.0F, 0.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -6.0F, -0.5F, 0.5236F, 0.0F, 0.0F));

		ModelPartData body_6_1_r1 = anglerfish.addChild("body_6_1_r1", ModelPartBuilder.create().uv(25, 28).cuboid(-2.5F, -0.5F, -3.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.5F, -0.75F, -0.4363F, 0.0F, 0.0F));

		ModelPartData jaw = anglerfish.addChild("jaw", ModelPartBuilder.create().uv(0, 15).cuboid(-3.0F, 0.0F, -4.0F, 6.0F, 1.0F, 5.0F, new Dilation(0.0F))
		.uv(24, 6).cuboid(-3.0F, -1.0F, -4.0F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(19, 26).cuboid(-3.0F, -1.0F, -3.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(7, 26).cuboid(2.0F, -1.0F, -3.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(16, 22).cuboid(0.25F, -2.25F, -3.75F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F))
		.uv(2, 21).cuboid(-1.25F, -2.25F, -3.75F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, -0.5F, 0.2618F, 0.0F, 0.0F));

		ModelPartData tooth_r1 = jaw.addChild("tooth_r1", ModelPartBuilder.create().uv(19, 0).cuboid(-1.0F, -2.0F, -1.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(1.75F, -0.25F, 0.5F, 0.0F, -1.5708F, 0.0F));

		ModelPartData tooth_r2 = jaw.addChild("tooth_r2", ModelPartBuilder.create().uv(19, 2).cuboid(-1.0F, -2.0F, -1.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(1.75F, -0.25F, -1.25F, 0.0F, -1.5708F, 0.0F));

		ModelPartData tooth_r3 = jaw.addChild("tooth_r3", ModelPartBuilder.create().uv(19, 15).cuboid(-1.0F, -2.0F, -1.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.75F, -0.25F, -0.25F, 0.0F, 1.5708F, 0.0F));

		ModelPartData tooth_r4 = jaw.addChild("tooth_r4", ModelPartBuilder.create().uv(19, 17).cuboid(-1.0F, -2.0F, -1.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.75F, -0.25F, -2.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData tooth_r5 = jaw.addChild("tooth_r5", ModelPartBuilder.create().uv(0, 21).cuboid(-1.0F, -2.0F, -1.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -0.5F, -2.25F, 0.0F, -0.7854F, 0.0F));

		ModelPartData tooth_r6 = jaw.addChild("tooth_r6", ModelPartBuilder.create().uv(14, 21).cuboid(-1.0F, -2.0F, -1.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.25F, -0.5F, -2.75F, 0.0F, 0.7854F, 0.0F));

		ModelPartData upper_jaw = anglerfish.addChild("upper_jaw", ModelPartBuilder.create(), ModelTransform.of(-0.5F, -4.5F, 0.0F, -0.2618F, 0.0F, 0.0F));

		ModelPartData front_tooth_r1 = upper_jaw.addChild("front_tooth_r1", ModelPartBuilder.create().uv(17, 15).cuboid(-0.5F, 1.5F, -3.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F))
		.uv(17, 17).cuboid(1.25F, 1.5F, -3.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(3.0F, 1.5F, -3.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.25F, -0.75F, 0.25F, -0.1745F, 0.0F, 0.0F));

		ModelPartData left_tooth_r1 = upper_jaw.addChild("left_tooth_r1", ModelPartBuilder.create().uv(2, 16).cuboid(-2.5F, 1.5F, -2.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(2, 4).cuboid(2.0F, 1.5F, -2.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.75F, -0.75F, 1.75F, -0.1745F, 0.0F, 0.0F));

		ModelPartData left_tooth_r2 = upper_jaw.addChild("left_tooth_r2", ModelPartBuilder.create().uv(0, 17).cuboid(-2.5F, 1.5F, -2.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(2, 14).cuboid(2.0F, 1.5F, -2.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.75F, -0.75F, 0.0F, -0.1745F, 0.0F, 0.0F));

		ModelPartData right_r1 = upper_jaw.addChild("right_r1", ModelPartBuilder.create().uv(0, 26).cuboid(1.5F, 1.5F, -2.0F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F))
		.uv(12, 26).cuboid(-2.5F, 1.5F, -2.0F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F))
		.uv(25, 26).cuboid(-2.5F, 1.5F, -3.0F, 5.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 8).cuboid(-2.5F, 0.5F, -3.0F, 5.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -1.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		ModelPartData tail = anglerfish.addChild("tail", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(4, 7).cuboid(0.0F, -1.5F, 0.5F, 0.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 7).cuboid(0.0F, -2.5F, 1.5F, 0.0F, 5.0F, 1.0F, new Dilation(0.0F))
		.uv(2, 7).cuboid(0.0F, -3.5F, 2.5F, 0.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(4, 2).cuboid(0.0F, 0.5F, 2.5F, 0.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.75F, 5.25F));

		ModelPartData rightfin = anglerfish.addChild("rightfin", ModelPartBuilder.create().uv(0, 3).cuboid(0.0F, 0.0F, -0.5F, 1.0F, 0.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 13).cuboid(1.0F, 0.0F, -0.5F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(2.5F, -2.0F, 1.5F));

		ModelPartData leftfin = anglerfish.addChild("leftfin", ModelPartBuilder.create().uv(2, 0).cuboid(-1.0F, 0.0F, -0.5F, 1.0F, 0.0F, 2.0F, new Dilation(0.0F))
		.uv(3, 6).cuboid(-2.0F, 0.0F, -0.5F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.5F, -2.0F, 1.5F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(AnglerfishEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.animateMovement(FishAnimations.ANGLERFISH_SWIMMING, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, FishAnimations.ANGLERFISH_IDLE, ageInTicks, 1f);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		anglerfish.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return anglerfish;
	}
}