
package palamod.item;

import palamod.procedures.TravelarmorLeggings_speedboostProcedure;
import palamod.procedures.TravelarmorHelmetTickEventProcedure;
import palamod.procedures.TravelarmorBoots_slowfallingProcedure;
import palamod.procedures.TravelarmorBody_jumpboostProcedure;

import palamod.itemgroup.PalamodItemGroup;

import palamod.PalamodModElements;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

@PalamodModElements.ModElement.Tag
public class TravelarmorItem extends PalamodModElements.ModElement {
	@ObjectHolder("palamod:travelarmor_helmet")
	public static final Item helmet = null;
	@ObjectHolder("palamod:travelarmor_chestplate")
	public static final Item body = null;
	@ObjectHolder("palamod:travelarmor_leggings")
	public static final Item legs = null;
	@ObjectHolder("palamod:travelarmor_boots")
	public static final Item boots = null;

	public TravelarmorItem(PalamodModElements instance) {
		super(instance, 224);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 15;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{1, 3, 1, 1}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 9;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "travelarmor";
			}

			@Override
			public float getToughness() {
				return 0f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(PalamodItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "palamod:textures/models/armor/travel2__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				super.onArmorTick(itemstack, world, entity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				TravelarmorHelmetTickEventProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
								new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}.setRegistryName("travelarmor_helmet"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(PalamodItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "palamod:textures/models/armor/travel2__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				TravelarmorBody_jumpboostProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}.setRegistryName("travelarmor_chestplate"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(PalamodItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "palamod:textures/models/armor/travel2__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				TravelarmorLeggings_speedboostProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}.setRegistryName("travelarmor_leggings"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(PalamodItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "palamod:textures/models/armor/travel2__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				TravelarmorBoots_slowfallingProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}.setRegistryName("travelarmor_boots"));
	}

}
