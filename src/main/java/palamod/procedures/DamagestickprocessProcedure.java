package palamod.procedures;

import palamod.PalamodMod;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Random;
import java.util.Map;

public class DamagestickprocessProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PalamodMod.LOGGER.warn("Failed to load dependency entity for procedure Damagestickprocess!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				PalamodMod.LOGGER.warn("Failed to load dependency itemstack for procedure Damagestickprocess!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		for (int index0 = 0; index0 < (int) (25); index0++) {
			if (entity instanceof LivingEntity) {
				LivingEntity _ent = (LivingEntity) entity;
				if (!_ent.world.isRemote()) {
					AbstractArrowEntity entityToSpawn = new ArrowEntity(_ent.world, _ent);
					entityToSpawn.shoot(_ent.getLookVec().x, _ent.getLookVec().y, _ent.getLookVec().z, 2, 0);
					entityToSpawn.setDamage((float) 0.25);
					entityToSpawn.setKnockbackStrength((int) 7.5);
					_ent.world.addEntity(entityToSpawn);
				}
			}
		}
		{
			ItemStack _ist = itemstack;
			if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
				_ist.shrink(1);
				_ist.setDamage(0);
			}
		}
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 900);
	}
}
