package palamod.procedures;

import palamod.item.MinagevoidstoneItem;

import palamod.gui.VoidstoneminerconfigGui;

import palamod.PalamodMod;

import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.block.Blocks;

import java.util.Map;

import io.netty.buffer.Unpooled;

public class MvprocessProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PalamodMod.LOGGER.warn("Failed to load dependency world for procedure Mvprocess!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PalamodMod.LOGGER.warn("Failed to load dependency x for procedure Mvprocess!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PalamodMod.LOGGER.warn("Failed to load dependency y for procedure Mvprocess!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PalamodMod.LOGGER.warn("Failed to load dependency z for procedure Mvprocess!");
			return;
		}
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
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (Screen.hasShiftDown()) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).closeScreen();
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
						@Override
						public ITextComponent getDisplayName() {
							return new StringTextComponent("Voidstoneminerconfig");
						}

						@Override
						public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
							return new VoidstoneminerconfigGui.GuiContainerMod(id, inventory,
									new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		} else {
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
						|| ((entity instanceof PlayerEntity)
								? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Blocks.COBBLESTONE))
								: false)
						|| ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Blocks.GRANITE)) : false)
						|| ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Blocks.DIORITE)) : false)
						|| ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Blocks.ANDESITE)) : false)
						|| ((entity instanceof PlayerEntity)
								? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Blocks.BLACKSTONE))
								: false)
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
}
