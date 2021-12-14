package de.mariocst.commands.player;

import de.mariocst.MarioMain;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player player)) {
            try {
                if (args.length == 1) {
                    Player t = MarioMain.getInstance().getServer().getPlayer(args[0]);

                    try {
                        if (t != null) {
                            t.setHealth(20d);
                            t.setFoodLevel(20);
                            t.sendMessage(MarioMain.getPrefix() + "Du wurdest geheilt und gesättigt!");
                            sender.sendMessage(MarioMain.getPrefix() + "Der Spieler " + t.getName() + " wurde geheilt und gesättigt!");
                            t.playSound(t.getLocation(), Sound.AMBIENT_CAVE, 0.2f, 1.2f);
                        }
                        else {
                            sender.sendMessage(MarioMain.getPrefix() + "Der Spieler " + args[0] + " existiert nicht!");
                        }
                    }
                    catch (NullPointerException e) {
                        sender.sendMessage(MarioMain.getPrefix() + "Der Spieler " + args[0] + " existiert nicht!");
                    }
                }
                else {
                    sender.sendMessage(MarioMain.getPrefix() + "/heal <Spieler>");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                sender.sendMessage(MarioMain.getPrefix() + "/heal <Spieler>");
            }
            return true;
        }

        if (player.hasPermission("mario.heal") || player.hasPermission("mario.*") || player.hasPermission("*") || player.isOp()) {
            try {
                if (args.length == 0) {
                    player.setHealth(20d);
                    player.setFoodLevel(20);
                    player.sendMessage(MarioMain.getPrefix() + "Du wurdest geheilt und gesättigt!");
                    player.playSound(player.getLocation(), Sound.AMBIENT_CAVE, 0.2f, 1.2f);
                }
                else if (args.length == 1 && (player.hasPermission("mario.heal.other") || player.hasPermission("mario.*") || player.hasPermission("*") || player.isOp())) {
                    Player t = MarioMain.getInstance().getServer().getPlayer(args[0]);

                    try {
                        if (t != null) {
                            t.setHealth(20d);
                            t.setFoodLevel(20);
                            t.sendMessage(MarioMain.getPrefix() + "Du wurdest geheilt und gesättigt!");
                            player.sendMessage(MarioMain.getPrefix() + "Der Spieler " + t.getName() + " wurde geheilt und gesättigt!");
                            t.playSound(t.getLocation(), Sound.AMBIENT_CAVE, 0.2f, 1.2f);
                        }
                        else {
                            player.sendMessage(MarioMain.getPrefix() + "Der Spieler " + args[0] + " existiert nicht!");
                            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
                        }
                    }
                    catch (NullPointerException e) {
                        player.sendMessage(MarioMain.getPrefix() + "Der Spieler " + args[0] + " existiert nicht!");
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
                    }
                }
                else {
                    player.sendMessage(MarioMain.getPrefix() + "/heal [Spieler]");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                player.sendMessage(MarioMain.getPrefix() + "/heal [Spieler]");
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
