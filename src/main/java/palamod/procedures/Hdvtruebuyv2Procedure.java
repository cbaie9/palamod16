package palamod.procedures;

import palamod.item.PlaceholdermarketItem;

import palamod.gui.StockhdvGui;
import palamod.gui.Palaerror0004Gui;
import palamod.gui.Palaerror0003Gui;
import palamod.gui.Palaerror0001Gui;

import palamod.PalamodMod;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import java.util.function.Supplier;
import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;

import io.netty.buffer.Unpooled;

public class Hdvtruebuyv2Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PalamodMod.LOGGER.warn("Failed to load dependency world for procedure Hdvtruebuyv2!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PalamodMod.LOGGER.warn("Failed to load dependency x for procedure Hdvtruebuyv2!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PalamodMod.LOGGER.warn("Failed to load dependency y for procedure Hdvtruebuyv2!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PalamodMod.LOGGER.warn("Failed to load dependency z for procedure Hdvtruebuyv2!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PalamodMod.LOGGER.warn("Failed to load dependency entity for procedure Hdvtruebuyv2!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(0, 10, 0), ("money_" + entity.getDisplayName().getString())) >= new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(0, 10, 0), ("market_price" + entity.getPersistentData().getDouble("temp_market_slot")))) {
			if ((new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_locked")) == false) {
				if (new Object() {
					public double getValue(IWorld world, BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos(0, 10, 0), ("market_hash" + entity.getPersistentData().getDouble("temp_market_slot"))) == entity
						.getPersistentData().getDouble("temp_market_hash")) {
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = (new Object() {
							public ItemStack getItemStack(BlockPos pos, int sltid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
								}
								return _retval.get();
							}
						}.getItemStack(new BlockPos(0, 10, 0), (int) (0)));
						_setstack.setCount((int) (new Object() {
							public double getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(world, new BlockPos(0, 10, 0), ("market_num" + entity.getPersistentData().getDouble("temp_market_slot")))));
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos(0, 10, 0);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble(("money_" + (new Object() {
								public String getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getString(tag);
									return "";
								}
							}.getValue(world, new BlockPos(0, 10, 0), ("market_pr" + entity.getPersistentData().getDouble("temp_market_slot"))))),
									(new Object() {
										public double getValue(IWorld world, BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(world, new BlockPos(0, 10, 0), ("money" + (new Object() {
										public String getValue(IWorld world, BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getString(tag);
											return "";
										}
									}.getValue(world, new BlockPos(0, 10, 0),
											("market_pr" + entity.getPersistentData().getDouble("temp_market_slot")))))) + new Object() {
												public double getValue(IWorld world, BlockPos pos, String tag) {
													TileEntity tileEntity = world.getTileEntity(pos);
													if (tileEntity != null)
														return tileEntity.getTileData().getDouble(tag);
													return -1;
												}
											}.getValue(world, new BlockPos(0, 10, 0),
													("market_price" + entity.getPersistentData().getDouble("temp_market_slot")))));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos(0, 10, 0);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble(("money_" + entity.getDisplayName().getString()), ((new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos(0, 10, 0), ("money_" + entity.getDisplayName().getString()))) - (new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos(0, 10, 0), ("market_price" + entity.getPersistentData().getDouble("temp_market_slot"))))));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos(0, 10, 0);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putBoolean(("market_buyed" + entity.getPersistentData().getDouble("temp_market_slot")), (true));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos(0, 10, 0);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble(("market_num" + entity.getPersistentData().getDouble("temp_market_slot")), 0);
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos(0, 10, 0);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble(("market_price" + entity.getPersistentData().getDouble("temp_market_slot")), 0);
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos(0, 10, 0);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putString(("market_name" + entity.getPersistentData().getDouble("temp_market_slot")), "Sold");
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					entity.getPersistentData().putBoolean("Wsb", (true));
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).closeScreen();
					PalamodMod.LOGGER.debug((entity.getDisplayName().getString() + " acces to hdv Stock ( code : Wsb )"));
					{
						Entity _ent = entity;
						if (_ent instanceof ServerPlayerEntity) {
							BlockPos _bpos = new BlockPos(0, 10, 0);
							NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
								@Override
								public ITextComponent getDisplayName() {
									return new StringTextComponent("Stockhdv");
								}

								@Override
								public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
									return new StockhdvGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
								}
							}, _bpos);
						}
					}
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(PlaceholdermarketItem.block);
								_setstack.setCount((int) 1);
								((Slot) ((Map) invobj).get((int) ((entity.getPersistentData().getDouble("temp_market_slot"))))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).closeScreen();
					PalamodMod.LOGGER.debug((entity.getDisplayName().getString() + " close Hdv stock ( end code Wsb )"));
					entity.getPersistentData().putBoolean("Wsb", (false));
				} else {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).closeScreen();
					{
						Entity _ent = entity;
						if (_ent instanceof ServerPlayerEntity) {
							BlockPos _bpos = new BlockPos(x, y, z);
							NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
								@Override
								public ITextComponent getDisplayName() {
									return new StringTextComponent("Palaerror0004");
								}

								@Override
								public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
									return new Palaerror0004Gui.GuiContainerMod(id, inventory,
											new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
								}
							}, _bpos);
						}
					}
				}
			} else {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).closeScreen();
				{
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						BlockPos _bpos = new BlockPos(x, y, z);
						NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
							@Override
							public ITextComponent getDisplayName() {
								return new StringTextComponent("Palaerror0001");
							}

							@Override
							public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
								return new Palaerror0001Gui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				}
			}
		} else {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).closeScreen();
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
						@Override
						public ITextComponent getDisplayName() {
							return new StringTextComponent("Palaerror0003");
						}

						@Override
						public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
							return new Palaerror0003Gui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		}
	}
}
