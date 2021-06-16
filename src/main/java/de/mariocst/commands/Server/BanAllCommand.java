package de.mariocst.commands.Server;

import de.mariocst.MarioMain;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanAllCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            try {
                if (args.length == 0) {
                    int count = MarioMain.getInstance().getServer().getOnlinePlayers().size();
                    if (count == 0) {
                        Bukkit.getConsoleSender().sendMessage(MarioMain.getPrefix() + "Kein Spieler ist Online lol");
                        return false;
                    }
                    else {
                        for (Player t : MarioMain.getInstance().getServer().getOnlinePlayers()) {
                            t.banPlayer("Banned by Admin");
                        }

                        Bukkit.getConsoleSender().sendMessage(MarioMain.getPrefix() + "Alle Spieler gebannt!");
                    }
                }
                else if (args.length >= 1) {
                    int count = MarioMain.getInstance().getServer().getOnlinePlayers().size();
                    if (count == 0) {
                        Bukkit.getConsoleSender().sendMessage(MarioMain.getPrefix() + "Kein Spieler ist Online lol");
                        return false;
                    }
                    else {
                        String reason = "";
                        for(int i = 0; i < args.length; i++) {
                            reason = reason + args[i] + " ";
                        }

                        for (Player t : MarioMain.getInstance().getServer().getOnlinePlayers()) {
                            t.banPlayer(reason);
                        }
                        Bukkit.getConsoleSender().sendMessage(MarioMain.getPrefix() + "Alle Spieler mit dem Grund " + reason + " gebannt!");
                    }
                }
                else {
                    Bukkit.getConsoleSender().sendMessage(MarioMain.getPrefix() + "Ungültige Parameter Länge!");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                Bukkit.getConsoleSender().sendMessage(MarioMain.getPrefix() + "Ungültige Parameter Länge!");
            }
            return false;
        }

        Player player = (Player) sender;
        if(player.hasPermission("mario.banall") || player.hasPermission("*") || player.isOp()) {
            try {
                if (args.length == 0) {
                    int count = MarioMain.getInstance().getServer().getOnlinePlayers().size();
                    if (count == 1) {
                        sender.sendMessage(MarioMain.getPrefix() + "Kein Spieler ist Online lol");
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                        return false;
                    }
                    else {
                        for (Player t : MarioMain.getInstance().getServer().getOnlinePlayers()) {
                            if (t != sender) {
                                t.banPlayer("Banned by Admin");
                            }
                        }

                        sender.sendMessage(MarioMain.getPrefix() + "Alle Spieler gebannt!");
                    }
                }
                else if (args.length >= 1) {
                    int count = MarioMain.getInstance().getServer().getOnlinePlayers().size();
                    if (count == 1) {
                        sender.sendMessage(MarioMain.getPrefix() + "Kein Spieler ist Online lol");
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                        return false;
                    }
                    else {
                        String reason = "";
                        for(int i = 0; i < args.length; i++) {
                            reason = reason + args[i] + " ";
                        }

                        for (Player t : MarioMain.getInstance().getServer().getOnlinePlayers()) {
                            if (t != sender) {
                                t.banPlayer(reason);
                            }
                        }
                        sender.sendMessage(MarioMain.getPrefix() + "Alle Spieler mit dem Grund " + reason + " gebannt!");
                    }
                }
                else {
                    sender.sendMessage(MarioMain.getPrefix() + "Ungültige Parameter Länge!");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                sender.sendMessage(MarioMain.getPrefix() + "Ungültige Parameter Länge!");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
            }
        } else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return false;
    }
}
