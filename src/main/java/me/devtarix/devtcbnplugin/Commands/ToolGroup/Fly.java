package me.devtarix.devtcbnplugin.Commands.ToolGroup;

import me.devtarix.devtcbnplugin.DevTCBNPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("devtcbn.fly") || player.getName().equals("TarixCat") || player.hasPermission("devtcbn.staff")) {
                    if(!DevTCBNPlugin.flyToggle.contains(player.getUniqueId())) {
                        player.setAllowFlight(true);
                        player.setFlying(true);
                        DevTCBNPlugin.flyToggle.add(player.getUniqueId());
                        player.sendMessage(ChatColor.GREEN + "Flight Set To True");
                        return true;
                    }
                    else {
                        player.setAllowFlight(false);
                        player.setFlying(false);
                        player.setNoDamageTicks(100);
                        DevTCBNPlugin.flyToggle.remove(player.getUniqueId());
                        player.sendMessage(ChatColor.GREEN + "Flight Set To False");
                    }
            }
            else{
                player.sendMessage("No Permission Given");
            }
        }
        else{
            sender.sendMessage("This command cannot be run from console, for obvious reasons...");
        }
        return true;
    }
}
