package net.BukkitPE.event.player;

import net.BukkitPE.Player;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.item.food.Food;

/**
 * Created by Snake1999 on 2016/1/14.
 * Package net.BukkitPE.event.player in project BukkitPE.
 */
public class PlayerEatFoodEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private Food food;

    public static HandlerList getHandlers() {
        return handlers;
    }

    public PlayerEatFoodEvent(Player player, Food food) {
        this.player = player;
        this.food = food;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

}
