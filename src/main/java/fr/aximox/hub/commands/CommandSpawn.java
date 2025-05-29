package fr.aximox.hub.commands;

import fr.mrmicky.fastinv.ItemBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;

public class CommandSpawn implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){

            if(cmd.getName().equalsIgnoreCase("hub")) {

                ItemStack navigation = new ItemBuilder(Material.NETHER_STAR).name("§bNavigation").build();
                Player player = (Player) sender;
                Location hub = new Location (Bukkit.getWorld("world"), 0.500, 64, 0.500, 179.6F, -6.5F);

                player.getInventory().clear();
                player.setHealth(20);
                player.setFoodLevel(20);
                player.getInventory().setBoots(null);
                player.getInventory().setLeggings(null);
                player.getInventory().setChestplate(null);
                player.getInventory().setHelmet(null);
                player.getInventory().setItem(4, navigation);
                player.teleport(hub);
            }
        }
        return false;
    }

    @EventHandler
    public void onPortal(PlayerPortalEvent event) {
        if (event.getCause() == PlayerTeleportEvent.TeleportCause.NETHER_PORTAL) {
            World w = Bukkit.getWorld("Arena");
            double x = 215.167;
            double y = 23;
            double z = -1256.541;
            Location loc = new Location(w, x, y, z);
            event.setTo(loc);
        }
    }
}
