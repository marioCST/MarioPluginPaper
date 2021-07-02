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
            String msg = String.join(" ", args);

            try {
                if (args.length == 2) {
                    Player t = MarioMain.getInstance().getServer().getPlayer(args[1]);

                    try {
                        if (t != null) {
                            if(msg.equals("0") || msg.equalsIgnoreCase("survival") || msg.equalsIgnoreCase("su")) {
                                t.setGameMode(GameMode.SURVIVAL);
                                t.sendMessage(MarioMain.getPrefix() + "Dein Gamemode wurde auf Survival gestellt!");
                                sender.sendMessage(MarioMain.getPrefix() + "Der Gamemode von " + t.getName() + " ist auf Survival gesetzt worden!");
                            } else if (msg.equals("1") || msg.equalsIgnoreCase("creative") || msg.equalsIgnoreCase("c")) {
                                t.setGameMode(GameMode.CREATIVE);
                                t.sendMessage(MarioMain.getPrefix() + "Dein Gamemode wurde auf Creative gestellt!");
                                sender.sendMessage(MarioMain.getPrefix() + "Der Gamemode von " + t.getName() + " ist auf Creative gesetzt worden!");
                            } else if (msg.equals("2") || msg.equalsIgnoreCase("adventure") || msg.equalsIgnoreCase("a")) {
                                t.setGameMode(GameMode.ADVENTURE);
                                t.sendMessage(MarioMain.getPrefix() + "Dein Gamemode wurde auf Adventure gestellt!");
                                sender.sendMessage(MarioMain.getPrefix() + "Der Gamemode von " + t.getName() + " ist auf Adventure gesetzt worden!");
                            } else if (msg.equals("3") || msg.equalsIgnoreCase("spectator") || msg.equalsIgnoreCase("sp")) {
                                t.setGameMode(GameMode.SPECTATOR);
                                t.sendMessage(MarioMain.getPrefix() + "Dein Gamemode wurde auf Spectator gestellt!");
                                sender.sendMessage(MarioMain.getPrefix() + "Der Gamemode von " + t.getName() + " ist auf Spectator gesetzt worden!");
                            } else {
                                sender.sendMessage(MarioMain.getPrefix() + "Bitte gib einen gültigen Gamemode ein!");
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
                    sender.sendMessage(MarioMain.getPrefix() + "Usage: /gm 0 oder 1 oder 2 oder 3 oder survival oder creative oder adventure oder spectator oder su oder c oder a oder sp");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                sender.sendMessage(MarioMain.getPrefix() + "Usage: /gm 0 oder 1 oder 2 oder 3 oder survival oder creative oder adventure oder spectator oder su oder c oder a oder sp");
            }
            return false;
        }

        Player player = (Player) sender;
        if(player.hasPermission("mario.gm") || player.hasPermission("*") || player.isOp()) {
            String msg = String.join(" ", args);

            boolean b = msg.equals("0") || msg.equalsIgnoreCase("survival") || msg.equalsIgnoreCase("su");
            boolean b1 = msg.equals("1") || msg.equalsIgnoreCase("creative") || msg.equalsIgnoreCase("c");
            boolean b2 = msg.equals("2") || msg.equalsIgnoreCase("adventure") || msg.equalsIgnoreCase("a");
            boolean b3 = msg.equals("3") || msg.equalsIgnoreCase("spectator") || msg.equalsIgnoreCase("sp");

            try {
                if (args.length == 1) {
                    if(b) {
                        player.setGameMode(GameMode.SURVIVAL);
                        sender.sendMessage(MarioMain.getPrefix() + "Dein Gamemode wurde auf Survival gestellt!");
                    } else if (b1) {
                        player.setGameMode(GameMode.CREATIVE);
                        sender.sendMessage(MarioMain.getPrefix() + "Dein Gamemode wurde auf Creative gestellt!");
                    } else if (b2) {
                        player.setGameMode(GameMode.ADVENTURE);
                        sender.sendMessage(MarioMain.getPrefix() + "Dein Gamemode wurde auf Adventure gestellt!");
                    } else if (b3) {
                        player.setGameMode(GameMode.ADVENTURE);
                        sender.sendMessage(MarioMain.getPrefix() + "Dein Gamemode wurde auf Spectator gestellt!");
                    } else {
                        sender.sendMessage(MarioMain.getPrefix() + "Bitte gib einen gültigen Gamemode ein!");
                    }
                }
                else if (args.length == 2) {
                    Player t = MarioMain.getInstance().getServer().getPlayer(args[1]);

                    try {
                        if (t != null) {
                            if(b) {
                                t.setGameMode(GameMode.SURVIVAL);
                                t.sendMessage(MarioMain.getPrefix() + "Dein Gamemode wurde auf Survival gestellt!");
                                sender.sendMessage(MarioMain.getPrefix() + "Der Gamemode von " + t.getName() + " ist auf Survival gesetzt worden!");
                            } else if (b1) {
                                t.setGameMode(GameMode.CREATIVE);
                                t.sendMessage(MarioMain.getPrefix() + "Dein Gamemode wurde auf Creative gestellt!");
                                sender.sendMessage(MarioMain.getPrefix() + "Der Gamemode von " + t.getName() + " ist auf Creative gesetzt worden!");
                            } else if (b2) {
                                t.setGameMode(GameMode.ADVENTURE);
                                t.sendMessage(MarioMain.getPrefix() + "Dein Gamemode wurde auf Adventure gestellt!");
                                sender.sendMessage(MarioMain.getPrefix() + "Der Gamemode von " + t.getName() + " ist auf Adventure gesetzt worden!");
                            } else if (b3) {
                                t.setGameMode(GameMode.ADVENTURE);
                                t.sendMessage(MarioMain.getPrefix() + "Dein Gamemode wurde auf Spectator gestellt!");
                                sender.sendMessage(MarioMain.getPrefix() + "Der Gamemode von " + t.getName() + " ist auf Spectator gesetzt worden!");
                            } else {
                                sender.sendMessage(MarioMain.getPrefix() + "Bitte gib einen gültigen Gamemode ein!");
                            }
                        }
                        else {
                            sender.sendMessage(MarioMain.getPrefix() + "Dieser Spieler existiert nicht!");
                            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                        }
                    }
                    catch (NullPointerException e) {
                        e.printStackTrace();
                        sender.sendMessage(MarioMain.getPrefix() + "Dieser Spieler existiert nicht!");
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                    }
                }
                else {
                    sender.sendMessage(MarioMain.getPrefix() + "Usage: /gm 0 oder 1 oder 2 oder 3 oder survival oder creative oder adventure oder spectator oder su oder c oder a oder sp");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                sender.sendMessage(MarioMain.getPrefix() + "Usage: /gm 0 oder 1 oder 2 oder 3 oder survival oder creative oder adventure oder spectator oder su oder c oder a oder sp");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
            }
        } else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return false;
    }
}
