package palamod.procedures;

import palamod.gui.GrinderguiGui;

import palamod.block.GrinderframeBlock;
import palamod.block.GrindercasingBlock;

import palamod.PalamodMod;

import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.PacketBuffer;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import io.netty.buffer.Unpooled;

public class GrinderopenProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PalamodMod.LOGGER.warn("Failed to load dependency world for procedure Grinderopen!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PalamodMod.LOGGER.warn("Failed to load dependency x for procedure Grinderopen!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PalamodMod.LOGGER.warn("Failed to load dependency y for procedure Grinderopen!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PalamodMod.LOGGER.warn("Failed to load dependency z for procedure Grinderopen!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PalamodMod.LOGGER.warn("Failed to load dependency entity for procedure Grinderopen!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x + 1, y - 1, z))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x - 1, y - 1, z))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x - 1, y + 1, z))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x + 1, y + 1, z))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x, y - 1, z - 1))).getBlock() == GrindercasingBlock.block
				&& (world.getBlockState(new BlockPos(x + 1, y - 1, z - 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x - 1, y - 1, z - 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x - 1, y, z - 1))).getBlock() == GrindercasingBlock.block
				&& (world.getBlockState(new BlockPos(x + 1, y, z - 1))).getBlock() == GrindercasingBlock.block
				&& (world.getBlockState(new BlockPos(x - 1, y + 1, z - 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x + 1, y + 1, z - 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x, y + 1, z - 1))).getBlock() == GrindercasingBlock.block
				&& (world.getBlockState(new BlockPos(x, y - 1, z - 2))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x + 1, y - 1, z - 2))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x - 1, y - 1, z - 2))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x - 1, y, z - 2))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x, y, z - 2))).getBlock() == GrindercasingBlock.block
				&& (world.getBlockState(new BlockPos(x + 1, y, z - 2))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x - 1, y + 1, z - 2))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x + 1, y + 1, z - 2))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x, y + 1, z - 2))).getBlock() == GrinderframeBlock.block) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).closeScreen();
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
						@Override
						public ITextComponent getDisplayName() {
							return new StringTextComponent("Grindergui");
						}

						@Override
						public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
							return new GrinderguiGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		} else if ((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x + 1, y - 1, z))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x - 1, y - 1, z))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x - 1, y + 1, z))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x + 1, y + 1, z))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x, y - 1, z + 1))).getBlock() == GrindercasingBlock.block
				&& (world.getBlockState(new BlockPos(x + 1, y - 1, z + 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x - 1, y - 1, z + 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x - 1, y, z + 1))).getBlock() == GrindercasingBlock.block
				&& (world.getBlockState(new BlockPos(x + 1, y, z + 1))).getBlock() == GrindercasingBlock.block
				&& (world.getBlockState(new BlockPos(x - 1, y + 1, z + 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x + 1, y + 1, z + 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x, y + 1, z + 1))).getBlock() == GrindercasingBlock.block
				&& (world.getBlockState(new BlockPos(x, y - 1, z + 2))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x + 1, y - 1, z + 2))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x - 1, y - 1, z + 2))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x - 1, y, z + 2))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x, y, z + 2))).getBlock() == GrindercasingBlock.block
				&& (world.getBlockState(new BlockPos(x + 1, y, z + 2))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x - 1, y + 1, z + 2))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x + 1, y + 1, z + 2))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x, y + 1, z + 2))).getBlock() == GrinderframeBlock.block) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).closeScreen();
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
						@Override
						public ITextComponent getDisplayName() {
							return new StringTextComponent("Grindergui");
						}

						@Override
						public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
							return new GrinderguiGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		} else if ((world.getBlockState(new BlockPos(x + 2, y - 1, z))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x + 2, y - 1, z + 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x + 2, y - 1, z - 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x + 2, y, z + 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x + 2, y, z))).getBlock() == GrindercasingBlock.block
				&& (world.getBlockState(new BlockPos(x + 2, y, z - 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x + 2, y + 1, z + 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x + 2, y + 1, z))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x + 2, y + 1, z + 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x, y - 1, z + 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x, y - 1, z - 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x, y + 1, z + 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x, y + 1, z + 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x + 1, y - 1, z))).getBlock() == GrindercasingBlock.block
				&& (world.getBlockState(new BlockPos(x + 1, y - 1, z + 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x + 1, y - 1, z - 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x + 1, y, z + 1))).getBlock() == GrindercasingBlock.block
				&& (world.getBlockState(new BlockPos(x + 1, y, z - 1))).getBlock() == GrindercasingBlock.block
				&& (world.getBlockState(new BlockPos(x + 1, y + 1, z + 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x + 1, y + 1, z))).getBlock() == GrindercasingBlock.block
				&& (world.getBlockState(new BlockPos(x + 1, y + 1, z + 1))).getBlock() == GrinderframeBlock.block) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).closeScreen();
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
						@Override
						public ITextComponent getDisplayName() {
							return new StringTextComponent("Grindergui");
						}

						@Override
						public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
							return new GrinderguiGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		} else if ((world.getBlockState(new BlockPos(x - 2, y - 1, z))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x - 2, y - 1, z + 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x - 2, y - 1, z - 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x - 2, y, z + 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x - 2, y, z))).getBlock() == GrindercasingBlock.block
				&& (world.getBlockState(new BlockPos(x - 2, y, z - 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x - 2, y + 1, z + 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x - 2, y + 1, z))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x - 2, y + 1, z + 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x, y - 1, z + 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x, y - 1, z - 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x, y + 1, z + 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x, y + 1, z + 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x - 1, y - 1, z))).getBlock() == GrindercasingBlock.block
				&& (world.getBlockState(new BlockPos(x - 1, y - 1, z + 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x - 1, y - 1, z - 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x - 1, y, z + 1))).getBlock() == GrindercasingBlock.block
				&& (world.getBlockState(new BlockPos(x - 1, y, z - 1))).getBlock() == GrindercasingBlock.block
				&& (world.getBlockState(new BlockPos(x - 1, y + 1, z + 1))).getBlock() == GrinderframeBlock.block
				&& (world.getBlockState(new BlockPos(x - 1, y + 1, z))).getBlock() == GrindercasingBlock.block
				&& (world.getBlockState(new BlockPos(x - 1, y + 1, z + 1))).getBlock() == GrinderframeBlock.block) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).closeScreen();
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
						@Override
						public ITextComponent getDisplayName() {
							return new StringTextComponent("Grindergui");
						}

						@Override
						public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
							return new GrinderguiGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("1"), (false));
			}
		}
	}
}
