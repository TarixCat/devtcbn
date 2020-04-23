package me.devtarix.devtcbnplugin;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class DevTCBNPluginListener implements Listener {

    protected ChatColor TarixColor = ChatColor.LIGHT_PURPLE;
    protected ChatColor PersonColor = ChatColor.GOLD;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String playerName = event.getPlayer().getDisplayName();

        if(playerName == "TarixCat") {
            event.getPlayer().sendMessage(TarixColor + "Welcome " + playerName + "to the server. Since you are the maker of this plugin you can use dev bypass on everything.");
        }
        else if(playerName == "Personpacman") {
            event.getPlayer().sendMessage(PersonColor + "Welcome " + playerName + "to the server. You are a founder of TCBN and have access to some bypass commands.");
        }
        else if(playerName == "TarixCat33") {
            event.getPlayer().sendMessage(TarixColor + "Welcome " + playerName + "to the server. You are an alt of TarixCat, you don't have any bypass commands.");
        }
        else {
            event.getPlayer().sendMessage("Welcome " + playerName + "to the server.");
        }
    }
}
