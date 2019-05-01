package org.elmedievo.medievoutils.Commands.Message;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.elmedievo.medievoutils.MedievoUtils;

import static org.elmedievo.medievoutils.Commands.Message.Methods.sendReplyMessage.reply;
import static org.elmedievo.medievoutils.util.Generic.NO_CONSOLE;
import static org.elmedievo.medievoutils.util.Methods.ConjoinCommandArgs.buildMessageFromCommandArgs;

public class Reply implements CommandExecutor {

    private final MedievoUtils plugin;

    private Reply(MedievoUtils instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("reply")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                String msg = buildMessageFromCommandArgs(args, 0);
                reply(player, msg);
            } else {
                sender.sendMessage(NO_CONSOLE);
            }
        }
        return true;
    }

    public static void registerReplyCommand() {
        MedievoUtils.instance.getCommand("reply").setExecutor(new Reply(MedievoUtils.instance));
    }
}
