package palamod.procedures;

import palamod.block.NbtblockBlock;

import palamod.PalamodMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.RegistryKey;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class SpawnCommandProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PalamodMod.LOGGER.warn("Failed to load dependency world for procedure SpawnCommand!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PalamodMod.LOGGER.warn("Failed to load dependency x for procedure SpawnCommand!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PalamodMod.LOGGER.warn("Failed to load dependency y for procedure SpawnCommand!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PalamodMod.LOGGER.warn("Failed to load dependency z for procedure SpawnCommand!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PalamodMod.LOGGER.warn("Failed to load dependency entity for procedure SpawnCommand!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			if (!dependencies.containsKey("cmdparams"))
				PalamodMod.LOGGER.warn("Failed to load dependency cmdparams for procedure SpawnCommand!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		double dim = 0;
		if ((entity.world.getDimensionKey()) == (World.OVERWORLD)) {
			dim = 0;
		} else if ((entity.world.getDimensionKey()) == (World.THE_NETHER)) {
			dim = (-1);
		} else if ((entity.world.getDimensionKey()) == (World.THE_END)) {
			dim = 1;
		} else {
			dim = 2;
		}
		if (dim == 0 || dim == -1 || dim == 1) {
			if ((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("0");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText()).equals("0")) {
				if ((world.getBlockState(new BlockPos((int) 0, (int) 10, (int) 0))).getBlock() == NbtblockBlock.block) {
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate((new Object() {
							public double getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_x")), (new Object() {
							public double getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_y")), (new Object() {
							public double getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_z")));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation((new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_x")), (new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_y")), (new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_z")), _ent.rotationYaw, _ent.rotationPitch,
									Collections.emptySet());
						}
					}
				} else {
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
							RegistryKey<World> destinationType = World.OVERWORLD;
							ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
							if (nextWorld != null) {
								((ServerPlayerEntity) _ent).connection
										.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
								((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
										nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
								for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
									((ServerPlayerEntity) _ent).connection
											.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
								}
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
					if ((world.getBlockState(new BlockPos((int) 0, (int) 10, (int) 0))).getBlock() == NbtblockBlock.block) {
						{
							Entity _ent = entity;
							_ent.setPositionAndUpdate((new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_x")), (new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_y")), (new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_z")));
							if (_ent instanceof ServerPlayerEntity) {
								((ServerPlayerEntity) _ent).connection.setPlayerLocation((new Object() {
									public double getValue(IWorld world, BlockPos pos, String tag) {
										TileEntity tileEntity = world.getTileEntity(pos);
										if (tileEntity != null)
											return tileEntity.getTileData().getDouble(tag);
										return -1;
									}
								}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_x")), (new Object() {
									public double getValue(IWorld world, BlockPos pos, String tag) {
										TileEntity tileEntity = world.getTileEntity(pos);
										if (tileEntity != null)
											return tileEntity.getTileData().getDouble(tag);
										return -1;
									}
								}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_y")), (new Object() {
									public double getValue(IWorld world, BlockPos pos, String tag) {
										TileEntity tileEntity = world.getTileEntity(pos);
										if (tileEntity != null)
											return tileEntity.getTileData().getDouble(tag);
										return -1;
									}
								}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_z")), _ent.rotationYaw, _ent.rotationPitch,
										Collections.emptySet());
							}
						}
					} else {
						{
							Entity _ent = entity;
							if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
								RegistryKey<World> destinationType = World.THE_NETHER;
								ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
								if (nextWorld != null) {
									((ServerPlayerEntity) _ent).connection
											.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
									((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
											nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
											_ent.rotationPitch);
									((ServerPlayerEntity) _ent).connection
											.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
									for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
										((ServerPlayerEntity) _ent).connection
												.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
									}
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
						}
						if ((world.getBlockState(new BlockPos((int) 0, (int) 10, (int) 0))).getBlock() == NbtblockBlock.block) {
							{
								Entity _ent = entity;
								_ent.setPositionAndUpdate((new Object() {
									public double getValue(IWorld world, BlockPos pos, String tag) {
										TileEntity tileEntity = world.getTileEntity(pos);
										if (tileEntity != null)
											return tileEntity.getTileData().getDouble(tag);
										return -1;
									}
								}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_x")), (new Object() {
									public double getValue(IWorld world, BlockPos pos, String tag) {
										TileEntity tileEntity = world.getTileEntity(pos);
										if (tileEntity != null)
											return tileEntity.getTileData().getDouble(tag);
										return -1;
									}
								}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_y")), (new Object() {
									public double getValue(IWorld world, BlockPos pos, String tag) {
										TileEntity tileEntity = world.getTileEntity(pos);
										if (tileEntity != null)
											return tileEntity.getTileData().getDouble(tag);
										return -1;
									}
								}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_z")));
								if (_ent instanceof ServerPlayerEntity) {
									((ServerPlayerEntity) _ent).connection.setPlayerLocation((new Object() {
										public double getValue(IWorld world, BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_x")), (new Object() {
										public double getValue(IWorld world, BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_y")), (new Object() {
										public double getValue(IWorld world, BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_z")), _ent.rotationYaw, _ent.rotationPitch,
											Collections.emptySet());
								}
							}
						} else {
							{
								Entity _ent = entity;
								if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
									RegistryKey<World> destinationType = World.THE_END;
									ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
									if (nextWorld != null) {
										((ServerPlayerEntity) _ent).connection
												.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
										((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
												nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
												_ent.rotationPitch);
										((ServerPlayerEntity) _ent).connection
												.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
										for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
										}
										((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
									}
								}
							}
							if ((world.getBlockState(new BlockPos((int) 0, (int) 10, (int) 0))).getBlock() == NbtblockBlock.block) {
								{
									Entity _ent = entity;
									_ent.setPositionAndUpdate((new Object() {
										public double getValue(IWorld world, BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_x")), (new Object() {
										public double getValue(IWorld world, BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_y")), (new Object() {
										public double getValue(IWorld world, BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_z")));
									if (_ent instanceof ServerPlayerEntity) {
										((ServerPlayerEntity) _ent).connection.setPlayerLocation((new Object() {
											public double getValue(IWorld world, BlockPos pos, String tag) {
												TileEntity tileEntity = world.getTileEntity(pos);
												if (tileEntity != null)
													return tileEntity.getTileData().getDouble(tag);
												return -1;
											}
										}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_x")), (new Object() {
											public double getValue(IWorld world, BlockPos pos, String tag) {
												TileEntity tileEntity = world.getTileEntity(pos);
												if (tileEntity != null)
													return tileEntity.getTileData().getDouble(tag);
												return -1;
											}
										}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_y")), (new Object() {
											public double getValue(IWorld world, BlockPos pos, String tag) {
												TileEntity tileEntity = world.getTileEntity(pos);
												if (tileEntity != null)
													return tileEntity.getTileData().getDouble(tag);
												return -1;
											}
										}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_z")), _ent.rotationYaw, _ent.rotationPitch,
												Collections.emptySet());
									}
								}
							} else {
								if (dim == 0) {
									{
										Entity _ent = entity;
										if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
											RegistryKey<World> destinationType = World.OVERWORLD;
											ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
											if (nextWorld != null) {
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
												((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
														nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
														_ent.rotationPitch);
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
												for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
													((ServerPlayerEntity) _ent).connection
															.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
												}
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
											}
										}
									}
								} else if (dim == 1) {
									{
										Entity _ent = entity;
										if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
											RegistryKey<World> destinationType = World.THE_END;
											ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
											if (nextWorld != null) {
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
												((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
														nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
														_ent.rotationPitch);
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
												for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
													((ServerPlayerEntity) _ent).connection
															.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
												}
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
											}
										}
									}
								} else {
									{
										Entity _ent = entity;
										if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
											RegistryKey<World> destinationType = World.THE_NETHER;
											ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
											if (nextWorld != null) {
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
												((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
														nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
														_ent.rotationPitch);
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
												for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
													((ServerPlayerEntity) _ent).connection
															.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
												}
												((ServerPlayerEntity) _ent).connection
														.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
											}
										}
									}
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"msg @p Aucun spawn d\u00E9tect\u00E9 dans aucune dimensions");
								}
							}
						}
					}
				}
			} else {
				if ((new Object() {
					public String getText() {
						String param = (String) cmdparams.get("0");
						if (param != null) {
							return param;
						}
						return "";
					}
				}.getText()).equals("1")) {
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
							RegistryKey<World> destinationType = World.OVERWORLD;
							ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
							if (nextWorld != null) {
								((ServerPlayerEntity) _ent).connection
										.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
								((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
										nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
								for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
									((ServerPlayerEntity) _ent).connection
											.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
								}
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate((new Object() {
							public double getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_x")), (new Object() {
							public double getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_y")), (new Object() {
							public double getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_z")));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation((new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_x")), (new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_y")), (new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_z")), _ent.rotationYaw, _ent.rotationPitch,
									Collections.emptySet());
						}
					}
				} else if ((new Object() {
					public String getText() {
						String param = (String) cmdparams.get("0");
						if (param != null) {
							return param;
						}
						return "";
					}
				}.getText()).equals("2")) {
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
							RegistryKey<World> destinationType = World.THE_NETHER;
							ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
							if (nextWorld != null) {
								((ServerPlayerEntity) _ent).connection
										.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
								((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
										nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
								for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
									((ServerPlayerEntity) _ent).connection
											.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
								}
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate((new Object() {
							public double getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_x")), (new Object() {
							public double getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_y")), (new Object() {
							public double getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_z")));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation((new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_x")), (new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_y")), (new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_z")), _ent.rotationYaw, _ent.rotationPitch,
									Collections.emptySet());
						}
					}
				} else if ((new Object() {
					public String getText() {
						String param = (String) cmdparams.get("0");
						if (param != null) {
							return param;
						}
						return "";
					}
				}.getText()).equals("3")) {
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
							RegistryKey<World> destinationType = World.THE_END;
							ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
							if (nextWorld != null) {
								((ServerPlayerEntity) _ent).connection
										.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
								((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
										nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
								for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
									((ServerPlayerEntity) _ent).connection
											.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
								}
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate((new Object() {
							public double getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_x")), (new Object() {
							public double getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_y")), (new Object() {
							public double getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_z")));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation((new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_x")), (new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_y")), (new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos((int) 0, (int) 10, (int) 0), "spawn_z")), _ent.rotationYaw, _ent.rotationPitch,
									Collections.emptySet());
						}
					}
				}
			}
		}
	}
}
