
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
public class PaladumfurnaceGuiWindow extends ContainerScreen<PaladumfurnaceGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = PaladumfurnaceGui.guistate;

	public PaladumfurnaceGuiWindow(PaladumfurnaceGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 180;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/paladumfurnace.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/big_slot.png"));
		this.blit(ms, this.guiLeft + 117, this.guiTop + 33, 0, 0, 26, 26, 26, 26);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/fire.png"));
		this.blit(ms, this.guiLeft + 58, this.guiTop + 42, 0, 0, 17, 14, 17, 14);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/fire01.png"));
		this.blit(ms, this.guiLeft + 58, this.guiTop + 40, 0, 0, 21, 17, 21, 17);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/fire02.png"));
		this.blit(ms, this.guiLeft + 61, this.guiTop + 41, 0, 0, 18, 16, 18, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/fire03.png"));
		this.blit(ms, this.guiLeft + 61, this.guiTop + 41, 0, 0, 17, 15, 17, 15);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/fire04.png"));
		this.blit(ms, this.guiLeft + 60, this.guiTop + 43, 0, 0, 17, 13, 17, 13);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/fire05.png"));
		this.blit(ms, this.guiLeft + 59, this.guiTop + 42, 0, 0, 20, 16, 20, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/fire06.png"));
		this.blit(ms, this.guiLeft + 60, this.guiTop + 39, 0, 0, 19, 18, 19, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/fire07.png"));
		this.blit(ms, this.guiLeft + 60, this.guiTop + 41, 0, 0, 18, 17, 18, 17);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/fire08.png"));
		this.blit(ms, this.guiLeft + 60, this.guiTop + 43, 0, 0, 16, 14, 16, 14);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/fire09.png"));
		this.blit(ms, this.guiLeft + 61, this.guiTop + 41, 0, 0, 16, 16, 16, 16);

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
		this.font.drawString(ms, "Paladium Furnace", 38, 3, -12829636);
		this.font.drawString(ms, "Inventory", 7, 73, -12829636);
		this.font.drawString(ms, "Upgrades", 2, 16, -65536);
		this.font.drawString(ms, "" + (int) (PalamodModVariables.g_num) + "", 89, 66, -12829636);
		this.font.drawString(ms, "" + (PalamodModVariables.Lucky_destroy) + "", 92, 18, -12829636);
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
