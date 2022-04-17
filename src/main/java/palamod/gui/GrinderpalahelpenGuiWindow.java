
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
public class GrinderpalahelpenGuiWindow extends ContainerScreen<GrinderpalahelpenGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = GrinderpalahelpenGui.guistate;

	public GrinderpalahelpenGuiWindow(GrinderpalahelpenGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 210;
		this.ySize = 185;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/grinderpalahelpen.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/grinder_block_front.png"));
		this.blit(ms, this.guiLeft + 6, this.guiTop + 7, 0, 0, 32, 32, 32, 32);

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
		this.font.drawString(ms, "Grinder", 85, 9, -12829636);
		this.font.drawString(ms, "The grinder is a machine for crafting", 3, 42, -12829636);
		this.font.drawString(ms, "special tool like hammer, fastword", 0, 53, -12829636);
		this.font.drawString(ms, "and broadsword You can also add", 1, 64, -12829636);
		this.font.drawString(ms, "upgrades give some effect to your tools", 1, 74, -12829636);
		this.font.drawString(ms, "Fortune : like vanilla but on hammer", 2, 83, -256);
		this.font.drawString(ms, " -) hammer", 1, 92, -256);
		this.font.drawString(ms, "Smelt : smelt the ore mined -) hammer", 2, 102, -8504309);
		this.font.drawString(ms, "Speed : haste / effiency  -) hammer", 2, 115, -816878);
		this.font.drawString(ms, "", -5, 71, -12829636);
		this.font.drawString(ms, "Flame : -) fire aspect for fastsword and", 1, 125, -3335911);
		this.font.drawString(ms, "Broadsword", 2, 133, -1826784);
		this.font.drawString(ms, "Damage : does more damage -) fastsword", 1, 141, -12829636);
		this.font.drawString(ms, "+ broadsword", 1, 150, -12829636);
		this.font.drawString(ms, "2 min 1/2", 159, 4, -12829636);
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
		this.addButton(new Button(this.guiLeft + 5, this.guiTop + 159, 50, 20, new StringTextComponent("next"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new GrinderpalahelpenGui.ButtonPressedMessage(0, x, y, z));
				GrinderpalahelpenGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 63, this.guiTop + 159, 45, 20, new StringTextComponent("menu"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new GrinderpalahelpenGui.ButtonPressedMessage(1, x, y, z));
				GrinderpalahelpenGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 124, this.guiTop + 159, 45, 20, new StringTextComponent("back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new GrinderpalahelpenGui.ButtonPressedMessage(2, x, y, z));
				GrinderpalahelpenGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
