package me.tcbndevelopment.cmdgroups;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PosGroup implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("pos") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			player.sendMessage(ChatColor.GREEN + "Printing Location...");
			player.sendMessage(ChatColor.GREEN + "Location X=" + player.getLocation().getBlockX() + " Y=" + player.getLocation().getBlockY() + " Z=" + player.getLocation().getBlockZ());

			
			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("otherpos") && sender instanceof Player) {
			
			Player player = (Player) sender;
			Player target = Bukkit.getPlayer(args[0]);
			
			player.sendMessage(ChatColor.GREEN + "Printing Target Location...");
			player.sendMessage(ChatColor.GREEN + "Location X=" + target.getLocation().getBlockX() + " Y=" + target.getLocation().getBlockY() + " Z=" + target.getLocation().getBlockZ());
			
			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("tellpos") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			player.sendMessage(ChatColor.GREEN + "Printing Location...");
			Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Player: " + ChatColor.WHITE + player.getName() + ChatColor.GREEN + "Location X=" + player.getLocation().getBlockX() + " Y=" + player.getLocation().getBlockY() + " Z=" + player.getLocation().getBlockZ());
			
			return true;
			
		}
	
		return true;
	}
	
}
