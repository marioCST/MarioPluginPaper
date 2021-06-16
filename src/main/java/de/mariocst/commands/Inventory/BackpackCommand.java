package de.mariocst.commands.Inventory;

import de.mariocst.MarioMain;
import de.mariocst.backpack.Backpack;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BackpackCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(MarioMain.getPrefix() + "Dieser Command geht nur InGame!");
            return true;
        } else {
            Player player = (Player) sender;

            if(player.hasPermission("mario.backpack") || player.hasPermission("mario.*") || player.isOp()) {
                Backpack backpack = MarioMain.getInstance().getBackpackManager().getBackpack(player.getUniqueId());

                player.openInventory(backpack.getInventory());
            }
            else {
                sender.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
            }
        }

        return false;
    }
}
