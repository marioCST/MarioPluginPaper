package de.mariocst.commands.Player;

import de.mariocst.MarioMain;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class RealnameCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)) {
            MarioMain.INSTANCE.log("InDev");
        } else {
            Player player = (Player) sender;

            if (player.hasPermission("mario.realname") || player.isOp()) {
                if (player.getName().equals("marioCST")) {
                    String target = args[0];
                    Player t = MarioMain.getInstance().getServer().getPlayer(target);

                    if (args.length == 1) {
                        try {
                            if (null != t) {
                                if (t.getName().equals(args[0])) {
                                    sender.sendMessage(MarioMain.PREFIX + "Dieser Spieler ist NICHT genickt!");
                                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
                                } else {
                                    sender.sendMessage(MarioMain.PREFIX + "Der Echte Name von " + args[0] + " ist: " + t.getName());
                                }
                            } else  {
                                sender.sendMessage(MarioMain.PREFIX + "java.lang.NullPointerException lol");
                                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
                            }
                        } catch (NullPointerException e) {
                            sender.sendMessage(MarioMain.PREFIX + "java.lang.NullPointerException lol");
                            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
                            e.printStackTrace();
                        }
                    } else if (args.length == 0) {
                        sender.sendMessage(MarioMain.PREFIX + "Bitte gib den Nickname an.");
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
                    } else {
                        sender.sendMessage(MarioMain.PREFIX + "§cBitte wähle einen gültigen Namen!");
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
                    }
                } else {
                    sender.sendMessage(MarioMain.PREFIX + "InDev");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
                }
            } else {
                sender.sendMessage(MarioMain.PREFIX + "§cKeine Rechte!");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
            }
        }
        return false;
    }
}
