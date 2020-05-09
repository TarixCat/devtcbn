package me.devtarix.devtcbnplugin.Commands.ToolGroup;

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
        }
        else{
            sender.sendMessage("This command cannot be run from console");
        }
        return true;
    }
}
