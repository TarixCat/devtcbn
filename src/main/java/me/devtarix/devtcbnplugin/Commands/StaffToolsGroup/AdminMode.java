package me.devtarix.devtcbnplugin.Commands.StaffToolsGroup;

import me.devtarix.devtcbnplugin.Storage;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminMode implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("devtcbn.staff.adminmode") || player.isOp()) {
                if(!Storage.adminModeToggle.contains(player.getUniqueId())) {
                    player.setCanPickupItems(false);
                    player.setAllowFlight(true);
                    player.setFlying(true);
                    player.setNoDamageTicks(99999999);
                    Storage.adminModeToggle.add(player.getUniqueId());
                    player.sendMessage(ChatColor.GREEN + "Adminmode Toggled ON");
                }
                else {
                    player.setCanPickupItems(true);
                    player.setAllowFlight(false);
                    player.setFlying(false);
                    player.setNoDamageTicks(2000);
                    Storage.adminModeToggle.remove(player.getUniqueId());
                    player.sendMessage(ChatColor.GREEN + "Adminmode Toggled OFF");
                }
            }
            else {
                player.sendMessage(Storage.errColor + Storage.noPerms);
            }
        }
        else {
            sender.sendMessage(Storage.errColor + Storage.noPerms);
        }
        return true;
    }
}
