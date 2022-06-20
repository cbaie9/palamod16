package palamod.procedures;

import palamod.item.MinagevoidstoneItem;

import palamod.PalamodMod;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Map;

public class MvprocessProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PalamodMod.LOGGER.warn("Failed to load dependency entity for procedure Mvprocess!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				PalamodMod.LOGGER.warn("Failed to load dependency itemstack for procedure Mvprocess!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		for (int index0 = 0; index0 < (int) (1000); index0++) {
			if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Blocks.STONE)) : false)
					&& ((entity instanceof PlayerEntity)
							? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(MinagevoidstoneItem.block))
							: false)) {
				itemstack.getOrCreateTag().putDouble("voidstone_count", (itemstack.getOrCreateTag().getDouble("voidstone_count") + 1));
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Blocks.STONE);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			}
			if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Blocks.COBBLESTONE)) : false)
					&& ((entity instanceof PlayerEntity)
							? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(MinagevoidstoneItem.block))
							: false)) {
				itemstack.getOrCreateTag().putDouble("voidstone_count", (itemstack.getOrCreateTag().getDouble("voidstone_count") + 1));
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Blocks.COBBLESTONE);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			}
			if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Blocks.GRANITE)) : false)
					&& ((entity instanceof PlayerEntity)
							? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(MinagevoidstoneItem.block))
							: false)) {
				itemstack.getOrCreateTag().putDouble("voidstone_count", (itemstack.getOrCreateTag().getDouble("voidstone_count") + 1));
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Blocks.GRANITE);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			}
			if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Blocks.DIORITE)) : false)
					&& ((entity instanceof PlayerEntity)
							? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(MinagevoidstoneItem.block))
							: false)) {
				itemstack.getOrCreateTag().putDouble("voidstone_count", (itemstack.getOrCreateTag().getDouble("voidstone_count") + 1));
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Blocks.DIORITE);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			}
			if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Blocks.ANDESITE)) : false)
					&& ((entity instanceof PlayerEntity)
							? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(MinagevoidstoneItem.block))
							: false)) {
				itemstack.getOrCreateTag().putDouble("voidstone_count", (itemstack.getOrCreateTag().getDouble("voidstone_count") + 1));
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Blocks.ANDESITE);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			}
			if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Blocks.BLACKSTONE)) : false)
					&& ((entity instanceof PlayerEntity)
							? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(MinagevoidstoneItem.block))
							: false)) {
				itemstack.getOrCreateTag().putDouble("voidstone_count", (itemstack.getOrCreateTag().getDouble("voidstone_count") + 1));
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Blocks.BLACKSTONE);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			}
			if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Blocks.BASALT)) : false)
					&& ((entity instanceof PlayerEntity)
							? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(MinagevoidstoneItem.block))
							: false)) {
				itemstack.getOrCreateTag().putDouble("voidstone_count", (itemstack.getOrCreateTag().getDouble("voidstone_count") + 1));
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Blocks.BASALT);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			}
			if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Blocks.NETHERRACK)) : false)
					&& ((entity instanceof PlayerEntity)
							? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(MinagevoidstoneItem.block))
							: false)) {
				itemstack.getOrCreateTag().putDouble("voidstone_count", (itemstack.getOrCreateTag().getDouble("voidstone_count") + 1));
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Blocks.NETHERRACK);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			}
			if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Blocks.STONE)) : false)
					|| ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Blocks.COBBLESTONE)) : false)
					|| ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Blocks.GRANITE)) : false)
					|| ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Blocks.DIORITE)) : false)
					|| ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Blocks.ANDESITE)) : false)
					|| ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Blocks.BLACKSTONE)) : false)
					|| ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Blocks.BASALT)) : false)
					|| ((entity instanceof PlayerEntity)
							? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Blocks.NETHERRACK))
							: false)) {
				continue;
			} else {
				break;
			}
		}
		(itemstack).setDisplayName(new StringTextComponent(("Voidstone miner -" + itemstack.getOrCreateTag().getDouble("voidstone_count"))));
	}
}
