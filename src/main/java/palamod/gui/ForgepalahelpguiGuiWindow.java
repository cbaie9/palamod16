
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
public class ForgepalahelpguiGuiWindow extends ContainerScreen<ForgepalahelpguiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = ForgepalahelpguiGui.guistate;

	public ForgepalahelpguiGuiWindow(ForgepalahelpguiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 300;
		this.ySize = 175;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/forgepalahelpgui.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/5forge.png"));
		this.blit(ms, this.guiLeft + 126, this.guiTop + 1, 0, 0, 171, 78, 171, 78);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/forge_front_on.png"));
		this.blit(ms, this.guiLeft + 7, this.guiTop + 56, 0, 0, 32, 32, 32, 32);

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
		this.font.drawString(ms, "Paladium Forge", 5, 2, -65485);
		this.font.drawString(ms, "La forge est un machine permettant de recycler ses outils", 2, 96, -12829636);
		this.font.drawString(ms, "en am\uFFFDthyste, titane , paladium et... endium pour les", 2, 106, -12829636);
		this.font.drawString(ms, "pour les transform\uFFFDs en minerais pour les r\uFFFD-utilis\uFFFDs", 2, 116, -12829636);
		this.font.drawString(ms, "Pour cela il suffi d'ins\uFFFDr\uFFFD du charbon ou du palamixed coal", 1, 126, -12829636);
		this.font.drawString(ms, "dane le slot 1 et mettre les outil que vous voulez recycler", 1, 137, -12829636);
		this.font.drawString(ms, "dans le slot 2, attendre un peu et c'est le minerais est", 2, 148, -12829636);
		this.font.drawString(ms, "cuit :]", 3, 159, -12829636);
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
		this.addButton(new Button(this.guiLeft + 2, this.guiTop + 14, 45, 20, new StringTextComponent("back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new ForgepalahelpguiGui.ButtonPressedMessage(0, x, y, z));
				ForgepalahelpguiGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 2, this.guiTop + 35, 45, 20, new StringTextComponent("menu"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new ForgepalahelpguiGui.ButtonPressedMessage(1, x, y, z));
				ForgepalahelpguiGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
