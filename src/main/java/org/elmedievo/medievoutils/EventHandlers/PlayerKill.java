package org.elmedievo.medievoutils.EventHandlers;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.elmedievo.medievoutils.MedievoUtils;

public class PlayerKill implements Listener {

    private final MedievoUtils plugin;

    private PlayerKill(MedievoUtils instance) {
        plugin = instance;
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerDeath(PlayerDeathEvent event) {
        Player dead_player = event.getEntity();
        World world = dead_player.getWorld();
        world.playSound(dead_player.getLocation(), Sound.ENTITY_BLAZE_DEATH, 10, 1);
        Entity killer = event.getEntity().getKiller();

        ItemStack skullItem = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
        SkullMeta skullMeta = (SkullMeta) skullItem.getItemMeta();
        skullMeta.setDisplayName(ChatColor.GRAY + "Cabeza Medieval de: " + dead_player.getDisplayName());
        skullMeta.setOwner(dead_player.getName());
        skullItem.setItemMeta(skullMeta);
        event.getDrops().add(skullItem);

        if (killer != null) {
            killer.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "+1 Kill " + ChatColor.DARK_PURPLE + "| " + ChatColor.GRAY + "killed " + ChatColor.YELLOW + dead_player.getDisplayName());
            event.setDeathMessage(ChatColor.YELLOW + dead_player.getName() + ChatColor.GRAY + " was killed by " + ChatColor.YELLOW + ((Player) killer).getDisplayName());
        } else {
            String dead_msg = event.getDeathMessage();
            event.setDeathMessage(ChatColor.DARK_RED + "⚔ " + ChatColor.RED + dead_msg);
        }
    }

    public static void registerPlayerKillEvent() {
        Bukkit.getPluginManager().registerEvents(new PlayerKill(MedievoUtils.instance), MedievoUtils.instance);
    }
}
