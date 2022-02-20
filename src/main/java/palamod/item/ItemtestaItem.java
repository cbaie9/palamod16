
package palamod.item;

import net.minecraft.entity.ai.attributes.Attributes;

@PalamodModElements.ModElement.Tag
public class ItemtestaItem extends PalamodModElements.ModElement {

	@ObjectHolder("palamod:itemtesta")
	public static final Item block = null;

	public ItemtestaItem(PalamodModElements instance) {
		super(instance, 638);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("itemtesta");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

	}

}
