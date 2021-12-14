package de.mariocst.commands.inventory;

import de.mariocst.MarioMain;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class EnderInvseeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player player)) {
            MarioMain.getInstance().log("Bitte führe den Command InGame aus!");
            return false;
        }

        if (player.hasPermission("mario.enderinvsee") || player.hasPermission("mario.*") || player.hasPermission("*") || player.isOp()) {
            try {
                if (args.length == 1) {
                    try {
                        Player t = player.getServer().getPlayer(args[0]);
                        if (t != null) {
                            if (t.getName().equals(player.getName())) {
                                sender.sendMessage(MarioMain.getPrefix() + "Du kannst doch wohl noch deine eigene EnderChest öffnen xD");
                                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
                            }
                            else {
                                player.openInventory(t.getEnderChest());
                            }
                        }
                        else {
                            sender.sendMessage(MarioMain.getPrefix() + "Der Spieler " + args[0] + " existiert nicht!");
                            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
                        }
                    }
                    catch (NullPointerException e) {
                        sender.sendMessage(MarioMain.getPrefix() + "Der Spieler " + args[0] + " existiert nicht!");
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
                    }
                }
                else {
                    sender.sendMessage(MarioMain.getPrefix() + "/enderinvsee <Spieler>");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                sender.sendMessage(MarioMain.getPrefix() + "/enderinvsee <Spieler>");
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
