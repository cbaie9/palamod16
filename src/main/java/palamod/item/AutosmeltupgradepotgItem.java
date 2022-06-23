
package palamod.item;

import palamod.itemgroup.PickaxeofgodstabItemGroup;

import palamod.PalamodModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@PalamodModElements.ModElement.Tag
public class AutosmeltupgradepotgItem extends PalamodModElements.ModElement {
	@ObjectHolder("palamod:autosmeltupgradepotg")
	public static final Item block = null;

	public AutosmeltupgradepotgItem(PalamodModElements instance) {
		super(instance, 262);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(PickaxeofgodstabItemGroup.tab).maxStackSize(64).rarity(Rarity.UNCOMMON));
			setRegistryName("autosmeltupgradepotg");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
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
