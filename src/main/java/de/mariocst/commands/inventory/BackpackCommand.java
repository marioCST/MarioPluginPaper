package de.mariocst.commands.inventory;

import de.mariocst.MarioMain;
import de.mariocst.backpack.Backpack;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BackpackCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(MarioMain.getPrefix() + "Dieser Command geht nur InGame!");
            return true;
        }

        if (player.hasPermission("mario.backpack") || player.hasPermission("mario.*") || player.hasPermission("mario.*") || player.isOp()) {
            Backpack backpack = MarioMain.getInstance().getBackpackManager().getBackpack(player.getUniqueId());

            player.openInventory(backpack.getInventory());
        }
        else {
            sender.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
        }
        return false;
    }
}
