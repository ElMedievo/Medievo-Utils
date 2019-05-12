package org.elmedievo.medievoutils.Commands.Restart;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.elmedievo.medievoutils.MedievoUtils;

import static org.elmedievo.medievoutils.Commands.Restart.RestartTask.restarting;
import static org.elmedievo.medievoutils.util.Generic.COUNTDOWNS_CANCELLED;
import static org.elmedievo.medievoutils.util.Generic.NO_PERMISSION;
import static org.elmedievo.medievoutils.util.Generic.TOO_MANY_ARGS;

public class Cancel implements CommandExecutor {

    private final MedievoUtils plugin;

    private Cancel(MedievoUtils instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("cancel") && sender.hasPermission("medievo.utils.cancel")) {
            if (args.length == 0) {
                restarting = false;
                Bukkit.broadcastMessage(COUNTDOWNS_CANCELLED);
            } else {
                sender.sendMessage(TOO_MANY_ARGS);
            }
        } else {
            sender.sendMessage(NO_PERMISSION);
        }
        return true;
    }

    public static void registerCancelCommand() {
        MedievoUtils.instance.getCommand("cancel").setExecutor(new Cancel(MedievoUtils.instance));
    }
}
