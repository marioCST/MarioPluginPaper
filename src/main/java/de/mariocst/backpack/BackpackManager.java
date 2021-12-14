package de.mariocst.backpack;

import de.mariocst.MarioMain;
import de.mariocst.utils.Backpacks;

import java.io.IOException;
import java.util.*;

public class BackpackManager {
    private final Map<UUID, Backpack> map;

    public BackpackManager() {
        map = new HashMap<>();

        load();
    }

    public Backpack getBackpack(UUID uuid) {
        if (map.containsKey(uuid)) {
            return map.get(uuid);
        }

        Backpack backpack = new Backpack(uuid);
        map.put(uuid, backpack);
        return backpack;
    }

    public void load() {
        Backpacks backpacks = MarioMain.getInstance().getBackpacks();

        List<String> uuids = backpacks.getBackpacks().getStringList("backpacks");

        uuids.forEach(s -> {
            UUID uuid = UUID.fromString(s);

            String base64 = backpacks.getBackpacks().getString("backpack." + s);

            try {
                map.put(uuid, new Backpack(uuid, base64));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void save() {
        Backpacks backpacks = MarioMain.getInstance().getBackpacks();

        List<String> uuids = new ArrayList<>();

        for (UUID uuid : map.keySet()) {
            uuids.add(uuid.toString());
        }

        backpacks.getBackpacks().set("backpacks", uuids);
        map.forEach((uuid, backpack) -> backpacks.getBackpacks().set("backpack." + uuid.toString(), backpack.toBase64()));
    }
}
