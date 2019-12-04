package me.tcbndevelopment;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.tcbndevelopment.cmdgroups.GamemodeGroup;
import me.tcbndevelopment.cmdgroups.PosGroup;
import me.tcbndevelopment.cmdgroups.StaffToolGroup;
import me.tcbndevelopment.cmdgroups.ToolsGroup;


public class DevTCBN extends JavaPlugin {
	
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
	
	GamemodeGroup gmgr = new GamemodeGroup();
	PosGroup psgr = new PosGroup();
	ToolsGroup togr = new ToolsGroup();
	StaffToolGroup stgr = new StaffToolGroup();
    
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new DevTCBNListener(), this);
		System.out.println("[BCPlugin] Are You Ready To Take Over The World?");
		System.out.println("[Server] I Am Ready To Dominate!");
		System.out.println("[TarixCat] I Am The Creator Of BCPlugin");
		System.out.println(Bukkit.getServer().getName() + " Online...");
		PluginManager pm = getServer().getPluginManager();
		pm.getPermission("playerPermission");
		
		this.getCommand("gms").setExecutor(gmgr);
		this.getCommand("gmc").setExecutor(gmgr);
		this.getCommand("gmsp").setExecutor(gmgr);
		this.getCommand("gma").setExecutor(gmgr);
		
		this.getCommand("tellpos").setExecutor(psgr);
		this.getCommand("otherpos").setExecutor(psgr);
		this.getCommand("pos").setExecutor(psgr);
		
		//this.getCommand("").setExecutor(gr);
		this.getCommand("cheal").setExecutor(togr);
		this.getCommand("cfly").setExecutor(togr);
		this.getCommand("cfeed").setExecutor(togr);
		
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
			
			if (player.hasPermission("devtcbn.update") || player.getName().equals("TarixCat")) {
				this.getServer().broadcastMessage(ChatColor.RED + "Warning: " + ChatColor.YELLOW + "Reloading Plugins Expect Lag...");
			}
			
			return true;
			
		}
		
		else {
			sender.sendMessage(ChatColor.GOLD + "L, you don't know how to use this...");
		}
		
		return true;
	}

}
