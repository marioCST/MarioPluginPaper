package de.mariocst.commands.announcements;

import de.mariocst.MarioMain;
import net.kyori.adventure.text.Component;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Custom implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player player)) {
            if (args.length >= 1) {
                StringBuilder msg = new StringBuilder();
                for (String arg : args) {
                    msg.append(arg).append(" ");
                }

                MarioMain.getInstance().getServer().broadcast(Component.text(MarioMain.getPrefix()));
                for (int i = 0; i <= 5; i++) {
                    MarioMain.getInstance().getServer().broadcast(Component.text(MarioMain.getPrefix() + msg.toString().replaceAll("&", "§")));
                    MarioMain.getInstance().getServer().broadcast(Component.text(MarioMain.getPrefix()));
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            else {
                sender.sendMessage(MarioMain.getPrefix() + "/broadcast5 <Nachricht>");
            }
            return false;
        }

        if (player.hasPermission("mario.broadcast5") || player.hasPermission("mario.*") || player.hasPermission("*") || player.isOp()) {
            if (args.length >= 1) {
                StringBuilder msg = new StringBuilder();
                for (String arg : args) {
                    msg.append(arg).append(" ");
                }

                MarioMain.getInstance().getServer().broadcast(Component.text(MarioMain.getPrefix()));
                for (int i = 0; i <= 5; i++) {
                    MarioMain.getInstance().getServer().broadcast(Component.text(MarioMain.getPrefix() + msg.toString().replaceAll("&", "§")));
                    MarioMain.getInstance().getServer().broadcast(Component.text(MarioMain.getPrefix()));
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            else {
                player.sendMessage(MarioMain.getPrefix() + "/broadcast5 <Nachricht>");
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
