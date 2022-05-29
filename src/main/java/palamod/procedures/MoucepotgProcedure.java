package palamod.procedures;

import palamod.PalamodMod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import java.util.Map;

public class MoucepotgProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PalamodMod.LOGGER.warn("Failed to load dependency world for procedure Moucepotg!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PalamodMod.LOGGER.warn("Failed to load dependency entity for procedure Moucepotg!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				PalamodMod.LOGGER.warn("Failed to load dependency itemstack for procedure Moucepotg!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 2000000) {
			(itemstack).setDisplayName(new StringTextComponent("Fully upgraded - Level 20"));
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					(itemstack).setDisplayName(new StringTextComponent("Pickaxe of the gods"));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 20);
		} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 1000000) {
			(itemstack)
					.setDisplayName(new StringTextComponent(((2000000 - entity.getPersistentData().getDouble("Pickaxe_stone")) + "Left - Level 19")));
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					(itemstack).setDisplayName(new StringTextComponent("Pickaxe of the gods"));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 20);
		} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 800000) {
			(itemstack)
					.setDisplayName(new StringTextComponent(((1000000 - entity.getPersistentData().getDouble("Pickaxe_stone")) + "Left - Level 18")));
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					(itemstack).setDisplayName(new StringTextComponent("Pickaxe of the gods"));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 20);
		} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 700000) {
			(itemstack)
					.setDisplayName(new StringTextComponent(((800000 - entity.getPersistentData().getDouble("Pickaxe_stone")) + "Left - Level 17")));
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					(itemstack).setDisplayName(new StringTextComponent("Pickaxe of the gods"));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 20);
		} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 600000) {
			(itemstack)
					.setDisplayName(new StringTextComponent(((700000 - entity.getPersistentData().getDouble("Pickaxe_stone")) + "Left - Level 16")));
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					(itemstack).setDisplayName(new StringTextComponent("Pickaxe of the gods"));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 20);
		} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 500000) {
			(itemstack)
					.setDisplayName(new StringTextComponent(((600000 - entity.getPersistentData().getDouble("Pickaxe_stone")) + "Left - Level 15")));
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					(itemstack).setDisplayName(new StringTextComponent("Pickaxe of the gods"));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 20);
		} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 400000) {
			(itemstack)
					.setDisplayName(new StringTextComponent(((500000 - entity.getPersistentData().getDouble("Pickaxe_stone")) + "Left - Level 14")));
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					(itemstack).setDisplayName(new StringTextComponent("Pickaxe of the gods"));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 20);
		} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 250000) {
			(itemstack)
					.setDisplayName(new StringTextComponent(((400000 - entity.getPersistentData().getDouble("Pickaxe_stone")) + "Left - Level 13")));
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					(itemstack).setDisplayName(new StringTextComponent("Pickaxe of the gods"));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 20);
		} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 150000) {
			(itemstack)
					.setDisplayName(new StringTextComponent(((250000 - entity.getPersistentData().getDouble("Pickaxe_stone")) + "Left - Level 12")));
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					(itemstack).setDisplayName(new StringTextComponent("Pickaxe of the gods"));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 20);
		} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 100000) {
			(itemstack)
					.setDisplayName(new StringTextComponent(((150000 - entity.getPersistentData().getDouble("Pickaxe_stone")) + "Left - Level 11")));
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					(itemstack).setDisplayName(new StringTextComponent("Pickaxe of the gods"));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 20);
		} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 50000) {
			(itemstack)
					.setDisplayName(new StringTextComponent(((100000 - entity.getPersistentData().getDouble("Pickaxe_stone")) + "Left - Level 10")));
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					(itemstack).setDisplayName(new StringTextComponent("Pickaxe of the gods"));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 20);
		} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 25000) {
			(itemstack).setDisplayName(new StringTextComponent(((50000 - entity.getPersistentData().getDouble("Pickaxe_stone")) + "Left - Level 9")));
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					(itemstack).setDisplayName(new StringTextComponent("Pickaxe of the gods"));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 20);
		} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 10000) {
			(itemstack).setDisplayName(new StringTextComponent(((25000 - entity.getPersistentData().getDouble("Pickaxe_stone")) + "Left - Level 8")));
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					(itemstack).setDisplayName(new StringTextComponent("Pickaxe of the gods"));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 20);
		} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 5000) {
			(itemstack).setDisplayName(new StringTextComponent(((10000 - entity.getPersistentData().getDouble("Pickaxe_stone")) + "Left - Level 7")));
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					(itemstack).setDisplayName(new StringTextComponent("Pickaxe of the gods"));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 20);
		} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 2000) {
			(itemstack).setDisplayName(new StringTextComponent(((5000 - entity.getPersistentData().getDouble("Pickaxe_stone")) + "Left - Level 6")));
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					(itemstack).setDisplayName(new StringTextComponent("Pickaxe of the gods"));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 20);
		} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 1000) {
			(itemstack).setDisplayName(new StringTextComponent(((2000 - entity.getPersistentData().getDouble("Pickaxe_stone")) + "Left - Level 5")));
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					(itemstack).setDisplayName(new StringTextComponent("Pickaxe of the gods"));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 20);
		} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 500) {
			(itemstack).setDisplayName(new StringTextComponent(((1000 - entity.getPersistentData().getDouble("Pickaxe_stone")) + "Left - Level 4")));
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					(itemstack).setDisplayName(new StringTextComponent("Pickaxe of the gods"));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 20);
		} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 250) {
			(itemstack).setDisplayName(new StringTextComponent(((500 - entity.getPersistentData().getDouble("Pickaxe_stone")) + "Left - Level 3")));
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					(itemstack).setDisplayName(new StringTextComponent("Pickaxe of the gods"));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 20);
		} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 100) {
			(itemstack).setDisplayName(new StringTextComponent(((250 - entity.getPersistentData().getDouble("Pickaxe_stone")) + "Left - Level 2")));
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					(itemstack).setDisplayName(new StringTextComponent("Pickaxe of the gods"));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 20);
		} else if (entity.getPersistentData().getDouble("Pickaxe_stone") >= 1) {
			(itemstack).setDisplayName(new StringTextComponent(((100 - entity.getPersistentData().getDouble("Pickaxe_stone")) + "Left - Level 1")));
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;

				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					(itemstack).setDisplayName(new StringTextComponent("Pickaxe of the gods"));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 20);
		}
	}
}
