package de.mariocst.commands.Player;

import de.mariocst.MarioMain;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            MarioMain.INSTANCE.log("Du bist kein Spieler!");
            return false;
        }

        Player player = (Player) sender;
        if(player.hasPermission("mario.fly") || player.hasPermission("*") || player.isOp()) {
            if(!(player.getAllowFlight())) {
                player.setAllowFlight(true);
                player.setFlying(true);
                player.sendMessage(MarioMain.PREFIX + "§aDu fliegst nun.");
            } else {
                player.setAllowFlight(false);
                player.setFlying(false);
                player.sendMessage(MarioMain.PREFIX + "§4Du fliegst nun nicht mehr.");
            }
        } else {
            sender.sendMessage(MarioMain.PREFIX + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return false;
    }
}
