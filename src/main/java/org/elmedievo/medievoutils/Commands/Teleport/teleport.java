package org.elmedievo.medievoutils.Commands.Teleport;

import org.elmedievo.medievoutils.MedievoUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.elmedievo.medievoutils.Commands.Teleport.Methods.teleportOther.teleportOther;
import static org.elmedievo.medievoutils.Commands.Teleport.Methods.teleportSelf.teleportSelf;
import static org.elmedievo.medievoutils.Commands.Teleport.Methods.teleportToCoords.teleportOtherToCoords;
import static org.elmedievo.medievoutils.Commands.Teleport.Methods.teleportToCoords.teleportSelfToCoords;
import static org.elmedievo.medievoutils.util.Generic.NO_CONSOLE;
import static org.elmedievo.medievoutils.util.Generic.NO_PERMISSION;
import static org.elmedievo.medievoutils.util.Generic.TOO_MANY_ARGS;

public class teleport implements CommandExecutor {

    private final MedievoUtils plugin;

    private teleport(MedievoUtils instance) {
        plugin = instance;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("teleport") && sender.hasPermission("medievo.utils.teleport")) {
            if (args.length == 1) {
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    Player player2 = Bukkit.getPlayer(args[0]);
                    teleportSelf(player, player2);
                } else {
                    sender.sendMessage(NO_CONSOLE);
                }
            } else if (args.length == 2) {
                String player = args[0];
                String player2 = args[1];
                teleportOther(sender, player, player2);
            }
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 3) {
                    String x = args[0];
                    String y = args[1];
                    String z = args[2];
                    teleportSelfToCoords(player, x, y ,z);
                } else if (args.length == 4) {
                    String teleported = args[0];
                    String x = args[1];
                    String y = args[2];
                    String z = args[3];
                    teleportOtherToCoords(player, teleported, x, y, z);
                }
            } else {
                sender.sendMessage(TOO_MANY_ARGS);
            }
        } else {
            sender.sendMessage(NO_PERMISSION);
        }
        return true;
    }

    public static void registerTeleportCommand() {
        MedievoUtils.instance.getCommand("teleport").setExecutor(new teleport(MedievoUtils.instance));
    }
}
