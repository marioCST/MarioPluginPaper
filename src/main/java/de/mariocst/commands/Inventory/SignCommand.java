package de.mariocst.commands.Inventory;

import de.mariocst.MarioMain;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;

public class SignCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            MarioMain.getInstance().log("Bitte führe den Command InGame aus!");
            return false;
        }

        Player player = (Player) sender;

        if (player.hasPermission("mario.sign") || player.hasPermission("mario.*") || player.hasPermission("*") || player.isOp()) {
            try {
                if (args.length >= 1) {
                    String msg = "";
                    for(int i = 0; i < args.length; i++) {
                        msg = msg + args[i] + " ";
                    }

                    try {
                        if (player.getInventory().getItem(player.getInventory().getHeldItemSlot()) != null) {
                            //player.getInventory().getItem(player.getInventory().getHeldItemSlot()).setItemMeta(Collections.singletonList(msg.replaceAll("&", "§")));
                        }
                        else {
                            player.sendMessage(MarioMain.getPrefix() + "Bitte halte ein Item in deiner Hand!");
                            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                        }
                    }
                    catch (NullPointerException e) {
                        e.printStackTrace();
                        player.sendMessage(MarioMain.getPrefix() + "Bitte halte ein Item in deiner Hand!");
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
        }
        else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return false;
    }
}
