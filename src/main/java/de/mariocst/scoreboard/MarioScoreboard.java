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
            Objects.requireNonNull(scoreboard.getObjective("display")).unregister();
        }

        this.objective = scoreboard.registerNewObjective("display", "dummy", displayName);
        this.objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        if (player == null) return;

        this.setDefaultScore();
        this.run();
    }

    private void setDefaultScore() {
        setScore("§f»»»»»»««««««", 0);

        if (player != null) {
            setScore(ChatColor.BLACK.toString(), 4);

            setScore("§7Dein Rang:", 3);

            if (player.isOp()) {
                setScore("§cOperator", 2);
            }
            else {
                setScore("§7Spieler", 2);
            }

            setScore(ChatColor.GOLD.toString(), 1);
        }

        setScore("§f»»»»»»««««««§f", 5);
    }

    public void setScore(String content, int score) {
        this.objective.getScore(content).setScore(score);
    }

    public void editScore(String oldContent, String newContent, int score) {
        this.objective.getScore(oldContent).resetScore();
        this.objective.getScore(newContent).setScore(score);
    }

    public void removeScore(String content) {
        this.objective.getScore(content).resetScore();
    }

    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (player == null) return;

                switch (socialId) {
                    case 0 -> {
                        editScore("§6»§f»»»»»«««««§6«§f", "§f»»»»»»««««««§f", 0);

                        if (player.isOp()) {
                            removeScore("§7Spieler");
                            setScore("§cOperator", 2);
                        }
                        else {
                            removeScore("§cOperator");
                            setScore("§7Spieler", 2);
                        }

                        editScore("§6»§f»»»»»«««««§6«", "§f»»»»»»««««««", 5);
                    }
                    case 1 -> {
                        editScore("§f»»»»»»««««««§f", "§f»»»»»§6»«§f«««««§f", 0);

                        if (player.isOp()) {
                            removeScore("§7Spieler");
                            setScore("§cOperator", 2);
                        }
                        else {
                            removeScore("§cOperator");
                            setScore("§7Spieler", 2);
                        }

                        editScore("§f»»»»»»««««««", "§f»»»»»§6»«§f«««««", 5);
                    }
                    case 2 -> {
                        editScore("§f»»»»»§6»«§f«««««§f", "§f»»»»§6»»««§f««««§f", 0);

                        if (player.isOp()) {
                            removeScore("§7Spieler");
                            setScore("§cOperator", 2);
                        }
                        else {
                            removeScore("§cOperator");
                            setScore("§7Spieler", 2);
                        }

                        editScore("§f»»»»»§6»«§f«««««", "§f»»»»§6»»««§f««««", 5);
                    }
                    case 3 -> {
                        editScore("§f»»»»§6»»««§f««««§f", "§f»»»§6»»»«««§f«««§f", 0);

                        if (player.isOp()) {
                            removeScore("§7Spieler");
                            setScore("§cOperator", 2);
                        }
                        else {
                            removeScore("§cOperator");
                            setScore("§7Spieler", 2);
                        }

                        editScore("§f»»»»§6»»««§f««««", "§f»»»§6»»»«««§f«««", 5);
                    }
                    case 4 -> {
                        editScore("§f»»»§6»»»«««§f«««§f", "§f»»§6»»»»««««§f««§f", 0);

                        if (player.isOp()) {
                            removeScore("§7Spieler");
                            setScore("§cOperator", 2);
                        }
                        else {
                            removeScore("§cOperator");
                            setScore("§7Spieler", 2);
                        }

                        editScore("§f»»»§6»»»«««§f«««", "§f»»§6»»»»««««§f««", 5);
                    }
                    case 5 -> {
                        editScore("§f»»§6»»»»««««§f««§f", "§f»§6»»»»»«««««§f«§f", 0);

                        if (player.isOp()) {
                            removeScore("§7Spieler");
                            setScore("§cOperator", 2);
                        }
                        else {
                            removeScore("§cOperator");
                            setScore("§7Spieler", 2);
                        }

                        editScore("§f»»§6»»»»««««§f««", "§f»§6»»»»»«««««§f«", 5);
                    }
                    case 6 -> {
                        editScore("§f»§6»»»»»«««««§f«§f", "§6»»»»»»««««««§f", 0);

                        if (player.isOp()) {
                            removeScore("§7Spieler");
                            setScore("§cOperator", 2);
                        }
                        else {
                            removeScore("§cOperator");
                            setScore("§7Spieler", 2);
                        }

                        editScore("§f»§6»»»»»«««««§f«", "§6»»»»»»««««««", 5);
                    }
                    case 7 -> {
                        editScore("§6»»»»»»««««««§f", "§6»»»»»§f»«§6«««««§f", 0);

                        if (player.isOp()) {
                            removeScore("§7Spieler");
                            setScore("§cOperator", 2);
                        }
                        else {
                            removeScore("§cOperator");
                            setScore("§7Spieler", 2);
                        }

                        editScore("§6»»»»»»««««««", "§6»»»»»§f»«§6«««««", 5);
                    }
                    case 8 -> {
                        editScore("§6»»»»»§f»«§6«««««§f", "§6»»»»§f»»««§6««««§f", 0);

                        if (player.isOp()) {
                            removeScore("§7Spieler");
                            setScore("§cOperator", 2);
                        }
                        else {
                            removeScore("§cOperator");
                            setScore("§7Spieler", 2);
                        }

                        editScore("§6»»»»»§f»«§6«««««", "§6»»»»§f»»««§6««««", 5);
                    }
                    case 9 -> {
                        editScore("§6»»»»§f»»««§6««««§f", "§6»»»§f»»»«««§6«««§f", 0);

                        if (player.isOp()) {
                            removeScore("§7Spieler");
                            setScore("§cOperator", 2);
                        }
                        else {
                            removeScore("§cOperator");
                            setScore("§7Spieler", 2);
                        }

                        editScore("§6»»»»§f»»««§6««««", "§6»»»§f»»»«««§6«««", 5);
                    }
                    case 10 -> {
                        editScore("§6»»»§f»»»«««§6«««§f", "§6»»§f»»»»««««§6««§f", 0);

                        if (player.isOp()) {
                            removeScore("§7Spieler");
                            setScore("§cOperator", 2);
                        }
                        else {
                            removeScore("§cOperator");
                            setScore("§7Spieler", 2);
                        }

                        editScore("§6»»»§f»»»«««§6«««", "§6»»§f»»»»««««§6««", 5);
                    }
                    case 11 -> {
                        editScore("§6»»§f»»»»««««§6««§f", "§6»§f»»»»»«««««§6«§f", 0);

                        if (player.isOp()) {
                            removeScore("§7Spieler");
                            setScore("§cOperator", 2);
                        }
                        else {
                            removeScore("§cOperator");
                            setScore("§7Spieler", 2);
                        }

                        editScore("§6»»§f»»»»««««§6««", "§6»§f»»»»»«««««§6«", 5);
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
