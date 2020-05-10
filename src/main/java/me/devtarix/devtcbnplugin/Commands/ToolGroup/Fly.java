package me.devtarix.devtcbnplugin.Commands.ToolGroup;

import me.devtarix.devtcbnplugin.DevTCBNPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class Fly implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("devtcbn.fly") || player.isOp() || player.getName().equals("TarixCat") || player.hasPermission("devtcbn.staff")) {
                    if(!DevTCBNPlugin.flyToggle.contains(player.getUniqueId()) || args[0].equalsIgnoreCase("true") || args[0].equalsIgnoreCase("on")) {
                        player.setAllowFlight(true);
                        player.setFlying(true);
                        DevTCBNPlugin.flyToggle.add(player.getUniqueId());
                        player.sendMessage(ChatColor.GREEN + "Flight Set To True");
                        return true;
                    }
                    else if(DevTCBNPlugin.flyToggle.contains(player.getUniqueId()) || args[0].equalsIgnoreCase("false") || args[0].equalsIgnoreCase("off")) {
                        player.setAllowFlight(false);
                        player.setFlying(false);
                        player.setNoDamageTicks(100);
                        DevTCBNPlugin.flyToggle.remove(player.getUniqueId());
                        player.sendMessage(ChatColor.GREEN + "Flight Set To False");
                        return true;
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
