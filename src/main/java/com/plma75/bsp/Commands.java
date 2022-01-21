package com.plma75.bsp;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    private final String prefix = ChatColor.translateAlternateColorCodes('&', "&e[ &5BSP &e] &d");
    private final String noPermission = BSP.getInstance().getNo_permission();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (args.length == 0) {
            if (player.hasPermission("bsp.use")) {
                player.sendMessage(prefix + "/BSP help (Send this message.)");
                player.sendMessage(prefix + "/BSP reload (reload config.)");
                player.sendMessage(prefix + "/BSP version (show this BSP plugin version.)");
            } else {
                player.sendMessage(noPermission);
            }
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("help")) {
                player.performCommand("bsp");
            } else if (args[0].equalsIgnoreCase("reload")) {
                if (player.hasPermission("bsp.use")) {
                    player.sendMessage(prefix + "Reloading configurations...");
                    BSP.getInstance().reloadConfig();
                    player.sendMessage(prefix + "Reload is finished.");
                } else {
                    player.sendMessage(noPermission);
                }
            } else if (args[0].equalsIgnoreCase("version")) {
                if (player.hasPermission("bsp.use")) {
                    player.sendMessage(prefix + "This BSP plugin version : " + ChatColor.AQUA + BSP.getInstance().getDescription().getVersion());
                } else {
                    player.sendMessage(noPermission);
                }
            }
        }
        return false;
    }
}
