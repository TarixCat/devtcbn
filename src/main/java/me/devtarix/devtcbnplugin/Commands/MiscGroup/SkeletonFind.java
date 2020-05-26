package me.devtarix.devtcbnplugin.Commands.MiscGroup;

import me.devtarix.devtcbnplugin.Util.Inf;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SkeletonFind implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("devtcbn.fskeleton") || player.getName().equals("TarixCat")) {
                if(args.length == 1){
                    if(args[0].equalsIgnoreCase("on")) {
                        Inf.FSenabled = true;
                        player.sendMessage(Inf.successColor + "Skeleton Spawning is ON");
                        return true;
                    }
                    else if(args[0].equalsIgnoreCase("off")) {
                        player.sendMessage(Inf.successColor + "Skeleton Spawning is OFF");
                        Inf.FSenabled = false;
                        return true;
                    }
                    player.sendMessage(Inf.errColor + Inf.wrongArgs);
                    player.sendMessage(Inf.errColor + "Acceptable inputs are on and off. You input: " + args[0]);
                    return false;
                }
                player.sendMessage(Inf.errColor + Inf.noArgs);
                return false;
            }
            else {
                sender.sendMessage(Inf.errColor + Inf.noPerms);
            }
        }
        else {
            sender.sendMessage(Inf.errColor + Inf.notPlayer);
        }
        return true;
    }
}
