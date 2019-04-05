package com.bgmbox.medievoutils.Commands;

import com.bgmbox.medievoutils.MedievoUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static com.bgmbox.medievoutils.util.Generic.BROADCAST_PREFIX;
import static com.bgmbox.medievoutils.util.Generic.NO_PERMISSION;
import static com.bgmbox.medievoutils.util.Methods.ConjoinCommandArgs.buildMessageFromCommandArgs;

public class Broadcast implements CommandExecutor {

    private final MedievoUtils plugin;

    private Broadcast(MedievoUtils instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("broadcast") && sender.hasPermission("medievo.utils.broadcast")) {
            String msg = buildMessageFromCommandArgs(args, 0);
            String colored_msg = (ChatColor.translateAlternateColorCodes ('&', msg));
            Bukkit.broadcastMessage(BROADCAST_PREFIX + colored_msg);
        } else {
            sender.sendMessage(NO_PERMISSION);
        }
        return true;
    }

    public static void registerBroadcastCommand() {
        MedievoUtils.instance.getCommand("broadcast").setExecutor(new Broadcast(MedievoUtils.instance));
    }
}
