
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
public class Grinderpalahelp2enGuiWindow extends ContainerScreen<Grinderpalahelp2enGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = Grinderpalahelp2enGui.guistate;

	public Grinderpalahelp2enGuiWindow(Grinderpalahelp2enGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 200;
		this.ySize = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/grinderpalahelp_2en.png");

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
		this.blit(ms, this.guiLeft + 3, this.guiTop + 6, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/1.png"));
		this.blit(ms, this.guiLeft + 6, this.guiTop + 146, 0, 0, 45, 46, 45, 46);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/2.png"));
		this.blit(ms, this.guiLeft + 52, this.guiTop + 146, 0, 0, 46, 46, 46, 46);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/3.png"));
		this.blit(ms, this.guiLeft + 100, this.guiTop + 146, 0, 0, 45, 46, 45, 46);

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
		this.font.drawString(ms, "2/2", 178, 5, -12829636);
		this.font.drawString(ms, "Grinder wiki", 68, 6, -12829636);
		this.font.drawString(ms, "Knockback : add  knockback effect  -)", 4, 41, -12829636);
		this.font.drawString(ms, "fastsword + broadsword", 3, 50, -12829636);
		this.font.drawString(ms, "How to Craft the grinder ", 3, 62, -4385001);
		this.font.drawString(ms, "We need for this  :", 3, 73, -12829636);
		this.font.drawString(ms, "1 grinder block, 5 grinder casing, 20", 4, 83, -12829636);
		this.font.drawString(ms, "grinder frame et l'asembing table", 2, 94, -12829636);
		this.font.drawString(ms, "With this craft step 1 two time and", 3, 104, -5433600);
		this.font.drawString(ms, "step 2 one time and craft step 3", 3, 115, -6750208);
		this.font.drawString(ms, "step 1", 11, 135, -12829636);
		this.font.drawString(ms, "step 2", 52, 136, -12829636);
		this.font.drawString(ms, "step 3", 105, 135, -12829636);
		this.font.drawString(ms, "It's done", 146, 126, -12829636);
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
		this.addButton(new Button(this.guiLeft + 147, this.guiTop + 173, 45, 20, new StringTextComponent("back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Grinderpalahelp2enGui.ButtonPressedMessage(0, x, y, z));
				Grinderpalahelp2enGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 147, this.guiTop + 151, 45, 20, new StringTextComponent("menu"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Grinderpalahelp2enGui.ButtonPressedMessage(1, x, y, z));
				Grinderpalahelp2enGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
