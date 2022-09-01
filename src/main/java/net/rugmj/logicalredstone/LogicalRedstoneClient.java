package net.rugmj.logicalredstone;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.command.CommandRegistryAccess;
import net.rugmj.logicalredstone.command.BinaryToDecimalCommand;
import net.rugmj.logicalredstone.command.DecimalToBinaryCommand;
import net.rugmj.logicalredstone.command.WoolCommand;
import net.rugmj.logicalredstone.event.KeyInputHandler;

public class LogicalRedstoneClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register(LogicalRedstoneClient::registerCommands);
        KeyInputHandler.register();
    }


    public static void registerCommands(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandRegistryAccess registryAccess) {
        DecimalToBinaryCommand.register(dispatcher);
        BinaryToDecimalCommand.register(dispatcher);
        WoolCommand.register(dispatcher);
    }
}

