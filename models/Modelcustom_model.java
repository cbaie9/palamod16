// Made with Blockbench 4.1.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelcustom_model extends EntityModel<Entity> {
	private final ModelRenderer elephant;
	private final ModelRenderer jambes;
	private final ModelRenderer pied;
	private final ModelRenderer tete;
	private final ModelRenderer oreille_gauche_p4_r1;
	private final ModelRenderer oreille_gauche_p3_r1;
	private final ModelRenderer oreille_gauche_p3_r2;
	private final ModelRenderer oreille_gauche_p2_r1;
	private final ModelRenderer oreille_gauche_p2_r2;
	private final ModelRenderer oreille_gauche_p1_r1;
	private final ModelRenderer t_central_r1;

	public Modelcustom_model() {
		textureWidth = 32;
		textureHeight = 32;

		elephant = new ModelRenderer(this);
		elephant.setRotationPoint(0.0F, 24.0F, 0.0F);
		elephant.setTextureOffset(3, 19).addBox(-3.0F, -9.0F, -4.0F, 6.0F, 5.0F, 8.0F, 0.0F, false);

		jambes = new ModelRenderer(this);
		jambes.setRotationPoint(0.0F, 0.0F, 0.0F);
		elephant.addChild(jambes);

		pied = new ModelRenderer(this);
		pied.setRotationPoint(0.0F, 0.0F, 0.0F);
		jambes.addChild(pied);
		pied.setTextureOffset(24, 19).addBox(2.0F, -6.0F, 1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		pied.setTextureOffset(24, 19).addBox(2.0F, -6.0F, -4.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		pied.setTextureOffset(24, 19).addBox(-4.0F, -6.0F, -4.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		pied.setTextureOffset(24, 19).addBox(-4.0F, -6.0F, 1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		tete = new ModelRenderer(this);
		tete.setRotationPoint(0.0F, 0.0F, 0.0F);
		elephant.addChild(tete);

		oreille_gauche_p4_r1 = new ModelRenderer(this);
		oreille_gauche_p4_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		tete.addChild(oreille_gauche_p4_r1);
		setRotationAngle(oreille_gauche_p4_r1, 0.0F, 0.0F, 0.0873F);
		oreille_gauche_p4_r1.setTextureOffset(0, 15).addBox(1.0F, -10.0F, 6.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		oreille_gauche_p3_r1 = new ModelRenderer(this);
		oreille_gauche_p3_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		tete.addChild(oreille_gauche_p3_r1);
		setRotationAngle(oreille_gauche_p3_r1, 0.0F, 0.0F, -0.0873F);
		oreille_gauche_p3_r1.setTextureOffset(0, 19).addBox(-3.0F, -10.0F, 6.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		oreille_gauche_p3_r2 = new ModelRenderer(this);
		oreille_gauche_p3_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		tete.addChild(oreille_gauche_p3_r2);
		setRotationAngle(oreille_gauche_p3_r2, 0.0F, 0.0F, 1.6144F);
		oreille_gauche_p3_r2.setTextureOffset(3, 23).addBox(-10.0F, 3.5F, 6.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		oreille_gauche_p2_r1 = new ModelRenderer(this);
		oreille_gauche_p2_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		tete.addChild(oreille_gauche_p2_r1);
		setRotationAngle(oreille_gauche_p2_r1, 0.0F, 0.0F, 1.4399F);
		oreille_gauche_p2_r1.setTextureOffset(3, 23).addBox(-10.0F, -5.5F, 6.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		oreille_gauche_p2_r2 = new ModelRenderer(this);
		oreille_gauche_p2_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		tete.addChild(oreille_gauche_p2_r2);
		setRotationAngle(oreille_gauche_p2_r2, 0.0F, 0.0F, -0.1745F);
		oreille_gauche_p2_r2.setTextureOffset(3, 23).addBox(3.0F, -10.0F, 6.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		oreille_gauche_p1_r1 = new ModelRenderer(this);
		oreille_gauche_p1_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		tete.addChild(oreille_gauche_p1_r1);
		setRotationAngle(oreille_gauche_p1_r1, 0.0F, 0.0F, 0.1745F);
		oreille_gauche_p1_r1.setTextureOffset(3, 23).addBox(-6.0F, -10.0F, 6.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		t_central_r1 = new ModelRenderer(this);
		t_central_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		tete.addChild(t_central_r1);
		setRotationAngle(t_central_r1, 0.0F, 3.1416F, 0.0F);
		t_central_r1.setTextureOffset(0, 0).addBox(-2.0F, -11.0F, -8.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		elephant.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		this.pied.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
		this.t_central_r1.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.t_central_r1.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}