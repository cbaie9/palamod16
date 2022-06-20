
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
public class HdvguiGuiWindow extends ContainerScreen<HdvguiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = HdvguiGui.guistate;
	TextFieldWidget recs;

	public HdvguiGuiWindow(HdvguiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 300;
		this.ySize = 225;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/hdvgui.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
		recs.render(ms, mouseX, mouseY, partialTicks);
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
		this.blit(ms, this.guiLeft + 7, this.guiTop + 74, 0, 0, 16, 16, 16, 16);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		if (recs.isFocused())
			return recs.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		recs.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "H\u00F4tel de vente", 47, 5, -12829636);
		this.font.drawString(ms, "Wip build 0031", 220, 4, -12829636);
		this.font.drawString(ms, "Premium ", 7, 59, -26368);
		this.font.drawString(ms, "" + (PalamodModVariables.market_name_0) + "", 50, 76, -12829636);
		this.font.drawString(ms, "" + (PalamodModVariables.market_price_0) + " $", 154, 77, -12829636);
		this.font.drawString(ms, "" + (PalamodModVariables.market_name_1) + "", 47, 100, -12829636);
		this.font.drawString(ms, "" + (PalamodModVariables.market_name_2) + "", 47, 123, -12829636);
		this.font.drawString(ms, "" + (PalamodModVariables.market_name_3) + "", 46, 147, -12829636);
		this.font.drawString(ms, "" + (PalamodModVariables.market_price_1) + " $", 154, 99, -12829636);
		this.font.drawString(ms, "" + (PalamodModVariables.MapVariables.get(world).market_price_2) + "", 153, 120, -12829636);
		this.font.drawString(ms, "" + (PalamodModVariables.MapVariables.get(world).market_price_3) + "", 155, 145, -12829636);
		this.font.drawString(ms, "Barre de recherche", 10, 20, -12829636);
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
		this.addButton(new Button(this.guiLeft + 234, this.guiTop + 194, 61, 20, new StringTextComponent("suivant"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new HdvguiGui.ButtonPressedMessage(0, x, y, z));
				HdvguiGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 178, this.guiTop + 194, 46, 20, new StringTextComponent("aide"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new HdvguiGui.ButtonPressedMessage(1, x, y, z));
				HdvguiGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 234, this.guiTop + 71, 40, 20, new StringTextComponent("buy"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new HdvguiGui.ButtonPressedMessage(2, x, y, z));
				HdvguiGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 9, this.guiTop + 194, 160, 20, new StringTextComponent("mettre en vente un article"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new HdvguiGui.ButtonPressedMessage(3, x, y, z));
				HdvguiGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 234, this.guiTop + 94, 40, 20, new StringTextComponent("buy"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new HdvguiGui.ButtonPressedMessage(4, x, y, z));
				HdvguiGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 234, this.guiTop + 119, 40, 20, new StringTextComponent("buy"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new HdvguiGui.ButtonPressedMessage(5, x, y, z));
				HdvguiGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 234, this.guiTop + 143, 40, 20, new StringTextComponent("buy"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new HdvguiGui.ButtonPressedMessage(6, x, y, z));
				HdvguiGui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		recs = new TextFieldWidget(this.font, this.guiLeft + 7, this.guiTop + 33, 120, 20,
				new StringTextComponent("que veut tu rechercher ajourd'hui")) {
			{
				setSuggestion("que veut tu rechercher ajourd'hui");
			}

			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("que veut tu rechercher ajourd'hui");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("que veut tu rechercher ajourd'hui");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:recs", recs);
		recs.setMaxStringLength(32767);
		this.children.add(this.recs);
	}
}
