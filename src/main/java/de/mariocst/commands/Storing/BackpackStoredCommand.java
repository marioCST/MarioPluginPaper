package de.mariocst.commands.Storing;

import de.mariocst.MarioMain;
import de.mariocst.backpack.BackpackStored;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BackpackStoredCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(MarioMain.getPrefix() + "Dieser Command geht nur InGame!");
            return true;
        } else {
            Player player = (Player) sender;

            if(player.hasPermission("mario.backpackstored") || player.hasPermission("mario.*") || player.isOp()) {
                try {
                    if (args.length == 1) {
                        Player t = MarioMain.getInstance().getServer().getPlayer(args[0]);

                        try {
                            if (t != null) {
                                BackpackStored backpackStored = MarioMain.getInstance().getBackpackManagerStored().getBackpackStored(t.getUniqueId());

                                player.openInventory(backpackStored.getInventory());
                            }
                        }
                        catch (NullPointerException e) {
                            e.printStackTrace();
                            player.sendMessage(MarioMain.getPrefix() + "Dieser Spieler existiert nicht!");
                        }
                    }
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                    player.sendMessage(MarioMain.getPrefix() + "Ungültige Parameter Länge!");
                }
            }
            else {
                sender.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
            }
        }

        return false;
    }
}