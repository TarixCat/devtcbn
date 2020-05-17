package me.devtarix.devtcbnplugin.Commands.MiscGroup;

import me.devtarix.devtcbnplugin.Storage;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.StringTokenizer;

public class SkeletonFind implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("devtcbn.fskeleton") || player.getName().equals("TarixCat")) {
                if(args.length == 1){
                    if(args[0].equalsIgnoreCase("on")) {
                        Storage.FSenabled = true;
                        player.sendMessage(Storage.successColor + "Skeleton Spawning is ON");
                        return true;
                    }
                    else if(args[0].equalsIgnoreCase("off")) {
                        player.sendMessage(Storage.successColor + "Skeleton Spawning is OFF");
                        Storage.FSenabled = false;
                        return true;
                    }
                    player.sendMessage(Storage.errColor + Storage.wrongArgs);
                    player.sendMessage(Storage.errColor + "Acceptable inputs are on and off. You input: " + args[0]);
                    return false;
                }
                player.sendMessage(Storage.errColor + Storage.noArgs);
                return false;
            }
            else {
                sender.sendMessage(Storage.errColor + Storage.noPerms);
            }
        }
        else {
            sender.sendMessage(Storage.errColor + Storage.notPlayer);
        }
        return true;
    }
}
