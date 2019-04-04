package com.bgmbox.medievoutils.Commands.Gamemode.Methods;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class getOwnGamemode {
    public static void tellOwnGamemode(Player player) {
        String gamemode = player.getGameMode().toString();
        switch (gamemode) {
            case "SURVIVAL":
                player.sendMessage(ChatColor.YELLOW + "Your current gamemode is SURVIVAL");
                break;
            case "CREATIVE":
                player.sendMessage(ChatColor.YELLOW + "Your current gamemode is CREATIVE");
                break;
            case "ADVENTURE":
                player.sendMessage(ChatColor.YELLOW + "Your current gamemode is ADVENTURE");
                break;
            case "SPECTATOR":
                player.sendMessage(ChatColor.YELLOW + "Your current gamemode is SPECTATOR");
                break;
        }
    }
}
