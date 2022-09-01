package net.rugmj.logicalredstone.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.rugmj.logicalredstone.LogicalRedstone;

import java.util.HashMap;
import java.util.Map;

import static com.mojang.brigadier.arguments.StringArgumentType.*;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.argument;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public class WoolCommand {

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
        dispatcher.register(literal("wool").redirect(colourCommand));
        dispatcher.register(literal("wo").redirect(colourCommand));

    }

    private static int run (FabricClientCommandSource source, String input) {
        LogicalRedstone.LOGGER.info("Inputted: {}", input);
        Map<String, Block> woolColours = new HashMap<>();
        woolColours.put("white", Blocks.WHITE_WOOL);
        woolColours.put("orange", Blocks.ORANGE_WOOL);
        woolColours.put("magenta", Blocks.MAGENTA_WOOL);
        woolColours.put("lightblue", Blocks.LIGHT_BLUE_WOOL);
        woolColours.put("yellow", Blocks.YELLOW_WOOL);
        woolColours.put("lime", Blocks.LIME_WOOL);
        woolColours.put("pink", Blocks.PINK_WOOL);
        woolColours.put("gray", Blocks.GRAY_WOOL);
        woolColours.put("lightgray", Blocks.LIGHT_GRAY_WOOL);
        woolColours.put("cyan", Blocks.CYAN_WOOL);
        woolColours.put("purple", Blocks.PURPLE_WOOL);
        woolColours.put("blue", Blocks.BLUE_WOOL);
        woolColours.put("brown", Blocks.BROWN_WOOL);
        woolColours.put("green", Blocks.GREEN_WOOL);
        woolColours.put("red", Blocks.RED_WOOL);
        woolColours.put("black", Blocks.BLACK_WOOL);

        Map<String, Block> glassColours = new HashMap<>();
        glassColours.put("white", Blocks.WHITE_STAINED_GLASS);
        glassColours.put("orange", Blocks.ORANGE_STAINED_GLASS);
        glassColours.put("magenta", Blocks.MAGENTA_STAINED_GLASS);
        glassColours.put("lightblue", Blocks.LIGHT_BLUE_STAINED_GLASS);
        glassColours.put("yellow", Blocks.YELLOW_STAINED_GLASS);
        glassColours.put("lime", Blocks.LIME_STAINED_GLASS);
        glassColours.put("pink", Blocks.PINK_STAINED_GLASS);
        glassColours.put("gray", Blocks.GRAY_STAINED_GLASS);
        glassColours.put("lightgray", Blocks.LIGHT_GRAY_STAINED_GLASS);
        glassColours.put("cyan", Blocks.CYAN_STAINED_GLASS);
        glassColours.put("purple", Blocks.PURPLE_STAINED_GLASS);
        glassColours.put("blue", Blocks.BLUE_STAINED_GLASS);
        glassColours.put("brown", Blocks.BROWN_STAINED_GLASS);
        glassColours.put("green", Blocks.GREEN_STAINED_GLASS);
        glassColours.put("red", Blocks.RED_STAINED_GLASS);
        glassColours.put("black", Blocks.BLACK_STAINED_GLASS);




        Block wool = woolColours.get(input);
        Block glass = glassColours.get(input);

        if (wool == null) {
            source.sendError(Text.of("Unknown colour, known colours are: " + String.join(", ", woolColours.keySet())));
            return -1;
        }

//        source.getPlayer().giveItemStack(new ItemStack(wool.asItem()));

        for (int i = 0; i < 9; i++) {
            LogicalRedstone.LOGGER.info(String.valueOf(source.getPlayer().getInventory().getStack(i).getName().getString().contains("Wool")));
            if (source.getPlayer().getInventory().getStack(i).getName().getString().contains("Wool")) {
                source.getPlayer().getInventory().setStack(i, new ItemStack(wool.asItem()));

            } else if (source.getPlayer().getInventory().getStack(i).getName().getString().contains("Glass")) {
                source.getPlayer().getInventory().setStack(i, new ItemStack(glass.asItem()));
            }
        }




        return 1;
    }
}
