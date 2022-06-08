
package palamod.gui;

import palamod.PalamodModVariables;

import palamod.PalamodMod;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class HdvconfguiGuiWindow extends ContainerScreen<HdvconfguiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = HdvconfguiGui.guistate;

	public HdvconfguiGuiWindow(HdvconfguiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 255;
		this.ySize = 166;
	}

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
		this.font.drawString(ms, "Vous allez acheter", 7, 13, -13369600);
		this.font.drawString(ms, "" + (PalamodModVariables.MapVariables.get(world).market_conf_name) + "", 109, 14, -16764058);
		this.font.drawString(ms, "\u00E0 " + (PalamodModVariables.MapVariables.get(world).market_conf_price) + " $", 6, 26, -13369600);
		this.font.drawString(ms, "Cette action est irr\u00E9versible ", 53, 116, -3407821);
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
		this.addButton(new Button(this.guiLeft + 5, this.guiTop + 136, 103, 20, new StringTextComponent("revenir au shop"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new HdvconfguiGui.ButtonPressedMessage(0, x, y, z));
				HdvconfguiGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 188, this.guiTop + 136, 61, 20, new StringTextComponent("Acheter"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new HdvconfguiGui.ButtonPressedMessage(1, x, y, z));
				HdvconfguiGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
