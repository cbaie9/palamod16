
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
public class Stickgui1GuiWindow extends ContainerScreen<Stickgui1Gui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = Stickgui1Gui.guistate;

	public Stickgui1GuiWindow(Stickgui1Gui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 400;
		this.ySize = 225;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/stickgui_1.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/1speed.png"));
		this.blit(ms, this.guiLeft + 0, this.guiTop + 103, 0, 0, 260, 118, 260, 118);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/1orbspeed.png"));
		this.blit(ms, this.guiLeft + 255, this.guiTop + 133, 0, 0, 87, 87, 87, 87);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/speedstick.png"));
		this.blit(ms, this.guiLeft + 120, this.guiTop + 193, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/speedstick.png"));
		this.blit(ms, this.guiLeft + 334, this.guiTop + 83, 0, 0, 32, 32, 32, 32);

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
		this.font.drawString(ms, "Sticks", 173, 4, -12829636);
		this.font.drawString(ms, "Les stick ( b\uFFFDton) de craftent dans la palamachine.Il en existe de plusieures", 8, 15, -12829636);
		this.font.drawString(ms, "types diff\uFFFDrent", 7, 28, -12829636);
		this.font.drawString(ms, "Speed stick : vous permet d'avoir un speed 3 pendant 10 secondes", 5, 83, -12829636);
		this.font.drawString(ms, "Craft de la speed orb", 257, 124, -12829636);
		this.font.drawString(ms, "(-", 343, 137, -12829636);
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
		this.addButton(new Button(this.guiLeft + 4, this.guiTop + 57, 70, 20, new StringTextComponent("item menu"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Stickgui1Gui.ButtonPressedMessage(0, x, y, z));
				Stickgui1Gui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 77, this.guiTop + 57, 45, 20, new StringTextComponent("menu"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Stickgui1Gui.ButtonPressedMessage(1, x, y, z));
				Stickgui1Gui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 127, this.guiTop + 57, 75, 20, new StringTextComponent("next stick"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Stickgui1Gui.ButtonPressedMessage(2, x, y, z));
				Stickgui1Gui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
