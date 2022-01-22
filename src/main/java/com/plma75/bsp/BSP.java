package com.plma75.bsp;

import com.plma75.bsp.API.BlockPluginEvent;
import com.plma75.bsp.Events.EvtPlayerCommandPreprocess;
import com.plma75.bsp.Events.EvtTabComplete;
import com.plma75.bsp.Utils.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.regex.Pattern;

public final class BSP extends JavaPlugin {
    // Instance? \\
    public static BSP instance;

    private final String prefix = ChatColor.translateAlternateColorCodes('&', "&e[&5BSP&e] &d");
    private final Pattern commands = Pattern.compile("(?:(bukkit:|minecraft:)?)(plugins|version|about|help|pl|ver|\\?)(.*)", 2);
    private String no_permission = this.getConfig().getString("message.NO-PERMISSION");

    ConsoleCommandSender logger = Bukkit.getConsoleSender();

    public BSP() {
        if (instance == null) {
            instance = this;
        } else {
            throw new IllegalStateException();
        }
    }

    public static BSP getInstance() {
        if (instance == null) {
            BSP bsp = new BSP();
            return bsp;
        }
        return instance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        setup();
        logger.sendMessage(prefix + "Blocking the plugin list to show.");
        logger.sendMessage(prefix + "If you want to see BSP commands. enter the '/bsp help' command.");
        logger.sendMessage(prefix + ChatColor.GRAY + "Created by Plma75.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        logger.sendMessage(prefix + "GoodBye! see you later.");
        logger.sendMessage(prefix + ChatColor.GRAY + "Created by Plma75.");
    }

    private void setup() {
        // Load Config \\
        saveDefaultConfig();
        File file = new File(getDataFolder(), "config.yml");
        if (file.length() == 0) {
            getConfig().options().copyDefaults(true);
            saveConfig();
        }

        // Load Command \\
        getCommand("bsp").setExecutor(new Commands());

        // Register Events \\
        Bukkit.getPluginManager().registerEvents(new EvtTabComplete(), this);
        Bukkit.getPluginManager().registerEvents(new EvtPlayerCommandPreprocess(), this);

        // Update Check \\
        if (this.getConfig().getBoolean("setting.update-checker")) {
            new UpdateChecker(this, 99380).getVersion(version -> {
                if (this.getDescription().getVersion().equals(version)) {
                    logger.sendMessage(prefix + "There is not a new update available.");
                } else {
                    logger.sendMessage(prefix + "There is a new update available: " + ChatColor.AQUA + version);
                }
            });
        } else {
            logger.sendMessage(prefix + "Updater-Checker is disabled.");
        }

    }

    public String getPrefix() {
        return prefix;
    }

    public String getNo_permission() {
        return no_permission;
    }

    public Pattern getCommands() {
        return commands;
    }


}
