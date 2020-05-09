package me.devtarix.devtcbnplugin;

import me.devtarix.devtcbnplugin.Commands.*;
import me.devtarix.devtcbnplugin.Commands.MiscGroup.InProgress;
import me.devtarix.devtcbnplugin.Commands.MiscGroup.PluginUpdate;
import me.devtarix.devtcbnplugin.Commands.MiscGroup.Test;
import me.devtarix.devtcbnplugin.Commands.ToolGroup.*;
import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
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

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new DevTCBNPluginListener(), this);
        System.out.println("[BCPlugin] Are You Ready To Take Over The World?");
        System.out.println("[Server] I Am Ready To Dominate!");
        System.out.println("[TarixCat] I Am The Creator Of BCPlugin");
        log(Level.INFO, "We are starting up..");
        log(Level.SEVERE, "This is a test do not panic...");
        PluginManager pm = getServer().getPluginManager();
        pm.addPermission(playerPermission);

        //this.getCommand("").setExecutor(gr);
        this.getCommand("cwb").setExecutor(new WorkBench());
        this.getCommand("cheal").setExecutor(new Heal());
        this.getCommand("cfly").setExecutor(new Fly());
        this.getCommand("cfeed").setExecutor(new Feed());
        this.getCommand("chelp").setExecutor(new Help());
        this.getCommand("test").setExecutor(new Test());
        this.getCommand("inp").setExecutor(new InProgress());
        this.getCommand("update").setExecutor(new PluginUpdate());
    }

    @Override
    public void onDisable() {
        log(Level.INFO, "Shutting Down.");
    }
}
