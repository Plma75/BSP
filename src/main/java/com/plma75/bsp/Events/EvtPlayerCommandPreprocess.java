package com.plma75.bsp.Events;

import com.plma75.bsp.API.BlockPluginEvent;
import com.plma75.bsp.BSP;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.regex.Pattern;

public class EvtPlayerCommandPreprocess implements Listener {

    Pattern commands = BSP.getInstance().getCommands();

    @EventHandler
    public void onCommandPreprocess(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage().substring(1);
        if (commands.matcher(message).matches()) {
            event.setCancelled(true);

            BlockPluginEvent blockPluginEvent = new BlockPluginEvent(player);
            Bukkit.getPluginManager().callEvent(blockPluginEvent);

        }
    }

}
