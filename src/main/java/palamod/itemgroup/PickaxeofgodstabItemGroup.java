
package palamod.itemgroup;

import palamod.item.Pickaxeofthegodslv1Item;

import palamod.PalamodModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@PalamodModElements.ModElement.Tag
public class PickaxeofgodstabItemGroup extends PalamodModElements.ModElement {
	public PickaxeofgodstabItemGroup(PalamodModElements instance) {
		super(instance, 777);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabpickaxeofgodstab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Pickaxeofthegodslv1Item.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
