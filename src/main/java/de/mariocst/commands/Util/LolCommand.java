package de.mariocst.commands.Util;

import de.mariocst.MarioMain;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LolCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            Bukkit.broadcastMessage(MarioMain.PREFIX + "§a§lLOL");
            return false;
        }

        Player player = (Player) sender;
        if(player.hasPermission("mario.lol") || player.hasPermission("*") || player.isOp()) {
            Bukkit.broadcastMessage(MarioMain.PREFIX + "§a§lLOL");
        } else {
            player.sendMessage(MarioMain.PREFIX + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return false;
    }
}
