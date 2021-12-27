package com.lemon.equivalence.emc;

import com.google.gson.Gson;
import com.lemon.equivalence.Equivalence;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;

import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class EMCProvider {
    public static final EMCProvider INSTANCE = new EMCProvider();

    public Map<String, Integer> emcValues = new HashMap<String, Integer>();

    EMCProvider() {
        Optional<ModContainer> optionalContainer = FabricLoader.getInstance().getModContainer(Equivalence.MOD_ID);
        if (optionalContainer.isEmpty()) {
            System.out.println("[Equivalence] Oops! Mod container doesn't exist yet!");
        }

        ModContainer container = optionalContainer.get();
        String emcJson = null;
        try {
            emcJson = Files.readString(container.getPath("emc_values.json"));
        } catch (IOException e) {
            System.out.println("Failed to open emc_values.json");
            e.printStackTrace();
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        Map<String,Double> rawValues = gson.fromJson(emcJson, HashMap.class);

        for (String key: rawValues.keySet()) {
            this.emcValues.put(key, rawValues.get(key).intValue());
        }
    }

    public Integer getEMC(String item) {
        if (this.emcValues.containsKey(item)) {
            Integer emcValue = this.emcValues.get(item);
            return emcValue;
        } else {
            return 0;
        }
    }
}
