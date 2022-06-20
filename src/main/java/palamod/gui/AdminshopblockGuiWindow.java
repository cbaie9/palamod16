
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
public class AdminshopblockGuiWindow extends ContainerScreen<AdminshopblockGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = AdminshopblockGui.guistate;

	public AdminshopblockGuiWindow(AdminshopblockGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 205;
		this.ySize = 190;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/adminshopblock.png");

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
		this.addButton(new Button(this.guiLeft + 22, this.guiTop + 6, 46, 20, new StringTextComponent("Dirt"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockGui.ButtonPressedMessage(0, x, y, z));
				AdminshopblockGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 146, this.guiTop + 8, 51, 20, new StringTextComponent("Grass"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockGui.ButtonPressedMessage(1, x, y, z));
				AdminshopblockGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 22, this.guiTop + 32, 51, 20, new StringTextComponent("Stone"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockGui.ButtonPressedMessage(2, x, y, z));
				AdminshopblockGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 22, this.guiTop + 58, 82, 20, new StringTextComponent("Netherrack"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockGui.ButtonPressedMessage(3, x, y, z));
				AdminshopblockGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 21, this.guiTop + 84, 72, 20, new StringTextComponent("Soul sand"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockGui.ButtonPressedMessage(4, x, y, z));
				AdminshopblockGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 151, this.guiTop + 33, 46, 20, new StringTextComponent("Sand"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockGui.ButtonPressedMessage(5, x, y, z));
				AdminshopblockGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 141, this.guiTop + 57, 56, 20, new StringTextComponent("Gravel"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockGui.ButtonPressedMessage(6, x, y, z));
				AdminshopblockGui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 21, this.guiTop + 113, 72, 20, new StringTextComponent("Glowstone"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockGui.ButtonPressedMessage(7, x, y, z));
				AdminshopblockGui.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 21, this.guiTop + 141, 66, 20, new StringTextComponent("Oak wood"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockGui.ButtonPressedMessage(8, x, y, z));
				AdminshopblockGui.handleButtonAction(entity, 8, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 120, this.guiTop + 84, 77, 20, new StringTextComponent("blackstone"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockGui.ButtonPressedMessage(9, x, y, z));
				AdminshopblockGui.handleButtonAction(entity, 9, x, y, z);
			}
		}));
	}
}
