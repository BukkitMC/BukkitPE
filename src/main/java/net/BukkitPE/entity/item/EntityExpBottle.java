package net.BukkitPE.entity.item;

import net.BukkitPE.Player;
import net.BukkitPE.entity.Entity;
import net.BukkitPE.entity.projectile.EntityProjectile;
import net.BukkitPE.level.format.FullChunk;
import net.BukkitPE.level.particle.EnchantParticle;
import net.BukkitPE.level.particle.Particle;
import net.BukkitPE.level.particle.SpellParticle;
import net.BukkitPE.math.BukkitPERandom;
import net.BukkitPE.nbt.tag.CompoundTag;
import net.BukkitPE.network.protocol.AddEntityPacket;

/**
 * @author xtypr
 */
public class EntityExpBottle extends EntityProjectile {

    public static final int NETWORK_ID = 68;

    @Override
    public int getNetworkId() {
        return NETWORK_ID;
    }

    @Override
    public float getWidth() {
        return 0.25f;
    }

    @Override
    public float getLength() {
        return 0.25f;
    }

    @Override
    public float getHeight() {
        return 0.25f;
    }

    @Override
    protected float getGravity() {
        return 0.1f;
    }

    @Override
    protected float getDrag() {
        return 0.01f;
    }

    public EntityExpBottle(FullChunk chunk, CompoundTag nbt) {
        this(chunk, nbt, null);
    }

    public EntityExpBottle(FullChunk chunk, CompoundTag nbt, Entity shootingEntity) {
        super(chunk, nbt, shootingEntity);
    }

    @Override
    public boolean onUpdate(int currentTick) {
        if (this.closed) {
            return false;
        }

        this.timing.startTiming();

        int tickDiff = currentTick - this.lastUpdate;
        boolean hasUpdate = super.onUpdate(currentTick);

        if (this.age > 1200) {
            this.kill();
            hasUpdate = true;
        }

        if (this.isCollided) {
            this.kill();
            Particle particle1 = new EnchantParticle(this);
            this.getLevel().addParticle(particle1);
            Particle particle2 = new SpellParticle(this, 0x00385dc6);
            this.getLevel().addParticle(particle2);
            hasUpdate = true;

            BukkitPERandom random = new BukkitPERandom();
            int add = 1;
            for (int ii = 1; ii <= random.nextRange(3, 11); ii += add) {
                getLevel().dropExpOrb(this, add);
                add = random.nextRange(1, 3);
            }
        }

        this.timing.stopTiming();

        return hasUpdate;
    }

    @Override
    public void spawnTo(Player player) {
        AddEntityPacket pk = new AddEntityPacket();
        pk.type = EntityExpBottle.NETWORK_ID;
        pk.eid = this.getId();
        pk.x = (float) this.x;
        pk.y = (float) this.y;
        pk.z = (float) this.z;
        pk.speedX = (float) this.motionX;
        pk.speedY = (float) this.motionY;
        pk.speedZ = (float) this.motionZ;
        pk.metadata = this.dataProperties;
        player.dataPacket(pk);

        super.spawnTo(player);
    }
}
