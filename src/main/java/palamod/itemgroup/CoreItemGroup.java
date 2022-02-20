
package palamod.itemgroup;

import palamod.item.CoreitemItem;

import palamod.PalamodModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@PalamodModElements.ModElement.Tag
public class CoreItemGroup extends PalamodModElements.ModElement {
	public CoreItemGroup(PalamodModElements instance) {
		super(instance, 284);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabcore") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(CoreitemItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
