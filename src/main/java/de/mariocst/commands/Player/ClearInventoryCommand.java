package de.mariocst.commands.Player;

import de.mariocst.MarioMain;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearInventoryCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            MarioMain.INSTANCE.log("Dieser Command kann nur InGame ausgeführt werden!");
            return false;
        }

        Player player = (Player) sender;
        if(player.hasPermission("mario.clear") || player.hasPermission("*") || player.isOp()) {
            player.getInventory().clear();
            player.sendMessage(MarioMain.PREFIX + "Dein Inventar wurde gecleart!");
        } else {
            player.sendMessage(MarioMain.PREFIX + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return false;
    }
}
