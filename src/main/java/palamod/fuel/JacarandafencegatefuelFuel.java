
package palamod.fuel;

import palamod.block.Jacaranda_FenceGateBlock;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

@Mod.EventBusSubscriber
public class JacarandafencegatefuelFuel {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == Jacaranda_FenceGateBlock.block.asItem())
			event.setBurnTime(400);
	}
}
