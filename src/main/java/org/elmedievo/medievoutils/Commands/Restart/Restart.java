package org.elmedievo.medievoutils.Commands.Restart;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.elmedievo.medievoutils.MedievoUtils;

import static org.elmedievo.medievoutils.Commands.Restart.RestartTask.*;
import static org.elmedievo.medievoutils.util.Generic.*;
import static org.elmedievo.medievoutils.util.Methods.InputValidation.isInt;

public class Restart implements CommandExecutor {

    private final MedievoUtils plugin;

    private Restart(MedievoUtils instance) {
        plugin = instance;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("restart") && sender.hasPermission("medievo.utils.restart")) {
            if (!restarting) {
                if (args.length == 0) {
                    restarting = true;
                    int defaultTime = defaultRestartTime;
                    if (defaultTime % 10 != 0) {
                        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                            player.sendTitle(ChatColor.AQUA + "Restarting in... ", ChatColor.RED + "" + defaultTime + " " + evalPluralSecond(defaultTime));
                        }
                        Bukkit.broadcastMessage(String.valueOf(ChatColor.AQUA) + "Server restarting in " + ChatColor.DARK_RED + defaultTime + " " + ChatColor.AQUA + evalPluralSecond(defaultTime));
                    }
                    beginRestartCountdown(defaultTime);
                } else if (args.length == 1) {
                    if (isInt(args[0])) {
                        restarting = true;
                        if (Integer.parseInt(args[0]) % 10 != 0) {
                            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                                player.sendTitle(ChatColor.AQUA + "Restarting in... ", ChatColor.RED + args[0] + " " + evalPluralSecond(Integer.parseInt(args[0])));
                            }
                            Bukkit.broadcastMessage(String.valueOf(ChatColor.AQUA) + "Server restarting in " + ChatColor.DARK_RED + args[0] + ChatColor.AQUA + evalPluralSecond(Integer.parseInt(args[0])));
                        }
                        beginRestartCountdown(Integer.parseInt(args[0]));
                    } else {
                        sender.sendMessage(INVALID_TIME_PERIOD);
                    }
                } else {
                    sender.sendMessage(TOO_MANY_ARGS);
                }
            } else {
                sender.sendMessage(ALREADY_RESTARTING);
            }
        } else {
            sender.sendMessage(NO_PERMISSION);
        }
        return true;
    }

    public static void registerRestartCommand() {
        MedievoUtils.instance.getCommand("restart").setExecutor(new Restart(MedievoUtils.instance));
    }
}
