
package palamod.item;

import palamod.itemgroup.PalamodItemGroup;

import palamod.PalamodModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

@PalamodModElements.ModElement.Tag
public class TitanePickaxeItem extends PalamodModElements.ModElement {
	@ObjectHolder("palamod:titane_pickaxe")
	public static final Item block = null;

	public TitanePickaxeItem(PalamodModElements instance) {
		super(instance, 18);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 3999;
			}

			public float getEfficiency() {
				return 16f;
			}

			public float getAttackDamage() {
				return 4f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 25;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(TitaneIngotItem.block));
			}
		}, 1, -3f, new Item.Properties().group(PalamodItemGroup.tab)) {
		}.setRegistryName("titane_pickaxe"));
	}
}
