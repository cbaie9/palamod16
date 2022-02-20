package palamod.procedures;

import palamod.block.Judeecercis_LogBlock;
import palamod.block.Judeecercis_LeavesBlock;

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

public class JudeecercissapplinggrowProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PalamodMod.LOGGER.warn("Failed to load dependency world for procedure Judeecercissapplinggrow!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PalamodMod.LOGGER.warn("Failed to load dependency x for procedure Judeecercissapplinggrow!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PalamodMod.LOGGER.warn("Failed to load dependency y for procedure Judeecercissapplinggrow!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PalamodMod.LOGGER.warn("Failed to load dependency z for procedure Judeecercissapplinggrow!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PalamodMod.LOGGER.warn("Failed to load dependency entity for procedure Judeecercissapplinggrow!");
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
				if ((world.getBlockState(new BlockPos((int) x, (int) (Math.floor(y) + 1), (int) z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(new BlockPos((int) x, (int) (Math.floor(y) + 2), (int) z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(new BlockPos((int) x, (int) (Math.floor(y) + 3), (int) z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(new BlockPos((int) x, (int) (Math.floor(y) + 4), (int) z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(new BlockPos((int) x, (int) (Math.floor(y) + 5), (int) z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(new BlockPos((int) x, (int) (Math.floor(y) + 6), (int) z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (Math.floor(y) + 4), (int) z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (Math.floor(y) + 5), (int) z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (Math.floor(y) + 4), (int) z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (Math.floor(y) + 5), (int) z))).getBlock() == Blocks.AIR
						|| (world.getBlockState(new BlockPos((int) x, (int) (Math.floor(y) + 1), (int) z))).getBlock() == Blocks.CAVE_AIR
								&& (world.getBlockState(new BlockPos((int) x, (int) (Math.floor(y) + 2), (int) z))).getBlock() == Blocks.CAVE_AIR
								&& (world.getBlockState(new BlockPos((int) x, (int) (Math.floor(y) + 3), (int) z))).getBlock() == Blocks.CAVE_AIR
								&& (world.getBlockState(new BlockPos((int) x, (int) (Math.floor(y) + 4), (int) z))).getBlock() == Blocks.CAVE_AIR
								&& (world.getBlockState(new BlockPos((int) x, (int) (Math.floor(y) + 5), (int) z))).getBlock() == Blocks.CAVE_AIR
								&& (world.getBlockState(new BlockPos((int) x, (int) (Math.floor(y) + 6), (int) z))).getBlock() == Blocks.CAVE_AIR
								&& (world.getBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (Math.floor(y) + 4), (int) z)))
										.getBlock() == Blocks.CAVE_AIR
								&& (world.getBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (Math.floor(y) + 5), (int) z)))
										.getBlock() == Blocks.CAVE_AIR
								&& (world.getBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (Math.floor(y) + 4), (int) z)))
										.getBlock() == Blocks.CAVE_AIR
								&& (world.getBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (Math.floor(y) + 5), (int) z)))
										.getBlock() == Blocks.CAVE_AIR) {
					world.addParticle(ParticleTypes.SPIT, x, y, z, 0, 1, 0);
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = Judeecercis_LogBlock.block.getDefaultState();
						world.setBlockState(_bp, _bs, 3);
					}
					world.setBlockState(new BlockPos((int) x, (int) (Math.floor(y) + 1), (int) z), Judeecercis_LogBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) (Math.floor(y) + 2), (int) z), Judeecercis_LogBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) (Math.floor(y) + 3), (int) z), Judeecercis_LogBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) (Math.floor(y) + 4), (int) z), Judeecercis_LogBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) (Math.floor(y) + 5), (int) z), Judeecercis_LogBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) (Math.floor(y) + 6), (int) z), Judeecercis_LogBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) (Math.floor(y) + 7), (int) z), Judeecercis_LeavesBlock.block.getDefaultState(),
							3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (Math.floor(y) + 3), (int) (Math.floor(z) + 0)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (Math.floor(y) + 3), (int) (Math.floor(z) + 0)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) + 0), (int) (Math.floor(y) + 3), (int) (Math.floor(z) + 1)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) + 0), (int) (Math.floor(y) + 3), (int) (Math.floor(z) - 1)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (Math.floor(y) + 3), (int) (Math.floor(z) - 1)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (Math.floor(y) + 3), (int) (Math.floor(z) + 1)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) + 0), (int) (Math.floor(y) + 3), (int) (Math.floor(z) + 2)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) + 0), (int) (Math.floor(y) + 3), (int) (Math.floor(z) + 2)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) + 0), (int) (Math.floor(y) + 3), (int) (Math.floor(z) - 2)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (Math.floor(y) + 3), (int) (Math.floor(z) - 2)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (Math.floor(y) + 3), (int) (Math.floor(z) - 2)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) - 2), (int) (Math.floor(y) + 3), (int) (Math.floor(z) - 2)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) + 2), (int) (Math.floor(y) + 3), (int) (Math.floor(z) - 2)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) + 2), (int) (Math.floor(y) + 3), (int) (Math.floor(z) + 2)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) - 2), (int) (Math.floor(y) + 3), (int) (Math.floor(z) + 2)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (Math.floor(y) + 3), (int) (Math.floor(z) + 2)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (Math.floor(y) + 3), (int) (Math.floor(z) + 2)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) + 2), (int) (Math.floor(y) + 3), (int) (Math.floor(z) + 1)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) + 2), (int) (Math.floor(y) + 3), (int) (Math.floor(z) - 1)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) + 2), (int) (Math.floor(y) + 3), (int) (Math.floor(z) - 1)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) - 2), (int) (Math.floor(y) + 3), (int) (Math.floor(z) - 1)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) - 2), (int) (Math.floor(y) + 3), (int) (Math.floor(z) - 0)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) + 2), (int) (Math.floor(y) + 3), (int) (Math.floor(z) - 0)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) + 0), (int) (Math.floor(y) + 3), (int) (Math.floor(z) - 2)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) + 0), (int) (Math.floor(y) + 3), (int) (Math.floor(z) + 2)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (Math.floor(y) + 3), (int) (Math.floor(z) + 1)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) - 2), (int) (Math.floor(y) + 3), (int) (Math.floor(z) + 1)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) + 0), (int) (Math.floor(y) + 4), (int) (Math.floor(z) - 1)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) + 0), (int) (Math.floor(y) + 4), (int) (Math.floor(z) + 1)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (Math.floor(y) + 4), (int) (Math.floor(z) + 1)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (Math.floor(y) + 4), (int) (Math.floor(z) + 1)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (Math.floor(y) + 4), (int) (Math.floor(z) - 1)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (Math.floor(y) + 4), (int) (Math.floor(z) - 1)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (Math.floor(y) + 4), (int) (Math.floor(z) - 1)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (Math.floor(y) + 4), (int) (Math.floor(z) - 1)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (Math.floor(y) + 4), (int) (Math.floor(z) + 0)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (Math.floor(y) + 4), (int) (Math.floor(z) + 0)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (Math.floor(y) + 5), (int) (Math.floor(z) + 0)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (Math.floor(y) + 5), (int) (Math.floor(z) + 0)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) - 0), (int) (Math.floor(y) + 5), (int) (Math.floor(z) + 1)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) - 0), (int) (Math.floor(y) + 5), (int) (Math.floor(z) - 1)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) + 1), (int) (Math.floor(y) + 6), (int) (Math.floor(z) + 0)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) - 1), (int) (Math.floor(y) + 6), (int) (Math.floor(z) + 0)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) - 0), (int) (Math.floor(y) + 6), (int) (Math.floor(z) + 1)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) (Math.floor(x) - 0), (int) (Math.floor(y) + 6), (int) (Math.floor(z) - 1)),
							Judeecercis_LeavesBlock.block.getDefaultState(), 3);
				}
			}
		}
	}
}
