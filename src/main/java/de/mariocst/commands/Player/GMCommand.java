package de.mariocst.commands.Player;

import de.mariocst.MarioMain;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GMCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            MarioMain.INSTANCE.log("Dieser Command kann nur InGame ausgeführt werden!");
            return false;
        }

        Player player = (Player) sender;
        if(player.hasPermission("mario.gm") || player.hasPermission("*") || player.isOp()) {
            String msg = String.join(" ", args);

            if (args.length == 1) {
                if(msg.equals("0") || msg.equalsIgnoreCase("survival")) {
                    player.setGameMode(GameMode.SURVIVAL);
                    sender.sendMessage(MarioMain.PREFIX + "Dein Gamemode wurde auf Survival gestellt!");
                } else if (msg.equals("1") || msg.equalsIgnoreCase("creative")) {
                    player.setGameMode(GameMode.CREATIVE);
                    sender.sendMessage(MarioMain.PREFIX + "Dein Gamemode wurde auf Creative gestellt!");
                } else if (msg.equals("2") || msg.equalsIgnoreCase("adventure")) {
                    player.setGameMode(GameMode.ADVENTURE);
                    sender.sendMessage(MarioMain.PREFIX + "Dein Gamemode wurde auf Adventure gestellt!");
                } else if (msg.equals("3") || msg.equalsIgnoreCase("spectator")) {
                    player.setGameMode(GameMode.ADVENTURE);
                    sender.sendMessage(MarioMain.PREFIX + "Dein Gamemode wurde auf Spectator gestellt!");
                } else {
                    sender.sendMessage(MarioMain.PREFIX + "Bitte gib einen gültigen Gamemode ein!");
                }
            } else {
                sender.sendMessage(MarioMain.PREFIX + "Usage: /gm 0 oder 1 oder 2 oder 3 oder survival oder creative oder adventure oder spectator");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
            }
        } else {
            player.sendMessage(MarioMain.PREFIX + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return false;
    }
}
