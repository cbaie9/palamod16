
package palamod.item;

import palamod.itemgroup.PalamodItemGroup;

import palamod.PalamodModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

@PalamodModElements.ModElement.Tag
public class AmethysteAxeItem extends PalamodModElements.ModElement {
	@ObjectHolder("palamod:amethyste_axe")
	public static final Item block = null;

	public AmethysteAxeItem(PalamodModElements instance) {
		super(instance, 31);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 2999;
			}

			public float getEfficiency() {
				return 30f;
			}

			public float getAttackDamage() {
				return 4f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 56;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(AmethysteItem.block));
			}
		}, 1, -3f, new Item.Properties().group(PalamodItemGroup.tab)) {
		}.setRegistryName("amethyste_axe"));
	}
}
