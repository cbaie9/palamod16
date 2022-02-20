package palamod.procedures;

import palamod.PalamodMod;

import net.minecraft.entity.Entity;

import java.util.Map;

public class AntifakeEffect_add_nbtProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PalamodMod.LOGGER.warn("Failed to load dependency entity for procedure AntifakeEffect_add_nbt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putBoolean("antifake", (true));
	}
}
