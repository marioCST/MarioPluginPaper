package de.mariocst.commands.Player;

import de.mariocst.MarioMain;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            MarioMain.INSTANCE.log("Dieser Befehl geht nur InGame!");
        } else {
            Player player = (Player) sender;

            if (player.hasPermission("mario.speed") || player.isOp()) {
                try {
                    float value = Float.parseFloat(args[1]);
                    if (args.length == 2) {
                        try {
                            switch (args[0].toLowerCase()) {
                                case "fly": {
                                    if (value < 1 && value > -1) {
                                        player.setFlySpeed(value);
                                        sender.sendMessage(MarioMain.PREFIX + "Dein Fly Speed ist nun: " + value);
                                    }
                                    else if (value > 1) {
                                        player.sendMessage(MarioMain.PREFIX + "Bitte benutze eine kleinere Zahl!");
                                    }
                                    else if (value < -1) {
                                        player.sendMessage(MarioMain.PREFIX + "Bitte benutze eine größere Zahl!");
                                    }
                                    else {
                                        player.sendMessage(MarioMain.PREFIX + "Irgendetwas ist GEWALTIG schief gelaufen!");
                                    }
                                    break;
                                }
                                case "walk": {
                                    if (value < 1 && value > -1) {
                                        player.setWalkSpeed(value);
                                        sender.sendMessage(MarioMain.PREFIX + "Dein Walk Speed ist nun: " + value);
                                    }
                                    else if (value > 1) {
                                        player.sendMessage(MarioMain.PREFIX + "Bitte benutze eine kleinere Zahl!");
                                    }
                                    else if (value < -1) {
                                        player.sendMessage(MarioMain.PREFIX + "Bitte benutze eine größere Zahl!");
                                    }
                                    else {
                                        player.sendMessage(MarioMain.PREFIX + "Irgendetwas ist GEWALTIG schief gelaufen!");
                                    }
                                    break;
                                }
                                default: {
                                    sendUsage(sender);
                                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
                                    break;
                                }
                            }
                        } catch (NumberFormatException e) {
                            sender.sendMessage(MarioMain.PREFIX + "Bitte gib eine gültige Zahl an!");
                            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
                            e.printStackTrace();
                        }
                    } else {
                        sendUsage(sender);
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    sendUsage(sender);
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
                    e.printStackTrace();
                }
            } else {
                sender.sendMessage(MarioMain.PREFIX + "§cKeine Rechte!");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
            }
        }
        return false;
    }

    public void sendUsage(CommandSender sender) {
        sender.sendMessage(MarioMain.PREFIX + "§cUsage: §e/speed fly/walk <Value>");
    }
}
