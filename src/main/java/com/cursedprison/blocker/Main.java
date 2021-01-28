package com.cursedprison.blocker;

import com.cursedprison.blocker.Events.BlockPluginEvent;
import com.cursedprison.blocker.Events.ExplodeUser;
import com.cursedprison.blocker.Events.LaunchEffect;
import com.cursedprison.blocker.Freeze.Commands.FreezeCommand;
import com.cursedprison.blocker.Freeze.Commands.UnFreezeCommand;
import com.cursedprison.blocker.Freeze.Events.MoveEvent;
import com.cursedprison.blocker.ClearChat.ClearChat;
import com.cursedprison.blocker.Push.PushCommand;
import com.cursedprison.blocker.Restart.RestartCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Main extends JavaPlugin {


    public static Main instance;

    @Override
    public void onEnable() {

        instance = this;

        File file = new File(getDataFolder(), "config.yml");
        if (!file.exists())
            saveDefaultConfig();


        getServer().getPluginManager().registerEvents(new BlockPluginEvent(), this);
        getServer().getPluginManager().registerEvents(new LaunchEffect(), this);
        getServer().getPluginManager().registerEvents(new MoveEvent(), this);
        getServer().getPluginManager().registerEvents(new ClearChat(), this);
        getServer().getPluginManager().registerEvents(new ExplodeUser(), this);
        getServer().getPluginManager().registerEvents(new ClearChat(), this);
        getServer().getPluginManager().registerEvents(new PushCommand(), this);
        getServer().getPluginManager().registerEvents(new RestartCommand(), this);

        getCommand("launch").setExecutor(new LaunchEffect());
        getCommand("freeze").setExecutor(new FreezeCommand());
        getCommand("unfreeze").setExecutor(new UnFreezeCommand());
        getCommand("clearchat").setExecutor(new ClearChat());
        getCommand("explode").setExecutor(new ExplodeUser());
        getCommand("push").setExecutor(new PushCommand());

        for(int i = 0; i < 1000; i++) {
            Bukkit.broadcastMessage(" ");
        }


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance() {
        return instance;
    }
}
