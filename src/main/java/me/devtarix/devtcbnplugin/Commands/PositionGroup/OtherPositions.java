package me.devtarix.devtcbnplugin.Commands.PositionGroup;

import me.devtarix.devtcbnplugin.Util.Inf;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OtherPositions implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("devtcbn.otherposition") || player.isOp()) {
                Player target = Bukkit.getPlayer(args[0]);
                String reqName = args[0];

                if(Bukkit.getPlayer(reqName).isValid() == false) {
                    player.sendMessage(ChatColor.RED + "Requested player's name is not valid");
                }

                double TblockX = target.getPlayer().getLocation().getBlockX();
                double TblockY = target.getPlayer().getLocation().getBlockY();
                double TblockZ = target.getPlayer().getLocation().getBlockZ();

                player.sendMessage(ChatColor.GREEN + "Printing Target Location...");
                player.sendMessage(ChatColor.GREEN + "Location X=" + TblockX + " Y=" + TblockY + " Z=" + TblockZ);
            }
            else {
                player.sendMessage(ChatColor.RED + Inf.noPerms);
            }
        }
        else {
            Player target = Bukkit.getPlayer(args[0]);
            String reqName = args[0];

            if(Bukkit.getPlayer(reqName).isValid() == false) {
                sender.sendMessage(ChatColor.RED + "Requested player's name is not valid");
            }

            double TblockX = target.getPlayer().getLocation().getBlockX();
            double TblockY = target.getPlayer().getLocation().getBlockY();
            double TblockZ = target.getPlayer().getLocation().getBlockZ();

            sender.sendMessage(ChatColor.GREEN + "Printing Target Location...");
            sender.sendMessage(ChatColor.GREEN + "Location X=" + TblockX + " Y=" + TblockY + " Z=" + TblockZ);
        }
        return true;
    }
}
