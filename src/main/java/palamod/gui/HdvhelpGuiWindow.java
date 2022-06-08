
package palamod.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class HdvhelpGuiWindow extends ContainerScreen<HdvhelpGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = HdvhelpGui.guistate;

	public HdvhelpGuiWindow(HdvhelpGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 280;
		this.ySize = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/hdvhelp.png");

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
		this.font.drawString(ms, "H\u00F4tel de vente - aide", 19, 4, -12829636);
		this.font.drawString(ms, "L'h\u00F4tel de vente est un endroit o\u00F9 les joueurs", 18, 27, -10066330);
		this.font.drawString(ms, "vendent et s'ach\u00E8tent  des items de diff\u00E9rente", 19, 37, -10066330);
		this.font.drawString(ms, "valeur de fa\u00E7on s\u00E9curis\u00E9 sans interaction direct", 16, 47, -10066330);
		this.font.drawString(ms, "entre les joueurs", 17, 57, -10066330);
		this.font.drawString(ms, "Pour mettre en vente un objet cliquez sur ", 18, 77, -12829636);
		this.font.drawString(ms, "l'onglet correspondant mettez l'item \u00E0 vendre ", 18, 88, -12829636);
		this.font.drawString(ms, "dans le slot puis s\u00E9l\u00E8ctionn\u00E9 le prix et le", 18, 98, -12829636);
		this.font.drawString(ms, "nom qui sera affich\u00E9", 18, 109, -12829636);
		this.font.drawString(ms, "Pour acheter, trouvez un item interessant puis,", 17, 135, -12829636);
		this.font.drawString(ms, "appuyer le bouton 'buy' puis confimer votre", 17, 144, -12829636);
		this.font.drawString(ms, "choix", 18, 155, -12829636);
		this.font.drawString(ms, "Vente", 17, 67, -16751104);
		this.font.drawString(ms, "Achat", 16, 125, -3407821);
		this.font.drawString(ms, "Toute anarque n'est pas de notre faute sauf si  ", 16, 168, -16777012);
		this.font.drawString(ms, "Bug Les exploit sont souvent des mods ou hack non", 16, 176, -16777012);
		this.font.drawString(ms, "pr\u00E9vue Soyez prudent", 17, 185, -16777012);
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
	}
}
