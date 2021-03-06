package net.BukkitPE.item;

import net.BukkitPE.block.Block;

/**
 * Created by Snake1999 on 2016/2/3.
 * Package net.BukkitPE.item in project BukkitPE.
 */
public class ItemSkull extends Item {
    public static final int SKELETON_SKULL = 0;
    public static final int WITHER_SKELETON_SKULL = 1;
    public static final int ZOMBIE_HEAD = 2;
    public static final int HEAD = 3;
    public static final int CREEPER_HEAD = 4;

    public ItemSkull() {
        this(0, 1);
    }

    public ItemSkull(Integer meta) {
        this(meta, 1);
    }

    public ItemSkull(Integer meta, int count) {
        super(SKULL, meta, count, getItemSkullName(meta));
        this.block = Block.get(Block.SKULL_BLOCK);
    }

    public static String getItemSkullName(int meta) {
        switch (meta) {
            case 1:
                return "Wither Skeleton Skull";
            case 2:
                return "Zombie Head";
            case 3:
                return "Head";
            case 4:
                return "Creeper Head";
            case 0:
            default:
                return "Skeleton Skull";
        }
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }
}
