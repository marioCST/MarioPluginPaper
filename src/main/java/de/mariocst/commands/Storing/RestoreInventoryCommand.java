package de.mariocst.commands.Storing;

import de.mariocst.MarioMain;
import de.mariocst.backpack.BackpackStored;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RestoreInventoryCommand implements CommandExecutor {
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
                                if (backpackStored.getInventory().getItem(i) != null && t.getInventory().getItem(i) == null) {
                                    t.getInventory().setItem(i, backpackStored.getInventory().getItem(i));

                                    backpackStored.getInventory().clear(i);

                                    slots++;
                                }
                            }

                            for (int i = 36; i <= 40; i++) {
                                switch (i) {
                                    case 37:
                                        if (backpackStored.getInventory().getItem(i) != null && t.getInventory().getHelmet() == null) {
                                            t.getInventory().setItem(103, backpackStored.getInventory().getItem(i));

                                            backpackStored.getInventory().clear(i);

                                            slots++;
                                        }
                                        break;
                                    case 38:
                                        if (backpackStored.getInventory().getItem(i) != null && t.getInventory().getChestplate() == null) {
                                            t.getInventory().setItem(102, backpackStored.getInventory().getItem(i));

                                            backpackStored.getInventory().clear(i);

                                            slots++;
                                        }
                                        break;
                                    case 39:
                                        if (backpackStored.getInventory().getItem(i) != null && t.getInventory().getLeggings() == null) {
                                            t.getInventory().setItem(101, backpackStored.getInventory().getItem(i));

                                            backpackStored.getInventory().clear(i);

                                            slots++;
                                        }
                                        break;
                                    case 40:
                                        if (backpackStored.getInventory().getItem(i) != null && t.getInventory().getBoots() == null) {
                                            t.getInventory().setItem(100, backpackStored.getInventory().getItem(i));

                                            backpackStored.getInventory().clear(i);

                                            slots++;
                                        }
                                        break;
                                    default:
                                        sender.sendMessage(MarioMain.getPrefix() + "Mario muss noch mal ran haha");
                                        break;
                                }
                            }

                            if (backpackStored.getInventory().getItem(41) != null && t.getInventory().getItem(-106) == null) {
                                backpackStored.getInventory().setItem(-106, backpackStored.getInventory().getItem(41));

                                backpackStored.getInventory().clear(41);

                                slots++;
                            }

                            if (slots == 0) {
                                sender.sendMessage(MarioMain.getPrefix() + "Das gelagerte Backpack ist leer");
                            }
                            else {
                                int notEmptySlots = 0;

                                for (int i = 0; i <= 41; i++) {
                                    if (backpackStored.getInventory().getItem(i) != null) {
                                        notEmptySlots++;
                                    }
                                }

                                if (notEmptySlots != 0) {
                                    sender.sendMessage(MarioMain.getPrefix() + "Ein paar Items sind zurückgeblieben!");
                                    t.sendMessage(MarioMain.getPrefix() + "Ein paar Items sind leider nicht zurück, weil du an den entsprechenden Slots Items hattest!");
                                }

                                sender.sendMessage(MarioMain.getPrefix() + "Das Inventar von " + t.getName() + " wurde erfolgreich zurück gegeben!");
                                t.sendMessage(MarioMain.getPrefix() + "Dein Inventar wurde zurpck gegeben! Netter Admin haha");
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

        if(player.hasPermission("mario.restoreinventory") || player.hasPermission("*") || player.isOp()) {
            try {
                if (args.length == 1) {
                    Player t = MarioMain.getInstance().getServer().getPlayer(args[0]);

                    try {
                        if (t != null) {
                            BackpackStored backpackStored = MarioMain.getInstance().getBackpackManagerStored().getBackpackStored(t.getUniqueId());

                            int slots = 0;

                            for (int i = 0; i <= 36; i++) {
                                if (backpackStored.getInventory().getItem(i) != null && t.getInventory().getItem(i) == null) {
                                    t.getInventory().setItem(i, backpackStored.getInventory().getItem(i));

                                    backpackStored.getInventory().clear(i);

                                    slots++;
                                }
                            }

                            for (int i = 36; i <= 40; i++) {
                                switch (i) {
                                    case 37:
                                        if (backpackStored.getInventory().getItem(i) != null && t.getInventory().getHelmet() == null) {
                                            t.getInventory().setItem(103, backpackStored.getInventory().getItem(i));

                                            backpackStored.getInventory().clear(i);

                                            slots++;
                                        }
                                        break;
                                    case 38:
                                        if (backpackStored.getInventory().getItem(i) != null && t.getInventory().getChestplate() == null) {
                                            t.getInventory().setItem(102, backpackStored.getInventory().getItem(i));

                                            backpackStored.getInventory().clear(i);

                                            slots++;
                                        }
                                        break;
                                    case 39:
                                        if (backpackStored.getInventory().getItem(i) != null && t.getInventory().getLeggings() == null) {
                                            t.getInventory().setItem(101, backpackStored.getInventory().getItem(i));

                                            backpackStored.getInventory().clear(i);

                                            slots++;
                                        }
                                        break;
                                    case 40:
                                        if (backpackStored.getInventory().getItem(i) != null && t.getInventory().getBoots() == null) {
                                            t.getInventory().setItem(100, backpackStored.getInventory().getItem(i));

                                            backpackStored.getInventory().clear(i);

                                            slots++;
                                        }
                                        break;
                                }
                            }

                            if (backpackStored.getInventory().getItem(41) != null && t.getInventory().getItem(-106) == null) {
                                backpackStored.getInventory().setItem(-106, backpackStored.getInventory().getItem(41));

                                backpackStored.getInventory().clear(41);

                                slots++;
                            }

                            if (slots == 0) {
                                player.sendMessage(MarioMain.getPrefix() + "Das gelagerte Backpack ist leer");
                            }
                            else {
                                int notEmptySlots = 0;

                                for (int i = 0; i <= 41; i++) {
                                    if (backpackStored.getInventory().getItem(i) != null) {
                                        notEmptySlots++;
                                    }
                                }

                                if (notEmptySlots != 0) {
                                    player.sendMessage(MarioMain.getPrefix() + "Ein paar Items sind zurückgeblieben!");
                                    t.sendMessage(MarioMain.getPrefix() + "Ein paar Items sind leider nicht zurück, weil du an den entsprechenden Slots Items hattest!");
                                }

                                player.sendMessage(MarioMain.getPrefix() + "Das Inventar von " + t.getName() + " wurde erfolgreich zurück gegeben!");
                                t.sendMessage(MarioMain.getPrefix() + "Dein Inventar wurde zurpck gegeben! Netter Admin haha");
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
