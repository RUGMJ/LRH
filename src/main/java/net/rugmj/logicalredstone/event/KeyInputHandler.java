package net.rugmj.logicalredstone.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import net.rugmj.logicalredstone.StateManager;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATERGORY_LRH = "key.category.logicalredstone.lrh";
    public static final String KEY_TOGGLE_PLACE_DUST_ON_WOOL = "key.logicalredstone.place_dust_on_wool";

    public static KeyBinding placeDustOnWoolKey;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(placeDustOnWoolKey.wasPressed()) {
                StateManager.toggleAutoDustState();
                if (StateManager.getAutoDustState()) {
                    client.player.sendMessage(Text.of("§a Autodust Enabled"), true);
                } else client.player.sendMessage(Text.of("§4 Autodust Disabled"), true);
            }
        });
    }

    public static void register() {
        placeDustOnWoolKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_TOGGLE_PLACE_DUST_ON_WOOL,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_O,
                KEY_CATERGORY_LRH
        ));

        registerKeyInputs();
    }

}
