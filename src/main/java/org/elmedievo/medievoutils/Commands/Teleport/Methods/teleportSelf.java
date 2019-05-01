package org.elmedievo.medievoutils.Commands.Teleport.Methods;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import static org.elmedievo.medievoutils.util.Generic.WARNING_ICON;
import static org.elmedievo.medievoutils.util.Methods.PlayerIsOnline.playerIsOnline;

public class teleportSelf {
    public static void teleportSelf(Player player, Player player2) {
        if (playerIsOnline(player2.getName())) {
            player.teleport(player2);
            player.sendMessage(ChatColor.YELLOW + "Teleported to " + player2.getDisplayName());
        } else {
            player.sendMessage(WARNING_ICON + ChatColor.DARK_AQUA + player2.getName() + ChatColor.RED + " is currently offline or is invalid.");
        }
    }
}
