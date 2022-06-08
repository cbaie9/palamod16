package palamod.procedures;

import palamod.gui.StockhdvGui;

import palamod.PalamodMod;

import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.MathHelper;
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
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.block.BlockState;

import java.util.function.Supplier;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;

import io.netty.buffer.Unpooled;

public class Hdvsellv2Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PalamodMod.LOGGER.warn("Failed to load dependency world for procedure Hdvsellv2!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PalamodMod.LOGGER.warn("Failed to load dependency entity for procedure Hdvsellv2!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				PalamodMod.LOGGER.warn("Failed to load dependency guistate for procedure Hdvsellv2!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		ItemStack item_stock = ItemStack.EMPTY;
		if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed0")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 0);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed1")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 1);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed2")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 2);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed3")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 3);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed4")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 4);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed5")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 5);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed6")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 6);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed7")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 7);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed8")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 8);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed9")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 9);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed10")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 10);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed11")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 11);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed12")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 12);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed13")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 13);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed14")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 14);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed15")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 15);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed16")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 16);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed17")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 17);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed18")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 18);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed19")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 19);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed20")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 20);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed21")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 21);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed22")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 22);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed23")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 23);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed24")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 24);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed25")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 25);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed26")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 26);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed27")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 27);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed28")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 28);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed29")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 29);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed30")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 30);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed31")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 31);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed32")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 32);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed33")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 33);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed34")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 34);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed35")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 35);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed36")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 36);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed37")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 37);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed38")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 38);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed39")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 39);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed40")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 40);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed41")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 41);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed42")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 42);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed43")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 43);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed44")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 44);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed45")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 45);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed46")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 46);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed47")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 47);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed48")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 48);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed49")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 49);
		} else if (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(0, 10, 0), "market_buyed50")) {
			entity.getPersistentData().putDouble("Slot_number_hdv", 50);
		} else {
			if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed51")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 51);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed52")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 52);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed53")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 53);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed54")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 54);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed55")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 55);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed56")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 56);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed57")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 57);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed58")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 58);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed59")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 59);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed60")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 60);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed61")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 61);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed62")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 62);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed63")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 64);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed64")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 65);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed65")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 65);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed66")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 66);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed67")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 67);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed68")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 68);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed69")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 69);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed70")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 70);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed71")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 71);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed72")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 72);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed73")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 73);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed74")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 74);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed75")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 75);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed76")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 76);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed77")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 77);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed78")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 78);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed79")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 79);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed80")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 80);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed81")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 81);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed82")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 82);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed83")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 83);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed84")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 84);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed85")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 85);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed86")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 86);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed87")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 87);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed88")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 88);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed89")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 89);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed90")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 90);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed91")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 91);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed92")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 92);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed93")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 93);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed94")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 94);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed95")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 95);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed96")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 96);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed97")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 97);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed98")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 98);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed99")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 99);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed100")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 100);
			} else if (new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos(0, 10, 0), "market_buyed101")) {
				entity.getPersistentData().putDouble("Slot_number_hdv", 101);
			}
		}
		if (!world.isRemote()) {
			BlockPos _bp = new BlockPos(0, 10, 0);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putString(("market_pr" + entity.getPersistentData().getDouble("Slot_number_hdv")),
						(entity.getDisplayName().getString()));
			if (world instanceof World)
				((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (!world.isRemote()) {
			BlockPos _bp = new BlockPos(0, 10, 0);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putString(("market_name" + entity.getPersistentData().getDouble("Slot_number_hdv")), (new Object() {
					public String getText() {
						TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:market_name");
						if (_tf != null) {
							return _tf.getText();
						}
						return "";
					}
				}.getText()));
			if (world instanceof World)
				((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		item_stock = (new Object() {
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
		if (!world.isRemote()) {
			BlockPos _bp = new BlockPos(0, 10, 0);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble(("market_price" + entity.getPersistentData().getDouble("Slot_number_hdv")), new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(new Object() {
					public String getText() {
						TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:market_price");
						if (_tf != null) {
							return _tf.getText();
						}
						return "";
					}
				}.getText()));
			if (world instanceof World)
				((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (!world.isRemote()) {
			BlockPos _bp = new BlockPos(0, 10, 0);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble(("market_num" + entity.getPersistentData().getDouble("Slot_number_hdv")), (new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof ServerPlayerEntity) {
							Container _current = ((ServerPlayerEntity) entity).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
									if (stack != null)
										return stack.getCount();
								}
							}
						}
						return 0;
					}
				}.getAmount((int) (0))));
			if (world instanceof World)
				((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (!world.isRemote()) {
			BlockPos _bp = new BlockPos(0, 10, 0);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble(("market_hash" + entity.getPersistentData().getDouble("Slot_number_hdv")),
						(MathHelper.nextInt(new Random(), 1, 10000) / 10));
			if (world instanceof World)
				((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (!world.isRemote()) {
			BlockPos _bp = new BlockPos(0, 10, 0);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putBoolean(("market_buyed" + entity.getPersistentData().getDouble("Slot_number_hdv")), (false));
			if (world instanceof World)
				((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (entity instanceof ServerPlayerEntity) {
			Container _current = ((ServerPlayerEntity) entity).openContainer;
			if (_current instanceof Supplier) {
				Object invobj = ((Supplier) _current).get();
				if (invobj instanceof Map) {
					((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
					_current.detectAndSendChanges();
				}
			}
		}
		entity.getPersistentData().putBoolean("Wsa", (true));
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
		PalamodMod.LOGGER.debug((entity.getDisplayName().getString() + " Sell his item, access to hdv Stock ( code Wsa )"));
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
					ItemStack _setstack = (item_stock);
					_setstack.setCount((int) (new Object() {
						public double getValue(IWorld world, BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(world, new BlockPos(0, 10, 0), ("market_num" + entity.getPersistentData().getDouble("Slot_number_hdv")))));
					((Slot) ((Map) invobj).get((int) ((entity.getPersistentData().getDouble("Slot_number_hdv"))))).putStack(_setstack);
					_current.detectAndSendChanges();
				}
			}
		}
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
		entity.getPersistentData().putBoolean("Wsa", (false));
	}
}
