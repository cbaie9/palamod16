
package palamod.item;

import palamod.itemgroup.PalamodItemGroup;

import palamod.PalamodModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

@PalamodModElements.ModElement.Tag
public class AmethystebroadswordItem extends PalamodModElements.ModElement {
	@ObjectHolder("palamod:amethystebroadsword")
	public static final Item block = null;

	public AmethystebroadswordItem(PalamodModElements instance) {
		super(instance, 36);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 800;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 5.7f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 10;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -3.5f, new Item.Properties().group(PalamodItemGroup.tab)) {
		}.setRegistryName("amethystebroadsword"));
	}
}
