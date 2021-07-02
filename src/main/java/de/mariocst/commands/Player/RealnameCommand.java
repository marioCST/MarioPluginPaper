package de.mariocst.commands.Player;

import de.mariocst.MarioMain;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RealnameCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            if (args.length == 1) {
                for (Player online : MarioMain.getInstance().getServer().getOnlinePlayers()) {
                    if (online.getDisplayName().equals(args[0])) {
                        if (!online.getDisplayName().equals(online.getName())) {
                            sender.sendMessage(MarioMain.getPrefix() + "Der echte Name von " + args[0] + " ist: " + online.getName());
                        }
                        else {
                            sender.sendMessage(MarioMain.getPrefix() + "Dieser Spieler ist nicht genickt!");
                        }
                    }
                    else {
                        sender.sendMessage(MarioMain.getPrefix() + "Dieser Spieler Nick existiert nicht!");
                    }
                }
            } else if (args.length == 0) {
                sender.sendMessage(MarioMain.getPrefix() + "Bitte gib den Nickname an.");
            } else {
                sender.sendMessage(MarioMain.getPrefix() + "§cBitte wähle einen gültigen Namen!");
            }
        } else {
            Player player = (Player) sender;

            if (player.hasPermission("mario.realname") || player.isOp()) {
                if (args.length == 1) {
                    for (Player online : MarioMain.getInstance().getServer().getOnlinePlayers()) {
                        if (online.getDisplayName().equals(args[0])) {
                            if (!online.getDisplayName().equals(online.getName())) {
                                sender.sendMessage(MarioMain.getPrefix() + "Der echte Name von " + args[0] + " ist: " + online.getName());
                            }
                            else {
                                sender.sendMessage(MarioMain.getPrefix() + "Dieser Spieler ist nicht genickt!");
                                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
                            }
                        }
                        else {
                            sender.sendMessage(MarioMain.getPrefix() + "Dieser Spieler Nick existiert nicht!");
                            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
                        }
                    }
                } else if (args.length == 0) {
                    sender.sendMessage(MarioMain.getPrefix() + "Bitte gib den Nickname an.");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
                } else {
                    sender.sendMessage(MarioMain.getPrefix() + "§cBitte wähle einen gültigen Namen!");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
                }
            } else {
                sender.sendMessage(MarioMain.getPrefix() + "§cKeine Rechte!");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
            }
        }
        return false;
    }
}
