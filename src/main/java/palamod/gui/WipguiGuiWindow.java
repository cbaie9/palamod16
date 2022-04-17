
package palamod.gui;

import palamod.PalamodMod;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class WipguiGuiWindow extends ContainerScreen<WipguiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = WipguiGui.guistate;

	public WipguiGuiWindow(WipguiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 275;
		this.ySize = 225;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/wipgui.png");

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
		this.font.drawString(ms, "Palamod - Not in working in progress", 45, 6, -3407872);
		this.font.drawString(ms, "release\u00B2 / poisson d'avril", 5, 208, -12829636);
		this.font.drawString(ms, "Vous croyer qu'en 1 semaine on peut cr\u00E9er un hdv", 11, 36, -12829636);
		this.font.drawString(ms, "BRUH", 11, 51, -12829636);
		this.font.drawString(ms, "Ceci est un poisson d'avril ( sans blague )", 10, 64, -12829636);
		this.font.drawString(ms, "Sinon serieux rendez-vous \u00E0 la fermeture de la ", 7, 81, -12829636);
		this.font.drawString(ms, "v7.5", 250, 80, -26368);
		this.font.drawString(ms, "Pour avoir une surprise ", 7, 92, -12829636);
		this.font.drawString(ms, "Ps /palagift pour du bonus", 6, 120, -12829636);
		this.font.drawString(ms, "Ps 2 Chercher bien pour les indices", 5, 131, -12829636);
		this.font.drawString(ms, "Build 0031", 215, 208, -12829636);
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
		this.addButton(new Button(this.guiLeft + 4, this.guiTop + 163, 186, 20, new StringTextComponent("continuer pour voir les travaux -)"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new WipguiGui.ButtonPressedMessage(0, x, y, z));
				WipguiGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 199, this.guiTop + 163, 61, 20, new StringTextComponent("devnote"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new WipguiGui.ButtonPressedMessage(1, x, y, z));
				WipguiGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
