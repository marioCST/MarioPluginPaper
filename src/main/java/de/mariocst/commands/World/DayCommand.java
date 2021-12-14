package de.mariocst.commands.World;

import de.mariocst.MarioMain;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DayCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player player)) {
            MarioMain.getInstance().log("Bitte führe den Command InGame aus!");
            return true;
        }

        if (player.hasPermission("mario.day") || player.hasPermission("mario.*") || player.hasPermission("*") || player.isOp()) {
            player.getWorld().setTime(1000);
            player.sendMessage(MarioMain.getPrefix() + "Die Zeit wurde auf Tag gestellt!");
        }
        else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
        }
        return true;
    }
}
