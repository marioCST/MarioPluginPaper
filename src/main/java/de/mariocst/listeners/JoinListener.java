package de.mariocst.listeners;

import de.mariocst.MarioMain;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
            Player player = event.getPlayer();

            if(player.getName().equals("marioCST")) {
                player.sendMessage(MarioMain.PREFIX + "§a§lHallo marioCST!");
                event.setJoinMessage(MarioMain.PREFIX + "§4§lOWNER §8| §amarioCST §bist nun Online!");
            } else if(player.getName().equals("Hegge06")) {
                player.sendMessage(MarioMain.PREFIX + "§a§lMoin Hegge! marioCST hier. Habe das hier selber gecoded. Viel Spaß auf dem Server ;)");
                event.setJoinMessage(MarioMain.PREFIX + "§5§lFreund++ §8| §aHegge06 §bist nun Online!");
            } else if(player.getName().equals("Pixellord05")) {
                player.sendMessage(MarioMain.PREFIX + "§a§lHi Simon. marioCST hier. Ich kann ein bisschen programmieren und hoffe, dass du Spaß auf dem Server hast!");
                event.setJoinMessage(MarioMain.PREFIX + "§6§lSupporter §8| §r§aPixellord05 §bist nun Online!");
            } else if(player.getName().equals("Godlukas")) {
                player.sendMessage(MarioMain.PREFIX + "§a§lMoin Lukas (denke ich?)! Habe mich mal an ein eigenes Server Join and Quit Message PlugIn gesetzt. Hoffe es gefällt dir (wahrscheinlich bekommst du einen Anfall wie bei meinem Discord Bot xD)");
                event.setJoinMessage(MarioMain.PREFIX + "§7&lSpieler &8| &7Godlukas &aist nun Online!");
            } else if(player.getName().equals("_xZockerLP_")) {
                player.sendMessage(MarioMain.PREFIX + "§a§lHi Damian. Habe hier ein PlugIn gemacht.");
                event.setJoinMessage(MarioMain.PREFIX + "§5§lFreund++ §8| §7_xZockerLP_ §aist nun Online!");
            } else {
                player.sendMessage(MarioMain.PREFIX + ChatColor.GOLD + "Hallo und willkommen auf dem Server von §4§lOWNER §amarioCST!");
                event.setJoinMessage(MarioMain.PREFIX + ChatColor.GREEN + player.getName() + ChatColor.DARK_GREEN + ChatColor.BOLD + ", der wilde Spieler, ist erschienen");
            }
    }
}
