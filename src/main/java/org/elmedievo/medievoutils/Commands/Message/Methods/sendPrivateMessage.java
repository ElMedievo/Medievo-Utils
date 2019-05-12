package org.elmedievo.medievoutils.Commands.Message.Methods;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import static org.elmedievo.medievoutils.Commands.Message.MessageReplyQueue.messageReplyQueue;
import static org.elmedievo.medievoutils.util.Generic.NO_PLAYERS_MATCHED;
import static org.elmedievo.medievoutils.util.Generic.PM_PREFIX;
import static org.elmedievo.medievoutils.util.Methods.PlayerIsOnline.playerIsOnline;

public class sendPrivateMessage {
    @SuppressWarnings("deprecation")
    public static void sendPlayerMessageToPlayer(Player sender, String receiverInput, String msg) {
        if (playerIsOnline(receiverInput)) {
            Player receiver = Bukkit.getPlayer(receiverInput);
            messageReplyQueue.put(sender.getName(), receiver.getName());
            messageReplyQueue.put(receiver.getName(), sender.getName());
            if (sender.hasPermission("medievo.chat.color")) {
                sender.sendMessage(PM_PREFIX + ChatColor.GRAY + "To " + receiver.getDisplayName() + ChatColor.GRAY + ": " + ChatColor.RESET + ChatColor.translateAlternateColorCodes ('&', msg));
                receiver.sendMessage(PM_PREFIX + ChatColor.GRAY + "From " + sender.getDisplayName() + ChatColor.GRAY + ": " + ChatColor.RESET + ChatColor.translateAlternateColorCodes ('&', msg));
            } else {
                sender.sendMessage(PM_PREFIX + ChatColor.GRAY + "To " + receiver.getDisplayName() + ChatColor.GRAY + ": " + ChatColor.RESET +  msg);
                receiver.sendMessage(PM_PREFIX + ChatColor.GRAY + "From " + sender.getDisplayName() + ChatColor.GRAY + ": " + ChatColor.RESET + msg);
            }
            receiver.playSound(receiver.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 5, 2);
        } else {
            sender.sendMessage(NO_PLAYERS_MATCHED);
        }
    }
}
