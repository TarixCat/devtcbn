package me.devtarix.devtcbnplugin.Commands.PositionGroup;

import me.devtarix.devtcbnplugin.Storage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PositionBroadcast implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("devtcbn.broadcastposition")) {
                double blockX = player.getPlayer().getLocation().getBlockX();
                double blockY = player.getPlayer().getLocation().getBlockY();
                double blockZ = player.getPlayer().getLocation().getBlockZ();

                player.sendMessage(ChatColor.GREEN + "Printing Location...");
                Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Player: " + ChatColor.WHITE + player.getName() + ChatColor.GREEN + " Location X=" + blockX + " Y=" + blockY + " Z=" + blockZ);
            }
            else {
                player.sendMessage(Storage.errColor + Storage.noPerms);
            }
        }
        else {
            sender.sendMessage(Storage.errColor + Storage.notPlayer);
        }
        return true;
    }
}
