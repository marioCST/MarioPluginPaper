package de.mariocst.commands.World;

import de.mariocst.MarioMain;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WorldCreateCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            MarioMain.getInstance().log("Bitte führe den Command InGame aus!");
            return false;
        }

        Player player = (Player) sender;
        if(player.hasPermission("mario.worldcreate") || player.hasPermission("*") || player.isOp()) {
            try {
                if (args.length == 1) {
                    if (MarioMain.getInstance().getServer().getWorld(args[0]) == null) {
                        MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0]));

                        player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0] + " wurde erstellt!");
                    }
                    else {
                        player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0] + " existiert!");
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                    }
                }
                else {
                    player.sendMessage(MarioMain.getPrefix() + "/worldcreate <Welt>");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                player.sendMessage(MarioMain.getPrefix() + "/worldcreate <Welt>");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
            }
        } else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return false;
    }
}
