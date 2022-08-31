package net.rugmj.logicalredstone.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.text.Text;

import static com.mojang.brigadier.arguments.StringArgumentType.*;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.*;


public class BinaryToDecimalCommand {

    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(literal("bintodec").then(argument("binary", string()).executes(context -> run(context.getSource(), getString(context, "binary")))));
    }
    private static int run(FabricClientCommandSource source, String input) throws CommandSyntaxException {

        try {
            source.sendFeedback(Text.literal(Integer.toString(Integer.parseInt(input, 2))));
            return 1;
        } catch (Exception error) {
            source.sendError(Text.literal("Not a Binary Number!"));
            return -1;
        }



    }
}

