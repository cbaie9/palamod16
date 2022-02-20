
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
public class AmethysteSwordItem extends PalamodModElements.ModElement {
	@ObjectHolder("palamod:amethyste_sword")
	public static final Item block = null;

	public AmethysteSwordItem(PalamodModElements instance) {
		super(instance, 32);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2999;
			}

			public float getEfficiency() {
				return 14f;
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
		}, 3, -3f, new Item.Properties().group(PalamodItemGroup.tab)) {
		}.setRegistryName("amethyste_sword"));
	}
}
