package de.mariocst.scoreboard;

import de.mariocst.MarioMain;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TestScoreboard extends ScoreboardBuilder {
    private int socialId;

    public TestScoreboard(Player player) {
        super(player, "  §6§lmarioCST.de  ");
        socialId = 0;

        run();
    }

    @Override
    public void createScoreboard() {
        setScore(ChatColor.BLACK.toString(), 4);

        setScore("§7Dein Rang:", 3);

        if (player.isOp()){
            setScore("§cOperator", 2);
        }
        else {
            setScore("§7Spieler", 2);
        }

        setScore(ChatColor.GOLD.toString(), 1);
    }

    @Override
    public void update() {

    }

    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {
                switch (socialId) {
                    case 0 -> {
                        setScore("§f»»»»»»««««««", 0);
                        setScore("§f»»»»»»««««««", 5);
                    }
                    case 1 -> {
                        setScore("§f»»»»»§6»«§f«««««", 0);
                        setScore("§f»»»»»§6»«§f«««««", 5);
                    }
                    case 2 -> {
                        setScore("§f»»»»§6»»««§f««««", 0);
                        setScore("§f»»»»§6»»««§f««««", 5);
                    }
                    case 3 -> {
                        setScore("§f»»»§6»»»«««§f«««", 0);
                        setScore("§f»»»§6»»»«««§f«««", 5);
                    }
                    case 4 -> {
                        setScore("§f»»§6»»»»««««§f««", 0);
                        setScore("§f»»§6»»»»««««§f««", 5);
                    }
                    case 5 -> {
                        setScore("§f»§6»»»»»«««««§f«", 0);
                        setScore("§f»§6»»»»»«««««§f«", 5);
                    }
                    case 6 -> {
                        setScore("§6»»»»»»««««««", 0);
                        setScore("§6»»»»»»««««««", 5);
                    }
                    case 7 -> {
                        setScore("§6»»»»»§f»«§6«««««", 0);
                        setScore("§6»»»»»§f»«§6«««««", 5);
                    }
                    case 8 -> {
                        setScore("§6»»»»§f»»««§6««««", 0);
                        setScore("§6»»»»§f»»««§6««««", 5);
                    }
                    case 9 -> {
                        setScore("§6»»»§f»»»«««§6«««", 0);
                        setScore("§6»»»§f»»»«««§6«««", 5);
                    }
                    case 10 -> {
                        setScore("§6»»§f»»»»««««§6««", 0);
                        setScore("§6»»§f»»»»««««§6««", 5);
                    }
                    case 11 -> {
                        setScore("§6»§f»»»»»«««««§6«", 0);
                        setScore("§6»§f»»»»»«««««§6«", 5);
                    }
                }

                socialId++;

                if (socialId >= 12) {
                    socialId = 0;
                }
            }
        }.runTaskTimer(MarioMain.getInstance(), 10, 10);
    }
}
