
package palamod.block;

import palamod.procedures.DiamondspikedamageProcedure;

import palamod.itemgroup.PalamodItemGroup;

import palamod.PalamodModElements;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.util.Direction;
import net.minecraft.state.StateContainer;
import net.minecraft.state.DirectionProperty;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.stream.Stream;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;
import java.util.AbstractMap;

@PalamodModElements.ModElement.Tag
public class DiamondspikeBlock extends PalamodModElements.ModElement {
	@ObjectHolder("palamod:diamondspike")
	public static final Block block = null;

	public DiamondspikeBlock(PalamodModElements instance) {
		super(instance, 166);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(PalamodItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}

	public static class CustomBlock extends Block {
		public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

		public CustomBlock() {
			super(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).setRequiresTool().notSolid().setOpaque((bs, br, bp) -> false));
			this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
			setRegistryName("diamondspike");
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 0;
		}

		@Override
		public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
			Vector3d offset = state.getOffset(world, pos);
			switch ((Direction) state.get(FACING)) {
				case SOUTH :
				default :
					return VoxelShapes.or(makeCuboidShape(16, 0, 16, 0, 1, 0), makeCuboidShape(15, 1, 15, 2, 2, 2),
							makeCuboidShape(14, 2, 14, 4, 3, 4), makeCuboidShape(13, 3, 13, 6, 4, 6), makeCuboidShape(12, 4, 12, 8, 5, 8),
							makeCuboidShape(11, 5, 11, 10, 6, 10), makeCuboidShape(10, 6, 10, 12, 7, 12), makeCuboidShape(9, 7, 9, 14, 8, 14)

					)

							.withOffset(offset.x, offset.y, offset.z);
				case NORTH :
					return VoxelShapes.or(makeCuboidShape(0, 0, 0, 16, 1, 16), makeCuboidShape(1, 1, 1, 14, 2, 14),
							makeCuboidShape(2, 2, 2, 12, 3, 12), makeCuboidShape(3, 3, 3, 10, 4, 10), makeCuboidShape(4, 4, 4, 8, 5, 8),
							makeCuboidShape(5, 5, 5, 6, 6, 6), makeCuboidShape(6, 6, 6, 4, 7, 4), makeCuboidShape(7, 7, 7, 2, 8, 2)

					)

							.withOffset(offset.x, offset.y, offset.z);
				case EAST :
					return VoxelShapes.or(makeCuboidShape(16, 0, 0, 0, 1, 16), makeCuboidShape(15, 1, 1, 2, 2, 14),
							makeCuboidShape(14, 2, 2, 4, 3, 12), makeCuboidShape(13, 3, 3, 6, 4, 10), makeCuboidShape(12, 4, 4, 8, 5, 8),
							makeCuboidShape(11, 5, 5, 10, 6, 6), makeCuboidShape(10, 6, 6, 12, 7, 4), makeCuboidShape(9, 7, 7, 14, 8, 2)

					)

							.withOffset(offset.x, offset.y, offset.z);
				case WEST :
					return VoxelShapes.or(makeCuboidShape(0, 0, 16, 16, 1, 0), makeCuboidShape(1, 1, 15, 14, 2, 2),
							makeCuboidShape(2, 2, 14, 12, 3, 4), makeCuboidShape(3, 3, 13, 10, 4, 6), makeCuboidShape(4, 4, 12, 8, 5, 8),
							makeCuboidShape(5, 5, 11, 6, 6, 10), makeCuboidShape(6, 6, 10, 4, 7, 12), makeCuboidShape(7, 7, 9, 2, 8, 14)

					)

							.withOffset(offset.x, offset.y, offset.z);
			}
		}

		@Override
		protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
			builder.add(FACING);
		}

		public BlockState rotate(BlockState state, Rotation rot) {
			return state.with(FACING, rot.rotate(state.get(FACING)));
		}

		public BlockState mirror(BlockState state, Mirror mirrorIn) {
			return state.rotate(mirrorIn.toRotation(state.get(FACING)));
		}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
			;
			return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

		@Override
		public void onEntityCollision(BlockState blockstate, World world, BlockPos pos, Entity entity) {
			super.onEntityCollision(blockstate, world, pos, entity);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();

			DiamondspikedamageProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}
}
