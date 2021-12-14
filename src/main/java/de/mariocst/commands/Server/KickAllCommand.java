package de.mariocst.commands.Server;

import de.mariocst.MarioMain;
import net.kyori.adventure.text.Component;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class KickAllCommand implements CommandExecutor {
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
                        t.kick(Component.text("Kicked by Admin"));
                    }
                    sender.sendMessage(MarioMain.getPrefix() + "Alle Spieler gekickt!");
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
                        t.kick(Component.text(reason.toString()));
                    }
                    sender.sendMessage(MarioMain.getPrefix() + "Alle Spieler mit dem Grund " + reason + " gekickt!");
                }
            }
            return false;
        }

        if (player.hasPermission("mario.kickall") || player.hasPermission("mario.*") || player.hasPermission("*") || player.isOp()) {
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
                            t.kick(Component.text("Kicked by Admin"));
                        }
                    }
                    sender.sendMessage(MarioMain.getPrefix() + "Alle Spieler gekickt!");
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
                            t.kick(Component.text(reason.toString()));
                        }
                    }
                    sender.sendMessage(MarioMain.getPrefix() + "Alle Spieler mit dem Grund " + reason + " gekickt!");
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
