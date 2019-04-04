package com.bgmbox.medievoutils;

import org.bukkit.plugin.java.JavaPlugin;

import static com.bgmbox.medievoutils.util.CommandRegistry.registerCommands;
import static com.bgmbox.medievoutils.util.EventRegistry.registerEvents;

public final class MedievoUtils extends JavaPlugin {

    public static MedievoUtils instance;

    @Override
    public void onEnable() {
        instance = this;
        registerCommands();
        registerEvents();

    }

    @Override
    public void onDisable() {

    }
}
