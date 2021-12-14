package de.mariocst.commands.player;

import de.mariocst.MarioMain;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DieCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player player)) {
            MarioMain.getInstance().log("Du bist gestorben. Warte... Du bist eine Konsole!");
            return true;
        }

        if (player.hasPermission("mario.die") || player.hasPermission("mario.*") || player.hasPermission("*") || player.isOp()) {
            player.setHealth(0.0);
            player.sendMessage(MarioMain.getPrefix() + "Du bist gestorben.");
        }
        else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
        }
        return true;
    }
}
