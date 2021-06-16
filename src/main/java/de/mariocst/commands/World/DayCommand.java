package de.mariocst.commands.World;

import de.mariocst.MarioMain;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DayCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            MarioMain.getInstance().log("Dieser Command kann leider nur InGame ausgeführt werden!");
            return true;
        }

        Player player = (Player) sender;

        if(player.hasPermission("mario.day") || player.hasPermission("*") || player.isOp()) {
            player.getWorld().setTime(0);
            player.sendMessage(MarioMain.getPrefix() + "Die Zeit wurde auf Tag gestellt!");
        } else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return true;
    }
}
