
package palamod.item;

import palamod.itemgroup.PalamodItemGroup;

import palamod.PalamodModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

@PalamodModElements.ModElement.Tag
public class PaladiumgreenshovelItem extends PalamodModElements.ModElement {
	@ObjectHolder("palamod:paladiumgreenshovel")
	public static final Item block = null;

	public PaladiumgreenshovelItem(PalamodModElements instance) {
		super(instance, 56);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 4999;
			}

			public float getEfficiency() {
				return 36f;
			}

			public float getAttackDamage() {
				return 3f;
			}

			public int getHarvestLevel() {
				return 6;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(PaladiumIngotItem.block));
			}
		}, 1, -3.5f, new Item.Properties().group(PalamodItemGroup.tab)) {
		}.setRegistryName("paladiumgreenshovel"));
	}
}
