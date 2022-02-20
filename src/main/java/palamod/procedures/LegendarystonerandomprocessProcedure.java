package palamod.procedures;

import palamod.item.LegendarystoneteleportationItem;
import palamod.item.LegendarystonerandomItem;
import palamod.item.LegendarystonepowerItem;
import palamod.item.LegendarystonejobsItem;
import palamod.item.LegendarystoneinvisibleItem;
import palamod.item.LegendarystonefortuneItem;

import palamod.PalamodMod;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Random;
import java.util.Map;

public class LegendarystonerandomprocessProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PalamodMod.LOGGER.warn("Failed to load dependency entity for procedure Legendarystonerandomprocess!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double random = 0;
		random = (new Random().nextInt(5 + 1));
		if (random == 1) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(LegendarystonefortuneItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		} else if (random == 2) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(LegendarystoneinvisibleItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		} else if (random == 3) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(LegendarystonepowerItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		} else if (random == 4) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(LegendarystonejobsItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		} else if (random == 5) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(LegendarystoneteleportationItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
		if (entity instanceof PlayerEntity) {
			ItemStack _stktoremove = new ItemStack(LegendarystonerandomItem.block);
			((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
					((PlayerEntity) entity).container.func_234641_j_());
		}
	}
}
