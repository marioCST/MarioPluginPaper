package de.mariocst.commands.Player;

import de.mariocst.MarioMain;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
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
                            sender.sendMessage(MarioMain.getPrefix() + "Dieser Spieler existiert nicht!");
                        }
                    }
                    catch (NullPointerException e) {
                        e.printStackTrace();
                        sender.sendMessage(MarioMain.getPrefix() + "Dieser Spieler existiert nicht!");
                    }
                }
                else {
                    sender.sendMessage(MarioMain.getPrefix() + "Ungültige Parameter Länge!");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                sender.sendMessage(MarioMain.getPrefix() + "Ungültige Parameter Länge!");
            }
            return true;
        }

        Player player = (Player) sender;

        if(player.hasPermission("mario.heal") || player.hasPermission("*") || player.isOp()) {
            try {
                if (args.length == 0) {
                    player.setHealth(20d);
                    player.setFoodLevel(20);
                    player.sendMessage(MarioMain.getPrefix() + "Du wurdest geheilt und gesättigt!");
                    player.playSound(player.getLocation(), Sound.AMBIENT_CAVE, 0.2f, 1.2f);
                }
                else if (args.length == 1 && player.hasPermission("mario.heal.other")) {
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
                    player.sendMessage(MarioMain.getPrefix() + "Ungültige Parameter Länge!");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                player.sendMessage(MarioMain.getPrefix() + "Ungültige Parameter Länge!");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
            }
        } else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return true;
    }
}
