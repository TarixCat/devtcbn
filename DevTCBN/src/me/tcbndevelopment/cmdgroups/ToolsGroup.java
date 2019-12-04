package me.tcbndevelopment.cmdgroups;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ToolsGroup implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("chelp") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			player.sendMessage(ChatColor.GOLD + "-------Help-------");
			player.sendMessage(ChatColor.GOLD + "inp: Debug testing");
			player.sendMessage(ChatColor.GOLD + "test: Debug testing");
			player.sendMessage(ChatColor.GOLD + "pos: Prints position");
			if(player.hasPermission("devtcbn.staff") || player.hasPermission("devtcbn.gamemode")) {
				player.sendMessage(ChatColor.GOLD + "gma: Gamemode Adventure");
				player.sendMessage(ChatColor.GOLD + "gms: Gamemode Survival");
				player.sendMessage(ChatColor.GOLD + "gmsp: Gamemode Spectator");
				player.sendMessage(ChatColor.GOLD + "gmc: Gamemode Creative");
			}
			if(player.hasPermission("devtcbn.staff") || player.hasPermission("devtcbn.fly")) {
				player.sendMessage(ChatColor.GOLD + "fly: Flight Powers on or off?");
			}
			if(player.hasPermission("devtcbn.staff") || player.hasPermission("devtcbn.heal")) {
				player.sendMessage(ChatColor.GOLD + "heal: Heals you");
			}
			if(player.hasPermission("devtcbn.staff") || player.hasPermission("devtcbn.feed")) {
				player.sendMessage(ChatColor.GOLD + "feed: Feeds you");
			}
			if(player.hasPermission("devtcbn.staff") || player.hasPermission("devtcbn.pos")) {
				player.sendMessage(ChatColor.GOLD + "pos: Position");
			}
			if(player.hasPermission("devtcbn.staff") || player.hasPermission("devtcbn.adminmode")) {
				player.sendMessage(ChatColor.GOLD + "adminmode: Adminmode");
			}
			if(player.hasPermission("devtcbn.staff") || player.hasPermission("devtcbn.modmode")) {
				player.sendMessage(ChatColor.GOLD + "modmode: Modmode");
			}
			else {
			    player.getDisplayName();
			}
			player.sendMessage(ChatColor.GOLD + "------------------");
			
			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("cwb") && sender instanceof Player) {
			
			Player player = (Player) sender;
			if (player.hasPermission("devtcbn.workbench")) {
				player.openWorkbench(null, true);	
			}
			else {
				player.sendMessage(ChatColor.RED + "No permission to run command.");
			}
			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("cfly") && sender instanceof Player) {
			
			Player player = (Player) sender;
			if(player.hasPermission("devtcbn.staff")) {
			    if(args[0].equalsIgnoreCase("true") || args[0].equalsIgnoreCase("on")) {
			        player.setAllowFlight(true);
			        player.setFlying(true);
			        player.sendMessage(ChatColor.GREEN + "Flight Set To True");
			    }
			    if(args[0].equalsIgnoreCase("false") || args[0].equalsIgnoreCase("off")) {
			        player.setAllowFlight(false);
			        player.setFlying(false);
			        player.setNoDamageTicks(100);
			        player.sendMessage(ChatColor.GREEN + "Flight Set To False");
			    }
			    if(args[0].isEmpty()) {
				    player.sendMessage("Please use true or false as arguments");
			    }
			}
			else {
				player.sendMessage(ChatColor.RED + "You Don't Have Permission To Run This Command");
			}
			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("cheal") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if(player.hasPermission("devtcbn.heal")) {
				player.setHealth(20);
				player.setFireTicks(0);
				player.sendMessage(ChatColor.GREEN + "You Have Been Healed");
			}
			else {
				player.sendMessage(ChatColor.RED + "You Don't Have Permission To Run This Command");
			}
			
			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("cfeed") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if(player.hasPermission("devtcbn.feed")) {
				player.setFoodLevel(20);
				player.setSaturation(20);
				player.sendMessage(ChatColor.GREEN + "You Have Been Fed");
			}
			else {
				player.sendMessage(ChatColor.RED + "You Don't Have Permission To Run This Command");
			}
			
			return true;
			
		}
		
		return true;
	}
	
}
