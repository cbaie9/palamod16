
package palamod.fuel;

import palamod.block.Ostrya_woodFenceGateBlock;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

@Mod.EventBusSubscriber
public class OstryafencegatefuelFuel {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == Ostrya_woodFenceGateBlock.block.asItem())
			event.setBurnTime(400);
	}
}
