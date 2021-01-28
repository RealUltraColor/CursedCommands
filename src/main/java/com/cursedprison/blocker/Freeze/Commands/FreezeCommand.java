package com.cursedprison.blocker.Freeze.Commands;


import com.cursedprison.blocker.Freeze.Freeze;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class FreezeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if(args.length == 1) {
            Player p = Bukkit.getPlayer(args[0]);
            if(p != null) {
                Freeze.freezePlayer(p);
            }
        }
        return false;
    }

    //lol

}
