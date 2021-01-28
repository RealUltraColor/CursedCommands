package com.cursedprison.blocker.Restart;

import com.cursedprison.blocker.Main;
import com.cursedprison.blocker.Utils.Util;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class RestartCommand implements Listener {


    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {

        if (e.getMessage().equalsIgnoreCase("/restart") || e.getMessage().equalsIgnoreCase("/restart")) {
            e.setCancelled(true);
            try {
                runRestart(e.getPlayer());
            }catch(ClassCastException exception) {

            }
        }

    }





    public void runRestart(Player p) {

        BukkitRunnable r = (BukkitRunnable) new BukkitRunnable() {

            int i = 61;

            @Override
            public void run() {

                if (i == 60) {
                    p.sendMessage(Util.color("&c&lWARNING &8» &fThis server is &crestarting &fin &c60 seconds&f!"));
                    //send message
                }
                if (i == 45) {
                    p.sendMessage(Util.color("&c&lWARNING &8» &fThis server is &crestarting &fin &c45 seconds&f!"));
                    //send message
                }
                if (i == 30) {
                    p.sendMessage(Util.color("&c&lWARNING &8» &fThis server is &crestarting&f in &c30 seconds&f!"));
                }
                if (i == 15) {
                    p.sendMessage(Util.color("&c&lWARNING &8» &fThis server is now &crestarting&f!"));

                }
                if (i == 5) {
                    p.sendMessage(Util.color("&c&lWARNING &8» &fThis server is now &crestarting&f!"));

                }
                if (i == 0) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "restart");
                    //restart
                }
                //every second i goes down by one
                i--;


            }
        }.runTaskTimer(Main.getInstance(), 0, 20);
    }
}












