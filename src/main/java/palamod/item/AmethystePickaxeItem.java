
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
public class AmethystePickaxeItem extends PalamodModElements.ModElement {
	@ObjectHolder("palamod:amethyste_pickaxe")
	public static final Item block = null;

	public AmethystePickaxeItem(PalamodModElements instance) {
		super(instance, 30);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 2999;
			}

			public float getEfficiency() {
				return 14f;
			}

			public float getAttackDamage() {
				return 3f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 30;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(AmethysteItem.block));
			}
		}, 1, -3f, new Item.Properties().group(PalamodItemGroup.tab)) {
		}.setRegistryName("amethyste_pickaxe"));
	}
}
