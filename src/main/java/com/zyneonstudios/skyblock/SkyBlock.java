package com.zyneonstudios.skyblock;

import com.zyneonstudios.api.Zyneon;
import com.zyneonstudios.api.configuration.Config;
import com.zyneonstudios.api.utils.Strings;
import com.zyneonstudios.skyblock.commands.BiomeStickCommand;
import com.zyneonstudios.skyblock.listeners.PlayerInteract;
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
    Config config = new Config("plugins/SkyBlock/config.yml");

    @Override
    public void onLoad() {
        Strings.setPrefixWord("SkyBlock");
        config.set("General.API.Version",getDescription().getVersion());
        config.saveConfig();
        config.reloadConfig();
    }

    @Override
    public void onEnable() {
        initListeners();
    }

    @Override
    public void onDisable() {

    }

    private void initListeners() {

        getCommand("BiomeStick").setExecutor(new BiomeStickCommand());

        Zyneon.getAPI().initListenerClass(pluginManager,new PlayerInteract(),this);
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
