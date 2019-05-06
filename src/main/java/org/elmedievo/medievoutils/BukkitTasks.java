package org.elmedievo.medievoutils;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

class BukkitTasks {
    static void setGameParams() {
        new BukkitRunnable() {
            @Override
            public void run() {
                World world = Bukkit.getWorld("world");
                world.setDifficulty(Difficulty.HARD);
                this.cancel();
            }
        }.runTaskTimer(MedievoUtils.instance, 0L, 0L);
    }
}