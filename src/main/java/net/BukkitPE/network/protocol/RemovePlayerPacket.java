package net.BukkitPE.network.protocol;

import java.util.UUID;

/**

 * BukkitPE Project
 */
public class RemovePlayerPacket extends DataPacket {
    public final static byte NETWORK_ID = ProtocolInfo.REMOVE_PLAYER_PACKET;

    public long eid;
    public UUID uuid;

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    @Override
    public void decode() {

    }

    @Override
    public void encode() {
        this.reset();
        this.putLong(this.eid);
        this.putUUID(this.uuid);
    }
}
