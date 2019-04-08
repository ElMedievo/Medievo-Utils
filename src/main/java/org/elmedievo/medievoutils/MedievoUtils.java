package org.elmedievo.medievoutils;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.elmedievo.medievoutils.util.CommandRegistry;
import org.elmedievo.medievoutils.util.EventRegistry;
import org.elmedievo.medievoutils.util.Methods.ConsoleAlerts;

public final class MedievoUtils extends JavaPlugin {

    public static MedievoUtils instance;

    @Override
    public void onEnable() {
        instance = this;
        ConsoleAlerts.sendConsoleAlert(ChatColor.GREEN + "-----" + " Medievo-Utils " + "-----");
        CommandRegistry.registerCommands();
        EventRegistry.registerEvents();
        ConsoleAlerts.sendConsoleAlert(ChatColor.GREEN + "Medievo-Utils was successfully enabled");
        ConsoleAlerts.sendConsoleAlert(ChatColor.GREEN + "-------------------------");
    }

    @Override
    public void onDisable() {

    }
}
