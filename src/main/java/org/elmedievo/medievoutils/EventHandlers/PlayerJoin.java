package org.elmedievo.medievoutils.EventHandlers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.elmedievo.medievoutils.MedievoUtils;

public class PlayerJoin implements Listener {
    private final MedievoUtils plugin;

    private PlayerJoin(MedievoUtils instance) {
        plugin = instance;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public static void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (MedievoUtils.instance.getConfig().getBoolean("General.enable-welcoming")) {
            String welcome_msg = MedievoUtils.instance.getConfig().getString("General.welcome-msg").replaceAll("%l%", "\n");
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', welcome_msg));
        }
    }

    public static void registerPlayerJoinEvent() {
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoin(MedievoUtils.instance), MedievoUtils.instance);
    }
}
