package com.cursedprison.blocker.Events;


import com.cursedprison.blocker.Main;
import com.cursedprison.blocker.Utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.util.Vector;

import java.util.HashMap;

public class LaunchEffect implements Listener, CommandExecutor {

    static HashMap<Player, Player> playerHash = new HashMap<>();

    @EventHandler
    public void onDamage(EntityDamageEvent e) {

        if (e.getCause() == EntityDamageEvent.DamageCause.LIGHTNING) {
            e.setCancelled(true);
        }

        if (e.getEntity() instanceof Player) {
            if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
                if (playerHash.containsKey((Player) e.getEntity())) {
                    e.setCancelled(true);
                }
            }

        }
    }

    public static void launchPlayer(Player p) {

        World world = p.getWorld();
        Location loc = p.getLocation();

        world.strikeLightning(loc);

        //
        p.sendMessage(Util.color(Main.getInstance().getConfig().getString("Messages.launchMessage")));
        //

        p.setVelocity(new Vector(0, 25, 0));

        playerHash.put(p, p);

        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {

            playerHash.remove(p);

        }, 20 * 10);


    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        // /launch chriisto hi

        //check if args.length is 0
        //sender player msg saying error or something
        //beneath send message return true;

        if (args.length == 0) {
            p.sendMessage(Util.color("&CUsage: &7/launch (username)"));
            p.sendMessage(Util.color("&CDescription: &7Launch your selected victim into the sky!"));


            //stops code from running further
            return true;

        }
            if (args.length == 1) {
                if (Bukkit.getPlayer(args[0]) != null) {
                    launchPlayer(Bukkit.getPlayer(args[0]));

                }
            }


            return false;
        }
    }


