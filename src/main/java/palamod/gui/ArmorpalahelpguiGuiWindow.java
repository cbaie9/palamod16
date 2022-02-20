
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
public class ArmorpalahelpguiGuiWindow extends ContainerScreen<ArmorpalahelpguiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = ArmorpalahelpguiGui.guistate;

	public ArmorpalahelpguiGuiWindow(ArmorpalahelpguiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 300;
		this.ySize = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/armorpalahelpgui.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/amethyst_helmet.png"));
		this.blit(ms, this.guiLeft + 4, this.guiTop + 6, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/amethyst_chestplate.png"));
		this.blit(ms, this.guiLeft + 4, this.guiTop + 40, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/amethyst_leggings.png"));
		this.blit(ms, this.guiLeft + 5, this.guiTop + 77, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/amethyst_boots.png"));
		this.blit(ms, this.guiLeft + 5, this.guiTop + 121, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/endium_helmet.png"));
		this.blit(ms, this.guiLeft + 216, this.guiTop + 12, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/endium_chestplate.png"));
		this.blit(ms, this.guiLeft + 217, this.guiTop + 45, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/endium_leggings.png"));
		this.blit(ms, this.guiLeft + 216, this.guiTop + 80, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/endium_boots.png"));
		this.blit(ms, this.guiLeft + 220, this.guiTop + 117, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/paladium_chestplate.png"));
		this.blit(ms, this.guiLeft + 150, this.guiTop + 44, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/paladium_green_chestplate.png"));
		this.blit(ms, this.guiLeft + 114, this.guiTop + 42, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/paladium_green_boots.png"));
		this.blit(ms, this.guiLeft + 114, this.guiTop + 118, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/paladium_green_helmet.png"));
		this.blit(ms, this.guiLeft + 114, this.guiTop + 11, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/paladium_green_leggings.png"));
		this.blit(ms, this.guiLeft + 114, this.guiTop + 79, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/paladium_helmet.png"));
		this.blit(ms, this.guiLeft + 150, this.guiTop + 13, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/paladium_leggings.png"));
		this.blit(ms, this.guiLeft + 149, this.guiTop + 81, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/paladium_boots.png"));
		this.blit(ms, this.guiLeft + 152, this.guiTop + 118, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/titane_helmet.png"));
		this.blit(ms, this.guiLeft + 56, this.guiTop + 6, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/titane_chestplate.png"));
		this.blit(ms, this.guiLeft + 59, this.guiTop + 41, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/titane_leggings.png"));
		this.blit(ms, this.guiLeft + 60, this.guiTop + 79, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/titane_boots.png"));
		this.blit(ms, this.guiLeft + 60, this.guiTop + 117, 0, 0, 32, 32, 32, 32);

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
		this.font.drawString(ms, "+ 4.5", 35, 18, -12829636);
		this.font.drawString(ms, "+ 5", 36, 51, -12829636);
		this.font.drawString(ms, "+ 4", 36, 83, -12829636);
		this.font.drawString(ms, "+ 4.5", 37, 130, -12829636);
		this.font.drawString(ms, "+ 4.5", 82, 16, -12829636);
		this.font.drawString(ms, "+ 4.5", 88, 124, -12829636);
		this.font.drawString(ms, "+ 5", 88, 88, -12829636);
		this.font.drawString(ms, "+ 5", 90, 51, -12829636);
		this.font.drawString(ms, "+ 4.5", 179, 21, -12829636);
		this.font.drawString(ms, "Night Vision II", 159, 7, -12829636);
		this.font.drawString(ms, "+ 6.5", 183, 50, -12829636);
		this.font.drawString(ms, "Force", 181, 59, -12829636);
		this.font.drawString(ms, "+ 5.5 ", 179, 85, -12829636);
		this.font.drawString(ms, "Haste", 180, 98, -12829636);
		this.font.drawString(ms, "+ 5 Speed", 179, 124, -12829636);
		this.font.drawString(ms, "+ 5", 248, 21, -12829636);
		this.font.drawString(ms, "+ 7", 248, 53, -12829636);
		this.font.drawString(ms, "+ 5.5", 243, 87, -12829636);
		this.font.drawString(ms, "+ 5.5", 247, 122, -12829636);
		this.font.drawString(ms, "Night Vision II", 218, 37, -12829636);
		this.font.drawString(ms, "Force", 248, 62, -12829636);
		this.font.drawString(ms, "Haste", 249, 96, -12829636);
		this.font.drawString(ms, "Speed", 253, 131, -12829636);
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
		this.addButton(new Button(this.guiLeft + 9, this.guiTop + 155, 45, 20, new StringTextComponent("Back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new ArmorpalahelpguiGui.ButtonPressedMessage(0, x, y, z));
				ArmorpalahelpguiGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 62, this.guiTop + 155, 45, 20, new StringTextComponent("menu"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new ArmorpalahelpguiGui.ButtonPressedMessage(1, x, y, z));
				ArmorpalahelpguiGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
