package net.BukkitPE.event.entity;

import net.BukkitPE.entity.mob.EntityCreeper;
import net.BukkitPE.entity.weather.EntityLightningStrike;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class CreeperPowerEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    private final PowerCause cause;
    private EntityLightningStrike bolt;

    public CreeperPowerEvent(final EntityCreeper creeper, final EntityLightningStrike bolt, final PowerCause cause) {
        this(creeper, cause);
        this.bolt = bolt;
    }

    public CreeperPowerEvent(final EntityCreeper creeper, final PowerCause cause) {
        this.entity = creeper;
        this.cause = cause;
    }

    @Override
    public EntityCreeper getEntity() {
        return (EntityCreeper) super.getEntity();
    }

    /**
     * Gets the lightning bolt which is striking the Creeper.
     *
     * @return The Entity for the lightning bolt which is striking the Creeper
     */
    public EntityLightningStrike getLightning() {
        return bolt;
    }

    /**
     * Gets the cause of the creeper being (un)powered.
     *
     * @return A PowerCause value detailing the cause of change in power.
     */
    public PowerCause getCause() {
        return cause;
    }

    /**
     * An enum to specify the cause of the change in power
     */
    public enum PowerCause {

        /**
         * Power change caused by a lightning bolt
         * <p>
         * Powered state: true
         */
        LIGHTNING,
        /**
         * Power change caused by something else (probably a plugin)
         * <p>
         * Powered state: true
         */
        SET_ON,
        /**
         * Power change caused by something else (probably a plugin)
         * <p>
         * Powered state: false
         */
        SET_OFF
    }
}
