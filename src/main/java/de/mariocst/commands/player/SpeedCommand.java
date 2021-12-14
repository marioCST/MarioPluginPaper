package de.mariocst.commands.player;

import de.mariocst.MarioMain;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player player)) {
            MarioMain.getInstance().log("Bitte führe den Command InGame aus!");
            return true;
        }

        if (player.hasPermission("mario.speed") || player.hasPermission("mario.*") || player.hasPermission("*") || player.isOp()) {
            try {
                if (args.length == 2) {
                    try {
                        float value = Float.parseFloat(args[1]);

                        switch (args[0].toLowerCase()) {
                            case "fly" -> {
                                if (value > 1) {
                                    player.sendMessage(MarioMain.getPrefix() + "Bitte benutze eine kleinere Zahl!");
                                }
                                else if (value < -1) {
                                    player.sendMessage(MarioMain.getPrefix() + "Bitte benutze eine größere Zahl!");
                                }
                                else {
                                    player.setFlySpeed(value);
                                    player.sendMessage(MarioMain.getPrefix() + "Dein Fly Speed ist nun: " + value);
                                }
                            }
                            case "walk" -> {
                                if (value > 1) {
                                    player.sendMessage(MarioMain.getPrefix() + "Bitte benutze eine kleinere Zahl!");
                                }
                                else if (value < -1) {
                                    player.sendMessage(MarioMain.getPrefix() + "Bitte benutze eine größere Zahl!");
                                }
                                else {
                                    player.setWalkSpeed(value);
                                    player.sendMessage(MarioMain.getPrefix() + "Dein Walk Speed ist nun: " + value);
                                }
                            }
                            default -> {
                                player.sendMessage(MarioMain.getPrefix() + "/speed fly/walk <Value>");
                                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
                            }
                        }
                    }
                    catch (NumberFormatException e) {
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine gültige Zahl an!");
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
                    }
                }
                else {
                    player.sendMessage(MarioMain.getPrefix() + "/speed fly/walk <Value>");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                player.sendMessage(MarioMain.getPrefix() + "/speed fly/walk <Value>");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
            }
        } else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
        }
        return false;
    }
}
