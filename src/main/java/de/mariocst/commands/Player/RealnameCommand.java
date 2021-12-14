package de.mariocst.commands.Player;

import de.mariocst.MarioMain;
import net.kyori.adventure.text.Component;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class RealnameCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player player)) {
            if (args.length == 1) {
                for (Player online : MarioMain.getInstance().getServer().getOnlinePlayers()) {
                    if (Objects.equals(Component.text(args[0]), online.displayName())) {
                        if (!Objects.equals(online.displayName(), Component.text(online.getName()))) {
                            sender.sendMessage(MarioMain.getPrefix() + "Der echte Name von " + args[0] + " ist: " + online.getName());
                        }
                        else {
                            sender.sendMessage(MarioMain.getPrefix() + "Dieser Spieler ist nicht genickt!");
                        }
                    }
                    else {
                        sender.sendMessage(MarioMain.getPrefix() + "Dieser Spieler Nick existiert nicht!");
                    }
                }
            }
            else if (args.length == 0) {
                sender.sendMessage(MarioMain.getPrefix() + "Bitte gib den Nickname an.");
            }
            else {
                sender.sendMessage(MarioMain.getPrefix() + "/realname <Spieler>");
            }
            return true;
        }

        if (player.hasPermission("mario.realname") || player.hasPermission("mario.*") || player.hasPermission("*") || player.isOp()) {
            if (args.length == 1) {
                for (Player online : MarioMain.getInstance().getServer().getOnlinePlayers()) {
                    if (Objects.equals(online.displayName(), Component.text(args[0]))) {
                        if (!Objects.equals(online.displayName(), Component.text(online.getName()))) {
                            player.sendMessage(MarioMain.getPrefix() + "Der echte Name von " + args[0] + " ist: " + online.getName());
                        }
                        else {
                            player.sendMessage(MarioMain.getPrefix() + "Der Spieler " + args[0] + " ist nicht genickt!");
                            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
                        }
                    }
                    else {
                        player.sendMessage(MarioMain.getPrefix() + "Der Spieler Nick " + args[0] + " existiert nicht!");
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
                    }
                }
            }
            else if (args.length == 0) {
                player.sendMessage(MarioMain.getPrefix() + "Bitte gib den Nickname an.");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
            }
            else {
                player.sendMessage(MarioMain.getPrefix() + "/realname <Spieler>");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
            }
        }
        else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
        }
        return false;
    }
}
