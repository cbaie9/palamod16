package palamod.procedures;

import palamod.PalamodMod;

import net.minecraft.entity.Entity;

import java.util.Map;

public class PotggiveCommandExecutedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PalamodMod.LOGGER.warn("Failed to load dependency entity for procedure PotggiveCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("Pickaxe_stone", 20000000);
	}
}
