
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
public class CrusherpalahelpguiGuiWindow extends ContainerScreen<CrusherpalahelpguiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = CrusherpalahelpguiGui.guistate;

	public CrusherpalahelpguiGuiWindow(CrusherpalahelpguiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 400;
		this.ySize = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/crusherpalahelpgui.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/crusher_front.png"));
		this.blit(ms, this.guiLeft + 6, this.guiTop + 6, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/4crusher1.png"));
		this.blit(ms, this.guiLeft + 223, this.guiTop + 1, 0, 0, 174, 100, 174, 100);

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
		this.font.drawString(ms, "Paladium crusher wiki", 101, 3, -65485);
		this.font.drawString(ms, "Voici le crusher, la machine permetant, avec", 2, 29, -12829636);
		this.font.drawString(ms, "des fruit de fabriquer des minerais dont", 1, 42, -12829636);
		this.font.drawString(ms, "l'endium entre autre. Le principe est simple", 2, 54, -12829636);
		this.font.drawString(ms, "Il faut mettre du fuel* et des fruit dans le", 2, 66, -12829636);
		this.font.drawString(ms, "crusher. Le fuel est soit le gold mixed coal,", 1, 78, -12829636);
		this.font.drawString(ms, "( am\u00E9thyste ) soit l'am\u00E9thyste mixed coal,", 1, 89, -12829636);
		this.font.drawString(ms, "( titane ) soit le titane mixed coal ( paladium) ou le palamixed coal pour", 0, 101, -12829636);
		this.font.drawString(ms, "L'endium. Pour celui-ci il faudra ins\u00E9rer 128 palamixed et 128 orangeblue puis", 3, 113, -12829636);
		this.font.drawString(ms, "Fruit ici", 248, 59, -256);
		this.font.drawString(ms, "R\u00E9sultat ici", 307, 59, -16776961);
		this.font.drawString(ms, "Appuyer sur le bouton \"start fusion\" vous donnera 1 nugget quand tout les", 2, 126, -12829636);
		this.font.drawString(ms, "\u00E9l\u00E9ment auront \u00E9t\u00E9 ins\u00E8r\u00E9s.", 1, 138, -12829636);
		this.font.drawString(ms, "Note : vous n'\u00EAtes pas obliger d'ins\u00E8r\u00E8 128 de chaque mais il aura une chance", 3, 149, -26368);
		this.font.drawString(ms, "que le nugget n'apparaise [ probabilit\u00E9 \u00E9tant la chance que le nugget appairaise", 0, 158, -26368);
		this.font.drawString(ms, "et 128 \u00E9tant 100% de chance  ] pas", 4, 168, -26368);
		this.font.drawString(ms, "1/1 v1", 364, 183, -12829636);
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
		this.addButton(new Button(this.guiLeft + 186, this.guiTop + 171, 45, 20, new StringTextComponent("back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new CrusherpalahelpguiGui.ButtonPressedMessage(0, x, y, z));
				CrusherpalahelpguiGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 237, this.guiTop + 171, 45, 20, new StringTextComponent("menu"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new CrusherpalahelpguiGui.ButtonPressedMessage(1, x, y, z));
				CrusherpalahelpguiGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
