package me.devtarix.devtcbnplugin;

import me.devtarix.devtcbnplugin.Commands.MiscGroup.InProgress;
import me.devtarix.devtcbnplugin.Commands.MiscGroup.PluginUpdate;
import me.devtarix.devtcbnplugin.Commands.MiscGroup.Test;
import me.devtarix.devtcbnplugin.Commands.PositionGroup.OtherPositions;
import me.devtarix.devtcbnplugin.Commands.PositionGroup.Position;
import me.devtarix.devtcbnplugin.Commands.PositionGroup.PositionBroadcast;
import me.devtarix.devtcbnplugin.Commands.ToolGroup.*;
import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

public final class DevTCBNPlugin extends JavaPlugin {

    public static List<UUID> flyToggle = new ArrayList<UUID>();

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

    public Permission staffPermission = new Permission("devtcbn.staff");
    public Permission wbPermission = new Permission("devtcbn.workbench");
    public Permission healPermission = new Permission("devtcbn.heal");

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new DevTCBNPluginListener(), this);
        System.out.println("[BCPlugin] Are You Ready To Take Over The World?");
        System.out.println("[Server] I Am Ready To Dominate!");
        System.out.println("[TarixCat] I Am The Creator Of BCPlugin");
        log(Level.INFO, "We are starting up..");
        log(Level.SEVERE, "This is a test do not panic...");
        PluginManager pm = getServer().getPluginManager();
        pm.addPermission(staffPermission);

        //this.getCommand("").setExecutor(gr);
        this.getCommand("cwb").setExecutor(new WorkBench());
        this.getCommand("cheal").setExecutor(new Heal());
        this.getCommand("cfly").setExecutor(new Fly());
        this.getCommand("cfeed").setExecutor(new Feed());
        this.getCommand("chelp").setExecutor(new Help());
        this.getCommand("test").setExecutor(new Test());
        this.getCommand("inp").setExecutor(new InProgress());
        this.getCommand("update").setExecutor(new PluginUpdate());
        this.getCommand("pos").setExecutor(new Position());
        this.getCommand("rpos").setExecutor(new OtherPositions());
        this.getCommand("bcpos").setExecutor(new PositionBroadcast());
    }

    @Override
    public void onDisable() {
        log(Level.INFO, "Shutting Down.");
    }
}
