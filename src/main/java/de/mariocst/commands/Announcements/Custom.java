package de.mariocst.commands.Announcements;

import de.mariocst.MarioMain;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Custom implements CommandExecutor {
    public static String PREFIX = "§8[§6marioCST.de§8] §b";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        int schleife1 = 0;
        int schleife2 = 0;


        if(!(sender instanceof Player)) {
            if (args.length >= 1) {
                String msg = "";
                for(int i = 0; i < args.length; i++) {
                    msg = msg + args[i] + " ";
                }

                Bukkit.broadcastMessage(MarioMain.getPrefix());
                while (schleife1< 5) {
                    schleife1++;

                    Bukkit.broadcastMessage(MarioMain.getPrefix() + msg.replaceAll("&", "§"));
                    Bukkit.broadcastMessage(MarioMain.getPrefix());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                sender.sendMessage("§cUsage: §e/broadcast5 <Message>");
            }
            return false;
        }

        Player player = (Player) sender;
        if(player.hasPermission("mario.broadcast5") || player.hasPermission("*") || player.isOp()) {
            if (args.length >= 1) {
                String msg = "";
                for(int i = 0; i < args.length; i++) {
                    msg = msg + args[i] + " ";
                }

                Bukkit.broadcastMessage(MarioMain.getPrefix());
                while (schleife2< 5) {
                    schleife2++;

                    Bukkit.broadcastMessage(MarioMain.getPrefix() + msg.replaceAll("&", "§"));
                    Bukkit.broadcastMessage(MarioMain.getPrefix());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                sender.sendMessage("§cUsage: §e/broadcast5 <Message>");
            }
        } else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return false;
    }
}
