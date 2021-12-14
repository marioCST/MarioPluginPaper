package de.mariocst.commands.Others;

import de.mariocst.MarioMain;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class DateCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        Date date = new Date();
        if (!(sender instanceof Player player)) {
            sender.sendMessage(MarioMain.getPrefix() + "Es ist gerade " + ChatColor.GOLD + date);
            return false;
        }

        if (player.hasPermission("mario.date") || player.hasPermission("mario.*") || player.hasPermission("*") || player.isOp()) {
            player.sendMessage(MarioMain.getPrefix() + "Es ist gerade " + ChatColor.GOLD + date);
        }
        else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
        }
        return false;
    }
}
