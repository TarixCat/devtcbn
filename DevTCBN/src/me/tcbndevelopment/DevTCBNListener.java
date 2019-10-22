package me.tcbndevelopment;

import org.bukkit.ChatColor;
import org.bukkit.event.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
//Why doesn't this push to GitHub

public class DevTCBNListener implements Listener {
	
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
    	event.getPlayer().sendMessage(ChatColor.GREEN + "Hello " + event.getPlayer().getName() + ", To The DevTBCN Server!");
    }
    
    @EventHandler
    public void onCreativeMenuUse(InventoryCreativeEvent event) {

    }

}
