package me.tcbndevelopment;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class DevTCBN extends JavaPlugin {
	
    public static void sendMessage(Player p, String msg) {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
    }
    public static void broadcastMessage(String msg) {
        for (Player players : Bukkit.getOnlinePlayers()) {
            players.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
        }
    }
    public static void log(Level level, String msg) {
        System.out.println(msg);
    }
    
	public Permission playerPermission = new Permission("devtcbn.staff");
	public Permission playerPermission1 = new Permission("devtcbn.gamemode");
	public Permission playerPermission2 = new Permission("devtcbn.admin.force");
	
	@Override
	public void onEnable() {
		System.out.println("[DevTCBN] Are You Ready To Take Over The World?");
		System.out.println("[Server] I Am Ready To Dominate!");
		System.out.println("[TarixCat] I Am The Creator Of DevTCBN");
		PluginManager pm = getServer().getPluginManager();
		pm.getPermission("");
		pm.getPermission("playerPermission");
		pm.getPermission("playerPermission");
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("test") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			player.sendMessage(ChatColor.GOLD + "Hello, " + player.getDisplayName() + "! This Is A Test!");
			
			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("status") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			player.sendMessage(ChatColor.GOLD + "COMMAND IN PROGRESS");
			
			
			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("ops") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			player.sendMessage(ChatColor.GOLD + "OPs: " + Bukkit.getOperators());
			
			
			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("whitelisted") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			player.sendMessage(ChatColor.GOLD + "Whitelisted: " + Bukkit.getWhitelistedPlayers());
			
			
			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("srvinfo") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			player.sendMessage(ChatColor.GOLD + "Server Info: ");
			player.sendMessage(ChatColor.GOLD + "End Allowed: " + Bukkit.getAllowEnd());
			player.sendMessage(ChatColor.GOLD + "Nether Allowed: " + Bukkit.getAllowNether());
			player.sendMessage(ChatColor.GOLD + "Flight Allowed: " + Bukkit.getAllowFlight());
			player.sendMessage(ChatColor.GOLD + "Max Players: " + Bukkit.getMaxPlayers());
			player.sendMessage(ChatColor.GOLD + "Default Gamemode: " + Bukkit.getDefaultGameMode());

			
			
			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("wlme") && sender instanceof Player) {
			
			Player player = (Player) sender;
			if(player.hasPermission("devtcbn.staff") && player.hasPermission("devtcbn.admin.force")) {
			    if(args[0].equalsIgnoreCase("true")) {
			        player.setWhitelisted(true);
			        player.sendMessage(ChatColor.GREEN + "You Have Whitelisted Yourself");
			    }
			    if(args[0].equalsIgnoreCase("false")) {
			        player.setWhitelisted(false);
			        player.sendMessage(ChatColor.GREEN + "Unwhitelisted Yourself");
			    }
			    if(args[0].isEmpty()) {
				    player.sendMessage("Please use true or false as arguments");
			    }
			}
			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("setbed") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			//player.setBedSpawnLocation(player.getLocation());
			player.sendMessage(ChatColor.RED + "COMMAND DISABLED FOR ERRORS IN /bed");
			
			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("bed") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			//player.teleport(player.getBedSpawnLocation());
			player.sendMessage(ChatColor.RED + "COMMAND DISABLED FOR ERRORS IN itself");
			
			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("pos") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			player.sendMessage(ChatColor.GREEN + "Printing Location...");
			player.sendMessage(ChatColor.GREEN + "Location X=" + player.getLocation().getX() + " Y=" + player.getLocation().getY() + " Z=" + player.getLocation().getZ());
			
			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("bcfly") && sender instanceof Player) {
			
			Player player = (Player) sender;
			if(player.hasPermission("devtcbn.fly")) {
			    if(args[0].equalsIgnoreCase("true")) {
			        player.setAllowFlight(true);
			        player.setFlying(true);
			        player.sendMessage(ChatColor.GREEN + "Flight Set To True");
			    }
			    if(args[0].equalsIgnoreCase("false")) {
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
		
		if (cmd.getName().equalsIgnoreCase("heal") && sender instanceof Player) {
			
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
		
		if (cmd.getName().equalsIgnoreCase("feed") && sender instanceof Player) {
			
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

		if (cmd.getName().equalsIgnoreCase("gmc") && sender instanceof Player) {
			
			Player player = (Player) sender;
		    
			if(player.hasPermission("devtcbn.gamemode")) {
				player.setGameMode(GameMode.CREATIVE);
				player.sendMessage(ChatColor.GREEN + "Gamemode set to Creative");
			}
		    else {
				player.sendMessage(ChatColor.RED + "You Don't Have Permission To Run This Command");
			}
			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("gms") && sender instanceof Player) {
			
			Player player = (Player) sender;
		    
			if(player.hasPermission("devtcbn.gamemode")) {
				player.setGameMode(GameMode.SURVIVAL);
				player.sendMessage(ChatColor.GREEN + "Gamemode set to Survival");
			}
		    else {
				player.sendMessage(ChatColor.RED + "You Don't Have Permission To Run This Command");
			}
			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("gma") && sender instanceof Player) {
			
			Player player = (Player) sender;
		    
			if(player.hasPermission("devtcbn.gamemode")) {
				player.setGameMode(GameMode.ADVENTURE);
				player.sendMessage(ChatColor.GREEN + "Gamemode set to Adventure");
			}
		    else {
				player.sendMessage(ChatColor.RED + "You Don't Have Permission To Run This Command");
			}
			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("gmsp") && sender instanceof Player) {
			
			Player player = (Player) sender;
		    
			if(player.hasPermission("devtcbn.gamemode")) {
				player.setGameMode(GameMode.SPECTATOR);
				player.sendMessage(ChatColor.GREEN + "Gamemode set to Spectator");
			}
		    else {
				player.sendMessage(ChatColor.RED + "You Don't Have Permission To Run This Command");
			}
			return true;
			
		}
		
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
		
		
		return false;
	}

}
