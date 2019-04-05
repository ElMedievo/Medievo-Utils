package com.bgmbox.medievoutils.util.Methods;

import org.bukkit.Bukkit;

public class ConsoleAlerts {
    public static void sendConsoleAlert(String msg) {
        Bukkit.getServer().getConsoleSender().sendMessage(msg);
    }
}
