package de.mariocst.commands.Announcements;

import de.mariocst.MarioMain;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Stop implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        int schleife1 = 0;
        int schleife2 = 0;

        if(!(sender instanceof Player)) {
            while (schleife1 < 5) {
                schleife1++;

                Bukkit.broadcastMessage(MarioMain.PREFIX + "§4§lSERVER STOPP! Danke für's spielen!");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }

        Player player = (Player) sender;
        if(player.hasPermission("mario.stop") || player.hasPermission("*") || player.isOp()) {
            while (schleife2 < 5) {
                schleife2++;

                Bukkit.broadcastMessage(MarioMain.PREFIX + "§4§lSERVER STOPP! Danke für's spielen!");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            player.sendMessage(MarioMain.PREFIX + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return false;
    }
}