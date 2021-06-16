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

            if (player.hasPermission("mario.timer") || player.isOp()) {
                if(args.length == 0) {
                    sendUsage(sender);
                    return true;
                }

                switch(args[0].toLowerCase()) {
                    case "resume": {
                        Timer timer = MarioMain.getInstance().getTimer();

                        if (timer.isRunning()) {
                            sender.sendMessage(MarioMain.getPrefix() + "§cDer Timer läuft bereits!");
                            break;
                        }

                        timer.setRunning(true);
                        sender.sendMessage(MarioMain.getPrefix() + "Der Timer wurde gestartet!");
                        break;
                    }
                    case "pause": {
                        Timer timer = MarioMain.getInstance().getTimer();

                        if (!timer.isRunning()) {
                            sender.sendMessage(MarioMain.getPrefix() + "§cDer Timer läuft nicht.");
                            break;
                        }

                        timer.setRunning(false);
                        sender.sendMessage(MarioMain.getPrefix() + "Der Timer wurde gestoppt!");
                        break;
                    }
                    case "time": {
                        if(args.length != 2) {
                            sender.sendMessage("§cUsage: §6/timer time <Time>");
                            return true;
                        }

                        try {
                            Timer timer = MarioMain.getInstance().getTimer();

                            timer.setRunning(false);
                            timer.setTime(Integer.parseInt(args[1]));
                            sender.sendMessage(MarioMain.getPrefix() + "Die Zeit wurde auf " + args[1] + " gesetzt!");
                        } catch (NumberFormatException e) {
                            sender.sendMessage(MarioMain.getPrefix() + "§4Dein Parameter 2 muss eine Zahl sein!");
                            e.printStackTrace();
                        }
                        break;
                    }
                    case "reset": {
                        Timer timer = MarioMain.getInstance().getTimer();

                        timer.setRunning(false);
                        timer.setTime(0);
                        sender.sendMessage(MarioMain.getPrefix() + "Der Timer wurde resettet!");
                        break;
                    }
                    default: {
                        sendUsage(sender);
                        break;
                    }
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

            switch(args[0].toLowerCase()) {
                case "resume": {
                    Timer timer = MarioMain.getInstance().getTimer();

                    if (timer.isRunning()) {
                        sender.sendMessage(MarioMain.getPrefix() + "§cDer Timer läuft bereits!");
                        break;
                    }

                    timer.setRunning(true);
                    sender.sendMessage(MarioMain.getPrefix() + "Der Timer wurde gestartet!");
                    break;
                }
                case "pause": {
                    Timer timer = MarioMain.getInstance().getTimer();

                    if (!timer.isRunning()) {
                        sender.sendMessage(MarioMain.getPrefix() + "§cDer Timer läuft nicht.");
                        break;
                    }

                    timer.setRunning(false);
                    sender.sendMessage(MarioMain.getPrefix() + "Der Timer wurde gestoppt!");
                    break;
                }
                case "time": {
                    if(args.length != 2) {
                        sender.sendMessage("§cUsage: §6/timer time <Time>");
                        return true;
                    }

                    try {
                        Timer timer = MarioMain.getInstance().getTimer();

                        timer.setRunning(false);
                        timer.setTime(Integer.parseInt(args[1]));
                        sender.sendMessage(MarioMain.getPrefix() + "Die Zeit wurde auf " + args[1] + " gesetzt!");
                    } catch (NumberFormatException e) {
                        sender.sendMessage(MarioMain.getPrefix() + "§4Dein Parameter 2 muss eine Zahl sein!");
                        e.printStackTrace();
                    }
                    break;
                }
                case "reset": {
                    Timer timer = MarioMain.getInstance().getTimer();

                    timer.setRunning(false);
                    timer.setTime(0);
                    sender.sendMessage(MarioMain.getPrefix() + "Der Timer wurde resettet!");
                    break;
                }
                default: {
                    sendUsage(sender);
                    break;
                }
            }
        }

        return false;
    }

    private void sendUsage(CommandSender sender) {
        sender.sendMessage("§cUsage: §6/timer resume, /timer pause, /timer time <Time>, /timer reset");
    }
}
