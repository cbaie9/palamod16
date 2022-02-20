package palamod.procedures;

import palamod.world.LogsallGameRule;

import palamod.PalamodModVariables;

import palamod.PalamodMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.Property;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import java.util.Map;

public class LuckyexitProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PalamodMod.LOGGER.warn("Failed to load dependency world for procedure Luckyexit!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PalamodMod.LOGGER.warn("Failed to load dependency x for procedure Luckyexit!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PalamodMod.LOGGER.warn("Failed to load dependency y for procedure Luckyexit!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PalamodMod.LOGGER.warn("Failed to load dependency z for procedure Luckyexit!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PalamodMod.LOGGER.warn("Failed to load dependency entity for procedure Luckyexit!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		double destroy = 0;
		if (PalamodModVariables.Lucky_destroy == 1) {
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				BlockState _bs = Blocks.AIR.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
			if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule) == true) {
				PalamodMod.LOGGER.info(
						("(" + entity.getDisplayName().getString() + " ) Fermeture de l'interface lucky block apr\u00E8s ouverture [ code 1 ]"));
			}
		} else if (PalamodModVariables.Lucky_destroy == 2) {
			if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule) == true) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + "Ferme un lucky block ( Event non Ajout\u00E9 ) [ code 2 ]"));
			}
		} else if (PalamodModVariables.Lucky_destroy == 0) {
			if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule) == true) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + "Ferme un lucky block ( echap ) [ code  0 ]"));
			}
		} else {
			if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule) == true) {
				PalamodMod.LOGGER.info(("(" + entity.getDisplayName().getString()
						+ " ) Fermeture de l'interface lucky block apr\u00E8s ouverture sans renplacement [ code 3 ]"));
			}
		}
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
	}
}
