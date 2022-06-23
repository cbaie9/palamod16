
package palamod.itemgroup;

import palamod.item.PaladiumIngotItem;

import palamod.PalamodModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@PalamodModElements.ModElement.Tag
public class PalamodItemGroup extends PalamodModElements.ModElement {
	public PalamodItemGroup(PalamodModElements instance) {
		super(instance, 296);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabpalamod") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(PaladiumIngotItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
