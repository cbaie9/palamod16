
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
public class CrusherpalahelpguienGuiWindow extends ContainerScreen<CrusherpalahelpguienGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = CrusherpalahelpguienGui.guistate;

	public CrusherpalahelpguienGuiWindow(CrusherpalahelpguienGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 425;
		this.ySize = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/crusherpalahelpguien.png");

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
		this.blit(ms, this.guiLeft + 19, this.guiTop + 6, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("palamod:textures/4crusher1.png"));
		this.blit(ms, this.guiLeft + 250, this.guiTop + 1, 0, 0, 174, 100, 174, 100);

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
		this.font.drawString(ms, "Paladium crusher wiki", 114, 3, -65485);
		this.font.drawString(ms, "This is the crusher The machine can crusher", 15, 29, -12829636);
		this.font.drawString(ms, "fruit for making rare item ( ore )", 14, 42, -12829636);
		this.font.drawString(ms, "and endium, the most powerful ingot in this", 15, 54, -12829636);
		this.font.drawString(ms, "Mod For this you will need ore mixed coal", 15, 66, -12829636);
		this.font.drawString(ms, "for fuel. For exemple the endium need ", 14, 78, -12829636);
		this.font.drawString(ms, "Palamixed coal, for paladium the titane", 14, 89, -12829636);
		this.font.drawString(ms, "The titane mixed coal, for titane the amethyst mixed coal and finally for", 12, 101, -12829636);
		this.font.drawString(ms, "amethyst the gold mixed coal Add fuel and fruits for add probabilites ", 16, 113, -12829636);
		this.font.drawString(ms, "Fruit here", 261, 59, -256);
		this.font.drawString(ms, "R\uFFFDsult here", 323, 60, -16776961);
		this.font.drawString(ms, "One times you are ready to lunch the process click on \"start fusion\"", 15, 126, -12829636);
		this.font.drawString(ms, "The endium will be creating with the previous items and the result  will appear", 5, 138, -12829636);
		this.font.drawString(ms, "Note : It not mandatory to put 128 fruit and mixed coal but you will not have", 13, 149, -26368);
		this.font.drawString(ms, "100% Chance and could not have the result [ Check probabilities ] and 128 is", 13, 158, -26368);
		this.font.drawString(ms, "equal to 100%", 17, 168, -26368);
		this.font.drawString(ms, "1/1 v1", 377, 183, -12829636);
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
		this.addButton(new Button(this.guiLeft + 199, this.guiTop + 171, 45, 20, new StringTextComponent("back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new CrusherpalahelpguienGui.ButtonPressedMessage(0, x, y, z));
				CrusherpalahelpguienGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 250, this.guiTop + 171, 45, 20, new StringTextComponent("menu"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new CrusherpalahelpguienGui.ButtonPressedMessage(1, x, y, z));
				CrusherpalahelpguienGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
