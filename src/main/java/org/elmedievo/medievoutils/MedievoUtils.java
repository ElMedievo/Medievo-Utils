package org.elmedievo.medievoutils;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.elmedievo.medievoutils.util.Methods.ConsoleAlerts;

import static org.elmedievo.medievoutils.Commands.Message.MessageReplyQueue.loadMessageReplyQueue;
import static org.elmedievo.medievoutils.util.CommandRegistry.registerCommands;
import static org.elmedievo.medievoutils.util.EventRegistry.registerEvents;

public final class MedievoUtils extends JavaPlugin {

    public static MedievoUtils instance;

    @Override
    public void onEnable() {
        instance = this;
        ConsoleAlerts.sendConsoleAlert(ChatColor.GREEN + "-----" + " Medievo-Utils " + "-----");
        registerCommands();
        registerEvents();
        loadMessageReplyQueue();
        ConsoleAlerts.sendConsoleAlert(ChatColor.GREEN + "Medievo-Utils was successfully enabled");
        ConsoleAlerts.sendConsoleAlert(ChatColor.GREEN + "-------------------------");
    }

    @Override
    public void onDisable() {

    }
}
