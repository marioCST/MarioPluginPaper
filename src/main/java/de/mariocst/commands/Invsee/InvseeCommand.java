package de.mariocst.commands.Invsee;

import de.mariocst.MarioMain;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvseeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            MarioMain.getInstance().log("Bitte führe den Command InGame aus!");
            return false;
        }

        Player player = (Player) sender;
        if(player.hasPermission("mario.invsee") || player.hasPermission("*") || player.isOp()) {
            String usage = "§cUsage: §6/invsee <Spieler>";
            try {
                if (args.length == 1) {
                    String nullp = "§cDieser Spieler existiert nicht!";
                    try {
                        Player t = player.getServer().getPlayer(args[0]);
                        if (t != null) {
                            if (t.getName().equals(player.getName())) {
                                sender.sendMessage(MarioMain.getPrefix() + "Du kannst doch wohl noch dein eigenes Inventar öffnen xD");
                                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                            }
                            else {
                                player.openInventory(t.getInventory());
                            }
                        }
                        else {
                            sender.sendMessage(MarioMain.getPrefix() + nullp);
                            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                        }
                    }
                    catch (NullPointerException e) {
                        e.printStackTrace();
                        sender.sendMessage(MarioMain.getPrefix() + nullp);
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                    }
                }
                else {
                    sender.sendMessage(MarioMain.getPrefix() + usage);
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                sender.sendMessage(MarioMain.getPrefix() + usage);
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
            }
        } else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return false;
    }
}
