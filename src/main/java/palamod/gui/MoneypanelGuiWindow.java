
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
public class MoneypanelGuiWindow extends ContainerScreen<MoneypanelGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = MoneypanelGui.guistate;
	TextFieldWidget Admin_player_money;
	TextFieldWidget Admin_money_change;

	public MoneypanelGuiWindow(MoneypanelGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 210;
		this.ySize = 170;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/moneypanel.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
		Admin_player_money.render(ms, mouseX, mouseY, partialTicks);
		Admin_money_change.render(ms, mouseX, mouseY, partialTicks);
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
		if (Admin_player_money.isFocused())
			return Admin_player_money.keyPressed(key, b, c);
		if (Admin_money_change.isFocused())
			return Admin_money_change.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		Admin_player_money.tick();
		Admin_money_change.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Money Panel", 68, 7, -12829636);
		this.font.drawString(ms, "Money to change ( - for remove money )", 5, 73, -12829636);
		this.font.drawString(ms, "Player to change money", 22, 38, -12829636);
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
		Admin_player_money = new TextFieldWidget(this.font, this.guiLeft + 21, this.guiTop + 49, 120, 20,
				new StringTextComponent("Enter player for change his money")) {
			{
				setSuggestion("Enter player for change his money");
			}

			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("Enter player for change his money");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("Enter player for change his money");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:Admin_player_money", Admin_player_money);
		Admin_player_money.setMaxStringLength(32767);
		this.children.add(this.Admin_player_money);
		this.addButton(new Button(this.guiLeft + 25, this.guiTop + 122, 56, 20, new StringTextComponent("Change"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new MoneypanelGui.ButtonPressedMessage(0, x, y, z));
				MoneypanelGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		Admin_money_change = new TextFieldWidget(this.font, this.guiLeft + 24, this.guiTop + 88, 120, 20,
				new StringTextComponent("Money to add/remove")) {
			{
				setSuggestion("Money to add/remove");
			}

			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("Money to add/remove");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("Money to add/remove");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:Admin_money_change", Admin_money_change);
		Admin_money_change.setMaxStringLength(32767);
		this.children.add(this.Admin_money_change);
	}
}
