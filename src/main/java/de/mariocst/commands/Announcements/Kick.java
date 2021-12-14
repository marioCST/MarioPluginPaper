package de.mariocst.commands.Announcements;

import de.mariocst.MarioMain;
import net.kyori.adventure.text.Component;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Kick implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player player)) {
            for (int i = 0; i <= 5; i++) {
                MarioMain.getInstance().getServer().broadcast(Component.text(MarioMain.getPrefix() + "§e§lALLE WERDEN GEKICKT! BITTE NACH KURZER ZEIT REJOINEN! NICHT DIREKT!"));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }

        if (player.hasPermission("mario.kick") || player.hasPermission("mario.*") || player.hasPermission("*") || player.isOp()) {
            for (int i = 0; i <= 5; i++) {
                MarioMain.getInstance().getServer().broadcast(Component.text(MarioMain.getPrefix() + "§e§lALLE WERDEN GEKICKT! BITTE NACH KURZER ZEIT REJOINEN! NICHT DIREKT!"));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
        }
        return false;
    }
}
