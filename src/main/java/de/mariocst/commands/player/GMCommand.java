package de.mariocst.commands.player;

import de.mariocst.MarioMain;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GMCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        boolean b = args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("su");
        boolean b1 = args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("c");
        boolean b2 = args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("a");
        boolean b3 = args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("sp");

        if (!(sender instanceof Player player)) {
            try {
                if (args.length == 2) {
                    Player t = MarioMain.getInstance().getServer().getPlayer(args[1]);

                    try {
                        if (t != null) {
                            if (b) {
                                t.setGameMode(GameMode.SURVIVAL);
                                t.sendMessage(MarioMain.getPrefix() + "Dein Gamemode wurde auf Survival gestellt!");
                                sender.sendMessage(MarioMain.getPrefix() + "Der Gamemode von " + t.getName() + " ist auf Survival gesetzt worden!");
                            }
                            else if (b1) {
                                t.setGameMode(GameMode.CREATIVE);
                                t.sendMessage(MarioMain.getPrefix() + "Dein Gamemode wurde auf Creative gestellt!");
                                sender.sendMessage(MarioMain.getPrefix() + "Der Gamemode von " + t.getName() + " ist auf Creative gesetzt worden!");
                            }
                            else if (b2) {
                                t.setGameMode(GameMode.ADVENTURE);
                                t.sendMessage(MarioMain.getPrefix() + "Dein Gamemode wurde auf Adventure gestellt!");
                                sender.sendMessage(MarioMain.getPrefix() + "Der Gamemode von " + t.getName() + " ist auf Adventure gesetzt worden!");
                            }
                            else if (b3) {
                                t.setGameMode(GameMode.SPECTATOR);
                                t.sendMessage(MarioMain.getPrefix() + "Dein Gamemode wurde auf Spectator gestellt!");
                                sender.sendMessage(MarioMain.getPrefix() + "Der Gamemode von " + t.getName() + " ist auf Spectator gesetzt worden!");
                            }
                            else {
                                sender.sendMessage(MarioMain.getPrefix() + "Bitte gib einen gültigen Gamemode ein!");
                            }
                        }
                        else {
                            sender.sendMessage(MarioMain.getPrefix() + "Der Spieler " + args[1] + " existiert nicht!");
                        }
                    }
                    catch (NullPointerException e) {
                        sender.sendMessage(MarioMain.getPrefix() + "Der Spieler " + args[1] + " existiert nicht!");
                    }
                }
                else {
                    sender.sendMessage(MarioMain.getPrefix() + "/gm <0|1|2|3|surivival|creative|adventure|spectator|su|c|a|sp> <Spieler>");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                sender.sendMessage(MarioMain.getPrefix() + "/gm <0|1|2|3|surivival|creative|adventure|spectator|su|c|a|sp> <Spieler>");
            }
            return false;
        }

        if (player.hasPermission("mario.gm") || player.hasPermission("mario.*") || player.hasPermission("*") || player.isOp()) {
            try {
                if (args.length == 1) {
                    if (b) {
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(MarioMain.getPrefix() + "Dein Gamemode wurde auf Survival gestellt!");
                    }
                    else if (b1) {
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(MarioMain.getPrefix() + "Dein Gamemode wurde auf Creative gestellt!");
                    }
                    else if (b2) {
                        player.setGameMode(GameMode.ADVENTURE);
                        player.sendMessage(MarioMain.getPrefix() + "Dein Gamemode wurde auf Adventure gestellt!");
                    }
                    else if (b3) {
                        player.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage(MarioMain.getPrefix() + "Dein Gamemode wurde auf Spectator gestellt!");
                    }
                    else {
                        player.sendMessage(MarioMain.getPrefix() + "Bitte gib einen gültigen Gamemode ein!");
                    }
                }
                else if (args.length == 2) {
                    Player t = MarioMain.getInstance().getServer().getPlayer(args[1]);

                    try {
                        if (t != null) {
                            if (b) {
                                t.setGameMode(GameMode.SURVIVAL);
                                t.sendMessage(MarioMain.getPrefix() + "Dein Gamemode wurde auf Survival gestellt!");
                                player.sendMessage(MarioMain.getPrefix() + "Der Gamemode von " + t.getName() + " ist auf Survival gesetzt worden!");
                            }
                            else if (b1) {
                                t.setGameMode(GameMode.CREATIVE);
                                t.sendMessage(MarioMain.getPrefix() + "Dein Gamemode wurde auf Creative gestellt!");
                                player.sendMessage(MarioMain.getPrefix() + "Der Gamemode von " + t.getName() + " ist auf Creative gesetzt worden!");
                            }
                            else if (b2) {
                                t.setGameMode(GameMode.ADVENTURE);
                                t.sendMessage(MarioMain.getPrefix() + "Dein Gamemode wurde auf Adventure gestellt!");
                                player.sendMessage(MarioMain.getPrefix() + "Der Gamemode von " + t.getName() + " ist auf Adventure gesetzt worden!");
                            }
                            else if (b3) {
                                t.setGameMode(GameMode.SPECTATOR);
                                t.sendMessage(MarioMain.getPrefix() + "Dein Gamemode wurde auf Spectator gestellt!");
                                player.sendMessage(MarioMain.getPrefix() + "Der Gamemode von " + t.getName() + " ist auf Spectator gesetzt worden!");
                            }
                            else {
                                player.sendMessage(MarioMain.getPrefix() + "Bitte gib einen gültigen Gamemode ein!");
                            }
                        }
                        else {
                            player.sendMessage(MarioMain.getPrefix() + "Der Spieler " + args[1] + " existiert nicht!");
                            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
                        }
                    }
                    catch (NullPointerException e) {
                        player.sendMessage(MarioMain.getPrefix() + "Der Spieler " + args[1] + " existiert nicht!");
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
                    }
                }
                else {
                    player.sendMessage(MarioMain.getPrefix() + "/gm <0|1|2|3|surivival|creative|adventure|spectator|su|c|a|sp> [Spieler]");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                player.sendMessage(MarioMain.getPrefix() + "/gm <0|1|2|3|surivival|creative|adventure|spectator|su|c|a|sp> [Spieler]");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
            }
        } else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
        }
        return false;
    }
}
