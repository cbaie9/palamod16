package palamod.procedures;

import palamod.item.MinagevoidstoneItem;

import palamod.PalamodMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Map;
import java.util.HashMap;

public class MvprocesspickaxeverProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onBlockBreak(BlockEvent.BreakEvent event) {
			Entity entity = event.getPlayer();
			IWorld world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("xpAmount", event.getExpToDrop());
			dependencies.put("x", event.getPos().getX());
			dependencies.put("y", event.getPos().getY());
			dependencies.put("z", event.getPos().getZ());
			dependencies.put("px", entity.getPosX());
			dependencies.put("py", entity.getPosY());
			dependencies.put("pz", entity.getPosZ());
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("blockstate", event.getState());
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PalamodMod.LOGGER.warn("Failed to load dependency entity for procedure Mvprocesspickaxever!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		for (int index0 = 0; index0 < (int) (1000); index0++) {
			if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Blocks.STONE)) : false)
					&& ((entity instanceof PlayerEntity)
							? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(MinagevoidstoneItem.block))
							: false)) {
				entity.getPersistentData().putDouble("voidstone_count", (entity.getPersistentData().getDouble("voidstone_count") + 1));
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
				entity.getPersistentData().putDouble("voidstone_count", (entity.getPersistentData().getDouble("voidstone_count") + 1));
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
				entity.getPersistentData().putDouble("voidstone_count", (entity.getPersistentData().getDouble("voidstone_count") + 1));
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
				entity.getPersistentData().putDouble("voidstone_count", (entity.getPersistentData().getDouble("voidstone_count") + 1));
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
				entity.getPersistentData().putDouble("voidstone_count", (entity.getPersistentData().getDouble("voidstone_count") + 1));
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
				entity.getPersistentData().putDouble("voidstone_count", (entity.getPersistentData().getDouble("voidstone_count") + 1));
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
				entity.getPersistentData().putDouble("voidstone_count", (entity.getPersistentData().getDouble("voidstone_count") + 1));
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
				entity.getPersistentData().putDouble("voidstone_count", (entity.getPersistentData().getDouble("voidstone_count") + 1));
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
	}
}
