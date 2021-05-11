package de.mariocst;

import de.mariocst.backpack.BackpackManager;
import de.mariocst.backpack.BackpackManagerLarge;
import de.mariocst.commands.Announcements.*;
import de.mariocst.commands.Chat.*;
import de.mariocst.commands.Invsee.*;
import de.mariocst.commands.Player.*;
import de.mariocst.commands.Server.*;
import de.mariocst.commands.Setter.*;
import de.mariocst.commands.Util.*;
import de.mariocst.commands.World.*;
import de.mariocst.listeners.*;
import de.mariocst.timer.*;
import de.mariocst.utils.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class MarioMain extends JavaPlugin {

    public static String PREFIX = "§8[§6marioCST.de§8] §b";
    public static MarioMain INSTANCE;
    private static MarioMain instance;

    private BackpackManager backpackManager;
    private BackpackManagerLarge backpackManagerLarge;
    private Config config;
    private Backpacks backpacks;
    private BackpacksLarge backpacksLarge;
    private Timer timer;

    @Override
    public void onLoad() {
        instance = this;
        backpacks = new Backpacks();
        backpacksLarge = new BackpacksLarge();
        config = new Config();
    }

    public MarioMain() {
        INSTANCE = this;
    }

    @Override
    public void onEnable() {

        this.register();
        listenerRegistration();

        timer = new Timer();
        backpackManager = new BackpackManager();
        backpackManagerLarge = new BackpackManagerLarge();

        log("marioCST's PlugIn geladen!");
    }

    @Override
    public void onDisable() {
        log("marioCST's PlugIn entladen!");
        timer.save();
        backpackManager.save();
        backpackManagerLarge.save();
        backpacks.save();
        backpacksLarge.save();
        config.save();
    }

    @NotNull
    public Config getConfiguration() {
        return config;
    }

    @NotNull
    public Backpacks getBackpacks() {
        return backpacks;
    }

    @NotNull
    public BackpacksLarge getBackpacksLarge() {
        return backpacksLarge;
    }

    private void listenerRegistration() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(), this);
    }

    public void log(String text) {
        Bukkit.getConsoleSender().sendMessage(PREFIX + text);
    }

    private void register() {

        //Announcements
        Bukkit.getPluginCommand("broadcast5").setExecutor(new Custom());
        Bukkit.getPluginCommand("announcekick").setExecutor(new Kick());
        Bukkit.getPluginCommand("announcereload").setExecutor(new Reload());
        Bukkit.getPluginCommand("announcerestart").setExecutor(new Restart());
        Bukkit.getPluginCommand("announcestop").setExecutor(new Stop());

        //Chat
        Bukkit.getPluginCommand("broadcast").setExecutor(new BroadcastCommand());
        Bukkit.getPluginCommand("chatclear").setExecutor(new ChatClearCommand());

        //Invsee
        Bukkit.getPluginCommand("enderinvsee").setExecutor(new EnderInvseeCommand());
        Bukkit.getPluginCommand("invsee").setExecutor(new InvseeCommand());

        //Player
        Bukkit.getPluginCommand("backpack").setExecutor(new BackpackCommand());
        Bukkit.getPluginCommand("backpacklarge").setExecutor(new BackpackLargeCommand());
        Bukkit.getPluginCommand("clearinventory").setExecutor(new ClearInventoryCommand());
        Bukkit.getPluginCommand("die").setExecutor(new DieCommand());
        Bukkit.getPluginCommand("dumb").setExecutor(new DumbCommand());
        Bukkit.getPluginCommand("fly").setExecutor(new FlyCommand());
        Bukkit.getPluginCommand("gm").setExecutor(new GMCommand());
        Bukkit.getPluginCommand("heal").setExecutor(new HealCommand());
        Bukkit.getPluginCommand("nick").setExecutor(new NickCommand());
        Bukkit.getPluginCommand("realname").setExecutor(new RealnameCommand());
        Bukkit.getPluginCommand("speed").setExecutor(new SpeedCommand());
        Bukkit.getPluginCommand("unnick").setExecutor(new UnnickCommand());

        //Server
        Bukkit.getPluginCommand("banall").setExecutor(new BanAllCommand());
        Bukkit.getPluginCommand("kickall").setExecutor(new KickAllCommand());

        //Setter
        Bukkit.getPluginCommand("setlink").setExecutor(new SetLinkCommand());

        //Util
        Bukkit.getPluginCommand("date").setExecutor(new DateCommand());
        Bukkit.getPluginCommand("discord").setExecutor(new DiscordCommand());
        Bukkit.getPluginCommand("enderchest").setExecutor(new ECCommand());
        Bukkit.getPluginCommand("lol").setExecutor(new LolCommand());
        Bukkit.getPluginCommand("timer").setExecutor(new TimerCommand());

        //World
        Bukkit.getPluginCommand("day").setExecutor(new DayCommand());
        Bukkit.getPluginCommand("night").setExecutor(new NightCommand());

    }

    public static MarioMain getInstance() {
        return instance;
    }

    public Timer getTimer() {
        return timer;
    }

    public BackpackManager getBackpackManager() {
        return backpackManager;
    }

    public BackpackManagerLarge getBackpackManagerLarge() {
        return backpackManagerLarge;
    }
}
