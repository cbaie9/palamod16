package palamod.procedures;

import palamod.PalamodMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.screen.Screen;

import java.util.Map;
import java.util.Collections;

public class Elevator_processProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PalamodMod.LOGGER.warn("Failed to load dependency world for procedure Elevator_process!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PalamodMod.LOGGER.warn("Failed to load dependency x for procedure Elevator_process!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PalamodMod.LOGGER.warn("Failed to load dependency y for procedure Elevator_process!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PalamodMod.LOGGER.warn("Failed to load dependency z for procedure Elevator_process!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PalamodMod.LOGGER.warn("Failed to load dependency entity for procedure Elevator_process!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		double add_num = 0;
		double y_pos = 0;
		if (Screen.hasShiftDown()) {
			y_pos = y;
			add_num = 1;
			for (int index0 = 0; index0 < (int) (320); index0++) {
				if (BlockTags.getCollection().getTagByID(new ResourceLocation("palamod:elevator"))
						.contains((world.getBlockState(new BlockPos(x, y_pos - add_num, z))).getBlock())) {
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate(x, (y_pos - add_num + 1), z);
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, (y_pos - add_num + 1), z, _ent.rotationYaw,
									_ent.rotationPitch, Collections.emptySet());
						}
					}
					break;
				} else {
					add_num = (add_num + 1);
					continue;
				}
			}
		} else if (Screen.hasControlDown()) {
			y_pos = y;
			add_num = 1;
			for (int index1 = 0; index1 < (int) (320); index1++) {
				if (BlockTags.getCollection().getTagByID(new ResourceLocation("palamod:elevator"))
						.contains((world.getBlockState(new BlockPos(x, y_pos + add_num, z))).getBlock())) {
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate(x, (y_pos + add_num + 1), z);
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, (y_pos + add_num + 1), z, _ent.rotationYaw,
									_ent.rotationPitch, Collections.emptySet());
						}
					}
					break;
				} else {
					add_num = (add_num + 1);
					continue;
				}
			}
		}
	}
}
