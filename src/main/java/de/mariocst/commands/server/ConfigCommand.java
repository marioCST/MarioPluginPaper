package de.mariocst.commands.server;

import de.mariocst.MarioMain;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConfigCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player player)) {
            try {
                if (args.length == 1) {
                    switch (args[0].toLowerCase()) {
                        case "save" -> {
                            MarioMain.getInstance().saveConfigs();
                            sender.sendMessage(MarioMain.getPrefix() + "Configs gespeichert!");
                        }
                        case "reload" -> {
                            MarioMain.getInstance().loadConfigs();
                            sender.sendMessage(MarioMain.getPrefix() + "Configs neu geladen!");
                        }
                        default -> sender.sendMessage(MarioMain.getPrefix() + "/config <save|reload>");
                    }
                }
                else {
                    sender.sendMessage(MarioMain.getPrefix() + "/config <save|reload>");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                sender.sendMessage(MarioMain.getPrefix() + "/config <save|reload>");
            }
            return true;
        }

        if (player.hasPermission("mario.config") || player.hasPermission("mario.*") || player.hasPermission("*") || player.isOp()) {
            try {
                if (args.length == 1) {
                    switch (args[0].toLowerCase()) {
                        case "save" -> {
                            MarioMain.getInstance().saveConfigs();
                            player.sendMessage(MarioMain.getPrefix() + "Configs gespeichert!");
                        }
                        case "reload" -> {
                            MarioMain.getInstance().loadConfigs();
                            player.sendMessage(MarioMain.getPrefix() + "Configs neu geladen!");
                        }
                        default -> player.sendMessage(MarioMain.getPrefix() + "/config <save|reload>");
                    }
                }
                else {
                    player.sendMessage(MarioMain.getPrefix() + "/config <save|reload>");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                player.sendMessage(MarioMain.getPrefix() + "/config <save|reload>");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
            }
        }
        else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
        }
        return true;
    }

    private final String[] MODES = { "save", "reload" };

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        final List<String> completions = new ArrayList<>();
        if (args.length == 1) {
            StringUtil.copyPartialMatches(args[0], Arrays.asList(MODES), completions);
            Collections.sort(completions);
        }
        return completions;
    }
}
