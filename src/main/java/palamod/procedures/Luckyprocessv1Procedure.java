package palamod.procedures;

import palamod.world.LogsallGameRule;

import palamod.item.WeightedItem;
import palamod.item.PaladiumIngotItem;
import palamod.item.OrangeblueseedItem;
import palamod.item.LuckybetaItem;

import palamod.entity.PaladiumdynamiteEntity;
import palamod.entity.BigdynamiteentityEntity;

import palamod.block.TruetresureBlock;
import palamod.block.MegasafechestBlock;
import palamod.block.FalsetresureBlock;
import palamod.block.ColoredlampBlock;
import palamod.block.ColofullampBlock;
import palamod.block.AmethysteBlockBlock;
import palamod.block.AlarmBlock;

import palamod.PalamodModVariables;

import palamod.PalamodMod;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;
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
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.Property;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BoneMealItem;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.horse.SkeletonHorseEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import java.util.stream.Stream;
import java.util.function.Supplier;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.AbstractMap;

public class Luckyprocessv1Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PalamodMod.LOGGER.warn("Failed to load dependency world for procedure Luckyprocessv1!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PalamodMod.LOGGER.warn("Failed to load dependency x for procedure Luckyprocessv1!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PalamodMod.LOGGER.warn("Failed to load dependency y for procedure Luckyprocessv1!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PalamodMod.LOGGER.warn("Failed to load dependency z for procedure Luckyprocessv1!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PalamodMod.LOGGER.warn("Failed to load dependency entity for procedure Luckyprocessv1!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		double Random = 0;
		if ((new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "Lucky_lock")) == false) {
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putBoolean("Lucky_lock", (true));
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			Random = (new Random().nextInt(198300 + 1));
			if (Random >= 1 && Random <= 11600) {
				PalamodModVariables.lucky_name = "0 + 0 = La t\u00EAte \u00E0 Toto";
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
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).addExperienceLevel(-((int) 10000));
						if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
							PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu aux lucky block l'event"
									+ "0 + 0 = La t\u00EAte \u00E0 Toto"));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 100);
				PalamodModVariables.Lucky_destroy = 1;
			}
			if (Random >= 11600 && Random <= 14700) {
				PalamodModVariables.lucky_name = "20 000 Lieux";
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(WeightedItem.boots);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(WeightedItem.boots);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(WeightedItem.boots);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
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
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(WeightedItem.boots);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 100);
				if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu aux lucky block l'event" + " 20 000 Lieux"));
				}
				PalamodModVariables.Lucky_destroy = 1;
			}
			if (Random >= 11600 && Random <= 14700) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
							"Vous avez eu un event non impl\u00E9ment\u00E9 ( Adieu Faction ) ( N\u00E9gatif ) Vous avez le droit \u00E0 un deuxi\u00E8me essai"),
							(true));
				}
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putBoolean("Lucky_lock", (false));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu aux lucky block l'event"
							+ "Adieu Faction ( Non impl\u00E9ment\u00E9 )"));
				}
				PalamodModVariables.Lucky_destroy = 2;
			}
			if (Random >= 14700 && Random <= 26300) {
				PalamodModVariables.lucky_name = "Allumer le feu";
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Blocks.NETHERRACK);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Blocks.NETHERRACK);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Blocks.NETHERRACK);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
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
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"fill ~-5 ~-1 ~5 ~5 ~-1 ~-5 minecraft:netherrack");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"fill ~-5 ~ ~5 ~5 ~ ~-5 minecraft:fire");
						}
						if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
							PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu aux lucky block l'event" + "Allumer le feu"));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 100);
				PalamodModVariables.Lucky_destroy = 1;
			}
			if (Random >= 26300 && Random <= 27500) {
				PalamodModVariables.lucky_name = "Amethyste beacon";
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(AmethysteBlockBlock.block);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(AmethysteBlockBlock.block);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Blocks.BEACON);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
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
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"fill ~-3 ~-1 ~3 ~3 ~-1 ~-3 palamod:amethyste_block");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"fill ~-2 ~1 ~2 ~2 ~1 ~-2 palamod:amethyste_block");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"fill ~-1 ~2 ~1 ~1 ~2 ~-1 palamod:amethyste_block");
						}
						world.setBlockState(new BlockPos((int) x, (int) (y + 2), (int) z), Blocks.BEACON.getDefaultState(), 3);
						if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
							PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu aux lucky block l'event" + "Amethyste beacon"));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 100);
				PalamodModVariables.Lucky_destroy = 3;
			}
			if (Random >= 27500 && Random <= 14700) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
							"Vous avez eu un event non impl\u00E9ment\u00E9 ( Analyste ) ( N\u00E9gatif ) Vous avez le droit \u00E0 un deuxi\u00E8me essai"),
							(true));
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(LuckybetaItem.block);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(LuckybetaItem.block);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(LuckybetaItem.block);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putBoolean("Lucky_lock", (false));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
					PalamodMod.LOGGER.info(
							(entity.getDisplayName().getString() + " \u00E0 eu aux lucky block l'event" + "Analyste ( Non impl\u00E9ment\u00E9 )"));
				}
				Random = 2;
			}
			if (Random >= 14700 && Random <= 26300) {
				PalamodModVariables.lucky_name = "Aranho trap";
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Blocks.COBWEB);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Blocks.COBWEB);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Blocks.COBWEB);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
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
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"fill ~-5 ~-1 ~5 ~5 ~-1 ~-5 minecraft:cobweb");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"fill ~-5 ~ ~5 ~5 ~ ~-5 minecraft:cobweb");
						}
						if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
							PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu aux lucky block l'event" + "Aracno- trap"));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 100);
				PalamodModVariables.Lucky_destroy = 1;
			}
			if (Random >= 26300 && Random <= 35600) {
				PalamodModVariables.lucky_name = "Batman nerveux";
				for (int index0 = 0; index0 < (int) (3); index0++) {
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new BatEntity(EntityType.BAT, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Items.BAT_SPAWN_EGG);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Items.BAT_SPAWN_EGG);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Items.BAT_SPAWN_EGG);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
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
						if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
							PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu aux lucky block l'event" + "Batman Nerveux"));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 100);
				PalamodModVariables.Lucky_destroy = 1;
			}
			if (Random >= 35600 && Random <= 81900) {
				PalamodModVariables.lucky_name = "Body guard";
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Blocks.IRON_BLOCK);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Blocks.CARVED_PUMPKIN);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Blocks.IRON_BLOCK);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				for (int index1 = 0; index1 < (int) (3); index1++) {
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new IronGolemEntity(EntityType.IRON_GOLEM, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
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
						if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
							PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu aux lucky block l'event" + "Body guard"));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 100);
				PalamodModVariables.Lucky_destroy = 1;
			}
			if (Random >= 81900 && Random <= 97300) {
				PalamodModVariables.lucky_name = "Boom";
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Blocks.TNT);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Blocks.TNT);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Blocks.TNT);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				for (int index2 = 0; index2 < (int) (3); index2++) {
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new PaladiumdynamiteEntity.CustomEntity(PaladiumdynamiteEntity.entity, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
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
						if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
							PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu aux lucky block l'event" + "Boom"));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 100);
				PalamodModVariables.Lucky_destroy = 1;
			}
			if (Random >= 97300 && Random <= 120400) {
				PalamodModVariables.lucky_name = "BOOM";
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Items.TNT_MINECART);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Items.TNT_MINECART);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Items.TNT_MINECART);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				for (int index3 = 0; index3 < (int) (1); index3++) {
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new BigdynamiteentityEntity.CustomEntity(BigdynamiteentityEntity.entity, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
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
						if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
							PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu aux lucky block l'event" + "BOOM"));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 100);
				PalamodModVariables.Lucky_destroy = 1;
			}
			if (Random >= 120400 && Random <= 129700) {
				PalamodModVariables.lucky_name = "Boo-Ban";
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Blocks.POTTED_BAMBOO);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Blocks.POTTED_BAMBOO);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Blocks.POTTED_BAMBOO);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.BAMBOO_SAPLING.getDefaultState(), 3);
				for (int index4 = 0; index4 < (int) (5); index4++) {
					if (world instanceof World) {
						if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), (World) world, new BlockPos((int) x, (int) y, (int) z))
								|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), (World) world, new BlockPos((int) x, (int) y, (int) z),
										(Direction) null)) {
							if (!world.isRemote())
								((World) world).playEvent(2005, new BlockPos((int) x, (int) y, (int) z), 0);
						}
					}
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
						if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
							PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu aux lucky block l'event" + "Boo-Ban"));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 100);
				PalamodModVariables.Lucky_destroy = 3;
			}
			if (Random >= 129700 && Random <= 139000) {
				PalamodModVariables.lucky_name = "Bunny life";
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Items.RABBIT_FOOT);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Items.RABBIT_FOOT);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Items.RABBIT_FOOT);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				for (int index5 = 0; index5 < (int) (100); index5++) {
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
								_ent.setPositionAndUpdate(x, (y + 1), z);
								if (_ent instanceof ServerPlayerEntity) {
									((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, (y + 1), z, _ent.rotationYaw, _ent.rotationPitch,
											Collections.emptySet());
								}
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 20);
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
						if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
							PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu aux lucky block l'event" + "Bunny life"));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 100);
				PalamodModVariables.Lucky_destroy = 1;
			}
			if (Random >= 139000 && Random <= 143600) {
				PalamodModVariables.lucky_name = "C'est pas pass\u00E9 loin";
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).setHealth((float) 1);
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Blocks.CREEPER_HEAD);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Blocks.CREEPER_HEAD);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Blocks.CREEPER_HEAD);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
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
						if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
							PalamodMod.LOGGER.info(
									(entity.getDisplayName().getString() + " \u00E0 eu aux lucky block l'event" + "\"C'est pas pass\u00E9 loin\""));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 100);
				PalamodModVariables.Lucky_destroy = 1;
			}
			if (Random >= 143600 && Random <= 145100) {
				PalamodModVariables.lucky_name = "C'est tr\u00E8s haut non ?";
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Items.ENDER_PEARL);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Items.ENDER_PEARL);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Items.ENDER_PEARL);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				{
					Entity _ent = entity;
					_ent.setPositionAndUpdate(x, 256, z);
					if (_ent instanceof ServerPlayerEntity) {
						((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, 256, z, _ent.rotationYaw, _ent.rotationPitch,
								Collections.emptySet());
					}
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
						if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
							PalamodMod.LOGGER.info(
									(entity.getDisplayName().getString() + " \u00E0 eu aux lucky block l'event" + "\"C'est tr\u00E8s haut non ?\""));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 100);
				PalamodModVariables.Lucky_destroy = 1;
			}
			if (Random >= 145100 && Random <= 143600) {
				PalamodModVariables.lucky_name = "Caballo de la muerte";
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Items.BAT_SPAWN_EGG);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Items.BAT_SPAWN_EGG);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Items.BAT_SPAWN_EGG);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				for (int index6 = 0; index6 < (int) (5); index6++) {
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new SkeletonHorseEntity(EntityType.SKELETON_HORSE, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, (float) 0, (float) 0);
						entityToSpawn.setRenderYawOffset((float) 0);
						entityToSpawn.setRotationYawHead((float) 0);
						entityToSpawn.setMotion(0, 0, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
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
						if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
							PalamodMod.LOGGER
									.info((entity.getDisplayName().getString() + " \u00E0 eu aux lucky block l'event" + "Caballo de la muerte"));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 100);
				PalamodModVariables.Lucky_destroy = 1;
			}
			if (Random >= 145100 && Random <= 147400) {
				PalamodModVariables.lucky_name = "Carte au tr\u00E9sor";
				world.setBlockState(new BlockPos((int) 21000, (int) 255, (int) 100), TruetresureBlock.block.getDefaultState(), 3);
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(FalsetresureBlock.block);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(FalsetresureBlock.block);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(FalsetresureBlock.block);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"msg @s Le coffre au tr\u00E9sor  est a X:21000 Y:255 Z:100");
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
						if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
							PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu aux lucky block l'event"
									+ "carte au tr\u00E9sor (\u00E0$\u00F9$"));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 100);
				PalamodModVariables.Lucky_destroy = 1;
			}
			if (Random >= 147400 && Random <= 149700) {
				PalamodModVariables.lucky_name = "Carte au tr\u00E9sor";
				world.setBlockState(new BlockPos((int) 21000, (int) 255, (int) 100), FalsetresureBlock.block.getDefaultState(), 3);
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(FalsetresureBlock.block);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(FalsetresureBlock.block);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(FalsetresureBlock.block);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"msg @s Le coffre au tr\u00E9sor  est a X:21000 Y:255 Z:100");
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
						if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
							PalamodMod.LOGGER.info(
									(entity.getDisplayName().getString() + " \u00E0 eu aux lucky block l'event" + "carte au tr\u00E9sor $\u00F9$"));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 100);
				PalamodModVariables.Lucky_destroy = 1;
			}
			if (Random >= 149700 && Random <= 151200) {
				PalamodModVariables.lucky_name = "Au voleur";
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), AlarmBlock.block.getDefaultState(), 3);
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(AlarmBlock.block);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(AlarmBlock.block);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(AlarmBlock.block);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
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
						if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
							PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu aux lucky block l'event" + "Au voleur"));
						}
						PalamodModVariables.Lucky_destroy = 1;
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 100);
			}
			if (Random >= 151200 && Random <= 152100) {
				PalamodModVariables.lucky_name = "Coffre fort ";
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), MegasafechestBlock.block.getDefaultState(), 3);
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(MegasafechestBlock.block);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(MegasafechestBlock.block);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(MegasafechestBlock.block);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
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
						if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
							PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu aux lucky block l'event" + "Coffre fort"));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 100);
				PalamodModVariables.Lucky_destroy = 1;
			}
			if (Random >= 152100 && Random <= 156700) {
				PalamodModVariables.lucky_name = "Colorful lamp";
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), ColoredlampBlock.block.getDefaultState(), 3);
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(ColofullampBlock.block);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(ColofullampBlock.block);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(ColofullampBlock.block);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
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
						if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
							PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu aux lucky block l'event" + "Colorful lamp"));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 100);
				PalamodModVariables.Lucky_destroy = 2;
			}
			if (Random >= 156700 && Random <= 157200) {
				PalamodModVariables.lucky_name = " Comment t'a eu \u00E7a";
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(OrangeblueseedItem.block);
					_setstack.setCount((int) 12);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(OrangeblueseedItem.block);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(OrangeblueseedItem.block);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(OrangeblueseedItem.block);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
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
						if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
							PalamodMod.LOGGER
									.info((entity.getDisplayName().getString() + " \u00E0 eu aux lucky block l'event" + "Comment t'a eu \u00E7a"));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 100);
				PalamodModVariables.Lucky_destroy = 1;
			}
			if (Random >= 157200 && Random <= 161700) {
				PalamodModVariables.lucky_name = "Consolation";
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(PaladiumIngotItem.block);
					_setstack.setCount((int) 64);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(PaladiumIngotItem.block);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(PaladiumIngotItem.block);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(PaladiumIngotItem.block);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.fall")),
							SoundCategory.MASTER, (float) 2, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.fall")),
							SoundCategory.MASTER, (float) 2, (float) 1, false);
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
						if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
							PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu aux lucky block l'event" + "Consolation"));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 100);
				PalamodModVariables.Lucky_destroy = 1;
			}
			if (Random >= 161700 && Random <= 164000) {
				PalamodModVariables.lucky_name = "Diamond beacon";
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
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"fill ~-3 ~-1 ~3 ~3 ~-1 ~-3 minecraft:diamond_block");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"fill ~-2 ~1 ~2 ~2 ~1 ~-2 minecraft:diamond_block");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"fill ~-1 ~2 ~1 ~1 ~2 ~-1 minecraft:diamond_block");
						}
						world.setBlockState(new BlockPos((int) x, (int) (y + 2), (int) z), Blocks.BEACON.getDefaultState(), 3);
						if (entity instanceof PlayerEntity) {
							Container _current = ((PlayerEntity) entity).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									ItemStack _setstack = new ItemStack(Blocks.DIAMOND_BLOCK);
									_setstack.setCount((int) 1);
									((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
									_current.detectAndSendChanges();
								}
							}
						}
						if (entity instanceof PlayerEntity) {
							Container _current = ((PlayerEntity) entity).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									ItemStack _setstack = new ItemStack(Blocks.DIAMOND_BLOCK);
									_setstack.setCount((int) 1);
									((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
									_current.detectAndSendChanges();
								}
							}
						}
						if (entity instanceof PlayerEntity) {
							Container _current = ((PlayerEntity) entity).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									ItemStack _setstack = new ItemStack(Blocks.DIAMOND_BLOCK);
									_setstack.setCount((int) 1);
									((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
									_current.detectAndSendChanges();
								}
							}
						}
						if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
							PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu aux lucky block l'event" + "Diamond beacon"));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 100);
				PalamodModVariables.Lucky_destroy = 3;
			}
			if (Random >= 161700 && Random <= 164000) {
				PalamodModVariables.lucky_name = "Diamond beacon";
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Blocks.DIAMOND_BLOCK);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Blocks.DIAMOND_BLOCK);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Blocks.DIAMOND_BLOCK);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
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
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"fill ~-3 ~-1 ~3 ~3 ~-1 ~-3 minecraft:diamond_block");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"fill ~-2 ~1 ~2 ~2 ~1 ~-2 minecraft:diamond_block");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"fill ~-1 ~2 ~1 ~1 ~2 ~-1 minecraft:diamond_block");
						}
						world.setBlockState(new BlockPos((int) x, (int) (y + 2), (int) z), Blocks.BEACON.getDefaultState(), 3);
						if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
							PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu aux lucky block l'event" + "Diamond beacon"));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 100);
				PalamodModVariables.Lucky_destroy = 3;
			}
			if (Random > 164000) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("Random_lucky", Random);
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				Luckyprocessv2Procedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity),
								new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			} else {
				if (PalamodModVariables.Lucky_destroy == 1) {
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
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).closeScreen();
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 40);
				} else if (PalamodModVariables.Lucky_destroy == 0 || PalamodModVariables.Lucky_destroy == 2
						|| PalamodModVariables.Lucky_destroy == 3) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).closeScreen();
				}
			}
		}
	}
}
