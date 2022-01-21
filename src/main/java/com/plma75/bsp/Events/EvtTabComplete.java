package com.plma75.bsp.Events;

import com.plma75.bsp.API.BlockPluginEvent;
import com.plma75.bsp.BSP;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.TabCompleteEvent;

import java.util.regex.Pattern;

public class EvtTabComplete implements Listener {

    Pattern commands = BSP.getInstance().getCommands();

    @EventHandler
    public void onTabComplete(TabCompleteEvent event) {
        Player player = (Player) event.getSender();
        String message = event.getBuffer();
        if (message.startsWith("/")) {
            if (event.getSender() instanceof Player) {
                message = message.substring(1);
                if (commands.matcher(message).matches()) {
                    if (player.hasPermission(""))
                    event.setCancelled(true);

                    BlockPluginEvent blockPluginEvent = new BlockPluginEvent(player);
                    Bukkit.getPluginManager().callEvent(blockPluginEvent);

                }
            }
        }
    }

}
