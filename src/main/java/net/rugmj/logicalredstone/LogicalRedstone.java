package net.rugmj.logicalredstone;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.command.CommandRegistryAccess;
import net.rugmj.logicalredstone.command.BinaryToDecimalCommand;
import com.mojang.brigadier.CommandDispatcher;
import net.rugmj.logicalredstone.command.DecimalToBinaryCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogicalRedstone implements ModInitializer {
	public static final String MODID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		ClientCommandRegistrationCallback.EVENT.register(LogicalRedstone::registerCommands);

	}

	public static void registerCommands(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandRegistryAccess registryAccess) {
		DecimalToBinaryCommand.register(dispatcher);
		BinaryToDecimalCommand.register(dispatcher);
	}
}
