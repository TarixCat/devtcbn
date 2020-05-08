package me.devtarix.devtcbnplugin.Commands.MiscGroup;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PluginUpdate implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if (player.hasPermission("devtcbn.update") || player.getName().equals("TarixCat") || player.isOp()) {
                player.getServer().broadcastMessage(ChatColor.RED + "Warning: " + ChatColor.YELLOW + "Reloading Data Expect Lag...");
                player.getServer().reloadData();
                player.getServer().broadcastMessage(ChatColor.RED + "Reloaded Data...");
            }
        }
        return true;
    }
}
