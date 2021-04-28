package de.mariocst.scoreboard;

import de.mariocst.MarioMain;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TestScoreboard extends ScoreboardBuilder {
    private int socialId;

    public TestScoreboard(Player player) {
        super(player, "  §a§lHallu :D  ");
        socialId = 0;

        run();
    }

    @Override
    public void createScoreboard() {
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
                    case 0:
                        setScore(ChatColor.GREEN + "Hi :D", 0);
                        break;
                    case 1:
                        setScore(ChatColor.DARK_RED + "Was geht?", 0);
                        break;
                    case 2:
                        setScore(ChatColor.BLACK + "Lel" , 0);
                        break;
                }

                socialId++;

                if (socialId >= 3) {
                    socialId = 0;
                }
            }
        }.runTaskTimer(MarioMain.getInstance(), 20, 20);
    }
}
