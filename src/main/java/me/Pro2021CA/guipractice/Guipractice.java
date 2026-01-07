package me.Pro2021CA.guipractice;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Guipractice extends JavaPlugin {
    public static Plugin plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getCommand("gui").setExecutor(new guicommand());
        getServer().getPluginManager().registerEvents(new closeevent(), this);
        getServer().getPluginManager().registerEvents(new clickevent(), this);
        getCommand("players").setExecutor(new playerscommand()); // gui with online players
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
