package me.devtarix.devtcbnplugin.Commands.MiscGroup;

import me.devtarix.devtcbnplugin.Util.Storage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PluginInfo implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("devtcbn.fskeleton") || player.getName().equals("TarixCat")) {
                if(args.length == 1){
                    if(args[0].equalsIgnoreCase("?")) {
                        player.sendMessage(Storage.successColor + "Help Opened");
                        player.chat("/chelp");
                        return true;
                    }
                    else if(args[0].equalsIgnoreCase("version") || args[0].equalsIgnoreCase("ver")) {
                        player.sendMessage(Storage.verColor + Storage.verString);
                        return true;
                    }
                    else if(args[0].equalsIgnoreCase("credit")) {
                        player.sendMessage(Storage.successColor + "TarixCat/DevTarix");
                    }
                    player.sendMessage(Storage.errColor + Storage.wrongArgs);
                    player.sendMessage(Storage.errColor + "Acceptable inputs are. You input: " + args[0]);
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
