package net.BukkitPE.block;

import net.BukkitPE.Player;
import net.BukkitPE.item.Item;
import net.BukkitPE.item.ItemTool;
import net.BukkitPE.level.Level;
import net.BukkitPE.math.Vector3;
import net.BukkitPE.utils.BlockColor;

/**
 * Created on 2015/12/6 by xtypr.
 * Package net.BukkitPE.block in project BukkitPE .
 */
public class BlockSnowLayer extends BlockFlowable {

    public BlockSnowLayer() {
        this(0);
    }

    public BlockSnowLayer(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Snow Layer";
    }

    @Override
    public int getId() {
        return SNOW_LAYER;
    }

    @Override
    public double getHardness() {
        return 0.1;
    }

    @Override
    public double getResistance() {
        return 0.5;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_SHOVEL;
    }

    @Override
    public boolean canBeReplaced() {
        return true;
    }

    //TODO:雪片叠垒乐

    @Override
    public boolean place(Item item, Block block, Block target, int face, double fx, double fy, double fz, Player player) {
        Block down = this.getSide(0);
        if (down.isSolid()) {
            this.getLevel().setBlock(block, this, true);

            return true;
        }
        return false;
    }

    @Override
    public int onUpdate(int type) {
        if (type == Level.BLOCK_UPDATE_NORMAL) {
            if (this.getSide(Vector3.SIDE_DOWN).isTransparent()) {
                this.getLevel().useBreakOn(this);

                return Level.BLOCK_UPDATE_NORMAL;
            }
        } else if (type == Level.BLOCK_UPDATE_RANDOM) {
            if (this.getLevel().getBlockLightAt((int) this.x, (int) this.y, (int) this.z) >= 10) {
                this.getLevel().setBlock(this, new BlockAir(), true);
                return Level.BLOCK_UPDATE_NORMAL;
            }
        }
        return 0;
    }

    @Override
    public int[][] getDrops(Item item) {
        if (item.isShovel()) {
            return new int[][]{
                    {Item.SNOWBALL, 0, 1}
            };
        }
        return new int[][]{};
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.SNOW_BLOCK_COLOR;
    }
}


