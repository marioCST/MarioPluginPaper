package de.mariocst.utils;

import de.mariocst.MarioMain;

public class Prefix {
    private String prefix;

    private static Prefix prefixClass;

    public Prefix() {
        prefixClass = this;

        Config config = MarioMain.getInstance().getConfiguration();

        if (config.getConfig().contains("prefix")) {
            this.prefix = config.getConfig().getString("prefix");
        }
        else {
            this.prefix = "§8[§6marioCST.de§8] §b";
        }

        MarioMain.setPrefix(this.prefix);
    }

    public void reload() {
        Config config = MarioMain.getInstance().getConfiguration();

        if (config.getConfig().contains("prefix")) {
            this.prefix = config.getConfig().getString("prefix");
        }
        else {
            this.prefix = "§8[§6marioCST.de§8] §b";
        }

        MarioMain.setPrefix(this.prefix);
    }

    public static Prefix getPrefixClass() {
        return prefixClass;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void save() {
        Config config = MarioMain.getInstance().getConfiguration();

        config.getConfig().set("prefix", this.prefix);
    }
}
