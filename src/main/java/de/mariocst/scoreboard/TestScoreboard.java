package de.mariocst.scoreboard;

import de.mariocst.timer.Timer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class TestScoreboard extends ScoreboardBuilder{
    public TestScoreboard(Player player) {
        super(player, "  §a§lHallu :D  ");
    }

    @Override
    public void createScoreboard() {
        setScore("§7Dein Rang:", 1);

        if (player.isOp()){
            setScore("§cOperator", 0);
        }
        else {
            setScore("§7Spieler", 0);
        }
    }

    @Override
    public void update() {

    }
}
