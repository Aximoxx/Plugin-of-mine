package fr.aximox.hub.World;

import fr.aximox.hub.commands.CommandSpawn;
import fr.aximox.hub.listeners.PlayerListeners;
import fr.mrmicky.fastinv.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import static org.bukkit.Bukkit.getPluginCommand;

public class Arena implements CommandExecutor, Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Block block = event.getBlockPlaced();

        new BukkitRunnable() {
            @Override
            public void run() {
                if (block.getType() != Material.AIR) {
                    block.setType(Material.AIR);
                }
            }
        }.runTaskLater((Plugin) this, 100L);
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if ((event.getEntity() instanceof Player)) {
            event.getDrops().clear();
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        Location lobby = new Location(Bukkit.getWorld("world"), 0.5, 64, 0.5, 179.6F, -6.5F);
        ItemStack navigation = new ItemBuilder(Material.NETHER_STAR).name("§bNavigation").build();

        event.setRespawnLocation(lobby);
        player.getInventory().setItem(4, navigation);
    }

    @EventHandler
    public void onInventoryMoveItem(InventoryMoveItemEvent event) {
        event.setCancelled(false);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        getPluginCommand("pvp").setExecutor(new Arena());

        if (sender instanceof Player) {
            Player player = (Player) sender;

            Location arena = new Location(Bukkit.getWorld("Arena"), 215.167, 23, -1256.541, 90.2F, -2.0F);

            player.sendMessage("Tu à été téléporter à l'Arena");
            player.teleport(arena);
            player.setGameMode(GameMode.SURVIVAL);
            player.setHealth(20);
            player.setFoodLevel(20);
            player.getInventory().clear();


            player.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
            player.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
            player.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
            player.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));

            player.getInventory().setItem(0, new ItemStack(Material.DIAMOND_SWORD));
            player.getInventory().setItem(1, new ItemStack(Material.GOLDEN_APPLE, 2));
            player.getInventory().setItem(2, new ItemStack(Material.BOW));
            player.getInventory().setItem(9, new ItemStack(Material.ARROW, 12));
            player.getInventory().setItem(3, new ItemStack(Material.COOKED_BEEF, 64));
            player.getInventory().addItem(new ItemStack(Material.LEAVES, 383));
        }
        return false;
    }
}