package palamod.procedures;

import palamod.item.Pickaxeofthegodslv9Item;
import palamod.item.Pickaxeofthegodslv8Item;
import palamod.item.Pickaxeofthegodslv7Item;
import palamod.item.Pickaxeofthegodslv6Item;
import palamod.item.Pickaxeofthegodslv5Item;
import palamod.item.Pickaxeofthegodslv4Item;
import palamod.item.Pickaxeofthegodslv3Item;
import palamod.item.Pickaxeofthegodslv2Item;
import palamod.item.Pickaxeofthegodslv20Item;
import palamod.item.Pickaxeofthegodslv19Item;
import palamod.item.Pickaxeofthegodslv18Item;
import palamod.item.Pickaxeofthegodslv17Item;
import palamod.item.Pickaxeofthegodslv16Item;
import palamod.item.Pickaxeofthegodslv15Item;
import palamod.item.Pickaxeofthegodslv14Item;
import palamod.item.Pickaxeofthegodslv13Item;
import palamod.item.Pickaxeofthegodslv12Item;
import palamod.item.Pickaxeofthegodslv11Item;
import palamod.item.Pickaxeofthegodslv10Item;

import palamod.PalamodMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Map;

public class Upgradepotg1Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PalamodMod.LOGGER.warn("Failed to load dependency world for procedure Upgradepotg1!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PalamodMod.LOGGER.warn("Failed to load dependency x for procedure Upgradepotg1!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PalamodMod.LOGGER.warn("Failed to load dependency y for procedure Upgradepotg1!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PalamodMod.LOGGER.warn("Failed to load dependency z for procedure Upgradepotg1!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PalamodMod.LOGGER.warn("Failed to load dependency entity for procedure Upgradepotg1!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.STONE
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.GRANITE
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.DIORITE
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.NETHERRACK) {
			entity.getPersistentData().putDouble("Pickaxe_stone", (entity.getPersistentData().getDouble("Pickaxe_stone") + 1));
			if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 100 && !entity.getPersistentData().getBoolean("Pickaxe_stone_a1")) {
				entity.getPersistentData().putBoolean("Pickaxe_stone_a1", (true));
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv2Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 250 && !entity.getPersistentData().getBoolean("Pickaxe_stone_a2")) {
				entity.getPersistentData().putBoolean("Pickaxe_stone_a2", (true));
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv3Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 500 && !entity.getPersistentData().getBoolean("Pickaxe_stone_a3")) {
				entity.getPersistentData().putBoolean("Pickaxe_stone_a3", (true));
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv4Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 1000 && !entity.getPersistentData().getBoolean("Pickaxe_stone_a4")) {
				entity.getPersistentData().putBoolean("Pickaxe_stone_a4", (true));
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv5Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 2000 && !entity.getPersistentData().getBoolean("Pickaxe_stone_a5")) {
				entity.getPersistentData().putBoolean("Pickaxe_stone_a5", (true));
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv6Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 5000 && !entity.getPersistentData().getBoolean("Pickaxe_stone_a6")) {
				entity.getPersistentData().putBoolean("Pickaxe_stone_a6", (true));
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv7Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 10000 && !entity.getPersistentData().getBoolean("Pickaxe_stone_a7")) {
				entity.getPersistentData().putBoolean("Pickaxe_stone_a7", (true));
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv8Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 25000 && !entity.getPersistentData().getBoolean("Pickaxe_stone_a8")) {
				entity.getPersistentData().putBoolean("Pickaxe_stone_a8", (true));
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv9Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 50000 && !entity.getPersistentData().getBoolean("Pickaxe_stone_a9")) {
				entity.getPersistentData().putBoolean("Pickaxe_stone_a9", (true));
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv10Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 100000
					&& !entity.getPersistentData().getBoolean("Pickaxe_stone_a10")) {
				entity.getPersistentData().putBoolean("Pickaxe_stone_a10", (true));
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv11Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 150000
					&& !entity.getPersistentData().getBoolean("Pickaxe_stone_a11")) {
				entity.getPersistentData().putBoolean("Pickaxe_stone_a11", (true));
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv12Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") == 250000
					&& !entity.getPersistentData().getBoolean("Pickaxe_stone_a12")) {
				entity.getPersistentData().putBoolean("Pickaxe_stone_a12", (true));
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv13Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") == 400000
					&& !entity.getPersistentData().getBoolean("Pickaxe_stone_a13")) {
				entity.getPersistentData().putBoolean("Pickaxe_stone_a13", (true));
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv14Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") == 500000
					&& !entity.getPersistentData().getBoolean("Pickaxe_stone_a14")) {
				entity.getPersistentData().putBoolean("Pickaxe_stone_a14", (true));
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv15Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") == 600000
					&& !entity.getPersistentData().getBoolean("Pickaxe_stone_a15")) {
				entity.getPersistentData().putBoolean("Pickaxe_stone_a15", (true));
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv16Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") == 700000
					&& !entity.getPersistentData().getBoolean("Pickaxe_stone_a16")) {
				entity.getPersistentData().putBoolean("Pickaxe_stone_a16", (true));
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv17Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") == 800000
					&& !entity.getPersistentData().getBoolean("Pickaxe_stone_a17")) {
				entity.getPersistentData().putBoolean("Pickaxe_stone_a17", (true));
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv18Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") == 1000000
					&& !entity.getPersistentData().getBoolean("Pickaxe_stone_a18")) {
				entity.getPersistentData().putBoolean("Pickaxe_stone_a18", (true));
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv19Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") == 2000000
					&& !entity.getPersistentData().getBoolean("Pickaxe_stone_a19")) {
				entity.getPersistentData().putBoolean("Pickaxe_stone_a19", (true));
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv20Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			}
		}
	}
}
