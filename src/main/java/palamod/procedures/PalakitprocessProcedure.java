package palamod.procedures;

import palamod.PalamodMod;

import net.minecraft.entity.Entity;

import java.util.Map;

public class PalakitprocessProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PalamodMod.LOGGER.warn("Failed to load dependency entity for procedure Palakitprocess!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity.getPersistentData().getBoolean("take_palakit") == false) {
			entity.getPersistentData().putDouble("money", (entity.getPersistentData().getDouble("money") + 500));
			entity.getPersistentData().putBoolean("take_palakit", (true));
		}
	}
}
