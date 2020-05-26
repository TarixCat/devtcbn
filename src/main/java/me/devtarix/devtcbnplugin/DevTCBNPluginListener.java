package me.devtarix.devtcbnplugin;

import me.devtarix.devtcbnplugin.Util.Inf;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
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

    @EventHandler
    public void onSkeltonSpawn(EntitySpawnEvent entityEvent) {
        if(entityEvent.getEntityType() == EntityType.SKELETON) {
            if(Inf.FSenabled == false) {
                entityEvent.setCancelled(true);
            }
            else {
                entityEvent.setCancelled(false);
            }
        }
    }
}
