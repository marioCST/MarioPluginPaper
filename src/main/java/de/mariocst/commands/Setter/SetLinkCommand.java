package de.mariocst.commands.Setter;

import de.mariocst.MarioMain;
import de.mariocst.utils.Config;
import de.mariocst.utils.DiscordLink;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetLinkCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String msg = "";

        if(!(sender instanceof Player)) {
            if (args.length >= 1) {
                for(int i = 0; i < args.length; i++) {
                    msg = msg + args[i] + " ";
                }

                DiscordLink.getDiscordLink().setLink(msg);
                MarioMain.getInstance().log("Der Discord Link ist nun: " + msg);
                MarioMain.getInstance().saveConfigs();
            } else {
                MarioMain.getInstance().log("§cUsage: §e/setlink <Link>");
            }
            return false;
        }

        Player player = (Player) sender;
        if(player.hasPermission("mario.setlink") || player.hasPermission("*") || player.isOp()) {
            if (args.length >= 1) {
                for(int i = 0; i < args.length; i++) {
                    msg = msg + args[i] + " ";
                }

                DiscordLink.getDiscordLink().setLink(msg);
                sender.sendMessage(MarioMain.getPrefix() + "Der Discord Link ist nun: " + msg);
                MarioMain.getInstance().saveConfigs();
            } else {
                sender.sendMessage("§cUsage: §e/setlink <Link>");
            }
        } else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return false;
    }
}
