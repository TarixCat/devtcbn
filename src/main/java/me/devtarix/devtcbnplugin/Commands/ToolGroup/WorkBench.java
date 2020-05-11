package me.devtarix.devtcbnplugin.Commands.ToolGroup;

import me.devtarix.devtcbnplugin.Vars;
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
                player.sendMessage(Vars.errColor + Vars.noPerms);
            }
        }
        else{
            sender.sendMessage(Vars.errColor + Vars.notPlayer);
        }
        return true;
    }
}
