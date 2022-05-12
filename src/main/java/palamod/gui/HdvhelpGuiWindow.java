
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
		this.xSize = 250;
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
		this.font.drawString(ms, "H\uFFFDtel de vente - aide", 4, 4, -12829636);
		this.font.drawString(ms, "L'h\uFFFDtel de vente est un endroit o\uFFFD les joueurs", 3, 27, -10066330);
		this.font.drawString(ms, "vendent et s'ach\uFFFDtent  des items de diff\uFFFDrente", 4, 37, -10066330);
		this.font.drawString(ms, "valeur de fa\uFFFDon s\uFFFDcuris\uFFFD sans interaction entre", 1, 47, -10066330);
		this.font.drawString(ms, "joueur directe ", 2, 57, -10066330);
		this.font.drawString(ms, "Pour mettre en vente un objet cliquez sur ", 3, 77, -12829636);
		this.font.drawString(ms, "l'onglet correspondant mettez l'item \uFFFD vendre ", 3, 88, -12829636);
		this.font.drawString(ms, "dans le slot puis selectionn\uFFFD le prix et le", 3, 98, -12829636);
		this.font.drawString(ms, "nom qui sera afficher", 3, 109, -12829636);
		this.font.drawString(ms, "Pour acheter, trouvez un item interessant puis,", 2, 135, -12829636);
		this.font.drawString(ms, "appuyer le bouton 'buy' puis confimer votre", 2, 144, -12829636);
		this.font.drawString(ms, "choix", 3, 155, -12829636);
		this.font.drawString(ms, "Vente", 2, 67, -16751104);
		this.font.drawString(ms, "Achat", 1, 125, -3407821);
		this.font.drawString(ms, "Toute anarque n'est pas de notre faute sauf si  ", 1, 168, -16777012);
		this.font.drawString(ms, "Bug Les exploite sont souvent des mods non", 1, 176, -16777012);
		this.font.drawString(ms, "pr\uFFFDvue Soyez prudent", 2, 185, -16777012);
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
