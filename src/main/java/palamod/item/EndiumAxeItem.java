
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
public class EndiumAxeItem extends PalamodModElements.ModElement {
	@ObjectHolder("palamod:endium_axe")
	public static final Item block = null;

	public EndiumAxeItem(PalamodModElements instance) {
		super(instance, 49);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 10000;
			}

			public float getEfficiency() {
				return 50f;
			}

			public float getAttackDamage() {
				return 7f;
			}

			public int getHarvestLevel() {
				return 8;
			}

			public int getEnchantability() {
				return 50;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(EndiumIngotItem.block));
			}
		}, 1, -3f, new Item.Properties().group(PalamodItemGroup.tab)) {
		}.setRegistryName("endium_axe"));
	}
}
