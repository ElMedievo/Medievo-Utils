package org.elmedievo.medievoutils.Commands.Gamemode.Methods;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import static org.elmedievo.medievoutils.util.Generic.NO_GAMEMODE_MATCHED;
import static org.elmedievo.medievoutils.util.Generic.WARNING_ICON;
import static org.elmedievo.medievoutils.util.Methods.PlayerIsOnline.playerIsOnline;

public class setGamemodeOther {
    public static void setGamemodeOther(Player player1, String player2_name, String gamemode) {
        if (playerIsOnline(player2_name, false)) {
            Player player2 = Bukkit.getServer().getPlayer(player2_name);
            if (gamemode.equalsIgnoreCase("0") || gamemode.equalsIgnoreCase("survival")) {
                player2.setGameMode(GameMode.SURVIVAL);
                player2.sendMessage(ChatColor.YELLOW + "Gamemode set to SURVIVAL by: " + player1.getDisplayName());
                player1.sendMessage(ChatColor.YELLOW + "Set gamemode SURVIVAL for: " + player2.getDisplayName());
            } else if (gamemode.equalsIgnoreCase("1") || gamemode.equalsIgnoreCase("creative")) {
                player2.setGameMode(GameMode.CREATIVE);
                player2.sendMessage(ChatColor.YELLOW + "Gamemode set to CREATIVE by: " + player1.getDisplayName());
                player1.sendMessage(ChatColor.YELLOW + "Set gamemode CREATIVE for: " + player2.getDisplayName());
            } else if (gamemode.equalsIgnoreCase("2") || gamemode.equalsIgnoreCase("adventure")) {
                player2.setGameMode(GameMode.ADVENTURE);
                player2.sendMessage(ChatColor.YELLOW + "Gamemode set to ADVENTURE by: " + player1.getDisplayName());
                player1.sendMessage(ChatColor.YELLOW + "Set gamemode ADVENTURE for: " + player2.getDisplayName());
            } else if (gamemode.equalsIgnoreCase("3") || gamemode.equalsIgnoreCase("spectator")) {
                player2.setGameMode(GameMode.SPECTATOR);
                player2.sendMessage(ChatColor.YELLOW + "Gamemode set to SPECTATOR by: " + player1.getDisplayName());
                player1.sendMessage(ChatColor.YELLOW + "Set gamemode SPECTATOR for: " + player2.getDisplayName());
            } else {
                player1.sendMessage(NO_GAMEMODE_MATCHED);
            }
        } else {
            player1.sendMessage(WARNING_ICON + ChatColor.DARK_AQUA + player2_name + ChatColor.RED + " is currently offline or is invalid.");
        }
    }
}
