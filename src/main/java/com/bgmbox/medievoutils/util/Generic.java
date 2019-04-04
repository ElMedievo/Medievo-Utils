package com.bgmbox.medievoutils.util;

import org.bukkit.ChatColor;

public class Generic {

    public static String BROADCAST_PREFIX = ChatColor.WHITE + "[" + ChatColor.GOLD + "Broadcast" + ChatColor.WHITE + "] " + ChatColor.RESET;

    public static String WARNING_ICON = ChatColor.YELLOW + "⚠ ";

    private static String chatErrorPrefix = ChatColor.YELLOW + "⚠ " + ChatColor.RED;
    private static String consoleErrorPrefix = ChatColor.RED + "";
    public static String
            NO_GAMEMODE_MATCHED = chatErrorPrefix + "No gamemode matched query",
            TOO_MANY_ARGS = chatErrorPrefix + "Too many arguments.",
            NO_CONSOLE = consoleErrorPrefix + "You must be a player to execute this command.",
            NO_PERMISSION = chatErrorPrefix + "You do not have permission.";
}
