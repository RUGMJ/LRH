package net.rugmj.logicalredstone.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.text.Text;

import static com.mojang.brigadier.arguments.IntegerArgumentType.*;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.*;


public class DecimalToBinaryCommand {

    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(literal("dectobin").then(argument("decimal", integer(0)).executes(context -> run(context.getSource(), getInteger(context, "decimal")))));
    }
    private static int run(FabricClientCommandSource source, int input) throws CommandSyntaxException {

        source.sendFeedback(Text.literal(Integer.toBinaryString(input)));
        return 1;
    }
}

