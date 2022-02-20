package palamod.procedures;

import palamod.PalamodMod;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.Inventory;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Map;

public class HamsfProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PalamodMod.LOGGER.warn("Failed to load dependency world for procedure Hamsf!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PalamodMod.LOGGER.warn("Failed to load dependency x for procedure Hamsf!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PalamodMod.LOGGER.warn("Failed to load dependency y for procedure Hamsf!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PalamodMod.LOGGER.warn("Failed to load dependency z for procedure Hamsf!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PalamodMod.LOGGER.warn("Failed to load dependency entity for procedure Hamsf!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (entity.rotationPitch > 40 || entity.rotationPitch < -40) {
			if ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
							((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock()))),
									((World) world)).isPresent())
											? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock()))),
													(World) world).get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
				if (Math.random() < 0.33) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								((world instanceof World && ((World) world).getRecipeManager()
										.getRecipe(IRecipeType.SMELTING, new Inventory(
												(new ItemStack((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock()))),
												((World) world))
										.isPresent())
												? ((World) world).getRecipeManager()
														.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																(world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock()))),
																(World) world)
														.get().getRecipeOutput().copy()
												: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 0);
						world.addEntity(entityToSpawn);
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
							((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock()))),
									((World) world)).isPresent())
											? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock()))),
													(World) world).get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
				if (Math.random() < 0.33) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								((world instanceof World && ((World) world).getRecipeManager()
										.getRecipe(IRecipeType.SMELTING, new Inventory(
												(new ItemStack((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock()))),
												((World) world))
										.isPresent())
												? ((World) world).getRecipeManager()
														.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																(world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock()))),
																(World) world)
														.get().getRecipeOutput().copy()
												: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 0);
						world.addEntity(entityToSpawn);
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
							((world instanceof World && ((World) world).getRecipeManager()
									.getRecipe(IRecipeType.SMELTING, new Inventory(
											(new ItemStack((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)))).getBlock()))),
											((World) world))
									.isPresent())
											? ((World) world).getRecipeManager()
													.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
															(world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)))).getBlock()))),
															(World) world)
													.get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
				if (Math.random() < 0.33) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(
										(new ItemStack((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)))).getBlock()))),
										((World) world)).isPresent())
												? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
														(world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)))).getBlock()))),
														(World) world).get().getRecipeOutput().copy()
												: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 0);
						world.addEntity(entityToSpawn);
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 1)))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 1)))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
							((world instanceof World && ((World) world).getRecipeManager()
									.getRecipe(IRecipeType.SMELTING, new Inventory(
											(new ItemStack((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 1)))).getBlock()))),
											((World) world))
									.isPresent())
											? ((World) world).getRecipeManager()
													.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
															(world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 1)))).getBlock()))),
															(World) world)
													.get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
				if (Math.random() < 0.33) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(
										(new ItemStack((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 1)))).getBlock()))),
										((World) world)).isPresent())
												? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
														(world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z - 1)))).getBlock()))),
														(World) world).get().getRecipeOutput().copy()
												: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 0);
						world.addEntity(entityToSpawn);
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z - 1)))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z - 1)))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
							((world instanceof World && ((World) world).getRecipeManager()
									.getRecipe(IRecipeType.SMELTING, new Inventory(
											(new ItemStack((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z - 1)))).getBlock()))),
											((World) world))
									.isPresent())
											? ((World) world).getRecipeManager()
													.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
															(world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z - 1)))).getBlock()))),
															(World) world)
													.get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
				if (Math.random() < 0.33) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(
										(new ItemStack((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z - 1)))).getBlock()))),
										((World) world)).isPresent())
												? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
														(world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z - 1)))).getBlock()))),
														(World) world).get().getRecipeOutput().copy()
												: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 0);
						world.addEntity(entityToSpawn);
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z + 1)))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z + 1)))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
							((world instanceof World && ((World) world).getRecipeManager()
									.getRecipe(IRecipeType.SMELTING, new Inventory(
											(new ItemStack((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z + 1)))).getBlock()))),
											((World) world))
									.isPresent())
											? ((World) world).getRecipeManager()
													.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
															(world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z + 1)))).getBlock()))),
															(World) world)
													.get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
				if (Math.random() < 0.33) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(
										(new ItemStack((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z + 1)))).getBlock()))),
										((World) world)).isPresent())
												? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
														(world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z + 1)))).getBlock()))),
														(World) world).get().getRecipeOutput().copy()
												: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 0);
						world.addEntity(entityToSpawn);
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
							((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock()))),
									((World) world)).isPresent())
											? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock()))),
													(World) world).get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
				if (Math.random() < 0.33) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								((world instanceof World && ((World) world).getRecipeManager()
										.getRecipe(IRecipeType.SMELTING, new Inventory(
												(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock()))),
												((World) world))
										.isPresent())
												? ((World) world).getRecipeManager()
														.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																(world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock()))),
																(World) world)
														.get().getRecipeOutput().copy()
												: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 0);
						world.addEntity(entityToSpawn);
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
							((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock()))),
									((World) world)).isPresent())
											? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock()))),
													(World) world).get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
				if (Math.random() < 0.33) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								((world instanceof World && ((World) world).getRecipeManager()
										.getRecipe(IRecipeType.SMELTING, new Inventory(
												(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock()))),
												((World) world))
										.isPresent())
												? ((World) world).getRecipeManager()
														.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																(world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock()))),
																(World) world)
														.get().getRecipeOutput().copy()
												: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 0);
						world.addEntity(entityToSpawn);
					}
				}
			}
		} else if ((entity.getHorizontalFacing()) == Direction.NORTH || (entity.getHorizontalFacing()) == Direction.SOUTH) {
			if ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
							((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock()))),
									((World) world)).isPresent())
											? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock()))),
													(World) world).get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
				if (Math.random() < 0.33) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								((world instanceof World && ((World) world).getRecipeManager()
										.getRecipe(IRecipeType.SMELTING, new Inventory(
												(new ItemStack((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock()))),
												((World) world))
										.isPresent())
												? ((World) world).getRecipeManager()
														.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																(world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock()))),
																(World) world)
														.get().getRecipeOutput().copy()
												: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 0);
						world.addEntity(entityToSpawn);
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
							((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock()))),
									((World) world)).isPresent())
											? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock()))),
													(World) world).get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
				if (Math.random() < 0.33) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								((world instanceof World && ((World) world).getRecipeManager()
										.getRecipe(IRecipeType.SMELTING, new Inventory(
												(new ItemStack((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock()))),
												((World) world))
										.isPresent())
												? ((World) world).getRecipeManager()
														.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																(world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock()))),
																(World) world)
														.get().getRecipeOutput().copy()
												: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 0);
						world.addEntity(entityToSpawn);
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
							((world instanceof World && ((World) world).getRecipeManager()
									.getRecipe(IRecipeType.SMELTING, new Inventory(
											(new ItemStack((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z))).getBlock()))),
											((World) world))
									.isPresent())
											? ((World) world).getRecipeManager()
													.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
															(world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z))).getBlock()))),
															(World) world)
													.get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
				if (Math.random() < 0.33) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(
										(new ItemStack((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z))).getBlock()))),
										((World) world)).isPresent())
												? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
														(world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z))).getBlock()))),
														(World) world).get().getRecipeOutput().copy()
												: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 0);
						world.addEntity(entityToSpawn);
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
							((world instanceof World && ((World) world).getRecipeManager()
									.getRecipe(IRecipeType.SMELTING, new Inventory(
											(new ItemStack((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z))).getBlock()))),
											((World) world))
									.isPresent())
											? ((World) world).getRecipeManager()
													.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
															(world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z))).getBlock()))),
															(World) world)
													.get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
				if (Math.random() < 0.33) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(
										(new ItemStack((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z))).getBlock()))),
										((World) world)).isPresent())
												? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
														(world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z))).getBlock()))),
														(World) world).get().getRecipeOutput().copy()
												: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 0);
						world.addEntity(entityToSpawn);
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
							((world instanceof World && ((World) world).getRecipeManager()
									.getRecipe(IRecipeType.SMELTING, new Inventory(
											(new ItemStack((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z))).getBlock()))),
											((World) world))
									.isPresent())
											? ((World) world).getRecipeManager()
													.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
															(world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z))).getBlock()))),
															(World) world)
													.get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
				if (Math.random() < 0.33) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(
										(new ItemStack((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z))).getBlock()))),
										((World) world)).isPresent())
												? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
														(world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z))).getBlock()))),
														(World) world).get().getRecipeOutput().copy()
												: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 0);
						world.addEntity(entityToSpawn);
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
							((world instanceof World && ((World) world).getRecipeManager()
									.getRecipe(IRecipeType.SMELTING, new Inventory(
											(new ItemStack((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z))).getBlock()))),
											((World) world))
									.isPresent())
											? ((World) world).getRecipeManager()
													.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
															(world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z))).getBlock()))),
															(World) world)
													.get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
				if (Math.random() < 0.33) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(
										(new ItemStack((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z))).getBlock()))),
										((World) world)).isPresent())
												? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
														(world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z))).getBlock()))),
														(World) world).get().getRecipeOutput().copy()
												: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 0);
						world.addEntity(entityToSpawn);
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
							((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()))),
									((World) world)).isPresent())
											? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()))),
													(World) world).get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
				if (Math.random() < 0.33) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								((world instanceof World && ((World) world).getRecipeManager()
										.getRecipe(IRecipeType.SMELTING, new Inventory(
												(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()))),
												((World) world))
										.isPresent())
												? ((World) world).getRecipeManager()
														.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																(world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()))),
																(World) world)
														.get().getRecipeOutput().copy()
												: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 0);
						world.addEntity(entityToSpawn);
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
							((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()))),
									((World) world)).isPresent())
											? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()))),
													(World) world).get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
				if (Math.random() < 0.33) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								((world instanceof World && ((World) world).getRecipeManager()
										.getRecipe(IRecipeType.SMELTING, new Inventory(
												(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()))),
												((World) world))
										.isPresent())
												? ((World) world).getRecipeManager()
														.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																(world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()))),
																(World) world)
														.get().getRecipeOutput().copy()
												: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 0);
						world.addEntity(entityToSpawn);
					}
				}
			}
		} else if ((entity.getHorizontalFacing()) == Direction.WEST || (entity.getHorizontalFacing()) == Direction.EAST) {
			if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
							((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock()))),
									((World) world)).isPresent())
											? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock()))),
													(World) world).get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
				if (Math.random() < 0.33) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								((world instanceof World && ((World) world).getRecipeManager()
										.getRecipe(IRecipeType.SMELTING, new Inventory(
												(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock()))),
												((World) world))
										.isPresent())
												? ((World) world).getRecipeManager()
														.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																(world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock()))),
																(World) world)
														.get().getRecipeOutput().copy()
												: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 0);
						world.addEntity(entityToSpawn);
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
							((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock()))),
									((World) world)).isPresent())
											? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock()))),
													(World) world).get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
				if (Math.random() < 0.33) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								((world instanceof World && ((World) world).getRecipeManager()
										.getRecipe(IRecipeType.SMELTING, new Inventory(
												(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock()))),
												((World) world))
										.isPresent())
												? ((World) world).getRecipeManager()
														.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																(world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock()))),
																(World) world)
														.get().getRecipeOutput().copy()
												: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 0);
						world.addEntity(entityToSpawn);
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
							((world instanceof World && ((World) world).getRecipeManager()
									.getRecipe(IRecipeType.SMELTING, new Inventory(
											(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)))).getBlock()))),
											((World) world))
									.isPresent())
											? ((World) world).getRecipeManager()
													.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
															(world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)))).getBlock()))),
															(World) world)
													.get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
				if (Math.random() < 0.33) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(
										(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)))).getBlock()))),
										((World) world)).isPresent())
												? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
														(world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)))).getBlock()))),
														(World) world).get().getRecipeOutput().copy()
												: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 0);
						world.addEntity(entityToSpawn);
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
							((world instanceof World && ((World) world).getRecipeManager()
									.getRecipe(IRecipeType.SMELTING, new Inventory(
											(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)))).getBlock()))),
											((World) world))
									.isPresent())
											? ((World) world).getRecipeManager()
													.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
															(world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)))).getBlock()))),
															(World) world)
													.get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
				if (Math.random() < 0.33) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(
										(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)))).getBlock()))),
										((World) world)).isPresent())
												? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
														(world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)))).getBlock()))),
														(World) world).get().getRecipeOutput().copy()
												: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 0);
						world.addEntity(entityToSpawn);
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
							((world instanceof World && ((World) world).getRecipeManager()
									.getRecipe(IRecipeType.SMELTING, new Inventory(
											(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)))).getBlock()))),
											((World) world))
									.isPresent())
											? ((World) world).getRecipeManager()
													.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
															(world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)))).getBlock()))),
															(World) world)
													.get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
				if (Math.random() < 0.33) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(
										(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)))).getBlock()))),
										((World) world)).isPresent())
												? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
														(world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)))).getBlock()))),
														(World) world).get().getRecipeOutput().copy()
												: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 0);
						world.addEntity(entityToSpawn);
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
							((world instanceof World && ((World) world).getRecipeManager()
									.getRecipe(IRecipeType.SMELTING, new Inventory(
											(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)))).getBlock()))),
											((World) world))
									.isPresent())
											? ((World) world).getRecipeManager()
													.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
															(world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)))).getBlock()))),
															(World) world)
													.get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
				if (Math.random() < 0.33) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(
										(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)))).getBlock()))),
										((World) world)).isPresent())
												? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
														(world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)))).getBlock()))),
														(World) world).get().getRecipeOutput().copy()
												: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 0);
						world.addEntity(entityToSpawn);
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
							((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock()))),
									((World) world)).isPresent())
											? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock()))),
													(World) world).get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
				if (Math.random() < 0.33) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								((world instanceof World && ((World) world).getRecipeManager()
										.getRecipe(IRecipeType.SMELTING, new Inventory(
												(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()))),
												((World) world))
										.isPresent())
												? ((World) world).getRecipeManager()
														.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																(world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()))),
																(World) world)
														.get().getRecipeOutput().copy()
												: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 0);
						world.addEntity(entityToSpawn);
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getMaterial() == net.minecraft.block.material.Material.ROCK
					&& !((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
							((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
									new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()))),
									((World) world)).isPresent())
											? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()))),
													(World) world).get().getRecipeOutput().copy()
											: ItemStack.EMPTY));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
				if (Math.random() < 0.33) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								((world instanceof World && ((World) world).getRecipeManager()
										.getRecipe(IRecipeType.SMELTING, new Inventory(
												(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()))),
												((World) world))
										.isPresent())
												? ((World) world).getRecipeManager()
														.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																(world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()))),
																(World) world)
														.get().getRecipeOutput().copy()
												: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 0);
						world.addEntity(entityToSpawn);
					}
				}
			}
		}
	}
}
