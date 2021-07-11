package de.mariocst.commands.Others;

import de.mariocst.MarioMain;
import de.mariocst.commands.Setter.SetLinkCommand;
import de.mariocst.utils.DiscordLink;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DiscordCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            MarioMain.getInstance().log("Unser Discord: " + DiscordLink.getDiscordLink().getLink());
            return false;
        }

        Player player = (Player) sender;
        if(player.hasPermission("mario.discord") || player.hasPermission("*") || player.isOp()) {
            sender.sendMessage(MarioMain.getPrefix() + "Unser Discord: " + DiscordLink.getDiscordLink().getLink());
        } else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return false;
    }
}
