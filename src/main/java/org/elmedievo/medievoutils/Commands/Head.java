package org.elmedievo.medievoutils.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.elmedievo.medievoutils.MedievoUtils;

import static org.elmedievo.medievoutils.util.Generic.*;

public class Head implements CommandExecutor {

    private final MedievoUtils plugin;

    private Head(MedievoUtils instance) {
        plugin = instance;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("head") && sender.hasPermission("medievo.utils.head")) {
            if (sender instanceof Player) {
                if (args.length == 1) {
                    Player player = (Player) sender;
                    String skullOwner = args[0];
                    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
                    SkullMeta skullMeta = (SkullMeta) skullItem.getItemMeta();
                    skullMeta.setOwner(skullOwner);
                    skullItem.setItemMeta(skullMeta);
                    player.getInventory().addItem(skullItem);
                    player.sendMessage(ChatColor.AQUA + "Given " + ChatColor.YELLOW + args[0] + ChatColor.AQUA + "'s head");
                } else if (args.length < 1) {
                    sender.sendMessage(TOO_FEW_ARGS);
                } else {
                    sender.sendMessage(TOO_MANY_ARGS);
                }
            } else {
                sender.sendMessage(NO_CONSOLE);
            }
        } else {
            sender.sendMessage(NO_PERMISSION);
        }
        return true;
    }

    public static void registerHeadCommand() {
        MedievoUtils.instance.getCommand("head").setExecutor(new Head(MedievoUtils.instance));
    }
}
