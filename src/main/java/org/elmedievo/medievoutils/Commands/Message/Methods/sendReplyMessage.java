package org.elmedievo.medievoutils.Commands.Message.Methods;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import static org.elmedievo.medievoutils.Commands.Message.MessageReplyQueue.messageReplyQueue;
import static org.elmedievo.medievoutils.util.Generic.NOBODY_TO_REPLY_TO;
import static org.elmedievo.medievoutils.util.Generic.NO_PLAYERS_MATCHED;
import static org.elmedievo.medievoutils.util.Generic.PM_PREFIX;
import static org.elmedievo.medievoutils.util.Methods.PlayerIsOnline.playerIsOnline;

public class sendReplyMessage {
    @SuppressWarnings("deprecation")
    public static void reply(Player sender, String msg) {
        String receiver = messageReplyQueue.get(sender.getName());
        if (receiver != null) {
            if (playerIsOnline(receiver)) {
                Player receiverPlayer = Bukkit.getPlayer(receiver);
                if (sender.hasPermission("medievo.chat.color")) {
                    sender.sendMessage(PM_PREFIX + ChatColor.GRAY + "To " + receiverPlayer.getDisplayName() + ChatColor.GRAY + ": " +  ChatColor.RESET + ChatColor.translateAlternateColorCodes ('&', msg));
                    receiverPlayer.sendMessage(PM_PREFIX + ChatColor.GRAY + "From " + sender.getDisplayName() + ChatColor.GRAY + ": " + ChatColor.RESET + ChatColor.translateAlternateColorCodes ('&', msg));
                } else {
                    sender.sendMessage(PM_PREFIX + ChatColor.GRAY + "To " + receiverPlayer.getDisplayName() + ChatColor.GRAY + ": " + ChatColor.RESET + msg);
                    receiverPlayer.sendMessage(PM_PREFIX + ChatColor.GRAY + "From " + sender.getDisplayName() + ChatColor.GRAY + ": " + ChatColor.RESET + msg);
                }
                receiverPlayer.playSound(receiverPlayer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 5, 2);
            } else {
                sender.sendMessage(NO_PLAYERS_MATCHED);
            }
        } else {
            sender.sendMessage(NOBODY_TO_REPLY_TO);
        }
    }
}
