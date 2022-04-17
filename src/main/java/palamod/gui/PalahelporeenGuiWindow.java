
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
public class PalahelporeenGuiWindow extends ContainerScreen<PalahelporeenGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = PalahelporeenGui.guistate;

	public PalahelporeenGuiWindow(PalahelporeenGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 280;
		this.ySize = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/palahelporeen.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/amethyst_ingot.png"));
		this.blit(ms, this.guiLeft + 4, this.guiTop + 141, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/paladium_ingot.png"));
		this.blit(ms, this.guiLeft + 3, this.guiTop + 65, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/findium.png"));
		this.blit(ms, this.guiLeft + 4, this.guiTop + 83, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/titane_ingot.png"));
		this.blit(ms, this.guiLeft + 4, this.guiTop + 109, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/paladium_green_ingot.png"));
		this.blit(ms, this.guiLeft + 3, this.guiTop + 47, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/endium_ingot.png"));
		this.blit(ms, this.guiLeft + 3, this.guiTop + 27, 0, 0, 16, 16, 16, 16);

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
		this.font.drawString(ms, "Paladium : The most powerful ore  who can be mined", 18, 73, -52480);
		this.font.drawString(ms, "some other thing", 18, 97, -205);
		this.font.drawString(ms, "Low cost ore, can be easily find ", 6, 157, -6750055);
		this.font.drawString(ms, "Very good ore for your first tools in the mod", 24, 125, -12829636);
		this.font.drawString(ms, "Am\u00E9thyste :", 24, 145, -6750055);
		this.font.drawString(ms, "Titane :", 23, 116, -12829636);
		this.font.drawString(ms, "Findium : can be used for crafting cave block and", 20, 87, -205);
		this.font.drawString(ms, "Green Paladium : Paladium but very very rare", 23, 51, -10027213);
		this.font.drawString(ms, "Endium : The ultimate ingot", 22, 29, -13434727);
		this.font.drawString(ms, "Obtain by Paladium crusher", 139, 37, -13434727);
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
		this.addButton(new Button(this.guiLeft + 222, this.guiTop + 6, 45, 20, new StringTextComponent("back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelporeenGui.ButtonPressedMessage(0, x, y, z));
				PalahelporeenGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 6, this.guiTop + 4, 45, 20, new StringTextComponent("menu"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelporeenGui.ButtonPressedMessage(1, x, y, z));
				PalahelporeenGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
