package net.rugmj.logicalredstone;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.command.CommandRegistryAccess;
import net.rugmj.logicalredstone.command.BinaryToDecimalCommand;
import net.rugmj.logicalredstone.command.ColourCodeCommand;
import net.rugmj.logicalredstone.command.DecimalToBinaryCommand;
import net.rugmj.logicalredstone.command.WoolCommand;
import net.rugmj.logicalredstone.event.KeyInputHandler;

public class LogicalRedstoneClient implements ClientModInitializer {
    public static boolean isWorldeditInstalled;

    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register(LogicalRedstoneClient::registerCommands);
        KeyInputHandler.register();
        isWorldeditInstalled = FabricLoader.getInstance().isModLoaded("worldedit");
    }


    public static void registerCommands(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandRegistryAccess registryAccess) {
        DecimalToBinaryCommand.register(dispatcher);
        BinaryToDecimalCommand.register(dispatcher);
        WoolCommand.register(dispatcher);
        ColourCodeCommand.register(dispatcher);
    }
}

