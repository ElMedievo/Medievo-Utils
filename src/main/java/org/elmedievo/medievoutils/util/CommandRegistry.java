package org.elmedievo.medievoutils.util;

import static org.elmedievo.medievoutils.Commands.Broadcast.registerBroadcastCommand;
import static org.elmedievo.medievoutils.Commands.Fly.registerFlyCommand;
import static org.elmedievo.medievoutils.Commands.Gamemode.Gamemode.registerGamemodeCommand;
import static org.elmedievo.medievoutils.Commands.Head.registerHeadCommand;
import static org.elmedievo.medievoutils.Commands.Message.Message.registerMessageCommand;
import static org.elmedievo.medievoutils.Commands.Message.Reply.registerReplyCommand;
import static org.elmedievo.medievoutils.Commands.Restart.Cancel.registerCancelCommand;
import static org.elmedievo.medievoutils.Commands.Restart.Restart.registerRestartCommand;
import static org.elmedievo.medievoutils.Commands.Scoreboard.registerScoreboardCommand;
import static org.elmedievo.medievoutils.Commands.Teleport.teleport.registerTeleportCommand;

public class CommandRegistry {
    public static void registerCommands() {
        registerGamemodeCommand();
        registerBroadcastCommand();
        registerTeleportCommand();
        registerMessageCommand();
        registerReplyCommand();
        registerHeadCommand();
        registerFlyCommand();
        registerRestartCommand();
        registerCancelCommand();
        registerScoreboardCommand();
    }
}
