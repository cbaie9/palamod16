
package palamod.fuel;

import palamod.block.Jacaranda_LeavesBlock;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

@Mod.EventBusSubscriber
public class JacarandaleavefuelFuel {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == Jacaranda_LeavesBlock.block.asItem())
			event.setBurnTime(60);
	}
}
