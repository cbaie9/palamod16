
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
public class NextPalahelpguiGuiWindow extends ContainerScreen<NextPalahelpguiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = NextPalahelpguiGui.guistate;

	public NextPalahelpguiGuiWindow(NextPalahelpguiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/next_palahelpgui.png");

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

		Minecraft.getInstance().getTextureManager()
				.bindTexture(new ResourceLocation("palamod:textures/palablock_green_palahelp2-removebg-preview_1.png"));
		this.blit(ms, this.guiLeft + 5, this.guiTop + 20, 0, 0, 75, 80, 75, 80);

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
		this.font.drawString(ms, "Palahelp", 5, 4, -52429);
		this.font.drawString(ms, "2/2", 4, 102, -16750951);
		this.font.drawString(ms, "more in the future :)", 63, 111, -12829636);
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
		this.addButton(new Button(this.guiLeft + 87, this.guiTop + 24, 80, 20, new StringTextComponent(" /..Commands"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new NextPalahelpguiGui.ButtonPressedMessage(0, x, y, z));
				NextPalahelpguiGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 87, this.guiTop + 56, 80, 20, new StringTextComponent("Lucky Stats"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new NextPalahelpguiGui.ButtonPressedMessage(1, x, y, z));
				NextPalahelpguiGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 6, this.guiTop + 134, 75, 20, new StringTextComponent("(---- Back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new NextPalahelpguiGui.ButtonPressedMessage(2, x, y, z));
				NextPalahelpguiGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
