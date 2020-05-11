package me.devtarix.devtcbnplugin;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;

public class DevTCBNPluginListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String playerName = event.getPlayer().getDisplayName();
            event.getPlayer().sendMessage(ChatColor.GOLD + "Welcome " + playerName + " to the server.");
    }

    @EventHandler
    public void onKick(PlayerKickEvent event) {
        DevTCBNPlugin.broadcastMessage("User " + event.getPlayer() + "has just been kicked for: " + event.getReason());
    }
}
