package de.mariocst.commands.server;

import de.mariocst.MarioMain;
import org.bukkit.BanList;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Instant;
import java.util.Date;

public class BanAllCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player player)) {
            int count = MarioMain.getInstance().getServer().getOnlinePlayers().size();
            
            if (args.length == 0) {
                if (count == 0) {
                    sender.sendMessage(MarioMain.getPrefix() + "Kein Spieler ist Online lol");
                    return false;
                }
                else {
                    for (Player t : MarioMain.getInstance().getServer().getOnlinePlayers()) {
                        MarioMain.getInstance().getServer().getBanList(BanList.Type.NAME).addBan(t.getName(), "Banned by Admin", Date.from(Instant.ofEpochSecond(7257600000L)), "Console");
                    }
                    sender.sendMessage(MarioMain.getPrefix() + "Alle Spieler gebannt!");
                }
            }
            else {
                if (count == 0) {
                    sender.sendMessage(MarioMain.getPrefix() + "Kein Spieler ist Online lol");
                    return false;
                }
                else {
                    StringBuilder reason = new StringBuilder();
                    for (String arg : args) {
                        reason.append(arg).append(" ");
                    }
                    
                    for (Player t : MarioMain.getInstance().getServer().getOnlinePlayers()) {
                        MarioMain.getInstance().getServer().getBanList(BanList.Type.NAME).addBan(t.getName(), reason.toString(), Date.from(Instant.ofEpochSecond(7257600000L)), "Console");
                    }
                    sender.sendMessage(MarioMain.getPrefix() + "Alle Spieler mit dem Grund " + reason + " gebannt!");
                }
            }
            return false;
        }

        if (player.hasPermission("mario.banall") || player.hasPermission("mario.*") || player.hasPermission("*") || player.isOp()) {
            int count = MarioMain.getInstance().getServer().getOnlinePlayers().size();
            
            if (args.length == 0) {
                if (count == 1) {
                    sender.sendMessage(MarioMain.getPrefix() + "Kein Spieler ist Online lol");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
                    return false;
                }
                else {
                    for (Player t : MarioMain.getInstance().getServer().getOnlinePlayers()) {
                        if (t != sender) {
                            MarioMain.getInstance().getServer().getBanList(BanList.Type.NAME).addBan(t.getName(), "Banned by Admin", Date.from(Instant.ofEpochSecond(7257600000L)), "Console");
                        }
                    }
                    sender.sendMessage(MarioMain.getPrefix() + "Alle Spieler gebannt!");
                }
            }
            else {
                if (count == 1) {
                    sender.sendMessage(MarioMain.getPrefix() + "Kein Spieler ist Online lol");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
                    return false;
                }
                else {
                    StringBuilder reason = new StringBuilder();
                    for (String arg : args) {
                        reason.append(arg).append(" ");
                    }
                    
                    for (Player t : MarioMain.getInstance().getServer().getOnlinePlayers()) {
                        if (t != sender) {
                            MarioMain.getInstance().getServer().getBanList(BanList.Type.NAME).addBan(t.getName(), reason.toString(), Date.from(Instant.ofEpochSecond(7257600000L)), "Console");
                        }
                    }
                    sender.sendMessage(MarioMain.getPrefix() + "Alle Spieler mit dem Grund " + reason + " gebannt!");
                }
            }
        }
        else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
        }
        return false;
    }
}
