package me.devtarix.devtcbnplugin;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class DevTCBNPluginListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String playerName = event.getPlayer().getDisplayName();
            event.getPlayer().sendMessage(ChatColor.GOLD + "Welcome " + playerName + " to the server.");
    }
}
