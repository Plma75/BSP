package com.plma75.bsp.API;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BlockPluginEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private Player player;

    public BlockPluginEvent(Player eventPlayer) {
        player = eventPlayer;
    }

    public Player getPlayer() {
        return player;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
