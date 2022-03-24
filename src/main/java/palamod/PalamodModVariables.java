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
import net.minecraft.entity.player.ServerPlayerEntity;

import java.util.function.Supplier;

public class PalamodModVariables {
	public PalamodModVariables(PalamodModElements elements) {
		elements.addNetworkMessage(WorldSavedDataSyncMessage.class, WorldSavedDataSyncMessage::buffer, WorldSavedDataSyncMessage::new,
				WorldSavedDataSyncMessage::handler);
	}

	public static String crusher_mode = "";
	public static double crusher_num_var = 0;
	public static double crusher_num_var_seen = 0;
	public static double g_num = 0;
	public static double alchemy = 0;
	public static String lucky_name = "no";
	public static double cooltick_spike = 0;
	public static double Lucky_destroy = 0;

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
		public double market_price_0 = 0.0;
		public double market_price_1 = 0.0;
		public double market_price_2 = 0;
		public double market_price_3 = 0;
		public double market_price_4 = 0;
		public double market_price_5 = 0;
		public double market_price_6 = 0;
		public double market_price_7 = 0;
		public double market_price_8 = 0;
		public double market_price_9 = 0;
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

		public MapVariables() {
			super(DATA_NAME);
		}

		public MapVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
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
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
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
