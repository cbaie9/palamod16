
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
public class PaladiumPickaxeItem extends PalamodModElements.ModElement {
	@ObjectHolder("palamod:paladium_pickaxe")
	public static final Item block = null;

	public PaladiumPickaxeItem(PalamodModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 4999;
			}

			public float getEfficiency() {
				return 24f;
			}

			public float getAttackDamage() {
				return 4f;
			}

			public int getHarvestLevel() {
				return 6;
			}

			public int getEnchantability() {
				return 10;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(PaladiumIngotItem.block));
			}
		}, 1, -2.5f, new Item.Properties().group(PalamodItemGroup.tab)) {
		}.setRegistryName("paladium_pickaxe"));
	}
}
