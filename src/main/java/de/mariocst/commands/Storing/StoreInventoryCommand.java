package de.mariocst.commands.Storing;

import de.mariocst.MarioMain;
import de.mariocst.backpack.BackpackStored;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StoreInventoryCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            try {
                if (args.length == 1) {
                    Player t = MarioMain.getInstance().getServer().getPlayer(args[0]);

                    try {
                        if (t != null) {
                            BackpackStored backpackStored = MarioMain.getInstance().getBackpackManagerStored().getBackpackStored(t.getUniqueId());

                            int slots = 0;

                            for (int i = 0; i <= 36; i++) {
                                if (t.getInventory().getItem(i - 1) != null) {
                                    backpackStored.getInventory().setItem(i, t.getInventory().getItem(i - 1));

                                    t.getInventory().clear(i - 1);

                                    slots++;
                                }
                            }

                            for (int i = 36; i <= 40; i++) {
                                switch (i) {
                                    case 37:
                                        if (t.getInventory().getHelmet() != null) {
                                            backpackStored.getInventory().setItem(i, t.getInventory().getHelmet());

                                            t.getInventory().clear(103);

                                            slots++;
                                        }
                                        break;
                                    case 38:
                                        if (t.getInventory().getChestplate() != null) {
                                            backpackStored.getInventory().setItem(i, t.getInventory().getChestplate());

                                            t.getInventory().clear(102);

                                            slots++;
                                        }
                                        break;
                                    case 39:
                                        if (t.getInventory().getLeggings() != null) {
                                            backpackStored.getInventory().setItem(i, t.getInventory().getLeggings());

                                            t.getInventory().clear(101);

                                            slots++;
                                        }
                                        break;
                                    case 40:
                                        if (t.getInventory().getBoots() != null) {
                                            backpackStored.getInventory().setItem(i, t.getInventory().getBoots());

                                            t.getInventory().clear(100);

                                            slots++;
                                        }
                                        break;
                                    default:
                                        sender.sendMessage(MarioMain.getPrefix() + "Mario muss noch mal ran haha");
                                        break;
                                }
                            }

                            if (t.getInventory().getItem(-106) != null) {
                                backpackStored.getInventory().setItem(41, t.getInventory().getItem(-106));

                                t.getInventory().clear(-106);

                                slots++;
                            }

                            if (slots == 0) {
                                sender.sendMessage(MarioMain.getPrefix() + "Das Inventar des Spielers ist leer haha");
                            }
                            else {
                                sender.sendMessage(MarioMain.getPrefix() + "Das Inventar von " + t.getName() + " wurde erfolgreich gelagert!");
                                t.sendMessage(MarioMain.getPrefix() + "Dein Inventar wurde gelagert! Frage einen Admin, um dein Inventar wieder zu bekommen lol");
                            }
                        }
                    }
                    catch (NullPointerException e) {
                        e.printStackTrace();
                        sender.sendMessage("Dieser Spieler existiert nicht!");
                    }
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                sender.sendMessage(MarioMain.getPrefix() + "Ungültige Parameter Länge!");
            }
            return true;
        }

        Player player = (Player) sender;

        if(player.hasPermission("mario.storeinventory") || player.hasPermission("*") || player.isOp()) {
            try {
                if (args.length == 1) {
                    Player t = MarioMain.getInstance().getServer().getPlayer(args[0]);

                    try {
                        if (t != null) {
                            BackpackStored backpackStored = MarioMain.getInstance().getBackpackManagerStored().getBackpackStored(t.getUniqueId());

                            int slots = 0;

                            for (int i = 0; i <= 36; i++) {
                                if (t.getInventory().getItem(i) != null) {
                                    backpackStored.getInventory().setItem(i, t.getInventory().getItem(i));

                                    t.getInventory().clear(i);

                                    slots++;
                                }
                            }

                            for (int i = 36; i <= 40; i++) {
                                switch (i) {
                                    case 37:
                                        if (t.getInventory().getHelmet() != null) {
                                            backpackStored.getInventory().setItem(i, t.getInventory().getHelmet());

                                            t.getInventory().clear(97);

                                            slots++;
                                        }
                                        break;
                                    case 38:
                                        if (t.getInventory().getChestplate() != null) {
                                            backpackStored.getInventory().setItem(i, t.getInventory().getChestplate());

                                            t.getInventory().clear(98);

                                            slots++;
                                        }
                                        break;
                                    case 39:
                                        if (t.getInventory().getLeggings() != null) {
                                            backpackStored.getInventory().setItem(i, t.getInventory().getLeggings());

                                            t.getInventory().clear(99);

                                            slots++;
                                        }
                                        break;
                                    case 40:
                                        if (t.getInventory().getBoots() != null) {
                                            backpackStored.getInventory().setItem(i, t.getInventory().getBoots());

                                            t.getInventory().clear(100);

                                            slots++;
                                        }
                                        break;
                                }
                            }

                            if (t.getInventory().getItem(101) != null) {
                                backpackStored.getInventory().setItem(101, t.getInventory().getItem(101));

                                t.getInventory().clear(101);

                                slots++;
                            }

                            if (slots == 0) {
                                player.sendMessage(MarioMain.getPrefix() + "Das Inventar des Spielers ist leer haha");
                            }
                            else {
                                player.sendMessage(MarioMain.getPrefix() + "Das Inventar von " + t.getName() + " wurde erfolgreich gelagert!");
                                t.sendMessage(MarioMain.getPrefix() + "Dein Inventar wurde gelagert! Frage einen Admin, um dein Inventar wieder zu bekommen lol");
                            }
                        }
                    }
                    catch (NullPointerException e) {
                        e.printStackTrace();
                        player.sendMessage("Dieser Spieler existiert nicht!");
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                    }
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                player.sendMessage(MarioMain.getPrefix() + "Ungültige Parameter Länge!");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
            }
        } else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return true;
    }
}
