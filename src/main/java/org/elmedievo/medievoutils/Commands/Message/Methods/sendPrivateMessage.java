package org.elmedievo.medievoutils.Commands.Message.Methods;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import static org.elmedievo.medievoutils.Commands.Message.MessageReplyQueue.messageReplyQueue;
import static org.elmedievo.medievoutils.util.Generic.PM_PREFIX;
import static org.elmedievo.medievoutils.util.Methods.PlayerIsOnline.playerIsOnline;

public class sendPrivateMessage {
    @SuppressWarnings("deprecation")
    public static void sendPlayerMessageToPlayer(Player sender, String receiverInput, String msg) {
        if (playerIsOnline(receiverInput)) {
            Player receiver = Bukkit.getPlayer(receiverInput);
            messageReplyQueue.put(sender.getName(), receiver.getName());

            sender.sendMessage(PM_PREFIX + ChatColor.GRAY + "To " + receiver.getDisplayName() + ChatColor.WHITE + ": " + msg);
            receiver.sendMessage(PM_PREFIX + ChatColor.GRAY + "From " + sender.getDisplayName() + ChatColor.WHITE + ": " + msg);
        }
    }
}
