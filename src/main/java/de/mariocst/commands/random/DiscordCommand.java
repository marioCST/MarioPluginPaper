package de.mariocst.commands.random;

import de.mariocst.MarioMain;
import de.mariocst.utils.DiscordLink;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DiscordCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(MarioMain.getPrefix() + "Unser Discord: " + DiscordLink.getDiscordLink().getLink());
            return false;
        }

        if (player.hasPermission("mario.discord") || player.hasPermission("mario.*") || player.hasPermission("*") || player.isOp()) {
            player.sendMessage(MarioMain.getPrefix() + "Unser Discord: " + DiscordLink.getDiscordLink().getLink());
        }
        else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
        }
        return false;
    }
}
