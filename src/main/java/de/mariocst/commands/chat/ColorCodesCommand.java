package de.mariocst.commands.chat;

import de.mariocst.MarioMain;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ColorCodesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(MarioMain.getPrefix() + "§6ColorCodes:");
            sender.sendMessage(MarioMain.getPrefix() + "§6Alle beginnen mit & !");
            sender.sendMessage(MarioMain.getPrefix() + "0: §0Schwarz§f, 1: §1Dunkel Blau§f, 2: §2Dunkel Grün§f, 3: §3Cyan§f, 4: §4Rot");
            sender.sendMessage(MarioMain.getPrefix() + "5: §5Lila§f, 6: §6Orange§f, 7: §7Hell Grau§f, 8: §8Dunkel Grau§f, 9: §9Hell Blau");
            sender.sendMessage(MarioMain.getPrefix() + "a: §aHell Grün§f, b: §bHell Blau§f, c: §cHell Rot§f, d: §dPink§f, e: §eGelb§f, f: Weiß");
            sender.sendMessage(MarioMain.getPrefix() + "k: §kmagische Zeichen§r§f, l: §lFett§r§f, o: §oKursiv§r§f, r: §rMacht alles rückgängig");
            return true;
        }

        if (player.hasPermission("mario.colorcodes") || player.hasPermission("mario.*") || player.hasPermission("*") || player.isOp()) {
            player.sendMessage(MarioMain.getPrefix() + "§6ColorCodes:");
            player.sendMessage(MarioMain.getPrefix() + "§6Alle beginnen mit & !");
            player.sendMessage(MarioMain.getPrefix() + "0: §0Schwarz§f, 1: §1Dunkel Blau§f, 2: §2Dunkel Grün§f, 3: §3Cyan§f, 4: §4Rot");
            player.sendMessage(MarioMain.getPrefix() + "5: §5Lila§f, 6: §6Orange§f, 7: §7Hell Grau§f, 8: §8Dunkel Grau§f, 9: §9Hell Blau");
            player.sendMessage(MarioMain.getPrefix() + "a: §aHell Grün§f, b: §bHell Blau§f, c: §cHell Rot§f, d: §dPink§f, e: §eGelb§f, f: Weiß");
            player.sendMessage(MarioMain.getPrefix() + "k: §kmagische Zeichen§r§f, l: §lFett§r§f, o: §oKursiv§r§f, r: §rMacht alles rückgängig");
        }
        else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
        }
        return true;
    }
}
