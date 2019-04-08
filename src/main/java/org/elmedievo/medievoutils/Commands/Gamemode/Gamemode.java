package org.elmedievo.medievoutils.Commands.Gamemode;

import org.elmedievo.medievoutils.MedievoUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.elmedievo.medievoutils.Commands.Gamemode.Methods.getOwnGamemode.tellOwnGamemode;
import static org.elmedievo.medievoutils.Commands.Gamemode.Methods.setGamemodeOther.setGamemodeOther;
import static org.elmedievo.medievoutils.Commands.Gamemode.Methods.setGamemodeSelf.setOwnGamemode;
import static org.elmedievo.medievoutils.util.Generic.NO_CONSOLE;
import static org.elmedievo.medievoutils.util.Generic.NO_PERMISSION;
import static org.elmedievo.medievoutils.util.Generic.TOO_MANY_ARGS;

public class Gamemode implements CommandExecutor {

    private final MedievoUtils plugin;

    private Gamemode(MedievoUtils instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("gamemode") && sender.hasPermission("medievo.utils.gamemode")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                String gamemode;
                if (args.length == 0) {
                    tellOwnGamemode(player);
                } else if (args.length == 1) {
                    gamemode = args[0];
                    setOwnGamemode(player, gamemode);
                } else if (args.length == 2) {
                    gamemode = args[0];
                    setGamemodeOther(player, args[1], gamemode);
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

    public static void registerGamemodeCommand() {
        MedievoUtils.instance.getCommand("gamemode").setExecutor(new Gamemode(MedievoUtils.instance));
    }
}
