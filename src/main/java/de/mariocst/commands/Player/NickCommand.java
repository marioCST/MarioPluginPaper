package de.mariocst.commands.Player;

import de.mariocst.MarioMain;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NickCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            MarioMain.getInstance().log("Dieser Command kann nur InGame ausgeführt werden!");
            return true;
        }

        Player player = (Player) sender;

        if(player.hasPermission("mario.nick") || player.hasPermission("*") || player.isOp()) {
            if (args.length == 1) {
                if (args[0].length() < 16) {
                    for (Player t : MarioMain.getInstance().getServer().getOnlinePlayers()) {
                        if (args[0].equals(t.getName()) && !args[0].equals(player.getName())) {
                            sender.sendMessage(MarioMain.getPrefix() + "Bitte ''fake'' keine Spieler!");
                        }
                        else if (args[0].equals(player.getName())) {
                            sender.sendMessage(MarioMain.getPrefix() + "/unnick");
                        }
                        else if (args[0].equals(t.getCustomName())) {
                            sender.sendMessage(MarioMain.getPrefix() + "Jemand hat sich bereits " + args[0] + " genannt!");
                        }
                        else {
                            String newNick = String.join(" ",  args);

                            player.setDisplayName(newNick);
                            player.setPlayerListName(newNick);
                            player.setCustomName(newNick);

                            sender.sendMessage(MarioMain.getPrefix() + "Dein Nickname wurde erfolgreich zu " + newNick + " geändert!");
                        }
                    }
                } else {
                    sender.sendMessage(MarioMain.getPrefix() + "Bitte wähle einen Namen, der kürzer als 16 Zeichen ist!");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                }
            } else {
                sender.sendMessage(MarioMain.getPrefix() + "Bitte gib einen Nickname ein, oder suche dir einen, der keine Leerzeichen hat!");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
            }
        } else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return true;
    }
}
