
package palamod.gui;

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
public class StatusdevnoteGuiWindow extends ContainerScreen<StatusdevnoteGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = StatusdevnoteGui.guistate;

	public StatusdevnoteGuiWindow(StatusdevnoteGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 300;
		this.ySize = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/statusdevnote.png");

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
		this.font.drawString(ms, "Dev log #0001 build 0040  v16a1", 3, 5, -12829636);
		this.font.drawString(ms, "Probl\u00E8me de market", 2, 26, -12829636);
		this.font.drawString(ms, "- Stokage de l'item en tant que nbt ", 9, 39, -12829636);
		this.font.drawString(ms, "autre", 6, 54, -12829636);
		this.font.drawString(ms, "Retard indermin\u00E9e des commande type /f", 5, 65, -12829636);
		this.font.drawString(ms, "A cause de refont, + maj moteur  arguments prochianment", 4, 76, -12829636);
		this.font.drawString(ms, "11/04/2022", 240, 7, -12829636);
		this.font.drawString(ms, "Info rapide : Le Market sera de 100 slots extensibles", 8, 116, -12829636);
		this.font.drawString(ms, "Par les maj : system de copier coller relais", 6, 129, -12829636);
		this.font.drawString(ms, "Au faite l'adminshop sortira rapidement apr\u00E8s la snapshot", 1, 150, -12829636);
		this.font.drawString(ms, "Du market ; system similaire", 1, 161, -12829636);
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
