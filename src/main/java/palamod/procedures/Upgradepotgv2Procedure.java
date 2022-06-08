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
import palamod.item.PalamixedcharoalItem;

import palamod.enchantment.BigholeEnchantment;
import palamod.enchantment.AutosmeltpotgEnchantment;

import palamod.PalamodMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.tags.BlockTags;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.Inventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.block.Blocks;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

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
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				PalamodMod.LOGGER.warn("Failed to load dependency itemstack for procedure Upgradepotgv2!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		boolean auto_smelt = false;
		double big_hole = 0;
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
				if ((EnchantmentHelper.getEnchantmentLevel(AutosmeltpotgEnchantment.enchantment, itemstack) != 0)) {
					auto_smelt = (true);
				} else if ((EnchantmentHelper.getEnchantmentLevel(BigholeEnchantment.enchantment, itemstack) != 0)) {
					big_hole = (EnchantmentHelper.getEnchantmentLevel(BigholeEnchantment.enchantment, itemstack));
				}
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv20Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (auto_smelt) {
					(itemstack).addEnchantment(AutosmeltpotgEnchantment.enchantment, (int) 1);
				} else if (0 < big_hole) {
					(itemstack).addEnchantment(BigholeEnchantment.enchantment, (int) big_hole);
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 1000000) {
				if ((EnchantmentHelper.getEnchantmentLevel(AutosmeltpotgEnchantment.enchantment, itemstack) != 0)) {
					auto_smelt = (true);
				} else if ((EnchantmentHelper.getEnchantmentLevel(BigholeEnchantment.enchantment, itemstack) != 0)) {
					big_hole = (EnchantmentHelper.getEnchantmentLevel(BigholeEnchantment.enchantment, itemstack));
				}
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv19Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (auto_smelt) {
					(itemstack).addEnchantment(AutosmeltpotgEnchantment.enchantment, (int) 1);
				} else if (0 < big_hole) {
					(itemstack).addEnchantment(BigholeEnchantment.enchantment, (int) big_hole);
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 800000) {
				if ((EnchantmentHelper.getEnchantmentLevel(AutosmeltpotgEnchantment.enchantment, itemstack) != 0)) {
					auto_smelt = (true);
				} else if ((EnchantmentHelper.getEnchantmentLevel(BigholeEnchantment.enchantment, itemstack) != 0)) {
					big_hole = (EnchantmentHelper.getEnchantmentLevel(BigholeEnchantment.enchantment, itemstack));
				}
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv18Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (auto_smelt) {
					(itemstack).addEnchantment(AutosmeltpotgEnchantment.enchantment, (int) 1);
				} else if (0 < big_hole) {
					(itemstack).addEnchantment(BigholeEnchantment.enchantment, (int) big_hole);
				}
			} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 700000) {
				if ((EnchantmentHelper.getEnchantmentLevel(AutosmeltpotgEnchantment.enchantment, itemstack) != 0)) {
					auto_smelt = (true);
				} else if ((EnchantmentHelper.getEnchantmentLevel(BigholeEnchantment.enchantment, itemstack) != 0)) {
					big_hole = (EnchantmentHelper.getEnchantmentLevel(BigholeEnchantment.enchantment, itemstack));
				}
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Pickaxeofthegodslv17Item.block);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (auto_smelt) {
					(itemstack).addEnchantment(AutosmeltpotgEnchantment.enchantment, (int) 1);
				} else if (0 < big_hole) {
					(itemstack).addEnchantment(BigholeEnchantment.enchantment, (int) big_hole);
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
		if ((EnchantmentHelper.getEnchantmentLevel(BigholeEnchantment.enchantment, itemstack) != 0) && (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(PalamixedcharoalItem.block))
				: false) || 0 < itemstack.getOrCreateTag().getDouble("potg_fuel"))) {
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, x, y, z, (int) 5, 3, 3, 3, 1);
			}
			HammernormalProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity),
							new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			if (0 < itemstack.getOrCreateTag().getDouble("potg_fuel")) {
				itemstack.getOrCreateTag().putDouble("potg_fuel", (itemstack.getOrCreateTag().getDouble("potg_fuel") - 1));
			} else {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(PalamixedcharoalItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				itemstack.getOrCreateTag().putDouble("potg_fuel", (itemstack.getOrCreateTag().getDouble("potg_fuel") + 2500));
			}
		}
		if ((EnchantmentHelper.getEnchantmentLevel(AutosmeltpotgEnchantment.enchantment, itemstack) != 0) && ((world instanceof World)
				? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(itemstack), (World) world).isPresent()
				: false)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
						((world instanceof World && ((World) world).getRecipeManager()
								.getRecipe(IRecipeType.SMELTING,
										new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), ((World) world))
								.isPresent())
										? ((World) world).getRecipeManager()
												.getRecipe(IRecipeType.SMELTING,
														new Inventory((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
														(World) world)
												.get().getRecipeOutput().copy()
										: ItemStack.EMPTY));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			world.setBlockState(new BlockPos(x, y, z), Blocks.AIR.getDefaultState(), 3);
		}
	}
}
