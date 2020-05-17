package me.devtarix.devtcbnplugin.Commands.ToolGroup;

import me.devtarix.devtcbnplugin.Util.Storage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WorkBench implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("devtcbn.workbench") || player.isOp()) {
                player.openWorkbench(null, true);
            }
            else {
                player.sendMessage(Storage.errColor + Storage.noPerms);
            }
        }
        else{
            sender.sendMessage(Storage.errColor + Storage.notPlayer);
        }
        return true;
    }
}
