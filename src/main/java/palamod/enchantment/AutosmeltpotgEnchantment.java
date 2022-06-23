
package palamod.enchantment;

import palamod.PalamodModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

@PalamodModElements.ModElement.Tag
public class AutosmeltpotgEnchantment extends PalamodModElements.ModElement {
	@ObjectHolder("palamod:autosmeltpotg")
	public static final Enchantment enchantment = null;

	public AutosmeltpotgEnchantment(PalamodModElements instance) {
		super(instance, 824);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("autosmeltpotg"));
	}

	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.VERY_RARE, EnchantmentType.VANISHABLE, slots);
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
			return false;
		}

		@Override
		public boolean canVillagerTrade() {
			return false;
		}
	}
}
