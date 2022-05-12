package palamod.procedures;

import palamod.item.OrangeblueseedItem;
import palamod.item.KiwanoseedItem;
import palamod.item.EggplantseedItem;
import palamod.item.ChervilseedItem;

import palamod.PalamodMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Map;
import java.util.HashMap;

public class SeeddropsProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onBlockBreak(BlockEvent.BreakEvent event) {
			Entity entity = event.getPlayer();
			IWorld world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("xpAmount", event.getExpToDrop());
			dependencies.put("x", event.getPos().getX());
			dependencies.put("y", event.getPos().getY());
			dependencies.put("z", event.getPos().getZ());
			dependencies.put("px", entity.getPosX());
			dependencies.put("py", entity.getPosY());
			dependencies.put("pz", entity.getPosZ());
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("blockstate", event.getState());
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PalamodMod.LOGGER.warn("Failed to load dependency world for procedure Seeddrops!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PalamodMod.LOGGER.warn("Failed to load dependency x for procedure Seeddrops!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PalamodMod.LOGGER.warn("Failed to load dependency y for procedure Seeddrops!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PalamodMod.LOGGER.warn("Failed to load dependency z for procedure Seeddrops!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.GRASS
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.DEAD_BUSH
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.TALL_GRASS
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.LARGE_FERN) && Math.random() < 0.1) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(EggplantseedItem.block));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
		}
		if (((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.GRASS
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.DEAD_BUSH
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.TALL_GRASS
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.LARGE_FERN) && Math.random() < 0.05) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ChervilseedItem.block));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
		}
		if (((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.GRASS
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.DEAD_BUSH
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.TALL_GRASS
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.LARGE_FERN) && Math.random() < 0.01) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(KiwanoseedItem.block));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
		}
		if (((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.GRASS
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.DEAD_BUSH
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.TALL_GRASS
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.LARGE_FERN) && Math.random() < 0.005) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(OrangeblueseedItem.block));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
		}
	}
}
