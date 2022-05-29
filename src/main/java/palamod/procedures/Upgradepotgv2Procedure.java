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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.tags.BlockTags;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Map;

public class Upgradepotgv2Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PalamodMod.LOGGER.warn("Failed to load dependency world for procedure Upgradepotgv2!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PalamodMod.LOGGER.warn("Failed to load dependency x for procedure Upgradepotgv2!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PalamodMod.LOGGER.warn("Failed to load dependency y for procedure Upgradepotgv2!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PalamodMod.LOGGER.warn("Failed to load dependency z for procedure Upgradepotgv2!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PalamodMod.LOGGER.warn("Failed to load dependency entity for procedure Upgradepotgv2!");
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
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.ANDESITE
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.COBBLESTONE
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.BLACKSTONE
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.NETHERRACK || BlockTags.getCollection()
						.getTagByID(new ResourceLocation("forge:stone")).contains((world.getBlockState(new BlockPos(x, y, z))).getBlock())) {
			entity.getPersistentData().putDouble("Pickaxe_stone", (entity.getPersistentData().getDouble("Pickaxe_stone") + 1));
			if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 2000000) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv20Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 1000000) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv19Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 800000) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv18Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 700000) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv17Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 600000) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv16Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 500000) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv15Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 400000) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv14Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 250000) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv13Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 150000) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv12Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 100000) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv11Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 50000) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv10Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 25000) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv9Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 10000) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv8Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 5000) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv7Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 2000) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv6Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 1000) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv5Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 500) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv4Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 250) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv3Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 100) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv2Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			}
		}
	}
}
