package org.elmedievo.medievoutils.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.elmedievo.medievoutils.MedievoUtils;

import static org.elmedievo.medievoutils.util.Generic.*;
import static org.elmedievo.medievoutils.util.Methods.PlayerIsOnline.playerIsOnline;

public class Fly implements CommandExecutor {

    private final MedievoUtils plugin;

    private Fly(MedievoUtils instance) {
        plugin = instance;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("fly") && sender.hasPermission("medievo.utils.fly")) {
            if (args.length == 0 && sender instanceof Player) {
                Player player = (Player) sender;
                if (!player.getAllowFlight()) {
                    player.setAllowFlight(true);
                    player.sendMessage(FLY_TOGGLED_ON);
                } else {
                    player.setAllowFlight(false);
                    player.sendMessage(FLY_TOGGLED_OFF);
                }
            } else if (args.length == 1) {
                if (playerIsOnline(args[0])) {
                    Player player2 = Bukkit.getServer().getPlayer(args[0]);
                    if (!player2.getAllowFlight()) {
                        player2.setAllowFlight(true);
                        player2.sendMessage(FLY_TOGGLED_ON);
                        sender.sendMessage(FLY_TOGGLED_ON_OTHER + player2.getDisplayName());
                    } else {
                        player2.setAllowFlight(false);
                        player2.sendMessage(FLY_TOGGLED_OFF);
                        sender.sendMessage(FLY_TOGGLED_OFF_OTHER + player2.getDisplayName());
                    }
                } else {
                    sender.sendMessage(NO_PLAYERS_MATCHED);
                }
            } else {
                sender.sendMessage(TOO_MANY_ARGS);
            }
        } else {
            sender.sendMessage(NO_PERMISSION);
        }
        return true;
    }

    public static void registerFlyCommand() {
        MedievoUtils.instance.getCommand("fly").setExecutor(new Fly(MedievoUtils.instance));
    }
}
