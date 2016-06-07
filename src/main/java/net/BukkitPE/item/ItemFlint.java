package net.BukkitPE.item;

/**

 * BukkitPE Project
 */
public class ItemFlint extends Item {

    public ItemFlint() {
        this(0, 1);
    }

    public ItemFlint(Integer meta) {
        this(meta, 1);
    }

    public ItemFlint(Integer meta, int count) {
        super(FLINT, meta, count, "Flint");
    }
}
