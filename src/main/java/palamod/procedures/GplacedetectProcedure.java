package palamod.procedures;

import palamod.block.GrinderframeBlock;

import palamod.PalamodMod;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.Property;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.block.BlockState;

import java.util.Map;

public class GplacedetectProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PalamodMod.LOGGER.warn("Failed to load dependency world for procedure Gplacedetect!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PalamodMod.LOGGER.warn("Failed to load dependency x for procedure Gplacedetect!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PalamodMod.LOGGER.warn("Failed to load dependency y for procedure Gplacedetect!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PalamodMod.LOGGER.warn("Failed to load dependency z for procedure Gplacedetect!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateContainer().getProperty("facing");
				if (_prop instanceof DirectionProperty)
					return _bs.get((DirectionProperty) _prop);
				_prop = _bs.getBlock().getStateContainer().getProperty("axis");
				return _prop instanceof EnumProperty && _prop.getAllowedValues().toArray()[0] instanceof Direction.Axis
						? Direction.getFacingFromAxisDirection(_bs.get((EnumProperty<Direction.Axis>) _prop), Direction.AxisDirection.POSITIVE)
						: Direction.NORTH;
			}
		}.getDirection((world.getBlockState(new BlockPos(x, y, z))))) == Direction.SOUTH) {
			if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == GrinderframeBlock.block
					&& (world.getBlockState(new BlockPos(x + 1, y - 1, z))).getBlock() == GrinderframeBlock.block
					&& (world.getBlockState(new BlockPos(x - 1, y - 1, z))).getBlock() == GrinderframeBlock.block
					&& (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == GrinderframeBlock.block
					&& (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == GrinderframeBlock.block
					&& (world.getBlockState(new BlockPos(x - 1, y + 1, z))).getBlock() == GrinderframeBlock.block
					&& (world.getBlockState(new BlockPos(x + 1, y + 1, z))).getBlock() == GrinderframeBlock.block
					&& (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == GrinderframeBlock.block) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos(x, y, z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putBoolean("G_structure", (true));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		}
	}
}
