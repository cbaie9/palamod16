package palamod.procedures;

import palamod.block.NbtblockBlock;

import palamod.PalamodMod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.RegistryKey;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.Property;
import net.minecraft.potion.EffectInstance;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import java.util.Map;

public class SetspawnprocessProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PalamodMod.LOGGER.warn("Failed to load dependency world for procedure Setspawnprocess!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PalamodMod.LOGGER.warn("Failed to load dependency x for procedure Setspawnprocess!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PalamodMod.LOGGER.warn("Failed to load dependency y for procedure Setspawnprocess!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PalamodMod.LOGGER.warn("Failed to load dependency z for procedure Setspawnprocess!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PalamodMod.LOGGER.warn("Failed to load dependency entity for procedure Setspawnprocess!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (!((world.getBlockState(new BlockPos(0, 10, 0))).getBlock() == NbtblockBlock.block)) {
			{
				BlockPos _bp = new BlockPos(0, 10, 0);
				BlockState _bs = NbtblockBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				TileEntity _te = world.getTileEntity(_bp);
				CompoundNBT _bnbt = null;
				if (_te != null) {
					_bnbt = _te.write(new CompoundNBT());
					_te.remove();
				}
				world.setBlockState(_bp, _bs, 3);
				if (_bnbt != null) {
					_te = world.getTileEntity(_bp);
					if (_te != null) {
						try {
							_te.read(_bso, _bnbt);
						} catch (Exception ignored) {
						}
					}
				}
			}
		}
		if (((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.AIR
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.VOID_AIR
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.CAVE_AIR)
				&& ((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.AIR
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.VOID_AIR
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.CAVE_AIR)
				|| entity.getPersistentData().getBoolean("spawn_warn")) {
			if ((entity.world.getDimensionKey()) == (World.OVERWORLD)) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos(0, 10, 0);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("spawn_x", x);
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos(0, 10, 0);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("spawn_y", y);
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos(0, 10, 0);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("spawn_z", z);
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"msg @a [serveur] Le spawn a \uFFFDt\uFFFD chang\uFFFD ");
				}
				entity.getPersistentData().putBoolean("spawn_warn", (false));
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos(0, 10, 0);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putString("spawn_dim_id", "0");
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private IWorld world;

					public void start(IWorld world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
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
						{
							BlockPos _bp = new BlockPos(0, 10, 0);
							BlockState _bs = NbtblockBlock.block.getDefaultState();
							BlockState _bso = world.getBlockState(_bp);
							TileEntity _te = world.getTileEntity(_bp);
							CompoundNBT _bnbt = null;
							if (_te != null) {
								_bnbt = _te.write(new CompoundNBT());
								_te.remove();
							}
							world.setBlockState(_bp, _bs, 3);
							if (_bnbt != null) {
								_te = world.getTileEntity(_bp);
								if (_te != null) {
									try {
										_te.read(_bso, _bnbt);
									} catch (Exception ignored) {
									}
								}
							}
						}
						if (!world.isRemote()) {
							BlockPos _bp = new BlockPos(0, 10, 0);
							TileEntity _tileEntity = world.getTileEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getTileData().putString("spawn_dim_id", "0");
							if (world instanceof World)
								((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
						}
						new Object() {
							private int ticks = 0;
							private float waitTicks;
							private IWorld world;

							public void start(IWorld world, int waitTicks) {
								this.waitTicks = waitTicks;
								MinecraftForge.EVENT_BUS.register(this);
								this.world = world;
							}

							@SubscribeEvent
							public void tick(TickEvent.ServerTickEvent event) {
								if (event.phase == TickEvent.Phase.END) {
									this.ticks += 1;
									if (this.ticks >= this.waitTicks)
										run();
								}
							}

							private void run() {
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
								{
									BlockPos _bp = new BlockPos(0, 10, 0);
									BlockState _bs = NbtblockBlock.block.getDefaultState();
									BlockState _bso = world.getBlockState(_bp);
									TileEntity _te = world.getTileEntity(_bp);
									CompoundNBT _bnbt = null;
									if (_te != null) {
										_bnbt = _te.write(new CompoundNBT());
										_te.remove();
									}
									world.setBlockState(_bp, _bs, 3);
									if (_bnbt != null) {
										_te = world.getTileEntity(_bp);
										if (_te != null) {
											try {
												_te.read(_bso, _bnbt);
											} catch (Exception ignored) {
											}
										}
									}
								}
								if (!world.isRemote()) {
									BlockPos _bp = new BlockPos(0, 10, 0);
									TileEntity _tileEntity = world.getTileEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_tileEntity != null)
										_tileEntity.getTileData().putString("spawn_dim_id", "0");
									if (world instanceof World)
										((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
								}
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
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 20);
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 20);
			} else if ((entity.world.getDimensionKey()) == (World.THE_NETHER)) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos(0, 10, 0);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("spawn_x", x);
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos(0, 10, 0);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("spawn_y", y);
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos(0, 10, 0);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("spawn_z", z);
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"msg @a [serveur] Le spawn a \uFFFDt\uFFFD chang\uFFFD ");
				}
				entity.getPersistentData().putBoolean("spawn_warn", (false));
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos(0, 10, 0);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putString("spawn_dim_id", "1");
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private IWorld world;

					public void start(IWorld world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
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
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
						}
						{
							BlockPos _bp = new BlockPos(0, 10, 0);
							BlockState _bs = NbtblockBlock.block.getDefaultState();
							BlockState _bso = world.getBlockState(_bp);
							TileEntity _te = world.getTileEntity(_bp);
							CompoundNBT _bnbt = null;
							if (_te != null) {
								_bnbt = _te.write(new CompoundNBT());
								_te.remove();
							}
							world.setBlockState(_bp, _bs, 3);
							if (_bnbt != null) {
								_te = world.getTileEntity(_bp);
								if (_te != null) {
									try {
										_te.read(_bso, _bnbt);
									} catch (Exception ignored) {
									}
								}
							}
						}
						if (!world.isRemote()) {
							BlockPos _bp = new BlockPos(0, 10, 0);
							TileEntity _tileEntity = world.getTileEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getTileData().putString("spawn_dim_id", "1");
							if (world instanceof World)
								((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
						}
						new Object() {
							private int ticks = 0;
							private float waitTicks;
							private IWorld world;

							public void start(IWorld world, int waitTicks) {
								this.waitTicks = waitTicks;
								MinecraftForge.EVENT_BUS.register(this);
								this.world = world;
							}

							@SubscribeEvent
							public void tick(TickEvent.ServerTickEvent event) {
								if (event.phase == TickEvent.Phase.END) {
									this.ticks += 1;
									if (this.ticks >= this.waitTicks)
										run();
								}
							}

							private void run() {
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
								{
									BlockPos _bp = new BlockPos(0, 10, 0);
									BlockState _bs = NbtblockBlock.block.getDefaultState();
									BlockState _bso = world.getBlockState(_bp);
									TileEntity _te = world.getTileEntity(_bp);
									CompoundNBT _bnbt = null;
									if (_te != null) {
										_bnbt = _te.write(new CompoundNBT());
										_te.remove();
									}
									world.setBlockState(_bp, _bs, 3);
									if (_bnbt != null) {
										_te = world.getTileEntity(_bp);
										if (_te != null) {
											try {
												_te.read(_bso, _bnbt);
											} catch (Exception ignored) {
											}
										}
									}
								}
								if (!world.isRemote()) {
									BlockPos _bp = new BlockPos(0, 10, 0);
									TileEntity _tileEntity = world.getTileEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_tileEntity != null)
										_tileEntity.getTileData().putString("spawn_dim_id", "1");
									if (world instanceof World)
										((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
								}
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
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 20);
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 20);
			} else {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos(0, 10, 0);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("spawn_x", x);
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos(0, 10, 0);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("spawn_y", y);
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos(0, 10, 0);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("spawn_z", z);
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"msg @a [serveur] Le spawn a \uFFFDt\uFFFD chang\uFFFD ");
				}
				entity.getPersistentData().putBoolean("spawn_warn", (false));
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos(0, 10, 0);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putString("spawn_dim_id", "2");
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private IWorld world;

					public void start(IWorld world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
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
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
						}
						{
							BlockPos _bp = new BlockPos(0, 10, 0);
							BlockState _bs = NbtblockBlock.block.getDefaultState();
							BlockState _bso = world.getBlockState(_bp);
							TileEntity _te = world.getTileEntity(_bp);
							CompoundNBT _bnbt = null;
							if (_te != null) {
								_bnbt = _te.write(new CompoundNBT());
								_te.remove();
							}
							world.setBlockState(_bp, _bs, 3);
							if (_bnbt != null) {
								_te = world.getTileEntity(_bp);
								if (_te != null) {
									try {
										_te.read(_bso, _bnbt);
									} catch (Exception ignored) {
									}
								}
							}
						}
						if (!world.isRemote()) {
							BlockPos _bp = new BlockPos(0, 10, 0);
							TileEntity _tileEntity = world.getTileEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getTileData().putString("spawn_dim_id", "2");
							if (world instanceof World)
								((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
						}
						new Object() {
							private int ticks = 0;
							private float waitTicks;
							private IWorld world;

							public void start(IWorld world, int waitTicks) {
								this.waitTicks = waitTicks;
								MinecraftForge.EVENT_BUS.register(this);
								this.world = world;
							}

							@SubscribeEvent
							public void tick(TickEvent.ServerTickEvent event) {
								if (event.phase == TickEvent.Phase.END) {
									this.ticks += 1;
									if (this.ticks >= this.waitTicks)
										run();
								}
							}

							private void run() {
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
								if (!world.isRemote()) {
									BlockPos _bp = new BlockPos(0, 10, 0);
									TileEntity _tileEntity = world.getTileEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_tileEntity != null)
										_tileEntity.getTileData().putString("spawn_dim_id", "2");
									if (world instanceof World)
										((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
								}
								{
									BlockPos _bp = new BlockPos(0, 10, 0);
									BlockState _bs = NbtblockBlock.block.getDefaultState();
									BlockState _bso = world.getBlockState(_bp);
									TileEntity _te = world.getTileEntity(_bp);
									CompoundNBT _bnbt = null;
									if (_te != null) {
										_bnbt = _te.write(new CompoundNBT());
										_te.remove();
									}
									world.setBlockState(_bp, _bs, 3);
									if (_bnbt != null) {
										_te = world.getTileEntity(_bp);
										if (_te != null) {
											try {
												_te.read(_bso, _bnbt);
											} catch (Exception ignored) {
											}
										}
									}
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 20);
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 20);
			}
		} else {
			entity.getPersistentData().putBoolean("spawn_warn", (true));
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"msg @p [warn] Le spawn semble obsru\uFFFDe veuill\uFFFD recommencer la commande pour confimer");
			}
		}
	}
}
