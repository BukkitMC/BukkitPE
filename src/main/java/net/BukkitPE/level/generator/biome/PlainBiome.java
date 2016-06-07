package net.BukkitPE.level.generator.biome;

import net.BukkitPE.block.Block;
import net.BukkitPE.block.BlockFlower;
import net.BukkitPE.level.generator.populator.PopulatorFlower;
import net.BukkitPE.level.generator.populator.PopulatorGrass;
import net.BukkitPE.level.generator.populator.PopulatorTallGrass;

/**

 * BukkitPE Project
 */
public class PlainBiome extends GrassyBiome {

    public PlainBiome() {
        super();

        PopulatorGrass grass = new PopulatorGrass();
        grass.setBaseAmount(40);
        PopulatorTallGrass tallGrass = new PopulatorTallGrass();
        tallGrass.setBaseAmount(7);
        PopulatorFlower flower = new PopulatorFlower();
        flower.setBaseAmount(10);
        flower.addType(Block.DANDELION, 0);
        flower.addType(Block.RED_FLOWER, BlockFlower.TYPE_POPPY);
        flower.addType(Block.RED_FLOWER, BlockFlower.TYPE_AZURE_BLUET);
        flower.addType(Block.RED_FLOWER, BlockFlower.TYPE_RED_TULIP);
        flower.addType(Block.RED_FLOWER, BlockFlower.TYPE_ORANGE_TULIP);
        flower.addType(Block.RED_FLOWER, BlockFlower.TYPE_WHITE_TULIP);
        flower.addType(Block.RED_FLOWER, BlockFlower.TYPE_PINK_TULIP);
        flower.addType(Block.RED_FLOWER, BlockFlower.TYPE_OXEYE_DAISY);


        this.addPopulator(grass);
        this.addPopulator(tallGrass);
        this.addPopulator(flower);

        this.setElevation(63, 74);

        this.temperature = 0.8;
        this.rainfall = 0.4;
    }

    @Override
    public String getName() {
        return "Plains";
    }
}
