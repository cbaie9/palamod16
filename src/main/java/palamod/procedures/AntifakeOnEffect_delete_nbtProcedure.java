package palamod.procedures;

import palamod.PalamodMod;

import net.minecraft.entity.Entity;

import java.util.Map;

public class AntifakeOnEffect_delete_nbtProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PalamodMod.LOGGER.warn("Failed to load dependency entity for procedure AntifakeOnEffect_delete_nbt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putBoolean("antifake", (false));
	}
}
