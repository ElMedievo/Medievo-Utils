package org.elmedievo.medievoutils;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

class BukkitTasks {
    @SuppressWarnings("deprecation")
    static void setGameParams() {
        /* TODO: Make this configurable */
        Bukkit.getServer().addRecipe(new FurnaceRecipe(new ItemStack(Material.LEATHER), Material.ROTTEN_FLESH, 0,1200));
        /* Medieval gold foundry mechanics */
        Bukkit.getServer().addRecipe(new FurnaceRecipe(new ItemStack(Material.GOLD_INGOT, 5), Material.GOLD_HELMET));
        Bukkit.getServer().addRecipe(new FurnaceRecipe(new ItemStack(Material.GOLD_INGOT, 8), Material.GOLD_CHESTPLATE));
        Bukkit.getServer().addRecipe(new FurnaceRecipe(new ItemStack(Material.GOLD_INGOT, 7), Material.GOLD_LEGGINGS));
        Bukkit.getServer().addRecipe(new FurnaceRecipe(new ItemStack(Material.GOLD_INGOT, 5), Material.GOLD_BOOTS));
        Bukkit.getServer().addRecipe(new FurnaceRecipe(new ItemStack(Material.GOLD_INGOT, 2), Material.GOLD_SWORD));
        Bukkit.getServer().addRecipe(new FurnaceRecipe(new ItemStack(Material.GOLD_INGOT, 3), Material.GOLD_PICKAXE));
        Bukkit.getServer().addRecipe(new FurnaceRecipe(new ItemStack(Material.GOLD_INGOT), Material.GOLD_SPADE));
        Bukkit.getServer().addRecipe(new FurnaceRecipe(new ItemStack(Material.GOLD_INGOT, 2), Material.GOLD_HOE));
        Bukkit.getServer().addRecipe(new FurnaceRecipe(new ItemStack(Material.GOLD_INGOT, 20), Material.GOLD_BARDING));
        Bukkit.getServer().addRecipe(new FurnaceRecipe(new ItemStack(Material.GOLDEN_APPLE, 8), Material.GOLDEN_APPLE));
        Bukkit.getServer().addRecipe(new FurnaceRecipe(new ItemStack(Material.GOLD_NUGGET, 8), Material.GOLDEN_CARROT));
        /* Medieval gold foundry mechanics */
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