
package palamod.item;

import palamod.itemgroup.PalamodItemGroup;

import palamod.PalamodModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@PalamodModElements.ModElement.Tag
public class ShovelpaternItem extends PalamodModElements.ModElement {
	@ObjectHolder("palamod:shovelpatern")
	public static final Item block = null;

	public ShovelpaternItem(PalamodModElements instance) {
		super(instance, 154);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(PalamodItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("shovelpatern");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}