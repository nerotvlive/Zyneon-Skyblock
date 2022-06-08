package com.zyneonstudios.skyblock.listeners;

import com.zyneonstudios.skyblock.SkyBlock;
import com.zyneonstudios.skyblock.utils.island.IslandPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        IslandPlayer iP = SkyBlock.getIslandPlayer(p.getUniqueId());
    }
}