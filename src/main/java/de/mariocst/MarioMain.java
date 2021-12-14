package de.mariocst;

import de.mariocst.backpack.BackpackManager;
import de.mariocst.backpack.BackpackManagerLarge;
import de.mariocst.backpack.BackpackManagerStored;
import de.mariocst.commands.announcements.*;
import de.mariocst.commands.chat.*;
import de.mariocst.commands.inventory.*;
import de.mariocst.commands.random.*;
import de.mariocst.commands.player.*;
import de.mariocst.commands.send.*;
import de.mariocst.commands.server.*;
import de.mariocst.commands.setter.*;
import de.mariocst.commands.storing.*;
import de.mariocst.commands.world.*;
import de.mariocst.listeners.*;
import de.mariocst.scoreboard.MarioScoreboard;
import de.mariocst.utils.*;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class MarioMain extends JavaPlugin {
    private static String prefix;
    private static MarioMain instance;

    private BackpackManager backpackManager;
    private BackpackManagerLarge backpackManagerLarge;
    private BackpackManagerStored backpackManagerStored;
    private Config config;
    private Backpacks backpacks;
    private BackpacksLarge backpacksLarge;
    private BackpacksStored backpacksStored;
    private Prefix prefixConfig;
    private DiscordLink discordLink;

    public List<Player> invTroll = new ArrayList<>();

    @Override
    public void onLoad() {
        instance = this;

        this.loadConfigs();
    }

    public MarioMain() {
        instance = this;
    }

    @Override
    public void onEnable() {
        try {
            this.register();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
            this.warning("Error beim Initialisieren der Commands! Deaktiviere Plugin...");
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }

        this.listenerRegistration();
        this.registerScoreboards();

        this.log("marioCST's Plugin geladen!");
    }

    @Override
    public void onDisable() {
        this.log("marioCST's Plugin entladen!");
        this.saveConfigs();
    }

    public Config getConfiguration() {
        return this.config;
    }

    public Backpacks getBackpacks() {
        return this.backpacks;
    }

    public BackpacksLarge getBackpacksLarge() {
        return this.backpacksLarge;
    }

    public BackpacksStored getBackpacksStored() {
        return this.backpacksStored;
    }

    public static String getPrefix() {
        return prefix;
    }

    public static void setPrefix(String prefix) {
        MarioMain.prefix = prefix;
    }

    private void listenerRegistration() {
        PluginManager pluginManager = this.getServer().getPluginManager();

        pluginManager.registerEvents(new InventoryListener(), this);
        pluginManager.registerEvents(new JoinListener(), this);
    }

    public void saveConfigs() {
        this.prefixConfig.save();
        this.discordLink.save();
        this.backpackManager.save();
        this.backpackManagerLarge.save();
        this.backpackManagerStored.save();

        this.backpacks.save();
        this.backpacksLarge.save();
        this.backpacksStored.save();
        this.config.save();
    }

    public void loadConfigs() {
        this.backpacks = new Backpacks();
        this.backpacksLarge = new BackpacksLarge();
        this.backpacksStored = new BackpacksStored();
        this.config = new Config();

        this.prefixConfig = new Prefix();
        this.discordLink = new DiscordLink();
        this.backpackManager = new BackpackManager();
        this.backpackManagerLarge = new BackpackManagerLarge();
        this.backpackManagerStored = new BackpackManagerStored();
    }

    public void log(String text) {
        this.getLogger().info(prefix + text);
    }

    public void warning(String text) {
        this.getLogger().warning(prefix + text);
    }

    private void registerScoreboards() {
        new MarioScoreboard(Component.text("  " + prefix + "  "), this.getServer().getScoreboardManager().getMainScoreboard(), null);
    }

    private void register() throws NullPointerException {
        // Announcements
        Objects.requireNonNull(this.getCommand("broadcast5")).setExecutor(new Custom());
        Objects.requireNonNull(this.getCommand("announcekick")).setExecutor(new Kick());
        Objects.requireNonNull(this.getCommand("announcereload")).setExecutor(new Reload());
        Objects.requireNonNull(this.getCommand("announcerestart")).setExecutor(new Restart());
        Objects.requireNonNull(this.getCommand("announcestop")).setExecutor(new Stop());

        // Chat
        Objects.requireNonNull(this.getCommand("broadcast")).setExecutor(new BroadcastCommand());
        Objects.requireNonNull(this.getCommand("chatclear")).setExecutor(new ChatClearCommand());
        Objects.requireNonNull(this.getCommand("colorcodes")).setExecutor(new ColorCodesCommand());

        // Inventory
        Objects.requireNonNull(this.getCommand("backpack")).setExecutor(new BackpackCommand());
        Objects.requireNonNull(this.getCommand("backpacklarge")).setExecutor(new BackpackLargeCommand());
        Objects.requireNonNull(this.getCommand("clearenderchest")).setExecutor(new ClearEnderChestCommand());
        Objects.requireNonNull(this.getCommand("clearinventory")).setExecutor(new ClearInventoryCommand());
        Objects.requireNonNull(this.getCommand("enderchest")).setExecutor(new ECCommand());
        Objects.requireNonNull(this.getCommand("enderinvsee")).setExecutor(new EnderInvseeCommand());
        Objects.requireNonNull(this.getCommand("invsee")).setExecutor(new InvseeCommand());

        // Player
        Objects.requireNonNull(this.getCommand("die")).setExecutor(new DieCommand());
        Objects.requireNonNull(this.getCommand("feed")).setExecutor(new FeedCommand());
        Objects.requireNonNull(this.getCommand("fly")).setExecutor(new FlyCommand());
        Objects.requireNonNull(this.getCommand("gm")).setExecutor(new GMCommand());
        Objects.requireNonNull(this.getCommand("heal")).setExecutor(new HealCommand());
        Objects.requireNonNull(this.getCommand("nick")).setExecutor(new NickCommand());
        Objects.requireNonNull(this.getCommand("realname")).setExecutor(new RealnameCommand());
        Objects.requireNonNull(this.getCommand("speed")).setExecutor(new SpeedCommand());
        Objects.requireNonNull(this.getCommand("unnick")).setExecutor(new UnnickCommand());

        // Random
        Objects.requireNonNull(this.getCommand("date")).setExecutor(new DateCommand());
        Objects.requireNonNull(this.getCommand("discord")).setExecutor(new DiscordCommand());
        Objects.requireNonNull(this.getCommand("troll")).setExecutor(new TrollCommand());

        // Send
        Objects.requireNonNull(this.getCommand("sendactionbar")).setExecutor(new SendActionBarCommand());
        Objects.requireNonNull(this.getCommand("sendmessage")).setExecutor(new SendMessageCommand());
        Objects.requireNonNull(this.getCommand("sendtitle")).setExecutor(new SendTitleCommand());

        // Server
        Objects.requireNonNull(this.getCommand("banall")).setExecutor(new BanAllCommand());
        Objects.requireNonNull(this.getCommand("config")).setExecutor(new ConfigCommand());
        Objects.requireNonNull(this.getCommand("kickall")).setExecutor(new KickAllCommand());

        // Setter
        Objects.requireNonNull(this.getCommand("setlink")).setExecutor(new SetLinkCommand());
        Objects.requireNonNull(this.getCommand("setprefix")).setExecutor(new SetPrefixCommand());

        // Storing
        Objects.requireNonNull(this.getCommand("backpackstored")).setExecutor(new BackpackStoredCommand());
        Objects.requireNonNull(this.getCommand("restoreinventory")).setExecutor(new RestoreInventoryCommand());
        Objects.requireNonNull(this.getCommand("storeinventory")).setExecutor(new StoreInventoryCommand());

        // World
        Objects.requireNonNull(this.getCommand("day")).setExecutor(new DayCommand());
        Objects.requireNonNull(this.getCommand("forceloadchunk")).setExecutor(new ForceLoadChunkCommand());
        Objects.requireNonNull(this.getCommand("night")).setExecutor(new NightCommand());
    }

    public static MarioMain getInstance() {
        return instance;
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
