package net.BukkitPE.entity.data;

import net.BukkitPE.entity.Entity;

/**
 * BukkitPE Project
 */
public class StringEntityData extends EntityData<String> {
    public String data;

    public StringEntityData(int id, String data) {
        super(id);
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public int getType() {
        return Entity.DATA_TYPE_STRING;
    }

    @Override
    public String toString() {
        return data;
    }
}
