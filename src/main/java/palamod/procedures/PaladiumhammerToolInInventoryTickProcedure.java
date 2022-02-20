package palamod.procedures;

import palamod.enchantment.SpeedEnchantment;
import palamod.enchantment.SmeltEnchantment;
import palamod.enchantment.HammerforturneEnchantment;

import palamod.PalamodMod;

import net.minecraft.item.ItemStack;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;

import java.util.Map;

public class PaladiumhammerToolInInventoryTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				PalamodMod.LOGGER.warn("Failed to load dependency itemstack for procedure PaladiumhammerToolInInventoryTick!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (itemstack.getOrCreateTag().getDouble("hammer_smelt") == 1) {
			(itemstack).addEnchantment(SmeltEnchantment.enchantment, (int) 1);
		} else if (itemstack.getOrCreateTag().getDouble("hammer_speed_1") == 1) {
			(itemstack).addEnchantment(SpeedEnchantment.enchantment, (int) 1);
			(itemstack).addEnchantment(Enchantments.EFFICIENCY, (int) 1);
		} else if (itemstack.getOrCreateTag().getDouble("hammer_speed_2") == 1) {
			(itemstack).addEnchantment(SpeedEnchantment.enchantment, (int) 2);
			(itemstack).addEnchantment(Enchantments.EFFICIENCY, (int) 2);
		} else if (itemstack.getOrCreateTag().getDouble("hammer_speed_3") == 1) {
			(itemstack).addEnchantment(SpeedEnchantment.enchantment, (int) 3);
			(itemstack).addEnchantment(Enchantments.EFFICIENCY, (int) 3);
		} else if (itemstack.getOrCreateTag().getDouble("hammer_fortune_1") == 1) {
			(itemstack).addEnchantment(HammerforturneEnchantment.enchantment, (int) 1);
		} else if (itemstack.getOrCreateTag().getDouble("hammer_fortune_2") == 1) {
			(itemstack).addEnchantment(HammerforturneEnchantment.enchantment, (int) 2);
		} else if (itemstack.getOrCreateTag().getDouble("hammer_fortune_3") == 1) {
			(itemstack).addEnchantment(HammerforturneEnchantment.enchantment, (int) 3);
		} else if ((EnchantmentHelper.getEnchantmentLevel(SmeltEnchantment.enchantment, itemstack) != 0)) {
			if (EnchantmentHelper.getEnchantmentLevel(SmeltEnchantment.enchantment, itemstack) == 1) {
				(itemstack).addEnchantment(Enchantments.EFFICIENCY, (int) 1);
			} else if (EnchantmentHelper.getEnchantmentLevel(SmeltEnchantment.enchantment, itemstack) == 2) {
				(itemstack).addEnchantment(Enchantments.EFFICIENCY, (int) 2);
			} else if (EnchantmentHelper.getEnchantmentLevel(SmeltEnchantment.enchantment, itemstack) == 3) {
				(itemstack).addEnchantment(Enchantments.EFFICIENCY, (int) 3);
			}
		}
	}
}
