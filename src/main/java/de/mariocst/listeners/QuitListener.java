package de.mariocst.listeners;

import de.mariocst.MarioMain;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if(player.getDisplayName().equals("marioCST")) {
            event.setQuitMessage(MarioMain.PREFIX + "§4§lOWNER §8| §amarioCST §bist geflohen...");
        } else if(player.getDisplayName().equals("Hegge06")) {
            event.setQuitMessage(MarioMain.PREFIX + "§5§lFreund++ §8| §aHegg06 §bist geflohen...");
        } else if(player.getDisplayName().equals("Pixellord05")) {
            event.setQuitMessage(MarioMain.PREFIX + "§6§lSupporter §8| §aPixellord05 §bist geflohen...");
        } else if(player.getDisplayName().equals("Godlukas")) {
            event.setQuitMessage(MarioMain.PREFIX + "§7§lSpieler §8| §7Godlukas §aist geflohen...");
        } else if(player.getDisplayName().equals("_xZockerLP_")) {
            event.setQuitMessage(MarioMain.PREFIX + "§5§lFreund++ §8| §7_xZockerLP_ §aist geflohen...");
        } else {
            event.setQuitMessage(MarioMain.PREFIX + ChatColor.RED + "Der Spieler " + player.getName() + " ist geflohen...");
        }

    }

}
