package de.mariocst.scoreboard;

import de.mariocst.MarioMain;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class MarioScoreboard {
    private final Objective objective;
    private final Player player;
    private int socialId;

    public MarioScoreboard(Component displayName, Scoreboard scoreboard, @Nullable Player player) {
        this.socialId = 0;

        this.player = player;

        if (scoreboard.getObjective("display") != null) {
            Objects.requireNonNull(scoreboard.getObjective("deaths")).unregister();
        }

        this.objective = scoreboard.registerNewObjective("display", "dummy", displayName);
        this.objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        this.createScoreboard();
        this.run();
    }

    public void createScoreboard() {
        if (this.player == null) return;

        this.setScore(ChatColor.BLACK.toString(), 4);

        this.setScore("§7Dein Rang:", 3);

        if (player.isOp()) {
            this.setScore("§cOperator", 2);
        }
        else {
            this.setScore("§7Spieler", 2);
        }

        this.setScore(ChatColor.GOLD.toString(), 1);
    }

    public void setScore(String content, int score) {
        this.objective.getScore(content).setScore(score);
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
