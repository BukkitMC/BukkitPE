package net.BukkitPE.event.player;

import net.BukkitPE.Player;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;

/**
 * Called when the player logs in, before things have been set up
 */
public class PlayerPreLoginEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    protected String kickMessage;

    public PlayerPreLoginEvent(Player player, String kickMessage) {
        this.player = player;
        this.kickMessage = kickMessage;
    }

    public void setKickMessage(String kickMessage) {
        this.kickMessage = kickMessage;
    }

    public String getKickMessage() {
        return this.kickMessage;
    }
}
