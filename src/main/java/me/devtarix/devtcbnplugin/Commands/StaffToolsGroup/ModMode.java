package me.devtarix.devtcbnplugin.Commands.StaffToolsGroup;

import me.devtarix.devtcbnplugin.Util.Inf;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ModMode implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("devtcbn.staff.modmode") || player.isOp()) {
                if(!Inf.modModeToggle.contains(player.getUniqueId())) {
                    player.setCanPickupItems(false);
                    player.setGameMode(GameMode.SPECTATOR);
                    player.setNoDamageTicks(99999999);
                    Inf.modModeToggle.add(player.getUniqueId());
                    player.sendMessage(ChatColor.GREEN + "Toggled Modmode ON");
                }
                else {
                    player.setCanPickupItems(true);
                    player.setGameMode(GameMode.SURVIVAL);
                    player.setNoDamageTicks(200);
                    Inf.modModeToggle.remove(player.getUniqueId());
                    player.sendMessage(ChatColor.GREEN + "Toggled Modmode OFF");
                }
            }
            else {
                player.sendMessage(Inf.E + Inf.noPerms);
            }
        }
        else {
            sender.sendMessage(Inf.E + Inf.noPerms);
        }
        return true;
    }
}
