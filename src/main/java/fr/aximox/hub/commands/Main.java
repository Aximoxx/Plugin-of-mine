package fr.aximox.hub.commands;

import fr.aximox.hub.World.Arena;
import fr.aximox.hub.listeners.PlayerListeners;
import fr.mrmicky.fastinv.FastInvManager;
import org.bukkit.*;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        FastInvManager.register(this);
        System.out.println("----------------------------");
        System.out.println("Le plugin vien de demarrer !");
        System.out.println("----------------------------");

        /*
        //List des spawns du KitPvP
        World world = Bukkit.getWorld("Arena");
        spawns.add(new Location(Bukkit.getWorld("Arena"), 197.668, 23, -1217.415, 148.5F, -3.9F));
        spawns.add(new Location(Bukkit.getWorld("Arena"), 149.321, 23, -1216.318, 149.2F, 0.1F));
        spawns.add(new Location(Bukkit.getWorld("Arena"), 128.686, 23, -1247.278, -102.6F, 0.2F));
        spawns.add(new Location(Bukkit.getWorld("Arena"), 128.602, 23, -1280.554, -60.8F, -0.0F));
         */

        getCommand("test").setExecutor(new commands());
        getCommand("say").setExecutor(new commands());
        getCommand("hub").setExecutor(new CommandSpawn());
        getCommand("pvp").setExecutor(new Arena());
        getServer().getPluginManager().registerEvents(new PlayerListeners(), this);

        World world = Bukkit.getWorld("world");
        WorldBorder wb = world.getWorldBorder();
        wb.setCenter(0, 0);
        wb.setSize(600);

    }

    @Override
    public void onDisable() {
        System.out.println("----------------------------");
        System.out.println("Le plugin vien de s'eteindre");
        System.out.println("----------------------------");
    }

}
