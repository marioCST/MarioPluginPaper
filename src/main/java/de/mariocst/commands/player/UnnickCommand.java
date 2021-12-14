package de.mariocst.commands.player;

import de.mariocst.MarioMain;
import net.kyori.adventure.text.Component;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class UnnickCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player player)) {
            MarioMain.getInstance().log("Dieser Command kann nur InGame ausgeführt werden!");
            return true;
        }

        if (player.hasPermission("mario.unnick") || player.hasPermission("mario.*") || player.hasPermission("*") || player.isOp()) {
            player.setCustomName(player.getName());
            player.playerListName(Component.text(player.getName()));
            player.displayName(Component.text(player.getName()));
            player.sendMessage(MarioMain.getPrefix() + "Dein Nickname wurde erfolgreich zurückgesetzt!");
        }
        else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
        }
        return true;
    }
}
