package com.bgmbox.medievoutils;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import static com.bgmbox.medievoutils.util.CommandRegistry.registerCommands;
import static com.bgmbox.medievoutils.util.EventRegistry.registerEvents;
import static com.bgmbox.medievoutils.util.Methods.ConsoleAlerts.sendConsoleAlert;

public final class MedievoUtils extends JavaPlugin {

    public static MedievoUtils instance;

    @Override
    public void onEnable() {
        instance = this;
        sendConsoleAlert(ChatColor.GREEN + "-----" + " Medievo-Utils " + "-----");
        registerCommands();
        registerEvents();
        sendConsoleAlert(ChatColor.GREEN + "Medievo-Utils was successfully enabled");
        sendConsoleAlert(ChatColor.GREEN + "-------------------------");
    }

    @Override
    public void onDisable() {

    }
}
