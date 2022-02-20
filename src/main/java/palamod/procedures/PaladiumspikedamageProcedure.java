package palamod.procedures;

import palamod.PalamodModVariables;

import palamod.PalamodMod;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class PaladiumspikedamageProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PalamodMod.LOGGER.warn("Failed to load dependency entity for procedure Paladiumspikedamage!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (PalamodModVariables.cooltick_spike == 0) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("spike.titane").setDamageBypassesArmor(), (float) 4);
			}
			PalamodModVariables.crusher_num_var = 20;
		}
	}
}
