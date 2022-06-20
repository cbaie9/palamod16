
package palamod.gui;

import palamod.PalamodModVariables;

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
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class Hdvguiv2GuiWindow extends ContainerScreen<Hdvguiv2Gui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = Hdvguiv2Gui.guistate;
	TextFieldWidget bdr_hdv;

	public Hdvguiv2GuiWindow(Hdvguiv2Gui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 300;
		this.ySize = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/hdvguiv_2.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
		bdr_hdv.render(ms, mouseX, mouseY, partialTicks);
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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/beta_block.png"));
		this.blit(ms, this.guiLeft + 276, this.guiTop + 4, 0, 0, 16, 16, 16, 16);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		if (bdr_hdv.isFocused())
			return bdr_hdv.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		bdr_hdv.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Hdv v2 build 0082", 5, 6, -12829636);
		this.font.drawString(ms, "" + (PalamodModVariables.market_name_0) + "", 30, 25, -12829636);
		this.font.drawString(ms, "" + (PalamodModVariables.market_price_0) + " \u20AC", 29, 36, -12829636);
		this.font.drawString(ms, "" + (int) (PalamodModVariables.market_price_1) + " \u20AC", 174, 36, -12829636);
		this.font.drawString(ms, "" + (PalamodModVariables.market_name_1) + "", 175, 24, -12829636);
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
		this.addButton(new Button(this.guiLeft + 10, this.guiTop + 52, 61, 20, new StringTextComponent("Acheter"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Hdvguiv2Gui.ButtonPressedMessage(0, x, y, z));
				Hdvguiv2Gui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 154, this.guiTop + 52, 61, 20, new StringTextComponent("Acheter"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Hdvguiv2Gui.ButtonPressedMessage(1, x, y, z));
				Hdvguiv2Gui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		bdr_hdv = new TextFieldWidget(this.font, this.guiLeft + 4, this.guiTop + 154, 120, 20, new StringTextComponent("Search in Hdv")) {
			{
				setSuggestion("Search in Hdv");
			}

			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("Search in Hdv");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("Search in Hdv");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:bdr_hdv", bdr_hdv);
		bdr_hdv.setMaxStringLength(32767);
		this.children.add(this.bdr_hdv);
		this.addButton(new Button(this.guiLeft + 22, this.guiTop + 175, 77, 20, new StringTextComponent("Rechercher"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Hdvguiv2Gui.ButtonPressedMessage(2, x, y, z));
				Hdvguiv2Gui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 10, this.guiTop + 131, 46, 20, new StringTextComponent("Vendre"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Hdvguiv2Gui.ButtonPressedMessage(3, x, y, z));
				Hdvguiv2Gui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 68, this.guiTop + 131, 46, 20, new StringTextComponent("Aide"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Hdvguiv2Gui.ButtonPressedMessage(4, x, y, z));
				Hdvguiv2Gui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
	}
}
