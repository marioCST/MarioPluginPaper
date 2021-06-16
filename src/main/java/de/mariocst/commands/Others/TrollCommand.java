package de.mariocst.commands.Others;

import de.mariocst.MarioMain;
import net.minecraft.server.v1_16_R3.PacketPlayOutExplosion;
import net.minecraft.server.v1_16_R3.Vec3D;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.Collections;

public class TrollCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            MarioMain.getInstance().log("In arbeit");
            return false;
        }

        Player player = (Player) sender;
        if (player.hasPermission("mario.troll") || player.hasPermission("*") || player.isOp()) {
            try {
                if (args.length == 1) {
                    Player t = MarioMain.getInstance().getServer().getPlayer(args[0]);

                    try {
                        if (t != null) {
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
