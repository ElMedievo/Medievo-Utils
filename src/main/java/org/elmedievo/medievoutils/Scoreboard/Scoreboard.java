package org.elmedievo.medievoutils.Scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.elmedievo.medievoutils.MedievoUtils;

import java.util.Collection;

import static org.elmedievo.medievoutils.Configuration.ReloadConfig.reloadConfig;

public class Scoreboard implements Listener {
    private final MedievoUtils plugin;

    private Scoreboard(MedievoUtils instance) {
        plugin = instance;
    }

    private static String rawScoreboardTitle;
    private static String rawScoreboardWeb;
    private static String coloredTitle;
    private static String coloredWeb;

    public static void loadScoreboardParams() {
        rawScoreboardTitle = MedievoUtils.instance.getConfig().getString("Scoreboard.title");
        rawScoreboardWeb = MedievoUtils.instance.getConfig().getString("Scoreboard.server-web");
        coloredTitle = ChatColor.translateAlternateColorCodes('&', rawScoreboardTitle);
        coloredWeb = ChatColor.translateAlternateColorCodes('&', rawScoreboardWeb);
    }

    private static void createScoreboard(Player player) {
        ScoreboardAPI scoreboard = ScoreboardAPI.createScore(player);
        scoreboard.setTitle(coloredTitle);
        scoreboard.setSlot(3, " ");
        scoreboard.setSlot(2, " ");
        scoreboard.setSlot(1, " ");
        scoreboard.setSlot(0, coloredWeb);
        reloadConfig();
        updateScoreboard(player, coloredTitle, coloredWeb);
    }

    private static void updateScoreboard(Player player, String title, String web) {
        ScoreboardAPI scoreboard = ScoreboardAPI.createScore(player);
        coloredTitle = title;
        coloredWeb = web;
        scoreboard.setTitle(title);
        scoreboard.setSlot(9, " ");
        scoreboard.setSlot(8, ChatColor.WHITE + "Server: " + ChatColor.WHITE + "[" + ChatColor.GOLD + "US" + ChatColor.WHITE + "]" + ChatColor.RESET);
        scoreboard.setSlot(7, " ");
        scoreboard.setSlot(6, ChatColor.WHITE + "Nick: " + ChatColor.RESET + player.getDisplayName() + ChatColor.RESET);
        scoreboard.setSlot(5, " ");
        scoreboard.setSlot(4, ChatColor.WHITE + "Clan: ");
        scoreboard.setSlot(3, ChatColor.GREEN + " »" + ChatColor.WHITE + " Name: " + ChatColor.DARK_AQUA + "soon..." + ChatColor.RESET );
        scoreboard.setSlot(2, ChatColor.GREEN + " »" + ChatColor.WHITE + " Gold: " + ChatColor.DARK_AQUA + "soon..." + ChatColor.RESET);
        scoreboard.setSlot(1, " ");
        scoreboard.setSlot(0, web);
    }

    private static void updateScoreboardAll(String title, String web) {
        Collection<? extends Player> onlinePlayers = Bukkit.getServer().getOnlinePlayers();
        onlinePlayers.forEach(player -> updateScoreboard(player, title, web));
    }

    public static void touchScoreboard() {
        reloadConfig();
        rawScoreboardTitle = MedievoUtils.instance.getConfig().getString("Scoreboard.title");
        rawScoreboardWeb = MedievoUtils.instance.getConfig().getString("Scoreboard.server-web");
        org.elmedievo.medievoutils.Scoreboard.Scoreboard.coloredTitle = ChatColor.translateAlternateColorCodes('&', rawScoreboardTitle);
        org.elmedievo.medievoutils.Scoreboard.Scoreboard.coloredWeb = ChatColor.translateAlternateColorCodes('&', rawScoreboardWeb);
        updateScoreboardAll(org.elmedievo.medievoutils.Scoreboard.Scoreboard.coloredTitle, org.elmedievo.medievoutils.Scoreboard.Scoreboard.coloredWeb);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        createScoreboard(player);
        touchScoreboard();
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if (ScoreboardAPI.hasScore(player)) {
            ScoreboardAPI.removeScore(player);
        }
    }

    public static void registerScoreboardEvents() {
        Bukkit.getPluginManager().registerEvents(new Scoreboard(MedievoUtils.instance), MedievoUtils.instance);
    }
}
