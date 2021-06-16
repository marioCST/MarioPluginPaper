package de.mariocst.commands.Player;

import de.mariocst.MarioMain;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            try {
                if (args.length == 1) {
                    Player t = MarioMain.getInstance().getServer().getPlayer(args[0]);

                    try {
                        if (t != null) {
                            if(!(t.getAllowFlight())) {
                                t.setAllowFlight(true);
                                t.setFlying(true);
                                t.sendMessage(MarioMain.getPrefix() + "§aDu fliegst nun.");
                                sender.sendMessage(MarioMain.getPrefix() + "§aDer Spieler " + t.getName() + " fliegt nun.");
                            } else {
                                t.setAllowFlight(false);
                                t.setFlying(false);
                                t.sendMessage(MarioMain.getPrefix() + "§4Du fliegst nun nicht mehr.");
                                sender.sendMessage(MarioMain.getPrefix() + "§4Der Spieler " + t.getName() + " fliegt nun nicht mehr.");
                            }
                        }
                        else {
                            sender.sendMessage(MarioMain.getPrefix() + "Dieser Spieler existiert nicht!");
                        }
                    }
                    catch (NullPointerException e) {
                        e.printStackTrace();
                        sender.sendMessage(MarioMain.getPrefix() + "Dieser Spieler existiert nicht!");
                    }
                }
                else {
                    sender.sendMessage(MarioMain.getPrefix() + "Ungültige Parameter Länge!");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                sender.sendMessage(MarioMain.getPrefix() + "Ungültige Parameter Länge!");
            }
            return false;
        }

        Player player = (Player) sender;
        if(player.hasPermission("mario.fly") || player.hasPermission("*") || player.isOp()) {
            try {
                if (args.length == 0) {
                    if(!(player.getAllowFlight())) {
                        player.setAllowFlight(true);
                        player.setFlying(true);
                        player.sendMessage(MarioMain.getPrefix() + "§aDu fliegst nun.");
                    } else {
                        player.setAllowFlight(false);
                        player.setFlying(false);
                        player.sendMessage(MarioMain.getPrefix() + "§4Du fliegst nun nicht mehr.");
                    }
                }
                else if (args.length == 1) {
                    Player t = MarioMain.getInstance().getServer().getPlayer(args[0]);

                    try {
                        if (t != null) {
                            if(!(t.getAllowFlight())) {
                                t.setAllowFlight(true);
                                t.setFlying(true);
                                t.sendMessage(MarioMain.getPrefix() + "§aDu fliegst nun.");
                                player.sendMessage(MarioMain.getPrefix() + "§aDer Spieler " + t.getName() + " fliegt nun.");
                            } else {
                                t.setAllowFlight(false);
                                t.setFlying(false);
                                t.sendMessage(MarioMain.getPrefix() + "§4Du fliegst nun nicht mehr.");
                                player.sendMessage(MarioMain.getPrefix() + "§4Der Spieler " + t.getName() + " fliegt nun nicht mehr.");
                            }
                        }
                        else {
                            player.sendMessage(MarioMain.getPrefix() + "Dieser Spieler existiert nicht!");
                            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                        }
                    }
                    catch (NullPointerException e) {
                        e.printStackTrace();
                        player.sendMessage(MarioMain.getPrefix() + "Dieser Spieler existiert nicht!");
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                    }
                }
                else {
                    player.sendMessage(MarioMain.getPrefix() + "Ungültige Parameter Länge!");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                player.sendMessage(MarioMain.getPrefix() + "Ungültige Parameter Länge!");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
            }
        } else {
            sender.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return false;
    }
}
