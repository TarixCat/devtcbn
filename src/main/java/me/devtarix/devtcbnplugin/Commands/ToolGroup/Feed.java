package me.devtarix.devtcbnplugin.Commands.ToolGroup;

import me.devtarix.devtcbnplugin.Util.Inf;
import org.bukkit.Bukkit;
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
                if(args.length == 0) {
                    player.setFoodLevel(20);
                    player.setSaturation(20);
                    player.sendMessage(ChatColor.GREEN + "You have been fed!");
                }
                if(args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    String reqName = args[0];
                    if(!target.isOnline()) {
                        player.sendMessage(Inf.E + Inf.notPlayer);
                        player.sendMessage(Inf.I + "Ensure that the spelling is correct");
                        return true;
                    }
                    else {
                        target.setFoodLevel(20);
                        target.setSaturation(20);
                        target.sendMessage(Inf.S + "You were fed by " + target);
                        player.sendMessage(Inf.S + "You have fed " + target);
                    }

                }
            }
            else{
                player.sendMessage(Inf.E + Inf.noPerms);
            }
        }
        else{
            sender.sendMessage(Inf.E + Inf.notPlayer);
        }
        return true;
    }
}
