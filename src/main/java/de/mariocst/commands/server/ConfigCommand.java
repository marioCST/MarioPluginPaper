package de.mariocst.commands.server;

import de.mariocst.MarioMain;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ConfigCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player player)) {
            try {
                if (args.length == 1) {
                    switch (args[0].toLowerCase()) {
                        case "save" -> {
                            MarioMain.getInstance().saveConfigs();
                            sender.sendMessage(MarioMain.getPrefix() + "Configs gespeichert!");
                        }
                        case "reload" -> {
                            MarioMain.getInstance().loadConfigs();
                            sender.sendMessage(MarioMain.getPrefix() + "Configs neu geladen!");
                        }
                        default -> sender.sendMessage(MarioMain.getPrefix() + "/config <save|reload>");
                    }
                }
                else {
                    sender.sendMessage(MarioMain.getPrefix() + "/config <save|reload>");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                sender.sendMessage(MarioMain.getPrefix() + "/config <save|reload>");
            }
            return true;
        }

        if (player.hasPermission("mario.config") || player.hasPermission("mario.*") || player.hasPermission("*") || player.isOp()) {
            try {
                if (args.length == 1) {
                    switch (args[0].toLowerCase()) {
                        case "save" -> {
                            MarioMain.getInstance().saveConfigs();
                            player.sendMessage(MarioMain.getPrefix() + "Configs gespeichert!");
                        }
                        case "reload" -> {
                            MarioMain.getInstance().loadConfigs();
                            player.sendMessage(MarioMain.getPrefix() + "Configs neu geladen!");
                        }
                        default -> player.sendMessage(MarioMain.getPrefix() + "/config <save|reload>");
                    }
                }
                else {
                    player.sendMessage(MarioMain.getPrefix() + "/config <save|reload>");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                player.sendMessage(MarioMain.getPrefix() + "/config <save|reload>");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
            }
        }
        else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
        }
        return true;
    }
}
