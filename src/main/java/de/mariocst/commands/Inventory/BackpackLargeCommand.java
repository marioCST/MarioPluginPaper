package de.mariocst.commands.Inventory;

import de.mariocst.MarioMain;
import de.mariocst.backpack.BackpackLarge;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BackpackLargeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(MarioMain.getPrefix() + "Dieser Command geht nur InGame!");
            return true;
        } else {
            Player player = (Player) sender;

            if(player.hasPermission("mario.backpacklarge") || player.hasPermission("mario.*") || player.isOp()) {
                BackpackLarge backpackLarge = MarioMain.getInstance().getBackpackManagerLarge().getBackpackLarge(player.getUniqueId());

                player.openInventory(backpackLarge.getInventory());
            }
            else {
                sender.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
            }
        }

        return false;
    }
}
