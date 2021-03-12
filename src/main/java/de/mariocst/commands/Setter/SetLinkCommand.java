package de.mariocst.commands.Setter;

import de.mariocst.MarioMain;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetLinkCommand implements CommandExecutor {
    public static String Link  = "Kein Link definiert";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String msg = "";

        if(!(sender instanceof Player)) {
            if (args.length >= 1) {
                for(int i = 0; i < args.length; i++) {
                    msg = msg + args[i] + " ";
                }
                Link = msg;

                sender.sendMessage("Der Discord Link ist nun: " + Link);
            } else {
                sender.sendMessage("§cUsage: §e/setlink <Link>");
            }
            return false;
        }

        Player player = (Player) sender;
        if(player.hasPermission("mario.setlink") || player.hasPermission("*") || player.isOp()) {
            if (args.length >= 1) {
                for(int i = 0; i < args.length; i++) {
                    msg = msg + args[i] + " ";
                }
                Link = msg;

                sender.sendMessage(MarioMain.PREFIX + "Der Discord Link ist nun: " + Link);
            } else {
                sender.sendMessage("§cUsage: §e/setlink <Link>");
            }
        } else {
            player.sendMessage(MarioMain.PREFIX + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return false;
    }
}
