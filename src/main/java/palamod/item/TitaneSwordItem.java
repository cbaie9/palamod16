
package palamod.item;

import palamod.itemgroup.PalamodItemGroup;

import palamod.PalamodModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

@PalamodModElements.ModElement.Tag
public class TitaneSwordItem extends PalamodModElements.ModElement {
	@ObjectHolder("palamod:titane_sword")
	public static final Item block = null;

	public TitaneSwordItem(PalamodModElements instance) {
		super(instance, 20);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 3999;
			}

			public float getEfficiency() {
				return 1f;
			}

			public float getAttackDamage() {
				return 5f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 70;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(TitaneIngotItem.block));
			}
		}, 3, -2f, new Item.Properties().group(PalamodItemGroup.tab)) {
		}.setRegistryName("titane_sword"));
	}
}
