package com.cursedprison.blocker.Push;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
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

public class PushCommand implements Listener, CommandExecutor {

    static HashMap<Player, Player> playerHash = new HashMap<>();

    @EventHandler
    public void onDamage(EntityDamageEvent e) {

        if (e.getEntity() instanceof Player) {
            if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
                if (playerHash.containsKey((Player) e.getEntity())) {
                    e.setCancelled(true);
                }
            }
        }
    }

    public static void pushPlayer(Player p) {

        World world = p.getWorld();
        Location loc = p.getLocation();

        p.setVelocity(new Vector(0, 25, 0));

        playerHash.put(p, p);

        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {

            playerHash.remove(p);

        }, 30 * 20);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;


        if (args.length == 0) {
            p.sendMessage(Util.color("&CUsage: &7/push (username)"));
            p.sendMessage(Util.color("&CDescription: &7Have you ever wanted to just... push someone away?!"));


            return true;

        }
        if (args.length == 1) {
            if (Bukkit.getPlayer(args[0]) != null) {
                pushPlayer(Bukkit.getPlayer(args[0]));

            }
        }


        return false;
    }
}