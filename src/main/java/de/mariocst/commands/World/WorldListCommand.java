package de.mariocst.commands.World;

import de.mariocst.MarioMain;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WorldListCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            MarioMain.getInstance().log("Bitte führe den Command InGame aus!");
            return false;
        }

        Player player = (Player) sender;
        if(player.hasPermission("mario.worldlist") || player.hasPermission("*") || player.isOp()) {
            player.sendMessage(MarioMain.getPrefix() + "Alle Welten:");

            for (World world : MarioMain.getInstance().getServer().getWorlds()) {
                player.sendMessage(MarioMain.getPrefix() + world.getName());
            }
        } else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return false;
    }
}
