package com.lemon.equivalence.emc;

import com.google.gson.Gson;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.player.PlayerEntity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class PlayerEMCDatabase {
    Map<String, PlayerData> data = new HashMap<String, PlayerData>();

    public static final PlayerEMCDatabase INSTANCE = new PlayerEMCDatabase();

    PlayerEMCDatabase() {
        this.load();
    }

    public void load() {
        Path path = FabricLoader.getInstance().getConfigDir().resolve("equivalence-players.json");
        if (Files.exists(path)) {
            try {
                String data = Files.readString(path);
                Gson gson = new Gson();
                PlayerData[] entries = gson.fromJson(data, PlayerData[].class);
                for(PlayerData playerData: entries) {
                    this.data.put(playerData.uuid, playerData);
                }
            } catch (IOException e) {
                System.out.println("[Equivalence] Failed to load equivalence-players.json");
                e.printStackTrace();
            }
        } else {
            System.out.println("[Equivalence] equivalence-players.json not found, starting all players at 0 EMC");
        }
    }

    public void save() {
        Path path = FabricLoader.getInstance().getConfigDir().resolve("equivalence-players.json");

        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                System.out.println("[Equivalence] Failed to create equivalence-players.json");
                e.printStackTrace();
            }
        }

        Gson gson = new Gson();
        String json = gson.toJson(this.data.values());

        try {
            Files.writeString(path, json);
        } catch (IOException e) {
            System.out.println("[Equivalence] Failed to write to equivalence-players.json");
            e.printStackTrace();
        }
    }

    public void setEMC(PlayerEntity player, Integer emc) {
        String uuid = player.getUuidAsString();
        this.setEMC(uuid, emc);
    }
    public void setEMC(String uuid, Integer emc) {
        if (!this.data.containsKey(uuid)) {
            this.initializePlayerData(uuid);
        }

        PlayerData playerData = this.data.get(uuid);
        playerData.setEMC(emc);
        this.data.put(uuid, playerData);
    }

    public Integer getEMC(PlayerEntity player) {
        String uuid = player.getUuidAsString();
        return this.getEMC(uuid);
    }
    public Integer getEMC(String uuid) {
        if (this.data.containsKey(uuid)) {
            return this.data.get(uuid).getEMC();
        } else {
            return 0;
        }
    }

    public void initializePlayerData(PlayerEntity player) {
        this.initializePlayerData(player.getUuidAsString());
    }
    public void initializePlayerData(String uuid) {
        this.data.put(uuid, new PlayerData(uuid));
    }
}
