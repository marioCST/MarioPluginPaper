package de.mariocst.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {

        Player player = event.getPlayer();

        if(player.getDisplayName().equals("marioCST")) {
            event.setFormat(ChatColor.DARK_RED + "%1$s" + ChatColor.DARK_GRAY + ": " + ChatColor.YELLOW + "%2$s");
        } else if(player.getDisplayName().equals("Hegge06")) {
            event.setFormat(ChatColor.DARK_PURPLE + "%1$s" + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + "%2$s");
        } else if(player.getDisplayName().equals("Pixellord05")) {
            event.setFormat(ChatColor.DARK_AQUA + "%1$s" + ChatColor.DARK_GRAY + ": " + ChatColor.RED + "%2$s");
        } else if(player.getDisplayName().equals("Godlukas")) {
            event.setFormat(ChatColor.DARK_AQUA + "%1$s" + ChatColor.DARK_GRAY + ": " + ChatColor.RED + "%2$s");
        } else if(player.getDisplayName().equals("_xZockerLP_")) {
            event.setFormat(ChatColor.DARK_AQUA + "%1$s" + ChatColor.DARK_GRAY + ": " + ChatColor.RED + "%2$s");
        } else {
            event.setFormat(ChatColor.AQUA + "%1$s" + ChatColor.DARK_GRAY + ": " + ChatColor.WHITE + "%2$s");
        }

        event.setMessage((player.isOp() ? ChatColor.translateAlternateColorCodes( '&', event.getMessage()) : event.getMessage()));

    }

}
