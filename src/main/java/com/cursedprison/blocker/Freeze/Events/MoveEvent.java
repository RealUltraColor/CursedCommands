package com.cursedprison.blocker.Freeze.Events;


import com.cursedprison.blocker.Freeze.Freeze;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveEvent implements Listener {


    @EventHandler
    public void onMove(PlayerMoveEvent e) {

        if (Freeze.freezeHash.containsKey(e.getPlayer())) {
            e.setCancelled(true);
        }
    }

}
