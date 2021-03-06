package net.BukkitPE.block;

import net.BukkitPE.Player;
import net.BukkitPE.item.Item;
import net.BukkitPE.level.sound.LeverSound;
import net.BukkitPE.redstone.Redstone;

/**
 * @author BukkitPE Project Team
 */
public class BlockLever extends BlockFlowable {

    public BlockLever(int meta) {
        super(meta);
        this.setPowerLevel(Redstone.POWER_STRONGEST);
    }

    public BlockLever() {
        this(0);
    }

    @Override
    public String getName() {
        return "Lever";
    }

    @Override
    public int getId() {
        return LEVER;
    }

    @Override
    public boolean canBeActivated() {
        return true;
    }

    @Override
    public double getHardness() {
        return 0.5;
    }

    @Override
    public double getResistance() {
        return 2.5;
    }

    @Override
    public int[][] getDrops(Item item) {
        return new int[][]{
                {Item.LEVER, 0, 1}
        };
    }

    public boolean isPowerOn() {
        return (this.meta & 0x08) == 0x08;
    }

    @Override
    public boolean onActivate(Item item, Player player) {
        this.meta ^= 0x08;

        this.getLevel().setBlock(this, this, true, true);
        this.getLevel().addSound(new LeverSound(this, this.isPowerOn()));
        if (this.isPowerOn()) {
            this.setPowerSource(true);
            Redstone.active(this);
        } else {
            this.setPowerSource(false);
            Redstone.deactive(this, this.getPowerLevel());
        }
        return true;
    }

    @Override
    public boolean place(Item item, Block block, Block target, int face, double fx, double fy, double fz, Player player) {
        if (!target.isTransparent()) {
            int[] faces = new int[]{
                    0,
                    5,
                    4,
                    3,
                    2,
                    1,
            };
            int to;

            if (face == 0) {
                to = player != null ? player.getDirection() : 0;
                this.meta = (to % 2 != 1 ? 0 : 7);
            } else if (face == 1) {
                to = player != null ? player.getDirection() : 0;
                this.meta = (to % 2 != 1 ? 6 : 5);
            } else {
                this.meta = faces[face];
            }
            this.getLevel().setBlock(block, this, true, false);
            return true;
        }
        return false;
    }

    @Override
    public boolean onBreak(Item item) {
        super.onBreak(item);
        Redstone.deactive(this, this.getPowerLevel());
        return true;
    }

}
