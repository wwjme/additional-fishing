package net.wix3y.additionalfishing.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.wix3y.additionalfishing.entity.animation.FishAnimations;
import net.wix3y.additionalfishing.entity.custom.GoldfishEntity;

public class GoldfishModel<T extends GoldfishEntity> extends SinglePartEntityModel<T> {
	private final ModelPart goldfish;
	public GoldfishModel(ModelPart root) {
		this.goldfish = root.getChild("goldfish");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData goldfish = modelPartData.addChild("goldfish", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -4.0F, -5.0F, 2.0F, 3.0F, 6.0F, new Dilation(0.0F))
		.uv(4, 8).cuboid(0.0F, -4.75F, -4.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 8).cuboid(0.0F, -5.25F, -3.25F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(4, 1).cuboid(0.0F, -4.5F, -0.5F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(7, 7).cuboid(0.0F, -1.5F, -1.5F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 3).cuboid(0.0F, -1.5F, -4.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData tail = goldfish.addChild("tail", ModelPartBuilder.create().uv(4, 4).cuboid(0.0F, -0.5F, 0.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(0.0F, -1.5F, 1.0F, 0.0F, 3.0F, 2.0F, new Dilation(0.0F))
		.uv(4, 3).cuboid(0.0F, -1.5F, 3.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(4, 2).cuboid(0.0F, 0.5F, 3.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.5F, 1.0F));

		ModelPartData left_fin = goldfish.addChild("left_fin", ModelPartBuilder.create().uv(0, 1).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 0.0F, 1.0F, new Dilation(0.0F))
		.uv(9, 0).cuboid(-2.0F, 0.0F, 0.0F, 3.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -1.75F, -2.5F, -0.1572F, 0.3614F, -0.4215F));

		ModelPartData right_fin = goldfish.addChild("right_fin", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 0.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 9).cuboid(-1.0F, 0.0F, 0.0F, 3.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -1.75F, -2.5F, -0.1572F, -0.3614F, 0.4215F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(GoldfishEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.animateMovement(FishAnimations.GOLDFISH_SWIMMING, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, FishAnimations.GOLDFISH_IDLE, ageInTicks, 1f);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		goldfish.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return goldfish;
	}
}