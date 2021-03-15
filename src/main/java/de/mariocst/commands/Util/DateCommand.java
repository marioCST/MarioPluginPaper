package de.mariocst.commands.Util;

import de.mariocst.MarioMain;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Date;

public class DateCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Date date = new Date();
        if(!(sender instanceof Player)) {
            MarioMain.INSTANCE.log(MarioMain.PREFIX + "Es ist gerade " + ChatColor.GOLD + date.toString());
            return false;
        }

        Player player = (Player) sender;
        if(player.hasPermission("mario.date") || player.hasPermission("*") || player.isOp()) {
            sender.sendMessage(MarioMain.PREFIX + "Es ist gerade " + ChatColor.GOLD + date.toString());
        } else {
            player.sendMessage(MarioMain.PREFIX + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return false;
    }
}
