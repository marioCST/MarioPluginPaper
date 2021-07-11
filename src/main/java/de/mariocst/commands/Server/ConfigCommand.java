package de.mariocst.commands.Server;

import de.mariocst.MarioMain;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ConfigCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            try {
                if (args.length == 1) {
                    switch (args[0].toLowerCase()) {
                        case "save" -> {
                            MarioMain.getInstance().saveConfigs();
                            sender.sendMessage(MarioMain.getPrefix() + "Configs gespeichert!");
                        }
                        case "reload" -> {
                            MarioMain.getInstance().reloadConfigs();
                            sender.sendMessage(MarioMain.getPrefix() + "Configs neu geladen!");
                        }
                        default -> {
                            sender.sendMessage(MarioMain.getPrefix() + "/config <save|reload>");
                        }
                    }
                }
                else {
                    sender.sendMessage(MarioMain.getPrefix() + "/config <save|reload>");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                sender.sendMessage(MarioMain.getPrefix() + "/config <save|reload>");
            }
            return true;
        }

        Player player = (Player) sender;

        if(player.hasPermission("mario.config") || player.hasPermission("*") || player.isOp()) {
            try {
                if (args.length == 1) {
                    switch (args[0].toLowerCase()) {
                        case "save" -> {
                            MarioMain.getInstance().saveConfigs();
                            player.sendMessage(MarioMain.getPrefix() + "Configs gespeichert!");
                        }
                        case "reload" -> {
                            MarioMain.getInstance().reloadConfigs();
                            player.sendMessage(MarioMain.getPrefix() + "Configs neu geladen!");
                        }
                        default -> {
                            player.sendMessage(MarioMain.getPrefix() + "/config <save|reload>");
                        }
                    }
                }
                else {
                    player.sendMessage(MarioMain.getPrefix() + "/config <save|reload>");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                player.sendMessage(MarioMain.getPrefix() + "/config <save|reload>");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
            }
        } else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return true;
    }
}
