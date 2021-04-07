package de.mariocst.commands.Invsee;

import de.mariocst.MarioMain;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnderInvseeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            MarioMain.INSTANCE.log("Bitte führe den Command InGame aus!");
            return false;
        }

        Player player = (Player) sender;
        if(player.hasPermission("mario.enderinvsee") || player.hasPermission("*") || player.isOp()) {
            String usage = "§cUsage: §6/enderinvsee <Spieler>";
            try {
                if (args.length == 1) {
                    String nullp = "§cDieser Spieler existiert nicht!";
                    try {
                        Player t = player.getServer().getPlayer(args[0]);
                        if (t != null) {
                            if (t.getName().equals(player.getName())) {
                                sender.sendMessage(MarioMain.PREFIX + "Du kannst doch wohl noch deine eigene EnderChest öffnen xD");
                                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                            }
                            else {
                                player.openInventory(t.getEnderChest());
                            }
                        }
                        else {
                            sender.sendMessage(MarioMain.PREFIX + nullp);
                            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                        }
                    }
                    catch (NullPointerException e) {
                        e.printStackTrace();
                        sender.sendMessage(MarioMain.PREFIX + nullp);
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                    }
                }
                else {
                    sender.sendMessage(MarioMain.PREFIX + usage);
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                sender.sendMessage(MarioMain.PREFIX + usage);
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
            }
        } else {
            player.sendMessage(MarioMain.PREFIX + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return false;
    }
}
