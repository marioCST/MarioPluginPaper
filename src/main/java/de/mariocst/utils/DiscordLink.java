package de.mariocst.utils;

import de.mariocst.MarioMain;

public class DiscordLink {
    private String link;

    private static DiscordLink discordLink;

    public DiscordLink() {
        discordLink = this;

        Config config = MarioMain.getInstance().getConfiguration();

        if (config.getConfig().contains("link")) {
            this.link = config.getConfig().getString("link");
        }
        else {
            this.link = "https://discord.gg/xcVMMxF4QD";
        }
    }

    public void reload() {
        Config config = MarioMain.getInstance().getConfiguration();

        if (config.getConfig().contains("link")) {
            this.link = config.getConfig().getString("link");
        }
        else {
            this.link = "https://discord.gg/xcVMMxF4QD";
        }
    }

    public static DiscordLink getDiscordLink() {
        return discordLink;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void save() {
        Config config = MarioMain.getInstance().getConfiguration();

        config.getConfig().set("link", this.link);
    }
}
