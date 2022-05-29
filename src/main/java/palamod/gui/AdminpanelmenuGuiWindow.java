
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
public class AdminpanelmenuGuiWindow extends ContainerScreen<AdminpanelmenuGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = AdminpanelmenuGui.guistate;

	public AdminpanelmenuGuiWindow(AdminpanelmenuGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/adminpanelmenu.png");

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
		this.font.drawString(ms, "Admin Panel", 52, 5, -65536);
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
		this.addButton(new Button(this.guiLeft + 30, this.guiTop + 24, 108, 20, new StringTextComponent("Hdv Stocks Panel"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminpanelmenuGui.ButtonPressedMessage(0, x, y, z));
				AdminpanelmenuGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 43, this.guiTop + 51, 82, 20, new StringTextComponent("Money Panel"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminpanelmenuGui.ButtonPressedMessage(1, x, y, z));
				AdminpanelmenuGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 43, this.guiTop + 78, 82, 20, new StringTextComponent("Spawn Panel"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminpanelmenuGui.ButtonPressedMessage(2, x, y, z));
				AdminpanelmenuGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 38, this.guiTop + 108, 93, 20, new StringTextComponent("Trixium Panel"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminpanelmenuGui.ButtonPressedMessage(3, x, y, z));
				AdminpanelmenuGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 48, this.guiTop + 135, 77, 20, new StringTextComponent("Jobs Panel"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminpanelmenuGui.ButtonPressedMessage(4, x, y, z));
				AdminpanelmenuGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
	}
}
