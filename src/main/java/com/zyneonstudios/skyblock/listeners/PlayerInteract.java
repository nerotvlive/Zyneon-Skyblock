package com.zyneonstudios.skyblock.listeners;

import com.zyneonstudios.skyblock.items.biomestick.BiomeStick;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerInteract implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(p.getInventory().getItemInMainHand().getItemMeta()!=null) {
            if(p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData()==69) {
                e.setCancelled(true);
                ItemStack item = p.getInventory().getItemInMainHand();
                ItemMeta itemMeta = item.getItemMeta();
                if(itemMeta.getDisplayName().contains("BiomeStick")) {
                    String biomeName = itemMeta.getDisplayName().replace("§bBiomeStick §8(§a","").replace("§8)","");
                    BiomeStick biomeStick = new BiomeStick(Biome.valueOf(biomeName));
                    if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                        //CHUNK BIOME SWITCH
                    } else if(e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                        biomeStick.switchBiome();
                        p.getInventory().setItemInMainHand(null);
                        p.getInventory().setItemInMainHand(biomeStick.getItem());
                    }
                }
            }
        }
    }
}
