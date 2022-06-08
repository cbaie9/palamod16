
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
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class HdvsellguiGuiWindow extends ContainerScreen<HdvsellguiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = HdvsellguiGui.guistate;
	TextFieldWidget market_name;
	TextFieldWidget market_price;

	public HdvsellguiGuiWindow(HdvsellguiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 180;
		this.ySize = 180;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/hdvsellgui.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
		market_name.render(ms, mouseX, mouseY, partialTicks);
		market_price.render(ms, mouseX, mouseY, partialTicks);
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
		if (market_name.isFocused())
			return market_name.keyPressed(key, b, c);
		if (market_price.isFocused())
			return market_price.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		market_name.tick();
		market_price.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "alpha", 147, 3, -1);
		this.font.drawString(ms, "Prix de vente", 2, 36, -1);
		this.font.drawString(ms, "Nom de l'item", 3, 4, -1);
		this.font.drawString(ms, "Item", 126, 21, -10066330);
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
		market_name = new TextFieldWidget(this.font, this.guiLeft + 3, this.guiTop + 15, 120, 20, new StringTextComponent("Nom de l'item")) {
			{
				setSuggestion("Nom de l'item");
			}

			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("Nom de l'item");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("Nom de l'item");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:market_name", market_name);
		market_name.setMaxStringLength(32767);
		this.children.add(this.market_name);
		market_price = new TextFieldWidget(this.font, this.guiLeft + 3, this.guiTop + 47, 120, 20, new StringTextComponent("prix")) {
			{
				setSuggestion("prix");
			}

			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("prix");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("prix");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:market_price", market_price);
		market_price.setMaxStringLength(32767);
		this.children.add(this.market_price);
		this.addButton(new Button(this.guiLeft + 7, this.guiTop + 73, 56, 20, new StringTextComponent("vendre"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new HdvsellguiGui.ButtonPressedMessage(0, x, y, z));
				HdvsellguiGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
