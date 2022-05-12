package palamod.procedures;

import palamod.block.Erable_LogBlock;
import palamod.block.Erable_LeavesBlock;

import palamod.PalamodMod;

import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import java.util.Map;

public class ErablesapplinggrowProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PalamodMod.LOGGER.warn("Failed to load dependency world for procedure Erablesapplinggrow!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PalamodMod.LOGGER.warn("Failed to load dependency x for procedure Erablesapplinggrow!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PalamodMod.LOGGER.warn("Failed to load dependency y for procedure Erablesapplinggrow!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PalamodMod.LOGGER.warn("Failed to load dependency z for procedure Erablesapplinggrow!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PalamodMod.LOGGER.warn("Failed to load dependency entity for procedure Erablesapplinggrow!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		boolean bone_meal = false;
		if (new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayerEntity) {
					return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
				} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
					NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
							.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
					return _npi != null && _npi.getGameType() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity)) {
			bone_meal = (true);
		} else {
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == Items.BONE_MEAL
					&& Math.random() < 0.5) {
				if ((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(new BlockPos(x, y + 3, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(new BlockPos(x, y + 4, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(new BlockPos(x, y + 5, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(new BlockPos(x, y + 6, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(new BlockPos(x + 1, y + 4, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(new BlockPos(x + 1, y + 5, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(new BlockPos(x - 1, y + 4, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(new BlockPos(x - 1, y + 5, z))).getBlock() == Blocks.AIR
						|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.CAVE_AIR
								&& (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == Blocks.CAVE_AIR
								&& (world.getBlockState(new BlockPos(x, y + 3, z))).getBlock() == Blocks.CAVE_AIR
								&& (world.getBlockState(new BlockPos(x, y + 4, z))).getBlock() == Blocks.CAVE_AIR
								&& (world.getBlockState(new BlockPos(x, y + 5, z))).getBlock() == Blocks.CAVE_AIR
								&& (world.getBlockState(new BlockPos(x, y + 6, z))).getBlock() == Blocks.CAVE_AIR
								&& (world.getBlockState(new BlockPos(x + 1, y + 4, z))).getBlock() == Blocks.CAVE_AIR
								&& (world.getBlockState(new BlockPos(x + 1, y + 5, z))).getBlock() == Blocks.CAVE_AIR
								&& (world.getBlockState(new BlockPos(x - 1, y + 4, z))).getBlock() == Blocks.CAVE_AIR
								&& (world.getBlockState(new BlockPos(x - 1, y + 5, z))).getBlock() == Blocks.CAVE_AIR) {
					world.addParticle(ParticleTypes.SPIT, x, y, z, 0, 1, 0);
					{
						BlockPos _bp = new BlockPos(x, y, z);
						BlockState _bs = Erable_LogBlock.block.getDefaultState();
						world.setBlockState(_bp, _bs, 3);
					}
					world.setBlockState(new BlockPos(x, y + 1, z), Erable_LogBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x, y + 2, z), Erable_LogBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x, y + 3, z), Erable_LogBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x, y + 4, z), Erable_LogBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x, y + 5, z), Erable_LogBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x, y + 6, z), Erable_LogBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x, y + 7, z), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x - 1, y + 3, z + 0), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x + 1, y + 3, z + 0), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x + 0, y + 3, z + 1), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x + 0, y + 3, z - 1), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x - 1, y + 3, z - 1), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x + 1, y + 3, z + 1), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x + 0, y + 3, z + 2), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x + 0, y + 3, z + 2), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x + 0, y + 3, z - 2), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x + 1, y + 3, z - 2), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x - 1, y + 3, z - 2), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x - 2, y + 3, z - 2), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x + 2, y + 3, z - 2), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x + 2, y + 3, z + 2), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x - 2, y + 3, z + 2), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x - 1, y + 3, z + 2), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x + 1, y + 3, z + 2), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x + 2, y + 3, z + 1), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x + 2, y + 3, z - 1), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x + 2, y + 3, z - 1), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x - 2, y + 3, z - 1), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x - 2, y + 3, z - 0), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x + 2, y + 3, z - 0), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x + 0, y + 3, z - 2), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x + 0, y + 3, z + 2), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x - 1, y + 3, z + 1), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x - 2, y + 3, z + 1), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x + 0, y + 4, z - 1), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x + 0, y + 4, z + 1), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x + 1, y + 4, z + 1), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x - 1, y + 4, z + 1), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x + 1, y + 4, z - 1), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x - 1, y + 4, z - 1), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x - 1, y + 4, z - 1), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x - 1, y + 4, z - 1), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x - 1, y + 4, z + 0), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x + 1, y + 4, z + 0), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x + 1, y + 5, z + 0), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x - 1, y + 5, z + 0), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x - 0, y + 5, z + 1), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x - 0, y + 5, z - 1), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x + 1, y + 6, z + 0), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x - 1, y + 6, z + 0), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x - 0, y + 6, z + 1), Erable_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos(x - 0, y + 6, z - 1), Erable_LeavesBlock.block.getDefaultState(), 3);
				}
			}
		}
	}
}
