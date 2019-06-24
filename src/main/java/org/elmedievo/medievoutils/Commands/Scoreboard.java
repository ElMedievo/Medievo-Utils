package org.elmedievo.medievoutils.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.elmedievo.medievoutils.MedievoUtils;

import static org.elmedievo.medievoutils.Scoreboard.Scoreboard.*;
import static org.elmedievo.medievoutils.util.Generic.*;

public class Scoreboard implements CommandExecutor {

    private final MedievoUtils plugin;

    private Scoreboard(MedievoUtils instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("reloadscoreboard") && sender.hasPermission("medievo.utils.scoreboard")) {
            if (args.length == 0) {
                touchScoreboard();
                sender.sendMessage(RELOADED_SCOREBOARD);
            } else {
                sender.sendMessage(TOO_MANY_ARGS);
            }
        } else {
            sender.sendMessage(NO_PERMISSION);
        }
        return true;
    }

    public static void registerScoreboardCommand() {
        MedievoUtils.instance.getCommand("reloadscoreboard").setExecutor(new Scoreboard(MedievoUtils.instance));
    }
}
