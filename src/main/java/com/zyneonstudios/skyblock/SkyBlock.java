package com.zyneonstudios.skyblock;

import com.zyneonstudios.api.Zyneon;
import com.zyneonstudios.api.utils.Strings;
import com.zyneonstudios.skyblock.listeners.PlayerJoin;
import com.zyneonstudios.skyblock.listeners.PlayerQuit;
import com.zyneonstudios.skyblock.utils.island.IslandPlayer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashMap;
import java.util.UUID;

public final class SkyBlock extends JavaPlugin {

    public static PluginManager pluginManager = Bukkit.getPluginManager();
    public static final HashMap<UUID, IslandPlayer> skyblockPlayers = new HashMap<>();

    @Override
    public void onLoad() {
        Strings.setPrefixWord("SkyBlock");
    }

    @Override
    public void onEnable() {
        initListeners();
    }

    @Override
    public void onDisable() {

    }

    private void initListeners() {
        Zyneon.getAPI().initListenerClass(pluginManager,new PlayerJoin(),this);
        Zyneon.getAPI().initListenerClass(pluginManager,new PlayerQuit(),this);
    }

    public static IslandPlayer getIslandPlayer(UUID uuid) {
        if(skyblockPlayers.containsKey(uuid)) {
            return skyblockPlayers.get(uuid);
        } else {
            skyblockPlayers.put(uuid,new IslandPlayer(uuid));
            return getIslandPlayer(uuid);
        }
    }
}
