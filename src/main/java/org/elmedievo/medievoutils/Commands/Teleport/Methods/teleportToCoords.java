package org.elmedievo.medievoutils.Commands.Teleport.Methods;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import static org.elmedievo.medievoutils.util.Generic.INVALID_COORDINATES;
import static org.elmedievo.medievoutils.util.Generic.NO_PLAYERS_MATCHED;
import static org.elmedievo.medievoutils.util.Methods.InputValidation.isDouble;
import static org.elmedievo.medievoutils.util.Methods.PlayerIsOnline.playerIsOnline;

public class teleportToCoords {
    public static void teleportSelfToCoords(Player player, String xInput, String yInput, String zInput) {
        if (isDouble(xInput) && isDouble(yInput) && isDouble(zInput)) {
            World w = player.getWorld();
            double x = Double.parseDouble(xInput);
            double y = Double.parseDouble(yInput);
            double z = Double.parseDouble(zInput);

            player.teleport(new Location(w, x, y, z));
            player.sendMessage(ChatColor.YELLOW + "Teleported to " + ChatColor.AQUA + xInput + ", " + yInput + ", " + zInput);
        } else {
            player.sendMessage(INVALID_COORDINATES);
        }
    }

    @SuppressWarnings("deprecation")
    public static void teleportOtherToCoords(Player teleporter, String teleported, String xInput, String yInput, String zInput) {
        if (playerIsOnline(teleported)) {
            Player teleportedPlayer = Bukkit.getServer().getPlayer(teleported);
            if (isDouble(xInput) && isDouble(yInput) && isDouble(zInput)) {
                World w = teleporter.getWorld();
                double x = Double.parseDouble(xInput);
                double y = Double.parseDouble(yInput);
                double z = Double.parseDouble(zInput);

                teleportedPlayer.teleport(new Location(w, x, y ,z));
                teleporter.sendMessage(ChatColor.YELLOW + "Teleported " + teleportedPlayer.getDisplayName() + ChatColor.YELLOW + " to " + ChatColor.AQUA + xInput + ", " + yInput + ", " + zInput);
            } else {
                teleporter.sendMessage(INVALID_COORDINATES);
            }
        } else {
            teleporter.sendMessage(NO_PLAYERS_MATCHED);
        }
    }
}
