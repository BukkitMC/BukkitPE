package net.BukkitPE.event.player;

import net.BukkitPE.Player;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;

public class PlayerCommandPreprocessEvent extends PlayerMessageEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    public PlayerCommandPreprocessEvent(Player player, String message) {
        this.player = player;
        this.message = message;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
