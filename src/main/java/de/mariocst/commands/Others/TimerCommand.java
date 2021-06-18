package de.mariocst.commands.Others;

import de.mariocst.MarioMain;
import de.mariocst.timer.Timer;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TimerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (player.hasPermission("mario.timer") || player.hasPermission("mario.*") || player.hasPermission("*") ||  player.isOp()) {
                if (args.length == 0) {
                    sendUsage(sender);
                    return true;
                }

                switch (args[0].toLowerCase()) {
                    case "resume" -> {
                        Timer timer = MarioMain.getInstance().getTimer();

                        if (timer.isRunning()) {
                            sender.sendMessage(MarioMain.getPrefix() + "§cDer Timer läuft bereits!");
                            break;
                        }

                        timer.setRunning(true);
                        sender.sendMessage(MarioMain.getPrefix() + "Der Timer wurde gestartet!");
                    }
                    case "pause" -> {
                        Timer timer = MarioMain.getInstance().getTimer();

                        if (!timer.isRunning()) {
                            sender.sendMessage(MarioMain.getPrefix() + "§cDer Timer läuft nicht.");
                            break;
                        }

                        timer.setRunning(false);
                        sender.sendMessage(MarioMain.getPrefix() + "Der Timer wurde gestoppt!");
                    }
                    case "time" -> {
                        if (args.length != 4) {
                            sender.sendMessage("§cUsage: §6/timer time <Seconds> <Minutes> <Hours>");
                            return true;
                        }

                        try {
                            Timer timer = MarioMain.getInstance().getTimer();

                            timer.setRunning(false);
                            timer.setSeconds(Integer.parseInt(args[1]));
                            timer.setMinutes(Integer.parseInt(args[2]));
                            timer.setHours(Integer.parseInt(args[3]));
                            sender.sendMessage(MarioMain.getPrefix() + "Die Zeit wurde auf " + args[1] + " Sekunden, " + args[2] + " Minuten und " + args[3] + " Stunden gesetzt!");
                        } catch (NumberFormatException e) {
                            sender.sendMessage(MarioMain.getPrefix() + "§4Deine Parameter 2, 3 und 4 müssen eine ganze Zahl sein!");
                            e.printStackTrace();
                        }
                    }
                    case "reset" -> {
                        Timer timer = MarioMain.getInstance().getTimer();

                        timer.setRunning(false);
                        timer.setSeconds(0);
                        timer.setMinutes(0);
                        timer.setHours(0);
                        sender.sendMessage(MarioMain.getPrefix() + "Der Timer wurde resettet!");
                    }
                    default -> sendUsage(sender);
                }
            } else {
                player.sendMessage(MarioMain.getPrefix() + "§4Keine Rechte!");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
            }
        } else {
            if(args.length == 0) {
                sendUsage(sender);
                return true;
            }

            switch (args[0].toLowerCase()) {
                case "resume" -> {
                    Timer timer = MarioMain.getInstance().getTimer();

                    if (timer.isRunning()) {
                        sender.sendMessage(MarioMain.getPrefix() + "§cDer Timer läuft bereits!");
                        break;
                    }

                    timer.setRunning(true);
                    sender.sendMessage(MarioMain.getPrefix() + "Der Timer wurde gestartet!");
                }
                case "pause" -> {
                    Timer timer = MarioMain.getInstance().getTimer();

                    if (!timer.isRunning()) {
                        sender.sendMessage(MarioMain.getPrefix() + "§cDer Timer läuft nicht.");
                        break;
                    }

                    timer.setRunning(false);
                    sender.sendMessage(MarioMain.getPrefix() + "Der Timer wurde gestoppt!");
                }
                case "time" -> {
                    if (args.length != 4) {
                        sender.sendMessage("§cUsage: §6/timer time <Seconds> <Minutes> <Hours>");
                        return true;
                    }

                    try {
                        Timer timer = MarioMain.getInstance().getTimer();

                        timer.setRunning(false);
                        timer.setSeconds(Integer.parseInt(args[1]));
                        timer.setMinutes(Integer.parseInt(args[2]));
                        timer.setHours(Integer.parseInt(args[3]));
                        sender.sendMessage(MarioMain.getPrefix() + "Die Zeit wurde auf " + args[1] + " Sekunden, " + args[2] + " Minuten und " + args[3] + " Stunden gesetzt!");
                    } catch (NumberFormatException e) {
                        sender.sendMessage(MarioMain.getPrefix() + "§4Deine Parameter 2, 3 und 4 müssen eine ganze Zahl sein!");
                        e.printStackTrace();
                    }
                }
                case "reset" -> {
                    Timer timer = MarioMain.getInstance().getTimer();

                    timer.setRunning(false);
                    timer.setSeconds(0);
                    timer.setMinutes(0);
                    timer.setHours(0);
                    sender.sendMessage(MarioMain.getPrefix() + "Der Timer wurde resettet!");
                }
                default -> sendUsage(sender);
            }
        }

        return false;
    }

    private void sendUsage(CommandSender sender) {
        sender.sendMessage("§cUsage: §6/timer resume, /timer pause, /timer time <Seconds> <Minutes> <Hours>, /timer reset");
    }
}
