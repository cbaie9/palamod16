
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
public class ItemmenupalahelpGuiWindow extends ContainerScreen<ItemmenupalahelpGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = ItemmenupalahelpGui.guistate;

	public ItemmenupalahelpGuiWindow(ItemmenupalahelpGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/itemmenupalahelp.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/forest32.png"));
		this.blit(ms, this.guiLeft + 8, this.guiTop + 8, 0, 0, 32, 16, 32, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/desert16.png"));
		this.blit(ms, this.guiLeft + 8, this.guiTop + 24, 0, 0, 17, 16, 17, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/fish32.png"));
		this.blit(ms, this.guiLeft + 24, this.guiTop + 24, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/lake32.png"));
		this.blit(ms, this.guiLeft + 8, this.guiTop + 56, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/nether32.png"));
		this.blit(ms, this.guiLeft + 8, this.guiTop + 87, 0, 0, 32, 16, 32, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/plains16.png"));
		this.blit(ms, this.guiLeft + 8, this.guiTop + 40, 0, 0, 16, 16, 16, 16);

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
		this.font.drawString(ms, "Item menu", 69, 7, -65536);
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
		this.addButton(new Button(this.guiLeft + 3, this.guiTop + 141, 45, 20, new StringTextComponent("back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new ItemmenupalahelpGui.ButtonPressedMessage(0, x, y, z));
				ItemmenupalahelpGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 65, this.guiTop + 26, 100, 20, new StringTextComponent("legendary stone"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new ItemmenupalahelpGui.ButtonPressedMessage(1, x, y, z));
				ItemmenupalahelpGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 115, this.guiTop + 47, 50, 20, new StringTextComponent("B�tons"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new ItemmenupalahelpGui.ButtonPressedMessage(2, x, y, z));
				ItemmenupalahelpGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 115, this.guiTop + 68, 50, 20, new StringTextComponent("Armor"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new ItemmenupalahelpGui.ButtonPressedMessage(3, x, y, z));
				ItemmenupalahelpGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 40, this.guiTop + 89, 125, 20, new StringTextComponent("Xp bush / Xp berries"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new ItemmenupalahelpGui.ButtonPressedMessage(4, x, y, z));
				ItemmenupalahelpGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
	}
}
