
package palamod.block;

import palamod.itemgroup.PalamodItemGroup;

import palamod.PalamodModElements;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.property.Properties;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.feature.LakesFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.World;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.state.StateContainer;
import net.minecraft.item.Rarity;
import net.minecraft.item.Items;
import net.minecraft.item.Item;
import net.minecraft.item.BucketItem;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.Random;

@PalamodModElements.ModElement.Tag
public class PalalavaBlock extends PalamodModElements.ModElement {
	@ObjectHolder("palamod:palalava")
	public static final FlowingFluidBlock block = null;
	@ObjectHolder("palamod:palalava_bucket")
	public static final Item bucket = null;
	public static FlowingFluid flowing = null;
	public static FlowingFluid still = null;
	private ForgeFlowingFluid.Properties fluidproperties = null;

	public PalalavaBlock(PalamodModElements instance) {
		super(instance, 161);
		FMLJavaModLoadingContext.get().getModEventBus().register(new FluidRegisterHandler());
		MinecraftForge.EVENT_BUS.register(this);
		FMLJavaModLoadingContext.get().getModEventBus().register(new FeatureRegisterHandler());
	}

	private static class FluidRegisterHandler {
		@SubscribeEvent
		public void registerFluids(RegistryEvent.Register<Fluid> event) {
			event.getRegistry().register(still);
			event.getRegistry().register(flowing);
		}
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(still, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(flowing, RenderType.getTranslucent());
	}

	@Override
	public void initElements() {
		fluidproperties = new ForgeFlowingFluid.Properties(() -> still, () -> flowing,
				FluidAttributes
						.builder(new ResourceLocation("palamod:blocks/palalava_bta_still"), new ResourceLocation("palamod:blocks/palalava_bta_move"))
						.luminosity(0).density(1000).viscosity(1000).temperature(300)

						.rarity(Rarity.COMMON))
				.explosionResistance(100f)

				.tickRate(5).levelDecreasePerBlock(1).slopeFindDistance(4).bucket(() -> bucket).block(() -> block);
		still = (FlowingFluid) new CustomFlowingFluid.Source(fluidproperties).setRegistryName("palalava");
		flowing = (FlowingFluid) new CustomFlowingFluid.Flowing(fluidproperties).setRegistryName("palalava_flowing");
		elements.blocks
				.add(() -> new FlowingFluidBlock(still, Block.Properties.create(Material.LAVA).hardnessAndResistance(100f).setLightLevel(s -> 0)) {
					@Override
					public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
						return true;
					}
				}.setRegistryName("palalava"));
		elements.items.add(() -> new BucketItem(still,
				new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(PalamodItemGroup.tab).rarity(Rarity.COMMON))
				.setRegistryName("palalava_bucket"));
	}

	public static abstract class CustomFlowingFluid extends ForgeFlowingFluid {
		public CustomFlowingFluid(Properties properties) {
			super(properties);
		}

		@Override
		public Vector3d getFlow(IBlockReader world, BlockPos pos, FluidState fluidstate) {
			return super.getFlow(world, pos, fluidstate).scale(-0.1);
		}

		public static class Source extends CustomFlowingFluid {
			public Source(Properties properties) {
				super(properties);
			}

			public int getLevel(FluidState state) {
				return 8;
			}

			public boolean isSource(FluidState state) {
				return true;
			}
		}

		public static class Flowing extends CustomFlowingFluid {
			public Flowing(Properties properties) {
				super(properties);
			}

			protected void fillStateContainer(StateContainer.Builder<Fluid, FluidState> builder) {
				super.fillStateContainer(builder);
				builder.add(LEVEL_1_8);
			}

			public int getLevel(FluidState state) {
				return state.get(LEVEL_1_8);
			}

			public boolean isSource(FluidState state) {
				return false;
			}
		}
	}

	private static Feature<BlockStateFeatureConfig> feature = null;
	private static ConfiguredFeature<?, ?> configuredFeature = null;

	private static class FeatureRegisterHandler {
		@SubscribeEvent
		public void registerFeature(RegistryEvent.Register<Feature<?>> event) {
			feature = new LakesFeature(BlockStateFeatureConfig.field_236455_a_) {
				@Override
				public boolean generate(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, BlockStateFeatureConfig config) {
					RegistryKey<World> dimensionType = world.getWorld().getDimensionKey();
					boolean dimensionCriteria = false;
					if (dimensionType == World.OVERWORLD)
						dimensionCriteria = true;
					if (!dimensionCriteria)
						return false;
					return super.generate(world, generator, rand, pos, config);
				}
			};
			configuredFeature = feature.withConfiguration(new BlockStateFeatureConfig(block.getDefaultState()))
					.withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(5)));
			event.getRegistry().register(feature.setRegistryName("palalava_lakes"));
			Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation("palamod:palalava_lakes"), configuredFeature);
		}
	}

	@SubscribeEvent
	public void addFeatureToBiomes(BiomeLoadingEvent event) {
		event.getGeneration().getFeatures(GenerationStage.Decoration.LOCAL_MODIFICATIONS).add(() -> configuredFeature);
	}
}
