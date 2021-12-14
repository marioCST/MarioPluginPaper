package de.mariocst.listeners;

import de.mariocst.MarioMain;
import de.mariocst.scoreboard.MarioScoreboard;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        Scoreboard scoreboard = MarioMain.getInstance().getServer().getScoreboardManager().getNewScoreboard();
        player.setScoreboard(scoreboard);
        new MarioScoreboard(Component.text("  " + MarioMain.getPrefix() + "  "), scoreboard, player);
    }
}
