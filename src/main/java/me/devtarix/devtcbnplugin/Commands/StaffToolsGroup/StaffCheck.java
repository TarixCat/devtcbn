package me.devtarix.devtcbnplugin.Commands.StaffToolsGroup;

import me.devtarix.devtcbnplugin.Util.Storage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffCheck implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("devtcbn.staff") || player.isOp()) {
                player.sendMessage("Op: " + player.isOp() );
                player.sendMessage("Fly: " + player.isFlying() );
                player.sendMessage("Gamemode: " + player.getGameMode() );
                player.sendMessage("All Perm-Node: " + player.isPermissionSet("devtcbn.staff.*"));
                player.sendMessage("Sleeping Ignored: " + player.isSleepingIgnored());
                player.sendMessage("Whitelisted: " + player.isWhitelisted());
                player.sendMessage("Whitelist Status: " + Bukkit.hasWhitelist());
                player.sendMessage("Operators: " + Bukkit.getOperators());
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
