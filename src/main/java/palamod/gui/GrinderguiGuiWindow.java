
package palamod.gui;

import palamod.PalamodModVariables;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class GrinderguiGuiWindow extends ContainerScreen<GrinderguiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = GrinderguiGui.guistate;

	public GrinderguiGuiWindow(GrinderguiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 195;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/grindergui.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/arrow_xxl.png"));
		this.blit(ms, this.guiLeft + 29, this.guiTop + 26, 0, 0, 32, 16, 32, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/arrow_new.png"));
		this.blit(ms, this.guiLeft + 27, this.guiTop + 74, 0, 0, 24, 10, 24, 10);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/arr0.png"));
		this.blit(ms, this.guiLeft + 137, this.guiTop + 81, 0, 0, 32, 16, 32, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/r2_1.png"));
		this.blit(ms, this.guiLeft + 112, this.guiTop + 8, 0, 0, 48, 64, 48, 64);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "" + (PalamodModVariables.g_num) + " /100", 82, 100, -12829636);
		this.font.drawString(ms, "Inventory", 6, 101, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
	}
}
