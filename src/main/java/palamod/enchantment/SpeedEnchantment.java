
package palamod.enchantment;

import palamod.item.PaladiumhammerItem;
import palamod.item.EndiumhammerItem;

import palamod.PalamodModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

@PalamodModElements.ModElement.Tag
public class SpeedEnchantment extends PalamodModElements.ModElement {
	@ObjectHolder("palamod:speed")
	public static final Enchantment enchantment = null;

	public SpeedEnchantment(PalamodModElements instance) {
		super(instance, 456);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("speed"));
	}

	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.COMMON, EnchantmentType.BREAKABLE, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 3;
		}

		@Override
		protected boolean canApplyTogether(Enchantment ench) {
			if (ench == HammerforturneEnchantment.enchantment)
				return true;
			if (ench == SmeltEnchantment.enchantment)
				return true;
			return false;
		}

		@Override
		public boolean canApplyAtEnchantingTable(ItemStack stack) {
			if (stack.getItem() == EndiumhammerItem.block)
				return true;
			if (stack.getItem() == PaladiumhammerItem.block)
				return true;
			return false;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return false;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return false;
		}

		@Override
		public boolean canGenerateInLoot() {
			return true;
		}

		@Override
		public boolean canVillagerTrade() {
			return true;
		}
	}
}
