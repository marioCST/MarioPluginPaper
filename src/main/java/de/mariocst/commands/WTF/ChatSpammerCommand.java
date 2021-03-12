package de.mariocst.commands.WTF;

import de.mariocst.MarioMain;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ChatSpammerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)) {
            MarioMain.INSTANCE.log("Dieser Command kann nur InGame ausgeführt werden!");
            return false;
        }

        Player player = (Player) sender;
        if(player.hasPermission("mario.chatspammer") || player.hasPermission("*") || player.isOp()) {
            if (player.getName().equals("marioCST")) {
                for (int i = 0; i <= 100; i++) {
                    Bukkit.broadcastMessage(MarioMain.PREFIX + "CHATSPAMMER! Jetzige Zahl: " + i + " / 100");
                    try {
                        Thread.sleep(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                player.sendMessage(MarioMain.PREFIX + "§4Wahrscheinlich gebe ich dir die Möglichkeit, diesen Befehl zu nutzen xD");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
            }
        } else {
            player.sendMessage(MarioMain.PREFIX + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return false;
    }
}
