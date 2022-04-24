package palamod;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.IServerWorld;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;

import java.util.function.Supplier;

public class PalamodModVariables {
	public PalamodModVariables(PalamodModElements elements) {
		elements.addNetworkMessage(WorldSavedDataSyncMessage.class, WorldSavedDataSyncMessage::buffer, WorldSavedDataSyncMessage::new,
				WorldSavedDataSyncMessage::handler);
	}

	public static double alchemy = 0;
	public static double cooltick_spike = 0;
	public static String crusher_mode = "";
	public static double crusher_num_var = 0;
	public static double crusher_num_var_seen = 0;
	public static double g_num = 0;
	public static double Lucky_destroy = 0;
	public static String lucky_name = "no";
	public static String furnace_processing = "\"\"";

	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote()) {
			WorldSavedData mapdata = MapVariables.get(event.getPlayer().world);
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (mapdata != null)
				PalamodMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(0, mapdata));
			if (worlddata != null)
				PalamodMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote()) {
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (worlddata != null)
				PalamodMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}

	public static class WorldVariables extends WorldSavedData {
		public static final String DATA_NAME = "palamod_worldvars";

		public WorldVariables() {
			super(DATA_NAME);
		}

		public WorldVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (world instanceof World && !world.isRemote())
				PalamodMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(((World) world)::getDimensionKey),
						new WorldSavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(IWorld world) {
			if (world instanceof ServerWorld) {
				return ((ServerWorld) world).getSavedData().getOrCreate(WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends WorldSavedData {
		public static final String DATA_NAME = "palamod_mapvars";
		public String market_conf_name = "error:0notset";
		public double market_conf_num = 0.0;
		public double market_conf_price = 0.0;
		public ItemStack market_item0 = ItemStack.EMPTY;
		public ItemStack market_item1 = ItemStack.EMPTY;
		public ItemStack market_item10 = ItemStack.EMPTY;
		public ItemStack market_item11 = ItemStack.EMPTY;
		public ItemStack market_item12 = ItemStack.EMPTY;
		public ItemStack market_item13 = ItemStack.EMPTY;
		public ItemStack market_item14 = ItemStack.EMPTY;
		public ItemStack market_item15 = ItemStack.EMPTY;
		public ItemStack market_item16 = ItemStack.EMPTY;
		public ItemStack market_item17 = ItemStack.EMPTY;
		public ItemStack market_item18 = ItemStack.EMPTY;
		public ItemStack market_item19 = ItemStack.EMPTY;
		public ItemStack market_item2 = ItemStack.EMPTY;
		public ItemStack market_item20 = ItemStack.EMPTY;
		public ItemStack market_item21 = ItemStack.EMPTY;
		public ItemStack market_item22 = ItemStack.EMPTY;
		public ItemStack market_item23 = ItemStack.EMPTY;
		public ItemStack market_item24 = ItemStack.EMPTY;
		public ItemStack market_item25 = ItemStack.EMPTY;
		public ItemStack market_item26 = ItemStack.EMPTY;
		public ItemStack market_item27 = ItemStack.EMPTY;
		public ItemStack market_item28 = ItemStack.EMPTY;
		public ItemStack market_item29 = ItemStack.EMPTY;
		public ItemStack market_item3 = ItemStack.EMPTY;
		public ItemStack market_item30 = ItemStack.EMPTY;
		public ItemStack market_item31 = ItemStack.EMPTY;
		public ItemStack market_item32 = ItemStack.EMPTY;
		public ItemStack market_item33 = ItemStack.EMPTY;
		public ItemStack market_item34 = ItemStack.EMPTY;
		public ItemStack market_item35 = ItemStack.EMPTY;
		public ItemStack market_item36 = ItemStack.EMPTY;
		public ItemStack market_item37 = ItemStack.EMPTY;
		public ItemStack market_item38 = ItemStack.EMPTY;
		public ItemStack market_item39 = ItemStack.EMPTY;
		public ItemStack market_item4 = ItemStack.EMPTY;
		public ItemStack market_item40 = ItemStack.EMPTY;
		public ItemStack market_item41 = ItemStack.EMPTY;
		public ItemStack market_item42 = ItemStack.EMPTY;
		public ItemStack market_item43 = ItemStack.EMPTY;
		public ItemStack market_item44 = ItemStack.EMPTY;
		public ItemStack market_item45 = ItemStack.EMPTY;
		public ItemStack market_item46 = ItemStack.EMPTY;
		public ItemStack market_item47 = ItemStack.EMPTY;
		public ItemStack market_item48 = ItemStack.EMPTY;
		public ItemStack market_item49 = ItemStack.EMPTY;
		public ItemStack market_item5 = ItemStack.EMPTY;
		public ItemStack market_item50 = ItemStack.EMPTY;
		public ItemStack market_item51 = ItemStack.EMPTY;
		public ItemStack market_item52 = ItemStack.EMPTY;
		public ItemStack market_item53 = ItemStack.EMPTY;
		public ItemStack market_item54 = ItemStack.EMPTY;
		public ItemStack market_item55 = ItemStack.EMPTY;
		public ItemStack market_item56 = ItemStack.EMPTY;
		public ItemStack market_item57 = ItemStack.EMPTY;
		public ItemStack market_item58 = ItemStack.EMPTY;
		public ItemStack market_item59 = ItemStack.EMPTY;
		public ItemStack market_item6 = ItemStack.EMPTY;
		public ItemStack market_item60 = ItemStack.EMPTY;
		public ItemStack market_item61 = ItemStack.EMPTY;
		public ItemStack market_item62 = ItemStack.EMPTY;
		public ItemStack market_item63 = ItemStack.EMPTY;
		public ItemStack market_item64 = ItemStack.EMPTY;
		public ItemStack market_item65 = ItemStack.EMPTY;
		public ItemStack market_item66 = ItemStack.EMPTY;
		public ItemStack market_item67 = ItemStack.EMPTY;
		public ItemStack market_item68 = ItemStack.EMPTY;
		public ItemStack market_item69 = ItemStack.EMPTY;
		public ItemStack market_item7 = ItemStack.EMPTY;
		public ItemStack market_item70 = ItemStack.EMPTY;
		public ItemStack market_item8 = ItemStack.EMPTY;
		public ItemStack market_item9 = ItemStack.EMPTY;
		public String market_name_0 = "not attribued";
		public String market_name_1 = "not attribued";
		public String market_name_2 = "not attribued";
		public String market_name_3 = "not attribued";
		public String market_name_4 = "not attribued";
		public String market_name_5 = "not attribued";
		public String market_name_6 = "not attribued";
		public String market_name_7 = "not attribued";
		public String market_name_8 = "not attribued";
		public String market_name_9 = "not attribued";
		public double market_price_0 = 0.0;
		public double market_price_1 = 0.0;
		public double market_price_2 = 0;
		public double market_price_3 = 0;
		public double market_price_4 = 0;
		public double market_price_5 = 0;
		public double market_price_6 = 0;
		public double market_price_7 = 0;
		public double market_price_8 = 0;
		public double market_price_9 = 0.0;
		public ItemStack market_item71 = ItemStack.EMPTY;
		public ItemStack market_item72 = ItemStack.EMPTY;
		public ItemStack market_item73 = ItemStack.EMPTY;
		public ItemStack market_item74 = ItemStack.EMPTY;
		public ItemStack market_item75 = ItemStack.EMPTY;
		public ItemStack market_item76 = ItemStack.EMPTY;
		public ItemStack market_item77 = ItemStack.EMPTY;
		public ItemStack market_item78 = ItemStack.EMPTY;
		public ItemStack market_item79 = ItemStack.EMPTY;
		public ItemStack market_item80 = ItemStack.EMPTY;
		public ItemStack market_item81 = ItemStack.EMPTY;
		public ItemStack market_item82 = ItemStack.EMPTY;
		public ItemStack market_item83 = ItemStack.EMPTY;
		public ItemStack market_item84 = ItemStack.EMPTY;
		public ItemStack market_item85 = ItemStack.EMPTY;
		public ItemStack market_item86 = ItemStack.EMPTY;
		public ItemStack market_item87 = ItemStack.EMPTY;
		public ItemStack market_item88 = ItemStack.EMPTY;
		public ItemStack market_item89 = ItemStack.EMPTY;
		public ItemStack market_item90 = ItemStack.EMPTY;
		public ItemStack market_item91 = ItemStack.EMPTY;
		public ItemStack market_item92 = ItemStack.EMPTY;
		public ItemStack market_item93 = ItemStack.EMPTY;
		public ItemStack market_item94 = ItemStack.EMPTY;
		public ItemStack market_item95 = ItemStack.EMPTY;
		public ItemStack market_item96 = ItemStack.EMPTY;
		public ItemStack market_item97 = ItemStack.EMPTY;
		public ItemStack market_item98 = ItemStack.EMPTY;
		public ItemStack market_item99 = ItemStack.EMPTY;

		public MapVariables() {
			super(DATA_NAME);
		}

		public MapVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
			market_conf_name = nbt.getString("market_conf_name");
			market_conf_num = nbt.getDouble("market_conf_num");
			market_conf_price = nbt.getDouble("market_conf_price");
			market_item0 = ItemStack.read(nbt.getCompound("market_item0"));
			market_item1 = ItemStack.read(nbt.getCompound("market_item1"));
			market_item10 = ItemStack.read(nbt.getCompound("market_item10"));
			market_item11 = ItemStack.read(nbt.getCompound("market_item11"));
			market_item12 = ItemStack.read(nbt.getCompound("market_item12"));
			market_item13 = ItemStack.read(nbt.getCompound("market_item13"));
			market_item14 = ItemStack.read(nbt.getCompound("market_item14"));
			market_item15 = ItemStack.read(nbt.getCompound("market_item15"));
			market_item16 = ItemStack.read(nbt.getCompound("market_item16"));
			market_item17 = ItemStack.read(nbt.getCompound("market_item17"));
			market_item18 = ItemStack.read(nbt.getCompound("market_item18"));
			market_item19 = ItemStack.read(nbt.getCompound("market_item19"));
			market_item2 = ItemStack.read(nbt.getCompound("market_item2"));
			market_item20 = ItemStack.read(nbt.getCompound("market_item20"));
			market_item21 = ItemStack.read(nbt.getCompound("market_item21"));
			market_item22 = ItemStack.read(nbt.getCompound("market_item22"));
			market_item23 = ItemStack.read(nbt.getCompound("market_item23"));
			market_item24 = ItemStack.read(nbt.getCompound("market_item24"));
			market_item25 = ItemStack.read(nbt.getCompound("market_item25"));
			market_item26 = ItemStack.read(nbt.getCompound("market_item26"));
			market_item27 = ItemStack.read(nbt.getCompound("market_item27"));
			market_item28 = ItemStack.read(nbt.getCompound("market_item28"));
			market_item29 = ItemStack.read(nbt.getCompound("market_item29"));
			market_item3 = ItemStack.read(nbt.getCompound("market_item3"));
			market_item30 = ItemStack.read(nbt.getCompound("market_item30"));
			market_item31 = ItemStack.read(nbt.getCompound("market_item31"));
			market_item32 = ItemStack.read(nbt.getCompound("market_item32"));
			market_item33 = ItemStack.read(nbt.getCompound("market_item33"));
			market_item34 = ItemStack.read(nbt.getCompound("market_item34"));
			market_item35 = ItemStack.read(nbt.getCompound("market_item35"));
			market_item36 = ItemStack.read(nbt.getCompound("market_item36"));
			market_item37 = ItemStack.read(nbt.getCompound("market_item37"));
			market_item38 = ItemStack.read(nbt.getCompound("market_item38"));
			market_item39 = ItemStack.read(nbt.getCompound("market_item39"));
			market_item4 = ItemStack.read(nbt.getCompound("market_item4"));
			market_item40 = ItemStack.read(nbt.getCompound("market_item40"));
			market_item41 = ItemStack.read(nbt.getCompound("market_item41"));
			market_item42 = ItemStack.read(nbt.getCompound("market_item42"));
			market_item43 = ItemStack.read(nbt.getCompound("market_item43"));
			market_item44 = ItemStack.read(nbt.getCompound("market_item44"));
			market_item45 = ItemStack.read(nbt.getCompound("market_item45"));
			market_item46 = ItemStack.read(nbt.getCompound("market_item46"));
			market_item47 = ItemStack.read(nbt.getCompound("market_item47"));
			market_item48 = ItemStack.read(nbt.getCompound("market_item48"));
			market_item49 = ItemStack.read(nbt.getCompound("market_item49"));
			market_item5 = ItemStack.read(nbt.getCompound("market_item5"));
			market_item50 = ItemStack.read(nbt.getCompound("market_item50"));
			market_item51 = ItemStack.read(nbt.getCompound("market_item51"));
			market_item52 = ItemStack.read(nbt.getCompound("market_item52"));
			market_item53 = ItemStack.read(nbt.getCompound("market_item53"));
			market_item54 = ItemStack.read(nbt.getCompound("market_item54"));
			market_item55 = ItemStack.read(nbt.getCompound("market_item55"));
			market_item56 = ItemStack.read(nbt.getCompound("market_item56"));
			market_item57 = ItemStack.read(nbt.getCompound("market_item57"));
			market_item58 = ItemStack.read(nbt.getCompound("market_item58"));
			market_item59 = ItemStack.read(nbt.getCompound("market_item59"));
			market_item6 = ItemStack.read(nbt.getCompound("market_item6"));
			market_item60 = ItemStack.read(nbt.getCompound("market_item60"));
			market_item61 = ItemStack.read(nbt.getCompound("market_item61"));
			market_item62 = ItemStack.read(nbt.getCompound("market_item62"));
			market_item63 = ItemStack.read(nbt.getCompound("market_item63"));
			market_item64 = ItemStack.read(nbt.getCompound("market_item64"));
			market_item65 = ItemStack.read(nbt.getCompound("market_item65"));
			market_item66 = ItemStack.read(nbt.getCompound("market_item66"));
			market_item67 = ItemStack.read(nbt.getCompound("market_item67"));
			market_item68 = ItemStack.read(nbt.getCompound("market_item68"));
			market_item69 = ItemStack.read(nbt.getCompound("market_item69"));
			market_item7 = ItemStack.read(nbt.getCompound("market_item7"));
			market_item70 = ItemStack.read(nbt.getCompound("market_item70"));
			market_item8 = ItemStack.read(nbt.getCompound("market_item8"));
			market_item9 = ItemStack.read(nbt.getCompound("market_item9"));
			market_name_0 = nbt.getString("market_name_0");
			market_name_1 = nbt.getString("market_name_1");
			market_name_2 = nbt.getString("market_name_2");
			market_name_3 = nbt.getString("market_name_3");
			market_name_4 = nbt.getString("market_name_4");
			market_name_5 = nbt.getString("market_name_5");
			market_name_6 = nbt.getString("market_name_6");
			market_name_7 = nbt.getString("market_name_7");
			market_name_8 = nbt.getString("market_name_8");
			market_name_9 = nbt.getString("market_name_9");
			market_price_0 = nbt.getDouble("market_price_0");
			market_price_1 = nbt.getDouble("market_price_1");
			market_price_2 = nbt.getDouble("market_price_2");
			market_price_3 = nbt.getDouble("market_price_3");
			market_price_4 = nbt.getDouble("market_price_4");
			market_price_5 = nbt.getDouble("market_price_5");
			market_price_6 = nbt.getDouble("market_price_6");
			market_price_7 = nbt.getDouble("market_price_7");
			market_price_8 = nbt.getDouble("market_price_8");
			market_price_9 = nbt.getDouble("market_price_9");
			market_item71 = ItemStack.read(nbt.getCompound("market_item71"));
			market_item72 = ItemStack.read(nbt.getCompound("market_item72"));
			market_item73 = ItemStack.read(nbt.getCompound("market_item73"));
			market_item74 = ItemStack.read(nbt.getCompound("market_item74"));
			market_item75 = ItemStack.read(nbt.getCompound("market_item75"));
			market_item76 = ItemStack.read(nbt.getCompound("market_item76"));
			market_item77 = ItemStack.read(nbt.getCompound("market_item77"));
			market_item78 = ItemStack.read(nbt.getCompound("market_item78"));
			market_item79 = ItemStack.read(nbt.getCompound("market_item79"));
			market_item80 = ItemStack.read(nbt.getCompound("market_item80"));
			market_item81 = ItemStack.read(nbt.getCompound("market_item81"));
			market_item82 = ItemStack.read(nbt.getCompound("market_item82"));
			market_item83 = ItemStack.read(nbt.getCompound("market_item83"));
			market_item84 = ItemStack.read(nbt.getCompound("market_item84"));
			market_item85 = ItemStack.read(nbt.getCompound("market_item85"));
			market_item86 = ItemStack.read(nbt.getCompound("market_item86"));
			market_item87 = ItemStack.read(nbt.getCompound("market_item87"));
			market_item88 = ItemStack.read(nbt.getCompound("market_item88"));
			market_item89 = ItemStack.read(nbt.getCompound("market_item89"));
			market_item90 = ItemStack.read(nbt.getCompound("market_item90"));
			market_item91 = ItemStack.read(nbt.getCompound("market_item91"));
			market_item92 = ItemStack.read(nbt.getCompound("market_item92"));
			market_item93 = ItemStack.read(nbt.getCompound("market_item93"));
			market_item94 = ItemStack.read(nbt.getCompound("market_item94"));
			market_item95 = ItemStack.read(nbt.getCompound("market_item95"));
			market_item96 = ItemStack.read(nbt.getCompound("market_item96"));
			market_item97 = ItemStack.read(nbt.getCompound("market_item97"));
			market_item98 = ItemStack.read(nbt.getCompound("market_item98"));
			market_item99 = ItemStack.read(nbt.getCompound("market_item99"));
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			nbt.putString("market_conf_name", market_conf_name);
			nbt.putDouble("market_conf_num", market_conf_num);
			nbt.putDouble("market_conf_price", market_conf_price);
			nbt.put("market_item0", market_item0.write(new CompoundNBT()));
			nbt.put("market_item1", market_item1.write(new CompoundNBT()));
			nbt.put("market_item10", market_item10.write(new CompoundNBT()));
			nbt.put("market_item11", market_item11.write(new CompoundNBT()));
			nbt.put("market_item12", market_item12.write(new CompoundNBT()));
			nbt.put("market_item13", market_item13.write(new CompoundNBT()));
			nbt.put("market_item14", market_item14.write(new CompoundNBT()));
			nbt.put("market_item15", market_item15.write(new CompoundNBT()));
			nbt.put("market_item16", market_item16.write(new CompoundNBT()));
			nbt.put("market_item17", market_item17.write(new CompoundNBT()));
			nbt.put("market_item18", market_item18.write(new CompoundNBT()));
			nbt.put("market_item19", market_item19.write(new CompoundNBT()));
			nbt.put("market_item2", market_item2.write(new CompoundNBT()));
			nbt.put("market_item20", market_item20.write(new CompoundNBT()));
			nbt.put("market_item21", market_item21.write(new CompoundNBT()));
			nbt.put("market_item22", market_item22.write(new CompoundNBT()));
			nbt.put("market_item23", market_item23.write(new CompoundNBT()));
			nbt.put("market_item24", market_item24.write(new CompoundNBT()));
			nbt.put("market_item25", market_item25.write(new CompoundNBT()));
			nbt.put("market_item26", market_item26.write(new CompoundNBT()));
			nbt.put("market_item27", market_item27.write(new CompoundNBT()));
			nbt.put("market_item28", market_item28.write(new CompoundNBT()));
			nbt.put("market_item29", market_item29.write(new CompoundNBT()));
			nbt.put("market_item3", market_item3.write(new CompoundNBT()));
			nbt.put("market_item30", market_item30.write(new CompoundNBT()));
			nbt.put("market_item31", market_item31.write(new CompoundNBT()));
			nbt.put("market_item32", market_item32.write(new CompoundNBT()));
			nbt.put("market_item33", market_item33.write(new CompoundNBT()));
			nbt.put("market_item34", market_item34.write(new CompoundNBT()));
			nbt.put("market_item35", market_item35.write(new CompoundNBT()));
			nbt.put("market_item36", market_item36.write(new CompoundNBT()));
			nbt.put("market_item37", market_item37.write(new CompoundNBT()));
			nbt.put("market_item38", market_item38.write(new CompoundNBT()));
			nbt.put("market_item39", market_item39.write(new CompoundNBT()));
			nbt.put("market_item4", market_item4.write(new CompoundNBT()));
			nbt.put("market_item40", market_item40.write(new CompoundNBT()));
			nbt.put("market_item41", market_item41.write(new CompoundNBT()));
			nbt.put("market_item42", market_item42.write(new CompoundNBT()));
			nbt.put("market_item43", market_item43.write(new CompoundNBT()));
			nbt.put("market_item44", market_item44.write(new CompoundNBT()));
			nbt.put("market_item45", market_item45.write(new CompoundNBT()));
			nbt.put("market_item46", market_item46.write(new CompoundNBT()));
			nbt.put("market_item47", market_item47.write(new CompoundNBT()));
			nbt.put("market_item48", market_item48.write(new CompoundNBT()));
			nbt.put("market_item49", market_item49.write(new CompoundNBT()));
			nbt.put("market_item5", market_item5.write(new CompoundNBT()));
			nbt.put("market_item50", market_item50.write(new CompoundNBT()));
			nbt.put("market_item51", market_item51.write(new CompoundNBT()));
			nbt.put("market_item52", market_item52.write(new CompoundNBT()));
			nbt.put("market_item53", market_item53.write(new CompoundNBT()));
			nbt.put("market_item54", market_item54.write(new CompoundNBT()));
			nbt.put("market_item55", market_item55.write(new CompoundNBT()));
			nbt.put("market_item56", market_item56.write(new CompoundNBT()));
			nbt.put("market_item57", market_item57.write(new CompoundNBT()));
			nbt.put("market_item58", market_item58.write(new CompoundNBT()));
			nbt.put("market_item59", market_item59.write(new CompoundNBT()));
			nbt.put("market_item6", market_item6.write(new CompoundNBT()));
			nbt.put("market_item60", market_item60.write(new CompoundNBT()));
			nbt.put("market_item61", market_item61.write(new CompoundNBT()));
			nbt.put("market_item62", market_item62.write(new CompoundNBT()));
			nbt.put("market_item63", market_item63.write(new CompoundNBT()));
			nbt.put("market_item64", market_item64.write(new CompoundNBT()));
			nbt.put("market_item65", market_item65.write(new CompoundNBT()));
			nbt.put("market_item66", market_item66.write(new CompoundNBT()));
			nbt.put("market_item67", market_item67.write(new CompoundNBT()));
			nbt.put("market_item68", market_item68.write(new CompoundNBT()));
			nbt.put("market_item69", market_item69.write(new CompoundNBT()));
			nbt.put("market_item7", market_item7.write(new CompoundNBT()));
			nbt.put("market_item70", market_item70.write(new CompoundNBT()));
			nbt.put("market_item8", market_item8.write(new CompoundNBT()));
			nbt.put("market_item9", market_item9.write(new CompoundNBT()));
			nbt.putString("market_name_0", market_name_0);
			nbt.putString("market_name_1", market_name_1);
			nbt.putString("market_name_2", market_name_2);
			nbt.putString("market_name_3", market_name_3);
			nbt.putString("market_name_4", market_name_4);
			nbt.putString("market_name_5", market_name_5);
			nbt.putString("market_name_6", market_name_6);
			nbt.putString("market_name_7", market_name_7);
			nbt.putString("market_name_8", market_name_8);
			nbt.putString("market_name_9", market_name_9);
			nbt.putDouble("market_price_0", market_price_0);
			nbt.putDouble("market_price_1", market_price_1);
			nbt.putDouble("market_price_2", market_price_2);
			nbt.putDouble("market_price_3", market_price_3);
			nbt.putDouble("market_price_4", market_price_4);
			nbt.putDouble("market_price_5", market_price_5);
			nbt.putDouble("market_price_6", market_price_6);
			nbt.putDouble("market_price_7", market_price_7);
			nbt.putDouble("market_price_8", market_price_8);
			nbt.putDouble("market_price_9", market_price_9);
			nbt.put("market_item71", market_item71.write(new CompoundNBT()));
			nbt.put("market_item72", market_item72.write(new CompoundNBT()));
			nbt.put("market_item73", market_item73.write(new CompoundNBT()));
			nbt.put("market_item74", market_item74.write(new CompoundNBT()));
			nbt.put("market_item75", market_item75.write(new CompoundNBT()));
			nbt.put("market_item76", market_item76.write(new CompoundNBT()));
			nbt.put("market_item77", market_item77.write(new CompoundNBT()));
			nbt.put("market_item78", market_item78.write(new CompoundNBT()));
			nbt.put("market_item79", market_item79.write(new CompoundNBT()));
			nbt.put("market_item80", market_item80.write(new CompoundNBT()));
			nbt.put("market_item81", market_item81.write(new CompoundNBT()));
			nbt.put("market_item82", market_item82.write(new CompoundNBT()));
			nbt.put("market_item83", market_item83.write(new CompoundNBT()));
			nbt.put("market_item84", market_item84.write(new CompoundNBT()));
			nbt.put("market_item85", market_item85.write(new CompoundNBT()));
			nbt.put("market_item86", market_item86.write(new CompoundNBT()));
			nbt.put("market_item87", market_item87.write(new CompoundNBT()));
			nbt.put("market_item88", market_item88.write(new CompoundNBT()));
			nbt.put("market_item89", market_item89.write(new CompoundNBT()));
			nbt.put("market_item90", market_item90.write(new CompoundNBT()));
			nbt.put("market_item91", market_item91.write(new CompoundNBT()));
			nbt.put("market_item92", market_item92.write(new CompoundNBT()));
			nbt.put("market_item93", market_item93.write(new CompoundNBT()));
			nbt.put("market_item94", market_item94.write(new CompoundNBT()));
			nbt.put("market_item95", market_item95.write(new CompoundNBT()));
			nbt.put("market_item96", market_item96.write(new CompoundNBT()));
			nbt.put("market_item97", market_item97.write(new CompoundNBT()));
			nbt.put("market_item98", market_item98.write(new CompoundNBT()));
			nbt.put("market_item99", market_item99.write(new CompoundNBT()));
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (world instanceof World && !world.isRemote())
				PalamodMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new WorldSavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(IWorld world) {
			if (world instanceof IServerWorld) {
				return ((IServerWorld) world).getWorld().getServer().getWorld(World.OVERWORLD).getSavedData().getOrCreate(MapVariables::new,
						DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class WorldSavedDataSyncMessage {
		public int type;
		public WorldSavedData data;

		public WorldSavedDataSyncMessage(PacketBuffer buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			this.data.read(buffer.readCompoundTag());
		}

		public WorldSavedDataSyncMessage(int type, WorldSavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(WorldSavedDataSyncMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.type);
			buffer.writeCompoundTag(message.data.write(new CompoundNBT()));
		}

		public static void handler(WorldSavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
