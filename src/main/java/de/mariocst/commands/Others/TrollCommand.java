package de.mariocst.commands.Others;

import de.mariocst.MarioMain;
import net.minecraft.server.v1_16_R3.*;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TrollCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            try {
                if (args.length >= 2) {
                    Player t = MarioMain.getInstance().getServer().getPlayer(args[1]);

                    try {
                        if (t != null) {
                            switch (args[0].toLowerCase()) {
                                case "explosion" -> {
                                    if (args.length == 3) {
                                        float multiplier = Float.parseFloat(args[2]);
                                        float value = multiplier * 4.0f;

                                        if (multiplier > 45.0f) {
                                            sender.sendMessage(MarioMain.getPrefix() + "Bitte gib eine kleinere Zahl ein!");
                                        }
                                        else if (multiplier <= 0.0f) {
                                            sender.sendMessage(MarioMain.getPrefix() + "Bitte gib eine größere Zahl ein!");
                                        }
                                        else {
                                            t.getWorld().createExplosion(t.getLocation(), value);
                                            sender.sendMessage(MarioMain.getPrefix() + "BOOM!");
                                        }
                                    }
                                    else {
                                        t.getWorld().createExplosion(t.getLocation(), 4.0f);
                                    }
                                }
                                case "inventory", "inv" -> {
                                    if (MarioMain.getInstance().invTroll.contains(t)) {
                                        MarioMain.getInstance().invTroll.remove(t);

                                        sender.sendMessage(MarioMain.getPrefix() + "Der Spieler " + t.getName() + " darf nun wieder sein Inventar benutzen!");

                                        for (int i = 0; i <= 35; i++) {
                                            t.getInventory().remove(Material.BARRIER);
                                        }
                                    }
                                    else {
                                        MarioMain.getInstance().invTroll.add(t);

                                        sender.sendMessage(MarioMain.getPrefix() + "Der Spieler " + t.getName() + " darf nun nicht mehr sein Inventar benutzen!");

                                        for (int i = 0; i <= 35; i++) {
                                            if (t.getInventory().getItem(i) == null) {
                                                t.getInventory().setItem(i, new ItemStack(Material.BARRIER, 1));
                                            }
                                        }
                                    }
                                }
                                case "thunderstrike", "ts", "strike" -> {
                                    t.getWorld().spawnEntity(t.getLocation(), EntityType.LIGHTNING);

                                    sender.sendMessage(MarioMain.getPrefix() + "Der Spieler " + t.getName() + " hat einen Schlag!");
                                }
                                case "drop" -> {
                                    for (int i = 0; i <= 39; i++) {
                                        if (t.getInventory().getItem(i) != null) {
                                            t.getWorld().dropItem(t.getLocation(), t.getInventory().getItem(i));
                                        }
                                    }

                                    sender.sendMessage(MarioMain.getPrefix() + "Der Spieler " + t.getName() + " wurde erfolgreich mit Itemdrop getrollt!");
                                }
                                default -> {
                                    sender.sendMessage(MarioMain.getPrefix() + "/troll <explosion|inventory|thunderstrike|drop> <Spieler>");
                                }
                            }
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
            return false;
        }

        Player player = (Player) sender;
        if (player.hasPermission("mario.troll") || player.hasPermission("*") || player.isOp()) {
            try {
                if (args.length >= 2) {
                    Player t = MarioMain.getInstance().getServer().getPlayer(args[1]);

                    try {
                        if (t != null) {
                            switch (args[0].toLowerCase()) {
                                case "explosion" -> {
                                    if (args.length == 3) {
                                        float multiplier = Float.parseFloat(args[2]);
                                        float value = multiplier * 4.0f;

                                        if (multiplier > 45.0f) {
                                            player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine kleinere Zahl ein!");
                                            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                                        }
                                        else if (multiplier <= 0.0f) {
                                            player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine größere Zahl ein!");
                                            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                                        }
                                        else {
                                            t.getWorld().createExplosion(t.getLocation(), value);
                                            player.sendMessage(MarioMain.getPrefix() + "BOOM!");
                                        }
                                    }
                                    else {
                                        t.getWorld().createExplosion(t.getLocation(), 4.0f);
                                    }
                                }
                                case "inventory", "inv" -> {
                                    if (MarioMain.getInstance().invTroll.contains(t)) {
                                        MarioMain.getInstance().invTroll.remove(t);

                                        player.sendMessage(MarioMain.getPrefix() + "Der Spieler " + t.getName() + " darf nun wieder sein Inventar benutzen!");
                                    }
                                    else {
                                        MarioMain.getInstance().invTroll.add(t);

                                        player.sendMessage(MarioMain.getPrefix() + "Der Spieler " + t.getName() + " darf nun nicht mehr sein Inventar benutzen!");
                                    }
                                }
                                case "thunderstrike", "ts", "strike" -> {
                                    t.getWorld().spawnEntity(t.getLocation(), EntityType.LIGHTNING);

                                    sender.sendMessage(MarioMain.getPrefix() + "Der Spieler " + t.getName() + " hat einen Schlag!");
                                }
                                case "drop" -> {
                                    for (int i = 0; i <= 39; i++) {
                                        if (t.getInventory().getItem(i) != null) {
                                            t.getWorld().dropItem(t.getLocation(), t.getInventory().getItem(i));
                                        }
                                    }

                                    sender.sendMessage(MarioMain.getPrefix() + "Der Spieler " + t.getName() + " wurde erfolgreich mit Itemdrop getrollt!");
                                }
                                default -> {
                                    player.sendMessage(MarioMain.getPrefix() + "/troll <explosion|inventory|thunderstrike|drop> <Spieler>");
                                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                                }
                            }
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
        return false;
    }
}
