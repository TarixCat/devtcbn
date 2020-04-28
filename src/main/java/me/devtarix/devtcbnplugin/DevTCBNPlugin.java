package me.devtarix.devtcbnplugin;

import me.devtarix.devtcbnplugin.Commands.*;
import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class DevTCBNPlugin extends JavaPlugin {

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
/*
    double blockX = event.getPlayer().getLocation().getBlockX();
    double blockY = event.getPlayer().getLocation().getBlockY();
    double blockZ = event.getPlayer().getLocation().getBlockZ();
*/
    public Permission playerPermission = new Permission("devtcbn.staff");
    public Permission playerPermission1 = new Permission("devtcbn.gamemode");
    public Permission playerPermission2 = new Permission("devtcbn.feed");
    public Permission playerPermission3 = new Permission("devtcbn.heal");
    public Permission playerPermission4 = new Permission("devtcbn.fly");
    public Permission playerPermission5 = new Permission("devtcbn.futureupdate");
    public Permission playerPermission6 = new Permission("devtcbn.adminmode");
    public Permission playerPermission7 = new Permission("devtcbn.modmode");
    public Permission playerPermission8 = new Permission("devtcbn.pos");

    private GamemodeGroup gmgr = new GamemodeGroup();
    private PosGroup psgr = new PosGroup();
    private ToolsGroup togr = new ToolsGroup();
    private StaffToolsGroup stgr = new StaffToolsGroup();
    private MiscGroup msgr = new MiscGroup();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new DevTCBNPluginListener(), this);
        System.out.println("[BCPlugin] Are You Ready To Take Over The World?");
        System.out.println("[Server] I Am Ready To Dominate!");
        System.out.println("[TarixCat] I Am The Creator Of BCPlugin");
        log(Level.INFO, "We are starting up..");
        log(Level.SEVERE, "This is a test do not panic...");
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
        this.getCommand("adminmode").setExecutor(stgr);
        this.getCommand("modmode").setExecutor(stgr);
        this.getCommand("staffcheck").setExecutor(stgr);
        this.getCommand("test").setExecutor(msgr);
        this.getCommand("inp").setExecutor(msgr);
        this.getCommand("update").setExecutor(msgr);
    }

    @Override
    public void onDisable() {
        log(Level.INFO, "Shutting Down.");
    }
}
