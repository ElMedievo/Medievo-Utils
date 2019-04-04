package com.bgmbox.medievoutils.util;

import static com.bgmbox.medievoutils.Commands.Broadcast.registerBroadcastCommand;
import static com.bgmbox.medievoutils.Commands.Gamemode.Gamemode.registerGamemodeCommand;

public class CommandRegistry {
    public static void registerCommands() {
        registerGamemodeCommand();
        registerBroadcastCommand();
    }
}
