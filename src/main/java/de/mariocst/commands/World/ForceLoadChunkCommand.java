package de.mariocst.commands.World;

import de.mariocst.MarioMain;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ForceLoadChunkCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            MarioMain.getInstance().log("Bitte führe den Command InGame aus!");
            return false;
        }

        Player player = (Player) sender;
        if(player.hasPermission("mario.forceloadchunk") || player.hasPermission("*") || player.isOp()) {
            if (player.getLocation().getChunk().isForceLoaded()) {
                player.getLocation().getChunk().setForceLoaded(false);
                player.sendMessage(MarioMain.getPrefix() + "Der Chunk bei X: " + player.getLocation().getChunk().getX() + " und Z: " + player.getLocation().getChunk().getZ() + " ist nun nicht mehr immer geladen!");
            }
            else {
                player.getLocation().getChunk().setForceLoaded(true);
                player.sendMessage(MarioMain.getPrefix() + "Der Chunk bei X: " + player.getLocation().getChunk().getX() + " und Z: " + player.getLocation().getChunk().getZ() + " ist nun immer geladen!");
            }
        } else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return false;
    }
}
