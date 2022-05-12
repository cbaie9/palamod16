
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
public class PalahelporeGuiWindow extends ContainerScreen<PalahelporeGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = PalahelporeGui.guistate;

	public PalahelporeGuiWindow(PalahelporeGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 220;
		this.ySize = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/palahelpore.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/amethyst_ingot.png"));
		this.blit(ms, this.guiLeft + 7, this.guiTop + 151, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/paladium_ingot.png"));
		this.blit(ms, this.guiLeft + 3, this.guiTop + 66, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/findium.png"));
		this.blit(ms, this.guiLeft + 4, this.guiTop + 87, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/titane_ingot.png"));
		this.blit(ms, this.guiLeft + 5, this.guiTop + 122, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/paladium_green_ingot.png"));
		this.blit(ms, this.guiLeft + 3, this.guiTop + 47, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/endium_ingot.png"));
		this.blit(ms, this.guiLeft + 1, this.guiTop + 26, 0, 0, 16, 16, 16, 16);

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
		this.font.drawString(ms, "Paladium :Le minerais le plus puissant", 23, 66, -52480);
		this.font.drawString(ms, "minable", 25, 76, -52480);
		this.font.drawString(ms, "Tr\uFFFDs rare sert a quelque craft", 18, 99, -205);
		this.font.drawString(ms, "dont le cave block et le spawn finder", 5, 110, -205);
		this.font.drawString(ms, "Minerais de bas niveau trouvable assez", 7, 168, -6750055);
		this.font.drawString(ms, "facilement", 6, 178, -6750055);
		this.font.drawString(ms, "Resitant,tr\uFFFDs bon pour ses premiers", 24, 131, -12829636);
		this.font.drawString(ms, "outils", 4, 140, -12829636);
		this.font.drawString(ms, "Am\uFFFDthyste :", 26, 153, -6750055);
		this.font.drawString(ms, "Titane :", 24, 121, -12829636);
		this.font.drawString(ms, "Findium :", 21, 89, -205);
		this.font.drawString(ms, "Paladium vert : \uFFFDquivalent en plus rare", 22, 52, -10027213);
		this.font.drawString(ms, "Endium : Le materiau ultime obtenable", 24, 27, -13434727);
		this.font.drawString(ms, "via le paladium crusher ( voir machine)", 19, 39, -13434727);
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
		this.addButton(new Button(this.guiLeft + 95, this.guiTop + 5, 45, 20, new StringTextComponent("back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelporeGui.ButtonPressedMessage(0, x, y, z));
				PalahelporeGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 30, this.guiTop + 5, 45, 20, new StringTextComponent("menu"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelporeGui.ButtonPressedMessage(1, x, y, z));
				PalahelporeGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
