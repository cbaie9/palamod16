
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
public class Stickgui7GuiWindow extends ContainerScreen<Stickgui7Gui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = Stickgui7Gui.guistate;

	public Stickgui7GuiWindow(Stickgui7Gui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 400;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/stickgui_7.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/1amage.png"));
		this.blit(ms, this.guiLeft + 0, this.guiTop + 48, 0, 0, 261, 116, 261, 116);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/image27.png"));
		this.blit(ms, this.guiLeft + 263, this.guiTop + 72, 0, 0, 86, 86, 86, 86);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/damagestick.png"));
		this.blit(ms, this.guiLeft + 287, this.guiTop + 30, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/damagestick.png"));
		this.blit(ms, this.guiLeft + 122, this.guiTop + 135, 0, 0, 16, 16, 16, 16);

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
		this.font.drawString(ms, "Damage stick : cr\uFFFDe un effet de knockback autout de vous", 3, 33, -12829636);
		this.font.drawString(ms, "craft du spike en paladium", 264, 60, -12829636);
		this.font.drawString(ms, "(--", 349, 73, -12829636);
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
		this.addButton(new Button(this.guiLeft + 7, this.guiTop + 8, 100, 20, new StringTextComponent("stick pr???c???dant"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Stickgui7Gui.ButtonPressedMessage(0, x, y, z));
				Stickgui7Gui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 125, this.guiTop + 7, 70, 20, new StringTextComponent("item menu"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Stickgui7Gui.ButtonPressedMessage(1, x, y, z));
				Stickgui7Gui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 212, this.guiTop + 7, 45, 20, new StringTextComponent("menu"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Stickgui7Gui.ButtonPressedMessage(2, x, y, z));
				Stickgui7Gui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
