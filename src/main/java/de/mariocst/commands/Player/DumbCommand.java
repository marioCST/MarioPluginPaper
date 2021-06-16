package de.mariocst.commands.Player;

import de.mariocst.MarioMain;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DumbCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            Bukkit.broadcastMessage(MarioMain.getPrefix() + "Die Konsole ist dumm.");
            return false;
        }

        Player player = (Player) sender;
        if(player.hasPermission("mario.dumb") || player.hasPermission("*") || player.isOp()) {
            Bukkit.broadcastMessage(MarioMain.getPrefix() + player.getDisplayName() + " ist dumm.");
        } else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return false;
    }
}
