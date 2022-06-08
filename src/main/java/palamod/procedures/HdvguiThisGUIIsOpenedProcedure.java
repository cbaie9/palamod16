package palamod.procedures;

import palamod.gui.StockhdvGui;
import palamod.gui.HdvguiGui;

import palamod.PalamodModVariables;

import palamod.PalamodMod;

import net.minecraftforge.fml.network.NetworkHooks;

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

import java.util.function.Supplier;
import java.util.Map;

import io.netty.buffer.Unpooled;

public class HdvguiThisGUIIsOpenedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PalamodMod.LOGGER.warn("Failed to load dependency world for procedure HdvguiThisGUIIsOpened!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PalamodMod.LOGGER.warn("Failed to load dependency entity for procedure HdvguiThisGUIIsOpened!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack item1 = ItemStack.EMPTY;
		ItemStack item2 = ItemStack.EMPTY;
		ItemStack item3 = ItemStack.EMPTY;
		ItemStack item4 = ItemStack.EMPTY;
		if (entity.getPersistentData().getBoolean("hdvnopen") == false || !entity.getPersistentData().getBoolean("hdvnopen")) {
			PalamodMod.LOGGER.debug((entity.getDisplayName().getString() + "get access to hdv stock ( code wso1 ) ( open )"));
			entity.getPersistentData().putBoolean("wso1", (true));
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
			item1 = (new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (0)));
			item2 = (new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (1)));
			item3 = (new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (2)));
			item4 = (new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (3)));
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).closeScreen();
			entity.getPersistentData().putBoolean("wso1", (false));
			PalamodMod.LOGGER.debug((entity.getDisplayName().getString() + "get access to hdv stock ( code wso1 ) ( close )"));
			entity.getPersistentData().putBoolean("hdvnopen", (true));
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					BlockPos _bpos = new BlockPos(0, 10, 0);
					NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
						@Override
						public ITextComponent getDisplayName() {
							return new StringTextComponent("Hdvgui");
						}

						@Override
						public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
							return new HdvguiGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
			entity.getPersistentData().putBoolean("hdvnopen", (false));
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = (item1);
						_setstack.setCount((int) (new Object() {
							public double getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(world, new BlockPos(0, 10, 0), "market_num0")));
						((Slot) ((Map) invobj).get((int) (0))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = (item2);
						_setstack.setCount((int) (new Object() {
							public double getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(world, new BlockPos(0, 10, 0), "market_num1")));
						((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = (item3);
						_setstack.setCount((int) (new Object() {
							public double getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(world, new BlockPos(0, 10, 0), "market_num2")));
						((Slot) ((Map) invobj).get((int) (2))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = (item4);
						_setstack.setCount((int) (new Object() {
							public double getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(world, new BlockPos(0, 10, 0), "market_num3")));
						((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
			PalamodModVariables.MapVariables.get(world).market_name_0 = (new Object() {
				public String getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_name0"));
			PalamodModVariables.MapVariables.get(world).syncData(world);
			PalamodModVariables.MapVariables.get(world).market_name_1 = (new Object() {
				public String getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_name1"));
			PalamodModVariables.MapVariables.get(world).syncData(world);
			PalamodModVariables.MapVariables.get(world).market_name_2 = (new Object() {
				public String getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_name2"));
			PalamodModVariables.MapVariables.get(world).syncData(world);
			PalamodModVariables.MapVariables.get(world).market_name_3 = (new Object() {
				public String getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_name3"));
			PalamodModVariables.MapVariables.get(world).syncData(world);
			PalamodModVariables.MapVariables.get(world).market_price_0 = (new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_price0"));
			PalamodModVariables.MapVariables.get(world).syncData(world);
			PalamodModVariables.MapVariables.get(world).market_price_1 = (new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_price1"));
			PalamodModVariables.MapVariables.get(world).syncData(world);
			PalamodModVariables.MapVariables.get(world).market_price_2 = (new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_price2"));
			PalamodModVariables.MapVariables.get(world).syncData(world);
			PalamodModVariables.MapVariables.get(world).market_price_3 = (new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_price3"));
			PalamodModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
