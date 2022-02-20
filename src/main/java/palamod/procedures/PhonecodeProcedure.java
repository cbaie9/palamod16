package palamod.procedures;

import palamod.item.DiamondstringItem;

import palamod.block.FakepaladiumoreBlock;

import palamod.PalamodMod;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.client.gui.widget.TextFieldWidget;

import java.util.Map;
import java.util.HashMap;

public class PhonecodeProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PalamodMod.LOGGER.warn("Failed to load dependency world for procedure Phonecode!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PalamodMod.LOGGER.warn("Failed to load dependency x for procedure Phonecode!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PalamodMod.LOGGER.warn("Failed to load dependency y for procedure Phonecode!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PalamodMod.LOGGER.warn("Failed to load dependency z for procedure Phonecode!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PalamodMod.LOGGER.warn("Failed to load dependency entity for procedure Phonecode!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				PalamodMod.LOGGER.warn("Failed to load dependency guistate for procedure Phonecode!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		if ((new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:cheat_code_secret");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText()).contains("cbaie9") || (new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:cheat_code_secret");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText()).contains("cb9") || (new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:cheat_code_secret");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText()).contains("4009")) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), FakepaladiumoreBlock.block.getDefaultState(), 3);
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).closeScreen();
		} else if ((new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:cheat_code_secret");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText()).contains("Combocircle") || (new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:cheat_code_secret");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText()).contains("CombocircleZ") || (new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:cheat_code_secret");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText()).contains("Combocircle123") || (new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:cheat_code_secret");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText()).contains("CombocircleZ123")) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).setGameType(GameType.ADVENTURE);
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"msg @s an cheater has been detected");
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).closeScreen();
		} else if ((new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:cheat_code_secret");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText()).contains("reset.gamemode")) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).setGameType(GameType.SURVIVAL);
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"msg @s reset.gamemode has been succesful executed You now in gamemode survival");
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).closeScreen();
		} else if ((new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:cheat_code_secret");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText()).contains("Wolfen") || (new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:cheat_code_secret");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText()).contains("wolfen")) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(DiamondstringItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"msg @s No suicide today please. Suicide is bad :{");
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).closeScreen();
		}
	}
}
