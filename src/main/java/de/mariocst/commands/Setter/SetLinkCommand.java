package de.mariocst.commands.Setter;

import de.mariocst.MarioMain;
import de.mariocst.utils.DiscordLink;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetLinkCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        StringBuilder msg = new StringBuilder();

        if (!(sender instanceof Player player)) {
            if (args.length >= 1) {
                for (String arg : args) {
                    msg.append(arg).append(" ");
                }

                DiscordLink.getDiscordLink().setLink(msg.toString());
                sender.sendMessage(MarioMain.getPrefix() + "Der Discord Link ist nun: " + msg);
                MarioMain.getInstance().saveConfigs();
            }
            else {
                sender.sendMessage(MarioMain.getPrefix() + "/setlink <Link>");
            }
            return false;
        }

        if (player.hasPermission("mario.setlink") || player.hasPermission("mario.*") || player.hasPermission("*") || player.isOp()) {
            if (args.length >= 1) {
                for (String arg : args) {
                    msg.append(arg).append(" ");
                }

                DiscordLink.getDiscordLink().setLink(msg.toString());
                player.sendMessage(MarioMain.getPrefix() + "Der Discord Link ist nun: " + msg);
                MarioMain.getInstance().saveConfigs();
            } else {
                player.sendMessage(MarioMain.getPrefix() + "/setlink <Link>");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
            }
        }
        else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
        }
        return false;
    }
}
