
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
public class EndiumSwordItem extends PalamodModElements.ModElement {
	@ObjectHolder("palamod:endium_sword")
	public static final Item block = null;

	public EndiumSwordItem(PalamodModElements instance) {
		super(instance, 50);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 10000;
			}

			public float getEfficiency() {
				return 1f;
			}

			public float getAttackDamage() {
				return 8f;
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
		}, 3, -2.25f, new Item.Properties().group(PalamodItemGroup.tab)) {
		}.setRegistryName("endium_sword"));
	}
}
