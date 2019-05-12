package org.elmedievo.medievoutils.Commands.Restart;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.elmedievo.medievoutils.MedievoUtils;

class RestartTask {
    static boolean restarting = false;
    static int defaultRestartTime = MedievoUtils.instance.getConfig().getInt("restart");

    static String evalPluralSecond(Integer second) {
        if (second == 1) {
            return "second";
        }
        else return "seconds";
    }

    @SuppressWarnings("deprecation")
    private static void announceRestartTimeRemaining(Integer second) {
        if (second % 10 == 0 || second == 1 || second == 2 || second == 3 || second == 4 || second == 5) {
            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                player.sendTitle(ChatColor.AQUA + "Restarting in...", ChatColor.RED + second.toString() + " " + evalPluralSecond(second));
            }
            Bukkit.broadcastMessage(String.valueOf(ChatColor.AQUA) + "Server restarting in " + ChatColor.DARK_RED + second + ChatColor.AQUA + " " + evalPluralSecond(second));
        }
    }

    @SuppressWarnings("deprecation")
    static void beginRestartCountdown(Integer seconds) {
        new BukkitRunnable() {
            int time = seconds;
            @Override
            public void run() {
                if (restarting) {
                    if (time == 0) {
                        Bukkit.broadcastMessage(ChatColor.AQUA + "Server is restarting!");
                        restarting = false;
                        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                            player.sendTitle(ChatColor.AQUA + "Server restarting!", "");
                        }
                        Bukkit.getServer().shutdown();
                        this.cancel();
                        return;
                    }
                    announceRestartTimeRemaining(time);
                    time--;
                } else {
                    this.cancel();
                }
            }
        }.runTaskTimer(MedievoUtils.instance, 0L, 20L);
    }
}
