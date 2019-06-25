package org.elmedievo.medievoutils.Commands.Teleport.Methods;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.elmedievo.medievoutils.util.Generic.CONSOLE_PREFIX;
import static org.elmedievo.medievoutils.util.Generic.NO_PLAYERS_MATCHED;
import static org.elmedievo.medievoutils.util.Generic.WARNING_ICON;
import static org.elmedievo.medievoutils.util.Methods.ConsoleAlerts.sendConsoleAlert;
import static org.elmedievo.medievoutils.util.Methods.PlayerIsOnline.playerIsOnline;

public class teleportOther {
    @SuppressWarnings("deprecation")
    public static void teleportOther(CommandSender teleporter, String inputForPlayer1, String inputForPlayer2) {
        if (playerIsOnline(inputForPlayer1) && playerIsOnline(inputForPlayer2)) {
            Player player1 = Bukkit.getServer().getPlayer(inputForPlayer1);
            Player player2 = Bukkit.getServer().getPlayer(inputForPlayer2);
            player1.teleport(player2);
            if (teleporter instanceof Player) {
                teleporter.sendMessage(ChatColor.YELLOW + "Teleported " + player1.getDisplayName() + ChatColor.YELLOW + " to " + player2.getDisplayName());
            } else {
                sendConsoleAlert(CONSOLE_PREFIX + ChatColor.YELLOW + "Teleported " + player1.getDisplayName() + ChatColor.YELLOW + " to " + player2.getDisplayName());
            }
        } else {
            teleporter.sendMessage(NO_PLAYERS_MATCHED);
        }
    }
}
