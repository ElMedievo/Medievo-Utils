package org.elmedievo.medievoutils.util;

import org.bukkit.ChatColor;

public class Generic {

    public static String CONSOLE_PREFIX = ChatColor.GOLD + "❖" + ChatColor.DARK_AQUA + "Console";
    public static String BROADCAST_PREFIX = ChatColor.WHITE + "[" + ChatColor.GOLD + "Broadcast" + ChatColor.WHITE + "] " + ChatColor.RESET;

    public static String PM_PREFIX = ChatColor.WHITE + "[" + ChatColor.GOLD + "MSG" + ChatColor.WHITE + "] ";

    public static String WARNING_ICON = ChatColor.YELLOW + "⚠ ";

    private static String chatErrorPrefix = ChatColor.YELLOW + "⚠ " + ChatColor.RED;
    private static String consoleErrorPrefix = ChatColor.RED + "";
    public static String
            NO_GAMEMODE_MATCHED = chatErrorPrefix + "No gamemode matched query.",
            NO_PLAYERS_MATCHED = chatErrorPrefix + "No players matched query.",
            TOO_MANY_ARGS = chatErrorPrefix + "Too many arguments.",
            TOO_FEW_ARGS = chatErrorPrefix + "Too few arguments.",
            NO_CONSOLE = consoleErrorPrefix + "You must be a player to execute this command.",
            NO_PERMISSION = chatErrorPrefix + "You do not have permission.",
            INVALID_COORDINATES = chatErrorPrefix + "Invalid coordinates.",
            NOBODY_TO_REPLY_TO = chatErrorPrefix + "You have nobody to reply to.";

    private static String successPrefix = ChatColor.GREEN + "";
    public static String
            FLY_TOGGLED_ON = ChatColor.YELLOW + "You can now fly!",
            FLY_TOGGLED_ON_OTHER = ChatColor.YELLOW + "Fly mode enabled for " + ChatColor.RESET,
            FLY_TOGGLED_OFF = ChatColor.YELLOW + "You can no longer fly!",
            FLY_TOGGLED_OFF_OTHER = ChatColor.YELLOW + "Fly mode disabled for " + ChatColor.RESET;
}
