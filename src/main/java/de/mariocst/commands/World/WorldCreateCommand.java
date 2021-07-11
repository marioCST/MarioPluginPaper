package de.mariocst.commands.World;

import de.mariocst.MarioMain;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WorldCreateCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            MarioMain.getInstance().log("Bitte führe den Command InGame aus!");
            return false;
        }

        Player player = (Player) sender;
        if(player.hasPermission("mario.worldcreate") || player.hasPermission("*") || player.isOp()) {
            try {
                if (args.length == 1) {
                    if (MarioMain.getInstance().getServer().getWorld(args[0].toLowerCase()) == null) {
                        MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0].toLowerCase()));

                        player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " wurde erstellt!");
                    }
                    else {
                        player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " existiert!");
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                    }
                }
                else if (args.length == 2) {
                    if (MarioMain.getInstance().getServer().getWorld(args[0].toLowerCase()) == null) {
                        switch (args[1]) {
                            case "normal" -> {
                                MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0].toLowerCase()).type(WorldType.NORMAL));

                                player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " wurde mit dem normalen Generator erstellt!");
                            }
                            case "flat" -> {
                                MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0].toLowerCase()).type(WorldType.FLAT));

                                player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " wurde mit dem flatten Generator erstellt!");
                            }
                            case "large_biomes", "largebiomes", "lb" -> {
                                MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0].toLowerCase()).type(WorldType.LARGE_BIOMES));

                                player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " wurde mit dem großen Biome Generator erstellt!");
                            }
                            case "amplified" -> {
                                MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0].toLowerCase()).type(WorldType.AMPLIFIED));

                                player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " wurde mit dem zerklüftetem Generator erstellt!");
                            }
                            default -> {
                                player.sendMessage(MarioMain.getPrefix() + "Generatoren: normal, flat, large_biomes (largebiomes, lb), amplified");
                            }
                        }
                    }
                    else {
                        player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " existiert!");
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                    }
                }
                else if (args.length == 3) {
                    if (MarioMain.getInstance().getServer().getWorld(args[0].toLowerCase()) == null) {
                        switch (args[1]) {
                            case "normal" -> {
                                switch (args[2]) {
                                    case "normal" -> {
                                        MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0].toLowerCase()).type(WorldType.NORMAL).environment(World.Environment.NORMAL));

                                        player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " wurde mit dem normalen Generator und der normalen Dimension erstellt!");
                                    }
                                    case "nether" -> {
                                        MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0].toLowerCase()).type(WorldType.NORMAL).environment(World.Environment.NETHER));

                                        player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " wurde mit dem normalen Generator und der Nether Dimension erstellt!");
                                    }
                                    case "end" -> {
                                        MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0].toLowerCase()).type(WorldType.NORMAL).environment(World.Environment.THE_END));

                                        player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " wurde mit dem normalen Generator und der End Dimension erstellt!");
                                    }
                                    default -> {
                                        try {
                                            long seed = Long.parseLong(args[2]);
                                            MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0].toLowerCase()).type(WorldType.NORMAL).seed(seed));

                                            player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " wurde mit dem normalen Generator und dem Seed " + seed + " erstellt!");
                                        }
                                        catch (NumberFormatException e) {
                                            e.printStackTrace();
                                            player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine gültige Zahl ein!");
                                            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                                        }
                                    }
                                }
                            }
                            case "flat" -> {
                                try {
                                    long seed = Long.parseLong(args[2]);
                                    MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0].toLowerCase()).type(WorldType.FLAT).seed(seed));

                                    player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " wurde mit dem flatten Generator und dem Seed " + seed + " erstellt!");
                                }
                                catch (NumberFormatException e) {
                                    e.printStackTrace();
                                    player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine gültige Zahl ein!");
                                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                                }
                            }
                            case "large_biomes", "largebiomes", "lb" -> {
                                switch (args[2]) {
                                    case "normal" -> {
                                        MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0].toLowerCase()).type(WorldType.LARGE_BIOMES).environment(World.Environment.NORMAL));

                                        player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " wurde mit dem großen Biome Generator und der normalen Dimension erstellt!");
                                    }
                                    case "nether" -> {
                                        MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0].toLowerCase()).type(WorldType.LARGE_BIOMES).environment(World.Environment.NETHER));

                                        player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " wurde mit dem großen Biome Generator und der Nether Dimension erstellt!");
                                    }
                                    case "end" -> {
                                        MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0].toLowerCase()).type(WorldType.LARGE_BIOMES).environment(World.Environment.THE_END));

                                        player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " wurde mit dem großen Biome Generator und der End Dimension erstellt!");
                                    }
                                    default -> {
                                        try {
                                            long seed = Long.parseLong(args[2]);
                                            MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0].toLowerCase()).type(WorldType.LARGE_BIOMES).seed(seed));

                                            player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " wurde mit dem großen Biome Generator und dem Seed " + seed + " erstellt!");
                                        }
                                        catch (NumberFormatException e) {
                                            e.printStackTrace();
                                            player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine gültige Zahl ein!");
                                            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                                        }
                                    }
                                }
                            }
                            case "amplified" -> {
                                switch (args[2]) {
                                    case "normal" -> {
                                        MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0].toLowerCase()).type(WorldType.AMPLIFIED).environment(World.Environment.NORMAL));

                                        player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " wurde mit dem zerklüftetem Generator und der normalen Dimension erstellt!");
                                    }
                                    case "nether" -> {
                                        MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0].toLowerCase()).type(WorldType.AMPLIFIED).environment(World.Environment.NETHER));

                                        player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " wurde mit dem zerklüftetem Generator und der Nether Dimension erstellt!");
                                    }
                                    case "end" -> {
                                        MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0].toLowerCase()).type(WorldType.AMPLIFIED).environment(World.Environment.THE_END));

                                        player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " wurde mit dem zerklüftetem Generator und der End Dimension erstellt!");
                                    }
                                    default -> {
                                        try {
                                            long seed = Long.parseLong(args[2]);
                                            MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0].toLowerCase()).type(WorldType.AMPLIFIED).seed(seed));

                                            player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " wurde mit dem zerklüftetem Generator und dem Seed " + seed + " erstellt!");
                                        }
                                        catch (NumberFormatException e) {
                                            e.printStackTrace();
                                            player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine gültige Zahl ein!");
                                            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                                        }
                                    }
                                }
                            }
                            default -> {
                                player.sendMessage(MarioMain.getPrefix() + "Generatoren: normal, flat, large_biomes (largebiomes, lb), amplified");
                            }
                        }
                    }
                    else {
                        player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " existiert!");
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                    }
                }
                else if (args.length == 4) {
                    if (MarioMain.getInstance().getServer().getWorld(args[0].toLowerCase()) == null) {
                        switch (args[1]) {
                            case "normal" -> {
                                try {
                                    long seed = Long.parseLong(args[2]);

                                    switch (args[3]) {
                                        case "normal" -> {
                                            MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0].toLowerCase()).type(WorldType.NORMAL).environment(World.Environment.NORMAL).seed(seed));

                                            player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " wurde mit dem normalen Generator, der normalen Dimension und dem Seed " + seed + " erstellt!");
                                        }
                                        case "nether" -> {
                                            MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0].toLowerCase()).type(WorldType.NORMAL).environment(World.Environment.NETHER).seed(seed));

                                            player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " wurde mit dem normalen Generator, der Nether Dimension und dem Seed " + seed + " erstellt!");
                                        }
                                        case "end" -> {
                                            MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0].toLowerCase()).type(WorldType.NORMAL).environment(World.Environment.THE_END).seed(seed));

                                            player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " wurde mit dem normalen Generator, der End Dimension und dem Seed " + seed + " erstellt!");
                                        }
                                        default -> {
                                            player.sendMessage(MarioMain.getPrefix() + "Dimensionen: Normal, Nether, End");
                                        }
                                    }
                                }
                                catch (NumberFormatException e) {
                                    e.printStackTrace();
                                    player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine gültige Zahl ein!");
                                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                                }
                            }
                            case "large_biomes", "largebiomes", "lb" -> {
                                try {
                                    long seed = Long.parseLong(args[2]);

                                    switch (args[3]) {
                                        case "normal" -> {
                                            MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0].toLowerCase()).type(WorldType.LARGE_BIOMES).environment(World.Environment.NORMAL).seed(seed));

                                            player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " wurde mit dem großen Biome Generator, der normalen Dimension und dem Seed " + seed + " erstellt!");
                                        }
                                        case "nether" -> {
                                            MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0].toLowerCase()).type(WorldType.LARGE_BIOMES).environment(World.Environment.NETHER).seed(seed));

                                            player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " wurde mit dem großen Biome Generator, der Nether Dimension und dem Seed " + seed + " erstellt!");
                                        }
                                        case "end" -> {
                                            MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0].toLowerCase()).type(WorldType.LARGE_BIOMES).environment(World.Environment.THE_END).seed(seed));

                                            player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " wurde mit dem großen Biome Generator, der End Dimension und dem Seed " + seed + " erstellt!");
                                        }
                                        default -> {
                                            player.sendMessage(MarioMain.getPrefix() + "Dimensionen: Normal, Nether, End");
                                        }
                                    }
                                }
                                catch (NumberFormatException e) {
                                    e.printStackTrace();
                                    player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine gültige Zahl ein!");
                                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                                }
                            }
                            case "amplified" -> {
                                try {
                                    long seed = Long.parseLong(args[2]);

                                    switch (args[3]) {
                                        case "normal" -> {
                                            MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0].toLowerCase()).type(WorldType.AMPLIFIED).environment(World.Environment.NORMAL).seed(seed));

                                            player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " wurde mit dem zerklüftetem Generator, der normalen Dimension und dem Seed " + seed + " erstellt!");
                                        }
                                        case "nether" -> {
                                            MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0].toLowerCase()).type(WorldType.AMPLIFIED).environment(World.Environment.NETHER).seed(seed));

                                            player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " wurde mit dem zerklüftetem Generator, der Nether Dimension und dem Seed " + seed + " erstellt!");
                                        }
                                        case "end" -> {
                                            MarioMain.getInstance().getServer().createWorld(new WorldCreator(args[0].toLowerCase()).type(WorldType.AMPLIFIED).environment(World.Environment.THE_END).seed(seed));

                                            player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " wurde mit dem zerklüftetem Generator, der End Dimension und dem Seed " + seed + " erstellt!");
                                        }
                                        default -> {
                                            player.sendMessage(MarioMain.getPrefix() + "Dimensionen: Normal, Nether, End");
                                        }
                                    }
                                }
                                catch (NumberFormatException e) {
                                    e.printStackTrace();
                                    player.sendMessage(MarioMain.getPrefix() + "Bitte gib eine gültige Zahl ein!");
                                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                                }
                            }
                            default -> {
                                player.sendMessage(MarioMain.getPrefix() + "Generatoren: normal, large_biomes (largebiomes, lb), amplified");
                            }
                        }
                    }
                    else {
                        player.sendMessage(MarioMain.getPrefix() + "Die Welt " + args[0].toLowerCase() + " existiert!");
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                    }
                }
                else {
                    player.sendMessage(MarioMain.getPrefix() + "/worldcreate <Welt> [Generator] [Seed|Dimension (Nur bei Flat nicht)] [Dimension (Wenn mit Seed, bei Flat nicht)]");
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                player.sendMessage(MarioMain.getPrefix() + "/worldcreate <Welt> [Generator] [Seed|Dimension (Nur bei Flat nicht)] [Dimension (Wenn mit Seed, bei Flat nicht)]");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
            }
        } else {
            player.sendMessage(MarioMain.getPrefix() + "Keine Rechte!");
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 1.2f);
        }
        return false;
    }
}
