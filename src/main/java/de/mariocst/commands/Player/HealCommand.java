package de.mariocst.commands.Player;

import de.mariocst.MarioMain;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            MarioMain.INSTANCE.log("Du bist kein Spieler");
            return true;
        }

        Player player = (Player) sender;

        if(player.hasPermission("mario.heal") || player.hasPermission("*") || player.isOp()) {
            player.setHealth(20d);
            player.setFoodLevel(20);
            player.sendMessage(MarioMain.PREFIX + "Du wurdest geheilt und gesättigt!");
            player.playSound(player.getLocation(), Sound.AMBIENT_CAVE, 0.2f, 1.2f);
        } else {
            player.sendMessage(MarioMain.PREFIX + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return true;
    }
}
