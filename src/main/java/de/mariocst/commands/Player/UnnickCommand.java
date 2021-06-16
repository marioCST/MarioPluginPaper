package de.mariocst.commands.Player;

import de.mariocst.MarioMain;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnnickCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            MarioMain.getInstance().log("Dieser Command kann nur InGame ausgeführt werden!");
            return true;
        }

        Player player = (Player) sender;

        if(player.hasPermission("mario.unnick") || player.hasPermission("*") || player.isOp()) {
            player.setCustomName(player.getName());
            player.setPlayerListName(player.getName());
            player.setDisplayName(player.getName());
            player.sendMessage(MarioMain.getPrefix() + "Dein Nickname wurde erfolgreich zurückgesetzt!");
        } else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return true;
    }
}
