// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.wix3y.additionalfishing.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.wix3y.additionalfishing.entity.animation.FishAnimations;
import net.wix3y.additionalfishing.entity.custom.ShrimpEntity;

public class ShrimpModel<T extends ShrimpEntity> extends SinglePartEntityModel<T> {
	private final ModelPart shrimp;
	public ShrimpModel(ModelPart root) {
		this.shrimp = root.getChild("shrimp");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData shrimp = modelPartData.addChild("shrimp", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -4.0F, -4.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F))
				.uv(0, 8).cuboid(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 23.0F, 0.0F));

		ModelPartData left_antenna = shrimp.addChild("left_antenna", ModelPartBuilder.create().uv(0, 4).cuboid(0.0F, -1.5F, -2.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(2, 4).cuboid(0.0F, -0.5F, -1.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, -3.5F, -4.0F));

		ModelPartData right_antenna = shrimp.addChild("right_antenna", ModelPartBuilder.create().uv(4, 4).cuboid(0.0F, -1.5F, -2.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 7).cuboid(0.0F, -0.5F, -1.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, -3.5F, -4.0F));

		ModelPartData left_legs = shrimp.addChild("left_legs", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, -2.0F, -1.5F));

		ModelPartData leg_3_r1 = left_legs.addChild("leg_3_r1", ModelPartBuilder.create().uv(2, 2).cuboid(-1.0F, 0.0F, -0.5F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 2).cuboid(-1.0F, 0.0F, -2.5F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -0.7854F));

		ModelPartData right_legs = shrimp.addChild("right_legs", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, -2.0F, -1.5F));

		ModelPartData leg_1_r1 = right_legs.addChild("leg_1_r1", ModelPartBuilder.create().uv(2, 3).cuboid(-0.1768F, -0.1768F, -1.5F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 3).cuboid(-0.1768F, -0.1768F, 0.5F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.25F, 0.0F, 0.0F, 0.0F, 0.7854F));

		ModelPartData tail = shrimp.addChild("tail", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(5, 8).cuboid(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 1.0F, new Dilation(0.0F))
				.uv(2, 4).cuboid(-1.5F, 0.0F, -3.0F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 4).cuboid(0.5F, 0.0F, -3.0F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.5F, 0.0F));
		return TexturedModelData.of(modelData, 16, 16);
	}
	@Override
	public void setAngles(ShrimpEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.animateMovement(FishAnimations.SHRIMP_SWIMMING, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, FishAnimations.SHRIMP_IDLE, ageInTicks, 1f);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		shrimp.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return shrimp;
	}
}