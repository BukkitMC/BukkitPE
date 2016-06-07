package net.BukkitPE.level.sound;

import net.BukkitPE.math.Vector3;
import net.BukkitPE.network.protocol.DataPacket;
import net.BukkitPE.network.protocol.LevelEventPacket;

/**
 * Created on 2015/11/21 by xtypr.
 * Package net.BukkitPE.level.sound in project BukkitPE .
 */
public class GenericSound extends Sound {
    public GenericSound(Vector3 pos, int id) {
        this(pos, id, 0);
    }

    public GenericSound(Vector3 pos, int id, float pitch) {
        super(pos.x, pos.y, pos.z);
        this.id = id;
        this.pitch = pitch * 1000f;
    }

    protected float pitch = 0f;
    protected int id;

    public float getPitch() {
        return this.pitch / 1000f;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch * 1000f;
    }

    @Override
    public DataPacket[] encode() {
        LevelEventPacket pk = new LevelEventPacket();
        pk.evid = this.id;
        pk.x = (float) this.x;
        pk.y = (float) this.y;
        pk.z = (float) this.z;
        pk.data = (int) this.pitch;

        return new DataPacket[]{pk};
    }

}
