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

//here
public class ExplodeUser implements Listener, CommandExecutor {


    //1. make method

    public void explodePlayer(Player p) {

        //get player location
        //get player world

        //use (what you named world variable) so for example:
        //World w = p.getWorld();
        //create the explosion with w.createExplosion()
        // :)
        Location loc = p.getLocation();
        World w = p.getWorld();

        w.createExplosion(loc, 1);
    }

    //class needs to implement listener
    //this method needs a @EventHandler tag
    @EventHandler
    public void onDamage(EntityDamageEvent e) {

        if (e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
            e.setCancelled(true);
        }


        //look in launch class for example of cancelling damage.
        //replica of launch pretty much
        //register command in main (this class will have to implement CommandExectuor)

        //register command in yml

    }

    //implement listener and CommandExectuor at top of class

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if (args.length == 0) {
            p.sendMessage(Util.color("&CUsage: &7/explode (username)"));
            p.sendMessage(Util.color("&CDescription: &7Execute a virtual explosion!"));


            //stops code from running further
            return true;

        }
        if (args.length == 1) {
            if (Bukkit.getPlayer(args[0]) != null) {
                explodePlayer(Bukkit.getPlayer(args[0]));

            }
        }
        return false;
    }
}

