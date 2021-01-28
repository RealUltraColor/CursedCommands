package com.cursedprison.blocker.ClearChat;


import com.cursedprison.blocker.Utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ClearChat implements CommandExecutor, Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {

        Player p = e.getPlayer();


                        Location loc = p.getLocation();
                        World w = p.getWorld();

                      //  p.sendMessage(Util.color("&E&LChat &8» &fYou have &ccleared &fthe chat!"));

                    }





    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        Player p = (Player) sender;

        // ! = not

        if(!p.hasPermission("clearchat.use")) {
            //send no perm message
            return true;
        }


        loop(500);




        // /launch chriisto hi

        //check if args.length is 0
        //sender player msg saying error or something
        //beneath send message return true;

        if(p.isOp())  {
            p.sendMessage(Util.color("&D&lChat &8» &fYou have &ccleared &fthe chat for all users! "));

            //stops code from running further
            return true;

        }
        return false;
    }




    public void loop(int range) {

        //range = 500

        for(Player p : Bukkit.getOnlinePlayers()) {
            if(p.hasPermission("clearchat.bypass")) {
                return;
            } else {
                for(int i = 0; i <= range; i++) {
                    p.sendMessage(" ");
                }
                p.sendMessage(Util.color("&c&lWARNING &8» &fYour chat has been &ccleared &fby a moderator!"));
            }
        }




    }


}
