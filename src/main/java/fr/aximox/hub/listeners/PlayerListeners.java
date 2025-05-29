package fr.aximox.hub.listeners;

import fr.aximox.hub.guis.NavigationGUI;
import fr.mrmicky.fastinv.ItemBuilder;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.Bukkit.getWorld;


public class PlayerListeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Location lobby = new Location(getWorld("world"), 0.500, 64, 0.500, 179.6F, -6.5F);
        Player player = event.getPlayer();

        player.sendMessage("§aBienvenue §e" + player.getName() + "§a sur le magnifique serveur de Aximox !");
        player.teleport(lobby);
        player.getPlayer().setGameMode(GameMode.ADVENTURE);

            ItemStack navigation = new ItemBuilder(Material.NETHER_STAR).name("§bNavigation").build();
            player.getInventory().clear();
            player.getInventory().setBoots(null);
            player.getInventory().setLeggings(null);
            player.getInventory().setChestplate(null);
            player.getInventory().setHelmet(null);
            player.getInventory().setItem(4, navigation);

    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if (item == null) return;
        if (item.getItemMeta() == null) return;
        if (item.getItemMeta().getDisplayName() == null) return;

        if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§bNavigation")) {
            new NavigationGUI(player).open(player);
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        ItemStack item = event.getItemDrop().getItemStack();
        if (item == null) return;
        if (item.getItemMeta() == null) return;
        if (item.getItemMeta().getDisplayName() == null) return;

        if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§bNavigation")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryMoveItem(InventoryMoveItemEvent event) {
        ItemStack item = event.getItem();
        if (item == null) return;
        if (item.getItemMeta() == null) return;
        if (item.getItemMeta().getDisplayName() == null) return;

        if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§bNavigation")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryCLick(InventoryClickEvent event) {
        ItemStack item = event.getCurrentItem();

        if (item == null) return;
        if (item.getItemMeta() == null) return;
        if (item.getItemMeta().getDisplayName() == null) return;

        if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§bNavigation")) {
            event.setCancelled(true);
        }
    }
}