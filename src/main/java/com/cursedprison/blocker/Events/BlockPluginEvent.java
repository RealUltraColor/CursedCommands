package com.cursedprison.blocker.Events;


import com.cursedprison.blocker.Main;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class BlockPluginEvent implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {

        if(e.getMessage().equalsIgnoreCase("/pl") || e.getMessage().equalsIgnoreCase("/plugins")) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(color(Main.getInstance().getConfig().getString("Messages.pluginMessage")));
        }

    }

    public String color(String s) {

        return ChatColor.translateAlternateColorCodes('&', s);

    }

}
