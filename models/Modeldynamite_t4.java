// Made with Blockbench 4.1.1
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modeldynamite_t4 extends EntityModel<Entity> {
	private final ModelRenderer bb_main;
	private final ModelRenderer dyme_r1;

	public Modeldynamite_t4() {
		textureWidth = 16;
		textureHeight = 16;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(0, 2).addBox(-2.0F, -2.0F, -2.0F, 2.0F, 2.0F, 8.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 2).addBox(-2.0F, -2.0F, -2.0F, 2.0F, 2.0F, 8.0F, 0.0F, false);

		dyme_r1 = new ModelRenderer(this);
		dyme_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(dyme_r1);
		setRotationAngle(dyme_r1, 0.0873F, 0.0873F, 0.0F);
		dyme_r1.setTextureOffset(0, 13).addBox(-2.0F, -1.0F, 6.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}