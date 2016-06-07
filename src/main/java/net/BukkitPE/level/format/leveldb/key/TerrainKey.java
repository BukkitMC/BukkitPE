package net.BukkitPE.level.format.leveldb.key;

/**

 * BukkitPE Project
 */
public class TerrainKey extends BaseKey {
    protected TerrainKey(int chunkX, int chunkZ) {
        super(chunkX, chunkZ, DATA_TERRAIN);
    }

    public static TerrainKey create(int chunkX, int chunkZ) {
        return new TerrainKey(chunkX, chunkZ);
    }
}
