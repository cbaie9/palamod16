package palamod.procedures;

import palamod.world.LogsallGameRule;

import palamod.item.PaladiumIngotItem;
import palamod.item.MoneyotherItem;
import palamod.item.CorechiItem;

import palamod.entity.ElephantlittleEntity;

import palamod.block.RenforcedobsidianBlock;
import palamod.block.LuckyblockBlock;
import palamod.block.EndiumBlockBlock;

import palamod.PalamodModVariables;

import palamod.PalamodMod;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;
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
import net.minecraft.particles.ParticleTypes;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import java.util.function.Supplier;
import java.util.concurrent.atomic.AtomicReference;
import java.util.Random;
import java.util.Map;

public class Luckyprocessv2Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PalamodMod.LOGGER.warn("Failed to load dependency world for procedure Luckyprocessv2!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PalamodMod.LOGGER.warn("Failed to load dependency x for procedure Luckyprocessv2!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PalamodMod.LOGGER.warn("Failed to load dependency y for procedure Luckyprocessv2!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PalamodMod.LOGGER.warn("Failed to load dependency z for procedure Luckyprocessv2!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PalamodMod.LOGGER.warn("Failed to load dependency entity for procedure Luckyprocessv2!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		double Random = 0;
		boolean illegal_operation_check = false;
		Random = (new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "Random_lucky"));
		if (Random >= 164000 && Random <= 164500) {
			PalamodModVariables.lucky_name = "Double Xp";
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(Items.EXPERIENCE_BOTTLE);
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
						ItemStack _setstack = new ItemStack(Items.EXPERIENCE_BOTTLE);
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
						ItemStack _setstack = new ItemStack(Items.EXPERIENCE_BOTTLE);
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).addExperienceLevel((int) ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0));
			if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu l'event aux Lucky Block " + " Double Xp"));
			}
			PalamodModVariables.Lucky_destroy = 1;
		}
		if (Random >= 164500 && Random <= 164600) {
			PalamodModVariables.lucky_name = "Duplicata";
			{
				AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> _iitemhandlerref.set(capability));
				if (_iitemhandlerref.get() != null) {
					for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
						ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = itemstackiterator;
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
					}
				}
			}
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(Blocks.STRUCTURE_BLOCK);
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
						ItemStack _setstack = new ItemStack(Blocks.COMMAND_BLOCK);
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
						ItemStack _setstack = new ItemStack(Blocks.STRUCTURE_BLOCK);
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
			if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu l'event aux Lucky Block " + " Duplicata"));
			}
			PalamodModVariables.Lucky_destroy = 1;
			illegal_operation_check = (true);
		}
		if (Random >= 600 && Random <= 166810) {
			PalamodModVariables.lucky_name = "End";
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
					RegistryKey<World> destinationType = World.THE_END;
					ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
					if (nextWorld != null) {
						((ServerPlayerEntity) _ent).connection.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
						((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1,
								nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
						((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
						for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
							((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
						}
						((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
					}
				}
			}
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(Blocks.END_PORTAL_FRAME);
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
						ItemStack _setstack = new ItemStack(Blocks.END_PORTAL);
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
						ItemStack _setstack = new ItemStack(Blocks.END_PORTAL_FRAME);
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
			if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu l'event aux Lucky Block " + " End"));
			}
			PalamodModVariables.Lucky_destroy = 1;
			illegal_operation_check = (true);
		}
		if (Random >= 166800 && Random <= 168000) {
			PalamodModVariables.lucky_name = "Endium beacon";
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(Blocks.LAPIS_BLOCK);
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
						ItemStack _setstack = new ItemStack(Blocks.BEACON);
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
						ItemStack _setstack = new ItemStack(Blocks.LAPIS_BLOCK);
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
						"fill ~-3 ~ ~3 ~3 ~ ~-3 minecraft:lapis_block");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"fill ~-2 ~1 ~2 ~2 ~1 ~-2 minecraft:lapis_block");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"fill ~-1 ~2 ~1 ~1 ~2 ~-1 minecraft:lapis_block");
			}
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), Blocks.BEACON.getDefaultState(), 3);
			if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu l'event aux Lucky Block " + " Endium beacon"));
			}
			PalamodModVariables.Lucky_destroy = 2;
			illegal_operation_check = (false);
		}
		if (Random >= 168000 && Random <= 168100) {
			PalamodModVariables.lucky_name = "Endium \"Grade\"";
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(CorechiItem.block);
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
						ItemStack _setstack = new ItemStack(CorechiItem.block);
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
						ItemStack _setstack = new ItemStack(CorechiItem.block);
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(CorechiItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
				PalamodMod.LOGGER
						.info((entity.getDisplayName().getString() + " \u00E0 eu l'event aux Lucky Block " + " Endium \"Grade\" ( core beta v1 )"));
			}
			PalamodModVariables.Lucky_destroy = 1;
			illegal_operation_check = (false);
		}
		if (Random >= 168100 && Random <= 168200) {
			PalamodModVariables.lucky_name = "Endium Block";
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(EndiumBlockBlock.block);
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
						ItemStack _setstack = new ItemStack(EndiumBlockBlock.block);
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
						ItemStack _setstack = new ItemStack(EndiumBlockBlock.block);
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(EndiumBlockBlock.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu l'event aux Lucky Block " + " Endium Block"));
			}
			PalamodModVariables.Lucky_destroy = 1;
			illegal_operation_check = (true);
		}
		if (Random >= 168200 && Random <= 191200) {
			PalamodModVariables.lucky_name = "Enferm\u00E9";
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(Blocks.IRON_BARS);
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
						ItemStack _setstack = new ItemStack(Blocks.IRON_BARS);
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
						ItemStack _setstack = new ItemStack(Blocks.IRON_BARS);
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"fill ~-3 ~ ~3 ~3 ~ ~-3 minecraft:obsidian");
			}
			{
				BlockPos _bp = new BlockPos((int) (x + 1), (int) (y + 1), (int) z);
				BlockState _bs = RenforcedobsidianBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) (x + 1), (int) y, (int) z);
				BlockState _bs = RenforcedobsidianBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) (x - 1), (int) (y + 1), (int) z);
				BlockState _bs = RenforcedobsidianBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) (x - 1), (int) y, (int) z);
				BlockState _bs = RenforcedobsidianBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) (z + 1));
				BlockState _bs = RenforcedobsidianBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) (z + 1));
				BlockState _bs = RenforcedobsidianBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) (z - 1));
				BlockState _bs = RenforcedobsidianBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) (z - 1));
				BlockState _bs = RenforcedobsidianBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				BlockPos _bp = new BlockPos((int) x, (int) (y + 2), (int) z);
				BlockState _bs = RenforcedobsidianBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
			if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu l'event aux Lucky Block " + " Enferm\u00E9"));
			}
			PalamodModVariables.Lucky_destroy = 1;
			illegal_operation_check = (false);
		}
		if (Random >= 191200 && Random <= 193500) {
			PalamodModVariables.lucky_name = " Et Les Phant";
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(Blocks.BAMBOO);
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
						ItemStack _setstack = new ItemStack(Blocks.BAMBOO);
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
						ItemStack _setstack = new ItemStack(Blocks.BAMBOO);
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new ElephantlittleEntity.CustomEntity(ElephantlittleEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(x, y, z, (float) 0, (float) 0);
				entityToSpawn.setRenderYawOffset((float) 0);
				entityToSpawn.setRotationYawHead((float) 0);
				entityToSpawn.setMotion(0, 0, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"Title title In current devloppement");
			}
			if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu l'event aux Lucky Block " + " Et Les Phant"));
			}
			PalamodModVariables.Lucky_destroy = 1;
			illegal_operation_check = (false);
		}
		if (Random >= 193500 && Random <= 193600) {
			PalamodModVariables.lucky_name = " Et Paf des \"sous \"";
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(MoneyotherItem.block);
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
						ItemStack _setstack = new ItemStack(MoneyotherItem.block);
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
						ItemStack _setstack = new ItemStack(MoneyotherItem.block);
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(LuckyblockBlock.block);
				_setstack.setCount((int) 64);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu l'event aux Lucky Block " + " Et paf des sous"));
			}
			PalamodModVariables.Lucky_destroy = 1;
			illegal_operation_check = (false);
		}
		if (Random >= 193600 && Random <= 193700) {
			PalamodModVariables.lucky_name = " Et Paf plus de \"sous\"";
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(MoneyotherItem.block);
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
						ItemStack _setstack = new ItemStack(MoneyotherItem.block);
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
						ItemStack _setstack = new ItemStack(MoneyotherItem.block);
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
			if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(LuckyblockBlock.block)) : false) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(LuckyblockBlock.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 20,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			}
			if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu l'event aux Lucky Block " + " Et paf plus de sous"));
			}
			PalamodModVariables.Lucky_destroy = 1;
			illegal_operation_check = (false);
		}
		if (Random >= 193700 && Random <= 196800) {
			PalamodModVariables.lucky_name = "Ex-pala-osion";
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
						ItemStack _setstack = new ItemStack(PaladiumIngotItem.block);
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
			for (int index0 = 0; index0 < (int) (64); index0++) {
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
							((ServerWorld) world).spawnParticle(ParticleTypes.EXPLOSION, x, y, z, (int) 5, 3, 3, 3, 1);
						}
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(PaladiumIngotItem.block));
							entityToSpawn.setPickupDelay((int) 0);
							world.addEntity(entityToSpawn);
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 6);
			}
			if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu l'event aux Lucky Block " + "Ex-pala-osion"));
			}
			PalamodModVariables.Lucky_destroy = 1;
			illegal_operation_check = (false);
		}
		if (Random >= 193700 && Random <= 198300) {
			PalamodModVariables.lucky_name = "Coordonn\u00E9 de Fuze";
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"/give @p written_book{pages:['{\"text\":\"Voici Les coordonn\u00E9es de Fuze et des r\u00E9compences \\n\\nCalcule la page \\n(( 3 + 90 / 3 + 6 ) / 3 + 2 ) / 5\\n\\nBonne chance ;)\"}','[\"\",{\"text\":\"1 : Coordonn\u00E9es\\n\\n\"},{\"selector\":\"https://youtu.be/3Y7aWLpuxA4\"}]','[\"\",{\"text\":\"2 Coordonn\u00E9 de fuze\\n\\n\"},{\"selector\":\"https://youtu.be/ajlkhFnz8eo?list=TLPQMTcwMjIwMjI29uqOA1D3sQ&t=4\"}]','[\"\",{\"text\":\"3 Coordonn\u00E9es de Fuze \\n\\n\"},{\"selector\":\"https://youtu.be/GPXkjtpGCFI?t=7\"}]','[\"\",{\"text\":\"4 Coordonn\u00E9es de fuze \\n\\n\"},{\"selector\":\"https://youtu.be/O91DT1pR1ew\"}]'],title:\"Ma base\",author:Fuzay,display:{Lore:[\"Les Coo de ma base\"]}}");
			}
			if (world.getWorldInfo().getGameRulesInstance().getBoolean(LogsallGameRule.gamerule)) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \u00E0 eu l'event aux Lucky Block " + "Coordonn\u00E9 de fuze"));
			}
			PalamodModVariables.Lucky_destroy = 1;
			illegal_operation_check = (false);
		}
	}
}
