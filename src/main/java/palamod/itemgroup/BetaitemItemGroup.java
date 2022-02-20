
package palamod.itemgroup;

import palamod.item.BetaitemsItem;

import palamod.PalamodModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@PalamodModElements.ModElement.Tag
public class BetaitemItemGroup extends PalamodModElements.ModElement {
	public BetaitemItemGroup(PalamodModElements instance) {
		super(instance, 285);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabbetaitem") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(BetaitemsItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
