package me.devtarix.devtcbnplugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MiscGroup implements CommandExecutor {

    private String test = "Currently In-Progress, pos, bed, setbed, advanced adminmode, modmode and resetdeaths";

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("test") && sender instanceof Player) {

            Player player = (Player) sender;

            player.sendMessage(ChatColor.GOLD + "Hello, " + player.getDisplayName() + "! This Is A Test!");

            return true;

        }

        if (cmd.getName().equalsIgnoreCase("inp") && sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("devtcbn.futureupdate")) {
                player.sendMessage(ChatColor.DARK_RED + test);
            }
            else {
                return true;
            }
            return true;

        }

        if (cmd.getName().equalsIgnoreCase("update") && sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("devtcbn.update") || player.getName().equals("TarixCat") || player.isOp()) {
                player.getServer().broadcastMessage(ChatColor.RED + "Warning: " + ChatColor.YELLOW + "Reloading Plugins Expect Lag...");
                player.getServer().reload();
                player.getServer().broadcastMessage(ChatColor.RED + "Reloaded plugins...");
            }

            return true;

        }

        else {
            sender.sendMessage(ChatColor.GOLD + "L, you don't know how to use this...");
        }

        return true;
    }

}
