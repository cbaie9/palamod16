
package palamod.fuel;

import palamod.block.Judeecercis_FenceGateBlock;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

@Mod.EventBusSubscriber
public class JudeecercisfencegatefuelFuel {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == Judeecercis_FenceGateBlock.block.asItem())
			event.setBurnTime(400);
	}
}
