package me.devtarix.devtcbnplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PosGroup implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(cmd.getName().equalsIgnoreCase("pos") && sender instanceof Player) {

            Player player = (Player) sender;

            double blockX = player.getPlayer().getLocation().getBlockX();
            double blockY = player.getPlayer().getLocation().getBlockY();
            double blockZ = player.getPlayer().getLocation().getBlockZ();

            player.sendMessage(ChatColor.GREEN + "Printing Location...");
            player.sendMessage(ChatColor.GREEN + "Location X=" + blockX + " Y=" + blockY + " Z=" + blockZ + " DIM=" + player.getLocation().getWorld());
        }

        else if(cmd.getName().equalsIgnoreCase("otherpos") && sender instanceof Player) {

            Player player = (Player) sender;

            Player target = Bukkit.getPlayer(args[0]);

            double TblockX = target.getPlayer().getLocation().getBlockX();
            double TblockY = target.getPlayer().getLocation().getBlockY();
            double TblockZ = target.getPlayer().getLocation().getBlockZ();

            player.sendMessage(ChatColor.GREEN + "Printing Target Location...");
            player.sendMessage(ChatColor.GREEN + "Location X=" + TblockX + " Y=" + TblockY + " Z=" + TblockZ + " DIM=" + target.getLocation().getWorld());
        }

        else if(cmd.getName().equalsIgnoreCase("tellpos") && sender instanceof Player) {

            Player player = (Player) sender;

            double blockX = player.getPlayer().getLocation().getBlockX();
            double blockY = player.getPlayer().getLocation().getBlockY();
            double blockZ = player.getPlayer().getLocation().getBlockZ();

            player.sendMessage(ChatColor.GREEN + "Printing Location...");
            Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Player: " + ChatColor.WHITE + player.getName() + ChatColor.GREEN + " Location X=" + blockX + " Y=" + blockY + " Z=" + blockZ + " DIM=" + player.getLocation().getWorld());
        }

        else {
        }
        return true;
    }

}
