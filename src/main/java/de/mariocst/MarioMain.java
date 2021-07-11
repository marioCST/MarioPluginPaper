package de.mariocst;

import de.mariocst.backpack.BackpackManager;
import de.mariocst.backpack.BackpackManagerLarge;
import de.mariocst.backpack.BackpackManagerStored;
import de.mariocst.commands.Announcements.*;
import de.mariocst.commands.Chat.*;
import de.mariocst.commands.Inventory.*;
import de.mariocst.commands.Invsee.*;
import de.mariocst.commands.Others.*;
import de.mariocst.commands.Player.*;
import de.mariocst.commands.Send.*;
import de.mariocst.commands.Server.*;
import de.mariocst.commands.Setter.*;
import de.mariocst.commands.Storing.*;
import de.mariocst.commands.World.*;
import de.mariocst.listeners.*;
import de.mariocst.timer.*;
import de.mariocst.utils.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class MarioMain extends JavaPlugin {

    private static String prefix = "§8[§6marioCST.de§8] §b";
    private static MarioMain instance;

    private BackpackManager backpackManager;
    private BackpackManagerLarge backpackManagerLarge;
    private BackpackManagerStored backpackManagerStored;
    private Config config;
    private Backpacks backpacks;
    private BackpacksLarge backpacksLarge;
    private BackpacksStored backpacksStored;
    private Timer timer;

    public List<Player> invTroll = new ArrayList<>();

    @Override
    public void onLoad() {
        instance = this;
        backpacks = new Backpacks();
        backpacksLarge = new BackpacksLarge();
        backpacksStored = new BackpacksStored();
        config = new Config();
    }

    public MarioMain() {
        instance = this;
    }

    @Override
    public void onEnable() {
        this.register();
        listenerRegistration();

        timer = new Timer();
        backpackManager = new BackpackManager();
        backpackManagerLarge = new BackpackManagerLarge();
        backpackManagerStored = new BackpackManagerStored();

        log("marioCST's PlugIn geladen!");
    }

    @Override
    public void onDisable() {
        log("marioCST's PlugIn entladen!");
        timer.save();
        backpackManager.save();
        backpackManagerLarge.save();
        backpackManagerStored.save();
        backpacks.save();
        backpacksLarge.save();
        backpacksStored.save();
        config.save();
    }

    public Config getConfiguration() {
        return config;
    }

    public Backpacks getBackpacks() {
        return backpacks;
    }

    public BackpacksLarge getBackpacksLarge() {
        return backpacksLarge;
    }

    public BackpacksStored getBackpacksStored() {
        return backpacksStored;
    }

    public static String getPrefix() {
        return prefix;
    }

    public static void setPrefix(String prefix) {
        MarioMain.prefix = prefix;
    }

    private void listenerRegistration() {
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new InventoryListener(), this);
        pluginManager.registerEvents(new JoinListener(), this);
    }

    public void log(String text) {
        Bukkit.getConsoleSender().sendMessage(getPrefix() + text);
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

        //Inventory
        Bukkit.getPluginCommand("backpack").setExecutor(new BackpackCommand());
        Bukkit.getPluginCommand("backpacklarge").setExecutor(new BackpackLargeCommand());
        Bukkit.getPluginCommand("clearenderchest").setExecutor(new ClearEnderChestCommand());
        Bukkit.getPluginCommand("clearinventory").setExecutor(new ClearInventoryCommand());

        //Invsee
        Bukkit.getPluginCommand("enderinvsee").setExecutor(new EnderInvseeCommand());
        Bukkit.getPluginCommand("invsee").setExecutor(new InvseeCommand());

        //Others
        Bukkit.getPluginCommand("date").setExecutor(new DateCommand());
        Bukkit.getPluginCommand("discord").setExecutor(new DiscordCommand());
        Bukkit.getPluginCommand("enderchest").setExecutor(new ECCommand());
        Bukkit.getPluginCommand("lol").setExecutor(new LolCommand());
        Bukkit.getPluginCommand("timer").setExecutor(new TimerCommand());
        Bukkit.getPluginCommand("troll").setExecutor(new TrollCommand());

        //Player
        Bukkit.getPluginCommand("die").setExecutor(new DieCommand());
        Bukkit.getPluginCommand("dumb").setExecutor(new DumbCommand());
        Bukkit.getPluginCommand("fly").setExecutor(new FlyCommand());
        Bukkit.getPluginCommand("gm").setExecutor(new GMCommand());
        Bukkit.getPluginCommand("heal").setExecutor(new HealCommand());
        Bukkit.getPluginCommand("nick").setExecutor(new NickCommand());
        Bukkit.getPluginCommand("realname").setExecutor(new RealnameCommand());
        Bukkit.getPluginCommand("speed").setExecutor(new SpeedCommand());
        Bukkit.getPluginCommand("unnick").setExecutor(new UnnickCommand());

        //Send
        Bukkit.getPluginCommand("sendactionbar").setExecutor(new SendActionBarCommand());
        Bukkit.getPluginCommand("sendmessage").setExecutor(new SendMessageCommand());
        Bukkit.getPluginCommand("sendtitle").setExecutor(new SendTitleCommand());

        //Server
        Bukkit.getPluginCommand("banall").setExecutor(new BanAllCommand());
        Bukkit.getPluginCommand("kickall").setExecutor(new KickAllCommand());

        //Setter
        Bukkit.getPluginCommand("setlink").setExecutor(new SetLinkCommand());

        //Storing BETA
        Bukkit.getPluginCommand("backpackstored").setExecutor(new BackpackStoredCommand());
        Bukkit.getPluginCommand("restoreinventory").setExecutor(new RestoreInventoryCommand());
        Bukkit.getPluginCommand("storeinventory").setExecutor(new StoreInventoryCommand());

        //World
        Bukkit.getPluginCommand("day").setExecutor(new DayCommand());
        Bukkit.getPluginCommand("night").setExecutor(new NightCommand());
        Bukkit.getPluginCommand("worldcreate").setExecutor(new WorldCreateCommand());
        Bukkit.getPluginCommand("worldlist").setExecutor(new WorldListCommand());
        Bukkit.getPluginCommand("worldtp").setExecutor(new WorldTPCommand());

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

    public BackpackManagerStored getBackpackManagerStored() {
        return backpackManagerStored;
    }
}
