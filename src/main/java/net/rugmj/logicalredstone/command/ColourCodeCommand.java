package net.rugmj.logicalredstone.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.text.Text;
import net.rugmj.logicalredstone.LogicalRedstoneClient;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.mojang.brigadier.arguments.StringArgumentType.getString;
import static com.mojang.brigadier.arguments.StringArgumentType.string;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.argument;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public class ColourCodeCommand {

    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        LiteralCommandNode<FabricClientCommandSource> colourCommand = dispatcher.register(literal("colour").then(argument("colour", string())
                .executes(context -> run(context.getSource(), getString(context, "colour")))
                .suggests((context, builder) -> {
                    builder.suggest("white");
                    builder.suggest("orange");
                    builder.suggest("magenta");
                    builder.suggest("lightblue");
                    builder.suggest("yellow");
                    builder.suggest("lime");
                    builder.suggest("pink");
                    builder.suggest("gray");
                    builder.suggest("lightgray");
                    builder.suggest("cyan");
                    builder.suggest("purple");
                    builder.suggest("blue");
                    builder.suggest("brown");
                    builder.suggest("green");
                    builder.suggest("red");
                    builder.suggest("black");

                    return builder.buildFuture();
                })));
        dispatcher.register(literal("color").redirect(colourCommand));
        dispatcher.register(literal("colourcode").redirect(colourCommand));
        dispatcher.register(literal("colorcode").redirect(colourCommand));


    }

    private static int run (FabricClientCommandSource source, String input) {
        Map<String, String> colours = new HashMap<>();
        colours.put("white", "");
        colours.put("orange", ":1");
        colours.put("magenta", ":2");
        colours.put("lightblue", ":3");
        colours.put("yellow", ":4");
        colours.put("lime", ":5");
        colours.put("pink", ":6");
        colours.put("gray", ":7");
        colours.put("lightgray", ":8");
        colours.put("cyan", ":9");
        colours.put("purple", ":10");
        colours.put("blue", ":11");
        colours.put("brown", ":12");
        colours.put("green", ":13");
        colours.put("red", ":14");
        colours.put("black", ":15");

        String wool = "35" + colours.get(input);
        String glass = "95" + colours.get(input);


        if (!LogicalRedstoneClient.isWorldeditInstalled && Objects.requireNonNull(source.getClient().world).isClient) {
            source.sendError(Text.of("Worldedit must be installed"));
            return -1;
        }

        if (colours.get(input) == null) {
            source.sendError(Text.of("Unknown colour, known colours are: " + String.join(", ", colours.keySet())));
            return -1;
        }

        source.getPlayer().sendCommand("//replace 35 " + wool, null );
        source.getPlayer().sendCommand("//replace 95 " + glass, null );


        return 1;
    }

}
