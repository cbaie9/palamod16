
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
public class LegendarystoneenGuiWindow extends ContainerScreen<LegendarystoneenGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = LegendarystoneenGui.guistate;

	public LegendarystoneenGuiWindow(LegendarystoneenGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 200;
		this.ySize = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/legendarystoneen_palahelp.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/legend_fortune.png"));
		this.blit(ms, this.guiLeft + 1, this.guiTop + 27, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/legend_invisibility.png"));
		this.blit(ms, this.guiLeft + 3, this.guiTop + 65, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/legend_jobs.png"));
		this.blit(ms, this.guiLeft + 4, this.guiTop + 84, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/legend_power.png"));
		this.blit(ms, this.guiLeft + 4, this.guiTop + 100, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/legend_tp.png"));
		this.blit(ms, this.guiLeft + 4, this.guiTop + 124, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/legend_random.png"));
		this.blit(ms, this.guiLeft + 0, this.guiTop + 149, 0, 0, 16, 16, 16, 16);

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
		this.font.drawString(ms, "Legendary stone wiki", 50, 4, -65536);
		this.font.drawString(ms, "Forturne : can give some random ore", 17, 30, -12829636);
		this.font.drawString(ms, "coal, iron, diamond, amethyst titane", 1, 44, -12829636);
		this.font.drawString(ms, "note : usable one time per day", 14, 17, -3407872);
		this.font.drawString(ms, "Invisible : give invisible effect", 22, 69, -12829636);
		this.font.drawString(ms, "Jobs : Give you some xp", 21, 86, -12829636);
		this.font.drawString(ms, "Power : You now swim in fake water", 20, 105, -12829636);
		this.font.drawString(ms, "without taking damage", 6, 115, -12829636);
		this.font.drawString(ms, "Teleportation : Teleport in a", 21, 126, -12829636);
		this.font.drawString(ms, "random place on the map", 4, 138, -12829636);
		this.font.drawString(ms, "random : Give you one of the five ", 16, 153, -12829636);
		this.font.drawString(ms, "Legenday stone", 3, 164, -12829636);
		this.font.drawString(ms, "and paladium", 3, 54, -12829636);
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
		this.addButton(new Button(this.guiLeft + 21, this.guiTop + 175, 45, 20, new StringTextComponent("back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new LegendarystoneenGui.ButtonPressedMessage(0, x, y, z));
				LegendarystoneenGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 90, this.guiTop + 175, 45, 20, new StringTextComponent("menu"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new LegendarystoneenGui.ButtonPressedMessage(1, x, y, z));
				LegendarystoneenGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
