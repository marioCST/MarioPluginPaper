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
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;

public class TrollCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            try {
                if (args.length == 2) {
                    Player t = MarioMain.getInstance().getServer().getPlayer(args[1]);

                    try {
                        if (t != null) {
                            switch (args[0].toLowerCase()) {
                                case "explosion" -> {
                                    ((CraftPlayer)t).getHandle().playerConnection.sendPacket(new PacketPlayOutExplosion(
                                            t.getLocation().getX(),
                                            t.getLocation().getY(),
                                            t.getLocation().getZ(),
                                            5.0F,
                                            Collections.EMPTY_LIST,
                                            new Vec3D(
                                                    t.getLocation().getBlockX(),
                                                    t.getLocation().getBlockY(),
                                                    t.getLocation().getBlockZ()
                                            )));
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
                                default -> {
                                    sender.sendMessage(MarioMain.getPrefix() + "/troll <explosion|inventory> <Spieler>");
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
                if (args.length == 2) {
                    Player t = MarioMain.getInstance().getServer().getPlayer(args[1]);

                    try {
                        if (t != null) {
                            switch (args[0].toLowerCase()) {
                                case "explosion" -> {
                                    ((CraftPlayer)t).getHandle().playerConnection.sendPacket(new PacketPlayOutExplosion(
                                            t.getLocation().getX(),
                                            t.getLocation().getY(),
                                            t.getLocation().getZ(),
                                            5.0F,
                                            Collections.EMPTY_LIST,
                                            new Vec3D(
                                                    t.getLocation().getBlockX(),
                                                    t.getLocation().getBlockY(),
                                                    t.getLocation().getBlockZ()
                                            )));
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
                                default -> {
                                    player.sendMessage(MarioMain.getPrefix() + "/troll <explosion|inventory> <Spieler>");
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
