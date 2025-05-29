package fr.aximox.hub.guis;

import fr.aximox.hub.utils.HeadList;
import fr.mrmicky.fastinv.FastInv;
import fr.mrmicky.fastinv.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.swing.*;
import java.net.ProtocolFamily;

public class NavigationGUI extends FastInv implements Listener {

    public NavigationGUI(Player player) {
        super(54, "§e- §8Navigation");


        setItems(getCorners(), new ItemBuilder(Material.STAINED_GLASS_PANE).name(" ").build());

        setItem(49, new ItemBuilder(Material.DIAMOND_SWORD).name("§bArène").build());

        setItem(50, new ItemBuilder(Material.DARK_OAK_DOOR_ITEM).name("§cFermer").build());

        setItem(11, new ItemBuilder(HeadList.LOUP_GAROU.getItemStack()).name("§4Loup-Garou UHC").build());

        setItem(12, new ItemBuilder(HeadList.DEMON_SLAYER.getItemStack()).name("§cDemon Slayer UHC").build());

        setItem(13, new ItemBuilder(HeadList.AOT.getItemStack()).name("§6Attaque des Titans UHC").build());

        setItem(14, new ItemBuilder(HeadList.TAUPE_GUN.getItemStack()).name("§9Taupe Gun UHC").build());

        setItem(15, new ItemBuilder(HeadList.DEATHNOTE.getItemStack()).name("§7Death Note UHC").build());

        setItem(3,new ItemBuilder(HeadList.YOUTUBE.getItemStack()).name("§cYoutube").build());

        setItem(4,new ItemBuilder(HeadList.TWITCH.getItemStack()).name("§5Twitch").build());

        setItem(5,new ItemBuilder(HeadList.X.getItemStack()).name("§0X").build());
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Inventory inv = event.getInventory();
        Player player = (Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();

        Location lguhc = new Location(Bukkit.getWorld("lobbylg"), 13.500D, 83.0D, -28.444D, -32.5F, -0.4F);
        Location lobby = new Location(Bukkit.getWorld("world"), 0.500, 64, 0.500, 179.6F, -6.5F);
        Location random = new Location(Bukkit.getWorld("lobbyrandom"), 0.500, 65, -9.500, 0.2f, -0.9F);
        Location LobbyPvP = new Location(Bukkit.getWorld("Arena"), 215.167, 23, -1256.541, 90.2F, -2.0F);

        if (current == null) return;

        if (inv.getName().equalsIgnoreCase("§e- §8Navigation")) {

            event.setCancelled(true);
            player.updateInventory();

            if (current.getType() == Material.DARK_OAK_DOOR_ITEM && current.hasItemMeta()
                    && current.getItemMeta().hasDisplayName()
                    && current.getItemMeta().getDisplayName().equalsIgnoreCase("§cFermer")) {
                player.playSound(player.getLocation(), Sound.BAT_TAKEOFF, 0.5f, 1f);
                player.closeInventory();
            }

            if (current.getType() == Material.DIAMOND_SWORD && current.hasItemMeta()
                    && current.getItemMeta().hasDisplayName()
                    && current.getItemMeta().getDisplayName().equalsIgnoreCase("§bArène")) {

                player.teleport(LobbyPvP);
                player.closeInventory();
            }

            if (current.getType() == Material.SKULL_ITEM && current.hasItemMeta()
                    && current.getItemMeta().hasDisplayName()
                    && current.getItemMeta().getDisplayName().equalsIgnoreCase("§4Loup-Garou UHC")) {

                player.teleport(lguhc);
                player.closeInventory();
            }

            if (current.getType() == Material.SKULL_ITEM && current.hasItemMeta()
                    && current.getItemMeta().hasDisplayName()
                    && current.getItemMeta().getDisplayName().equalsIgnoreCase("§cDemon Slayer UHC")) {

                player.teleport(lguhc);
                player.closeInventory();
            }

            if (current.getType() == Material.SKULL_ITEM && current.hasItemMeta()
                    && current.getItemMeta().hasDisplayName()
                    && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6Attaque des Titans UHC")) {

                player.teleport(lguhc);
                player.closeInventory();
            }

            if (current.getType() == Material.SKULL_ITEM && current.hasItemMeta()
                    && current.getItemMeta().hasDisplayName()
                    && current.getItemMeta().getDisplayName().equalsIgnoreCase("§9Taupe Gun UHC")) {

                player.teleport(random);
                player.closeInventory();
            }

            if (current.getType() == Material.SKULL_ITEM && current.hasItemMeta()
                    && current.getItemMeta().hasDisplayName()
                    && current.getItemMeta().getDisplayName().equalsIgnoreCase("§7Death Note UHC")) {

                player.teleport(random);
                player.closeInventory();

            }
        }
    }
}