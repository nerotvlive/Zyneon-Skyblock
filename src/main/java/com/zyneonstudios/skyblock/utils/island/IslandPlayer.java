package com.zyneonstudios.skyblock.utils.island;

import com.zyneonstudios.api.Zyneon;
import com.zyneonstudios.api.utils.user.User;
import java.util.UUID;

public class IslandPlayer {

    private User user;
    private UUID uuid;

    public IslandPlayer(User user) {
        this.user = user;
        this.uuid = user.getUUID();
    }

    public IslandPlayer(UUID uuid) {
        this.uuid = uuid;
        this.user = Zyneon.getAPI().getOnlineUser(uuid);
    }

    public User getUser() {
        return user;
    }

    public UUID getUUID() {
        return uuid;
    }

    public void destroy() {
        this.user = null;
        this.uuid = null;
    }
}