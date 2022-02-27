
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
import net.minecraft.client.gui.widget.button.CheckboxButton;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class MegasafechestfirstsetupGuiWindow extends ContainerScreen<MegasafechestfirstsetupGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = MegasafechestfirstsetupGui.guistate;
	TextFieldWidget safe_code;
	CheckboxButton safe_link;

	public MegasafechestfirstsetupGuiWindow(MegasafechestfirstsetupGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/megasafechestfirstsetup.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
		safe_code.render(ms, mouseX, mouseY, partialTicks);
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
		if (safe_code.isFocused())
			return safe_code.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		safe_code.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Safe setup", 55, 6, -13434625);
		this.font.drawString(ms, "1. enter future code of the safe", 4, 25, -12829636);
		this.font.drawString(ms, "2.Do you want link safe with", 3, 64, -12829636);
		this.font.drawString(ms, "this account ( bypass the code ", 2, 75, -12829636);
		this.font.drawString(ms, "it you )", 3, 85, -12829636);
		this.font.drawString(ms, "3. Save ", 5, 122, -12829636);
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
		safe_code = new TextFieldWidget(this.font, this.guiLeft + 8, this.guiTop + 42, 120, 20,
				new StringTextComponent("insert code ( chose something wou will not forget )")) {
			{
				setSuggestion("insert code ( chose something wou will not forget )");
			}

			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("insert code ( chose something wou will not forget )");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("insert code ( chose something wou will not forget )");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:safe_code", safe_code);
		safe_code.setMaxStringLength(32767);
		this.children.add(this.safe_code);
		safe_link = new CheckboxButton(this.guiLeft + 5, this.guiTop + 100, 150, 20, new StringTextComponent("link account"), false);
		MegasafechestfirstsetupGui.guistate.put("checkbox:safe_link", safe_link);
		this.addButton(safe_link);
		this.addButton(new Button(this.guiLeft + 26, this.guiTop + 135, 46, 20, new StringTextComponent("save"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new MegasafechestfirstsetupGui.ButtonPressedMessage(0, x, y, z));
				MegasafechestfirstsetupGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
