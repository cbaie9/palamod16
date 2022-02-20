
package palamod.item;

import palamod.itemgroup.PalamodItemGroup;

import palamod.PalamodModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

@PalamodModElements.ModElement.Tag
public class FuzeiiidiscItem extends PalamodModElements.ModElement {
	@ObjectHolder("palamod:fuzeiiidisc")
	public static final Item block = null;

	public FuzeiiidiscItem(PalamodModElements instance) {
		super(instance, 628);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, PalamodModElements.sounds.get(new ResourceLocation("palamod:fuze_record")),
					new Item.Properties().group(PalamodItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("fuzeiiidisc");
		}
	}
}
