package com.bgmbox.medievoutils.Commands.Gamemode.Methods;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import static com.bgmbox.medievoutils.util.Generic.NO_GAMEMODE_MATCHED;

public class setGamemodeSelf {
    public static void setOwnGamemode(Player player, String gamemode) {
        if (gamemode.equalsIgnoreCase("0") || gamemode.equalsIgnoreCase("survival")) {
            player.setGameMode(GameMode.SURVIVAL);
            player.sendMessage(ChatColor.YELLOW + "Gamemode set to SURVIVAL");
        } else if (gamemode.equalsIgnoreCase("1") || gamemode.equalsIgnoreCase("creative")) {
            player.setGameMode(GameMode.CREATIVE);
            player.sendMessage(ChatColor.YELLOW + "Gamemode set to CREATIVE");
        } else if (gamemode.equalsIgnoreCase("2") || gamemode.equalsIgnoreCase("adventure")) {
            player.setGameMode(GameMode.ADVENTURE);
            player.sendMessage(ChatColor.YELLOW + "Gamemode set to ADVENTURE");
        } else if (gamemode.equalsIgnoreCase("3") || gamemode.equalsIgnoreCase("spectator")) {
            player.setGameMode(GameMode.SPECTATOR);
            player.sendMessage(ChatColor.YELLOW + "Gamemode set to SPECTATOR");
        } else {
            player.sendMessage(NO_GAMEMODE_MATCHED);
        }
    }
}
