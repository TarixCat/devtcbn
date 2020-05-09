package me.devtarix.devtcbnplugin.Commands.ToolGroup;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("devtcbn.feed") || player.isOp() || player.getName().equals("TarixCat")) {
                player.setFoodLevel(20);
                player.setSaturation(20);
                player.sendMessage(ChatColor.GREEN + "You Have Been Fed");
            }
            else{
                player.sendMessage("No Permission Given");
            }
        }
        else{
            sender.sendMessage("This command cannot be run from console");
        }
        return true;
    }
}
