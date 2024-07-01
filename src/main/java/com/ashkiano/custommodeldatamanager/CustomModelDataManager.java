package com.ashkiano.custommodeldatamanager;

import org.bukkit.plugin.java.JavaPlugin;

public class CustomModelDataManager extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register the command
        this.getCommand("setcustommodeldata").setExecutor(new SetCustomModelDataCommand());
        Metrics metrics = new Metrics(this, 22247);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}