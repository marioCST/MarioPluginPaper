package de.mariocst.commands.inventory;

import de.mariocst.MarioMain;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ClearInventoryCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player player)) {
            try {
                if (args.length == 1) {
                    try {
                        Player t = MarioMain.getInstance().getServer().getPlayer(args[0]);

                        if (t != null) {
                            t.getInventory().clear();
                            t.sendMessage(MarioMain.getPrefix() + "Dein Inventar wurde gecleart!");
                            sender.sendMessage(MarioMain.getPrefix() + "Das Inventar von " + t.getName() + " wurde gecleart!");
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
                    sender.sendMessage(MarioMain.getPrefix() + "/clearinventory <Spieler>");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                sender.sendMessage(MarioMain.getPrefix() + "/clearinventory <Spieler>");
            }
            return false;
        }

        if (player.hasPermission("mario.clear") || player.hasPermission("mario.*") || player.hasPermission("*") || player.isOp()) {
            try {
                if (args.length == 0) {
                    player.getInventory().clear();
                    player.sendMessage(MarioMain.getPrefix() + "Dein Inventar wurde gecleart!");
                }
                else if (args.length == 1) {
                    try {
                        Player t = MarioMain.getInstance().getServer().getPlayer(args[0]);

                        if (t != null) {
                            t.getInventory().clear();
                            t.sendMessage(MarioMain.getPrefix() + "Dein Inventar wurde gecleart!");
                            player.sendMessage(MarioMain.getPrefix() + "Das Inventar von " + t.getName() + " wurde gecleart!");
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
                    player.sendMessage(MarioMain.getPrefix() + "/clearinventory [Spieler]");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                player.sendMessage(MarioMain.getPrefix() + "/clearinventory [Spieler]");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
            }
        }
        else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
        }
        return false;
    }
}
