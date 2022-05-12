package palamod.procedures;

import palamod.PalamodModVariables;

import palamod.PalamodMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

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
		if (entity instanceof PlayerEntity) {
			Container _current = ((PlayerEntity) entity).openContainer;
			if (_current instanceof Supplier) {
				Object invobj = ((Supplier) _current).get();
				if (invobj instanceof Map) {
					ItemStack _setstack = (PalamodModVariables.MapVariables.get(world).market_item0);
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
					ItemStack _setstack = (PalamodModVariables.MapVariables.get(world).market_item1);
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
					ItemStack _setstack = (PalamodModVariables.MapVariables.get(world).market_item2);
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
					ItemStack _setstack = (PalamodModVariables.MapVariables.get(world).market_item3);
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
