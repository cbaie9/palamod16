package palamod.procedures;

import palamod.item.TitaneIngotItem;
import palamod.item.PaladiumIngotItem;
import palamod.item.AmethysteItem;

import palamod.PalamodMod;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class Legendarystonefortune_processProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PalamodMod.LOGGER.warn("Failed to load dependency entity for procedure Legendarystonefortune_process!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				PalamodMod.LOGGER.warn("Failed to load dependency itemstack for procedure Legendarystonefortune_process!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		ItemStack item = ItemStack.EMPTY;
		double number = 0;
		if (Math.random() < 0.1) {
			item = new ItemStack(PaladiumIngotItem.block);
		} else if (Math.random() < 0.15) {
			item = new ItemStack(TitaneIngotItem.block);
		} else if (Math.random() < 0.25) {
			item = new ItemStack(AmethysteItem.block);
		} else if (Math.random() < 0.5) {
			item = new ItemStack(Items.DIAMOND);
		} else {
			item = new ItemStack(Items.GOLD_INGOT);
		}
		number = (Math.floor(Math.random()) * 10);
		if (Math.random() < 0.15) {
			number = (number * 10);
		}
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = (item);
			_setstack.setCount((int) number);
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 1728000);
	}
}
