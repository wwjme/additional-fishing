// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.wix3y.additionalfishing.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.wix3y.additionalfishing.entity.animation.FishAnimations;
import net.wix3y.additionalfishing.entity.custom.PiranhaEntity;

public class PiranhaModel<T extends PiranhaEntity> extends SinglePartEntityModel<T> {
	private final ModelPart piranha;
	public PiranhaModel(ModelPart root) {
		this.piranha = root.getChild("piranha");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData piranha = modelPartData.addChild("piranha", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -4.0F, -6.0F, 4.0F, 4.0F, 10.0F, new Dilation(0.0F))
		.uv(0, 14).cuboid(-2.0F, 0.0F, -4.0F, 4.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 21.0F, 1.0F));

		ModelPartData jaw = piranha.addChild("jaw", ModelPartBuilder.create().uv(16, 14).cuboid(-2.25F, 0.25F, -3.25F, 4.5F, 1.0F, 3.5F, new Dilation(0.0F))
		.uv(18, 5).cuboid(1.75F, -0.75F, -3.25F, 0.5F, 1.0F, 3.5F, new Dilation(0.0F))
		.uv(18, 0).cuboid(-2.25F, -0.75F, -3.25F, 0.5F, 1.0F, 3.5F, new Dilation(0.0F))
		.uv(16, 19).cuboid(-1.75F, -0.75F, -3.25F, 3.5F, 1.0F, 0.5F, new Dilation(0.0F))
		.uv(8, 5).cuboid(2.25F, -1.75F, -0.75F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(4, 8).cuboid(2.25F, -1.75F, -2.75F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(2, 14).cuboid(1.25F, -1.75F, -3.25F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(0, 14).cuboid(-0.5F, -1.75F, -3.25F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-2.25F, -1.75F, -3.25F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(2, 8).cuboid(-2.25F, -1.75F, -2.75F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 8).cuboid(-2.25F, -1.75F, -0.75F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, -3.0F, 0.1309F, 0.0F, 0.0F));

		ModelPartData topfin = piranha.addChild("topfin", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -1.0F, -1.5F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 2).cuboid(0.0F, -2.0F, -0.5F, 0.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -4.0F, -0.5F));

		ModelPartData rightfin = piranha.addChild("rightfin", ModelPartBuilder.create().uv(0, 2).cuboid(-1.0F, 0.0F, -0.5F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
		.uv(7, 0).cuboid(1.0F, 0.0F, -0.5F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 1.0F, -1.5F));

		ModelPartData leftfin = piranha.addChild("leftfin", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, 0.0F, -0.5F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
		.uv(5, 0).cuboid(-2.0F, 0.0F, -0.5F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 1.0F, -1.5F));

		ModelPartData bottomfin = piranha.addChild("bottomfin", ModelPartBuilder.create().uv(0, 4).cuboid(0.0F, -1.0F, -0.5F, 0.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 2.0F, 0.5F));

		ModelPartData backfin = piranha.addChild("backfin", ModelPartBuilder.create().uv(6, 5).cuboid(0.0F, -1.5F, -1.0F, 0.0F, 3.0F, 2.0F, new Dilation(0.0F))
		.uv(8, 0).cuboid(0.0F, -2.5F, 1.0F, 0.0F, 5.0F, 1.0F, new Dilation(0.0F))
		.uv(6, 0).cuboid(0.0F, -3.5F, 2.0F, 0.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(0.0F, 0.5F, 2.0F, 0.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.5F, 4.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(PiranhaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.animateMovement(FishAnimations.PIRANHA_SWIMMING, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, FishAnimations.PIRANHA_IDLE, ageInTicks, 1f);
		this.updateAnimation(entity.attackAnimationState, FishAnimations.PIRANHA_ATTACK, ageInTicks, 1f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		piranha.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return piranha;
	}
}