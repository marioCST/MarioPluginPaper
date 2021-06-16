package de.mariocst.commands.Inventory;

import de.mariocst.MarioMain;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearEnderChestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            try {
                if (args.length == 1) {
                    try {
                        Player t = MarioMain.getInstance().getServer().getPlayer(args[0]);

                        if (t != null) {
                            t.getEnderChest().clear();
                            t.sendMessage(MarioMain.getPrefix() + "Deine Ender Chest wurde gecleart!");
                            sender.sendMessage(MarioMain.getPrefix() + "Die Ender Chest von " + t.getName() + " wurde gecleart!");
                        }
                        else {
                            sender.sendMessage(MarioMain.getPrefix() + "Dieser Spieler existiert nicht!");
                        }
                    }
                    catch (NullPointerException e) {
                        e.printStackTrace();
                        sender.sendMessage(MarioMain.getPrefix() + "Dieser Spieler existiert nicht!");
                    }
                }
                else {
                    sender.sendMessage(MarioMain.getPrefix() + "/clearenderchest <Spieler>");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                sender.sendMessage(MarioMain.getPrefix() + "/clearenderchest <Spieler>");
            }
            return false;
        }

        Player player = (Player) sender;
        if (player.hasPermission("mario.clear") || player.hasPermission("*") || player.isOp()) {
            try {
                if (args.length == 0) {
                    player.getEnderChest().clear();
                    player.sendMessage(MarioMain.getPrefix() + "Deine Ender Chest wurde gecleart!");
                }
                else if (args.length == 1) {
                    try {
                        Player t = MarioMain.getInstance().getServer().getPlayer(args[0]);

                        if (t != null) {
                            t.getEnderChest().clear();
                            t.sendMessage(MarioMain.getPrefix() + "Deine Ender Chest wurde gecleart!");
                            player.sendMessage(MarioMain.getPrefix() + "Die Ender Chest von " + t.getName() + " wurde gecleart!");
                        }
                        else {
                            player.sendMessage(MarioMain.getPrefix() + "Dieser Spieler existiert nicht!");
                            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                        }
                    }
                    catch (NullPointerException e) {
                        e.printStackTrace();
                        player.sendMessage(MarioMain.getPrefix() + "Dieser Spieler existiert nicht!");
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                    }
                }
                else {
                    player.sendMessage(MarioMain.getPrefix() + "/clearenderchest oder /clearenderchest <Spieler>");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                player.sendMessage(MarioMain.getPrefix() + "/clearenderchest oder /clearenderchest <Spieler>");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
            }
        } else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return false;
    }
}
