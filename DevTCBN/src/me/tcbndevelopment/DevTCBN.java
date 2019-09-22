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
    public Permission playerPermission2 = new Permission("devtcbn.feed");
    public Permission playerPermission3 = new Permission("devtcbn.heal");
    public Permission playerPermission4 = new Permission("devtcbn.fly");
	
	@Override
	public void onEnable() {
		System.out.println("[BCPlugin] Are You Ready To Take Over The World?");
		System.out.println("[Server] I Am Ready To Dominate!");
		System.out.println("[TarixCat] I Am The Creator Of BCPlugin");
		System.out.println(Bukkit.getServer().getName() + " Online...");
		System.out.println(Bukkit.getOperators() + " Are Opped.");
		PluginManager pm = getServer().getPluginManager();
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
		
		if (cmd.getName().equalsIgnoreCase("inp") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			player.sendMessage(ChatColor.GOLD + "" + Bukkit.broadcastMessage("COMMAND IN PROGRESS"));
			
			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("adminmode") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if (player.hasPermission("devtcbn.staff")) {
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
				else {
					player.sendMessage(ChatColor.RED + "Please Use Args True/On or False/Off");
				}
			}
			else {
				player.sendMessage(ChatColor.RED + "You Don't Have Permission To Run This Command");
			}
			return true;
			
		}
		
		/*if (cmd.getName().equalsIgnoreCase("resetdeaths")) {
			
			Player player = (Player) sender;
			Player target = Bukkit.getPlayer(args[0]);
			Scoreboard Deaths = Bukkit.getServer().getScoreboardManager().getMainScoreboard();
			
			if (target == null) {
				player.sendMessage(ChatColor.RED + "Error: Player " + ChatColor.AQUA + args[0] + ChatColor.RED + " is not online.");
				return true;
			}
			target.setExp(0);
			target.getScoreboard();
			target.sendMessage(ChatColor.AQUA + "Your Deaths Have Been Reset To 0 By: " + ChatColor.YELLOW + player + ChatColor.AQUA + "!");
			player.sendMessage(ChatColor.YELLOW + target.getName() + "'s" + ChatColor.AQUA + "Deaths Have Been Reset.");
			
			return true;
			
		}*/
		
		/*if (cmd.getName().equalsIgnoreCase("cbc") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			player.sendMessage(ChatColor.GOLD + "" + Bukkit.broadcastMessage("COMMAND IN PROGRESS"));
			if(player.hasPermission("devtcbn.staff")) {
				Bukkit.broadcastMessage(ChatColor.GOLD + "[Warining] " + ChatColor.RED + args[*]);
			}
			else {
				player.sendMessage(ChatColor.RED + "You Don't Have Permission To Run This Command");
			}
			
			return true;
			
		}*/
		
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
			else {
			    player.getDisplayName();
			}
			player.sendMessage(ChatColor.GOLD + "------------------");
			
			return true;
			
		}
		
		/*if (cmd.getName().equalsIgnoreCase("setbed") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			//player.setBedSpawnLocation(player.getLocation());
			player.sendMessage(ChatColor.RED + "DISABLED");
			
			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("bed") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			//player.teleport(player.getBedSpawnLocation());
			player.sendMessage(ChatColor.RED + "DISABLED");
			
			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("pos") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			player.sendMessage(ChatColor.GREEN + "Printing Location...");
			player.sendMessage(ChatColor.GREEN + "Location X=" + player.getLocation().getX() + " Y=" + player.getLocation().getY() + " Z=" + player.getLocation().getZ());
			
			return true;
			
		}*/
		
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
			    else {
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
