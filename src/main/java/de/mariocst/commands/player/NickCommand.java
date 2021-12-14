package de.mariocst.commands.player;

import de.mariocst.MarioMain;
import net.kyori.adventure.text.Component;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class NickCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player player)) {
            MarioMain.getInstance().log("Bitte führe den Command InGame aus!");
            return true;
        }

        if (player.hasPermission("mario.nick") || player.hasPermission("mario.*") || player.hasPermission("*") || player.isOp()) {
            if (args.length == 1) {
                if (args[0].length() < 16) {
                    for (Player t : MarioMain.getInstance().getServer().getOnlinePlayers()) {
                        if (args[0].equals(t.getName()) && !args[0].equals(player.getName())) {
                            sender.sendMessage(MarioMain.getPrefix() + "Bitte \"fake\" keine Spieler!");
                        }
                        else if (args[0].equals(player.getName())) {
                            sender.sendMessage(MarioMain.getPrefix() + "/unnick");
                        }
                        else if (Objects.equals(Component.text(args[0]), t.displayName())) {
                            sender.sendMessage(MarioMain.getPrefix() + "Jemand hat sich bereits " + args[0] + " genannt!");
                        }
                        else {
                            player.displayName(Component.text(args[0]));
                            player.playerListName(Component.text(args[0]));
                            player.setCustomName(args[0]);

                            sender.sendMessage(MarioMain.getPrefix() + "Dein Nickname wurde erfolgreich zu " + args[0] + " geändert!");
                        }
                    }
                }
                else {
                    sender.sendMessage(MarioMain.getPrefix() + "Bitte wähle einen Namen, der kürzer als 16 Zeichen ist!");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
                }
            }
            else {
                sender.sendMessage(MarioMain.getPrefix() + "Bitte gib einen Nickname ein, oder suche dir einen, der keine Leerzeichen hat!");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
            }
        }
        else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
        }
        return true;
    }
}
