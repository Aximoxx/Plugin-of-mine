package fr.aximox.hub.commands;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.Listener;

import java.util.Arrays;


public class commands implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player)sender;

            if(cmd.getName().equalsIgnoreCase("test")) {
                player.sendMessage(ChatColor.YELLOW + "Tu est vraiment un monstre !");
                return true;
            }

            if(cmd.getName().equalsIgnoreCase("say")) {

                if(args.length == 0) {
                    player.sendMessage("§cLa commande est : /say <message>");
                }

                if(args.length >= 1) {
                    StringBuilder say = new StringBuilder();
                    for(String part : args) {
                        say.append("§6").append(Arrays.toString(args)).append(" ");
                    }
                    Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "UHC : " + say.toString());
                }
            }


            return false;
        }
        return false;
    }

}