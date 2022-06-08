package palamod.procedures;

import palamod.PalamodMod;

import net.minecraft.item.ItemStack;
import net.minecraft.enchantment.Enchantments;

import java.util.Map;

public class Infernalknocker_aknoProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				PalamodMod.LOGGER.warn("Failed to load dependency itemstack for procedure Infernalknocker_akno!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		(itemstack).addEnchantment(Enchantments.KNOCKBACK, (int) 5);
	}
}
