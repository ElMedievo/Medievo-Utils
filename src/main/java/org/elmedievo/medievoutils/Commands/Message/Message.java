package org.elmedievo.medievoutils.Commands.Message;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.elmedievo.medievoutils.MedievoUtils;

import static org.elmedievo.medievoutils.Commands.Message.Methods.sendPrivateMessage.sendPlayerMessageToPlayer;
import static org.elmedievo.medievoutils.util.Methods.ConjoinCommandArgs.buildMessageFromCommandArgs;

public class Message implements CommandExecutor {

    private final MedievoUtils plugin;

    private Message(MedievoUtils instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("message")) {
            if (sender instanceof Player) {
                Player issuerPlayer = (Player) sender;
                String receiver = args[0];
                String msg = buildMessageFromCommandArgs(args, 1);
                sendPlayerMessageToPlayer(issuerPlayer, receiver, msg);
            }
        }
        return true;
    }

    public static void registerMessageCommand() {
        MedievoUtils.instance.getCommand("message").setExecutor(new Message(MedievoUtils.instance));
    }
}
