package com.zyneonstudios.skyblock.commands;

import com.zyneonstudios.skyblock.items.biomestick.BiomeStick;
import org.bukkit.block.Biome;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BiomeStickCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender s, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(s instanceof Player p) {
            p.getInventory().addItem(new BiomeStick(Biome.PLAINS).getItem());
        }
        return false;
    }
}