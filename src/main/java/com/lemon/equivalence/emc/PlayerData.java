package com.lemon.equivalence.emc;

public class PlayerData {
    String uuid;
    Integer emc = 0;

    PlayerData (String uuid, Integer emc) {
        this.uuid = uuid;
        this.emc = emc;
    }

    PlayerData (String uuid) {
        this(uuid, 0);
    }

    public void setEMC(Integer emc) {
        this.emc = emc;
    }

    public Integer getEMC() {
        return this.emc;
    }
}
