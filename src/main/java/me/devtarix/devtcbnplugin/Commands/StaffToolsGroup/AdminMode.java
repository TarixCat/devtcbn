package me.devtarix.devtcbnplugin.Commands.StaffToolsGroup;

import me.devtarix.devtcbnplugin.DevTCBNPlugin;
import me.devtarix.devtcbnplugin.Vars;
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
                if(!DevTCBNPlugin.adminModeToggle.contains(player.getUniqueId())) {
                    player.setCanPickupItems(false);
                    player.setAllowFlight(true);
                    player.setFlying(true);
                    player.setNoDamageTicks(99999999);
                    DevTCBNPlugin.adminModeToggle.add(player.getUniqueId());
                    player.sendMessage(ChatColor.GREEN + "Adminmode Toggled ON");
                }
                else {
                    player.setCanPickupItems(true);
                    player.setAllowFlight(false);
                    player.setFlying(false);
                    player.setNoDamageTicks(2000);
                    DevTCBNPlugin.adminModeToggle.remove(player.getUniqueId());
                    player.sendMessage(ChatColor.GREEN + "Adminmode Toggled OFF");
                }
            }
            else {
                player.sendMessage(Vars.errColor + Vars.noPerms);
            }
        }
        else {
            sender.sendMessage(Vars.errColor + Vars.noPerms);
        }
        return true;
    }
}
