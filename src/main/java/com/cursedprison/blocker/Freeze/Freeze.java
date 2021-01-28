package com.cursedprison.blocker.Freeze;


import com.cursedprison.blocker.Main;
import com.cursedprison.blocker.Utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

public class Freeze {

    public static HashMap<Player, Player> freezeHash = new HashMap<>();


    public static void freezePlayer(Player p) {

        freezeHash.put(p, p);


        new BukkitRunnable() {

            @Override
            public void run() {
                if(freezeHash.containsKey(p)) {
                    p.sendMessage(Util.color("&5&lCP &8» &7You have been frozen! Join our discord at &5&odiscord.cursedprison.com!"));
                } else {
                    this.cancel();
                }
            }
        }.runTaskTimer(Main.getInstance(), 0, 20 * 5);

    }
    public static void unFreeze(Player p) {

        freezeHash.remove(p, p);

        p.sendMessage(Util.color("&5&lCP &8» &7You have been unfrozen!"));

    }

}
