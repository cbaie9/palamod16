package palamod.entity.renderer;

import palamod.entity.PaladiumdynamiteEntity;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class PaladiumdynamiteRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(PaladiumdynamiteEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modeldynamite_t4(), 0.5f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("palamod:textures/pala_dyna.png");
					}
				};
			});
		}
	}

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
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}

}
