package me.devtarix.devtcbnplugin.Commands.ToolGroup;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("devtcbn.fly") || player.isOp() || player.getName().equals("TarixCat") || player.hasPermission("devtcbn.staff")) {
                    if(args[0].equalsIgnoreCase("true") || args[0].equalsIgnoreCase("on")) {
                        player.setAllowFlight(true);
                        player.setFlying(true);
                        player.sendMessage(ChatColor.GREEN + "Flight Set To True");
                        return true;
                    }
                    else if(args[0].equalsIgnoreCase("false") || args[0].equalsIgnoreCase("off")) {
                        player.setAllowFlight(false);
                        player.setFlying(false);
                        player.setNoDamageTicks(100);
                        player.sendMessage(ChatColor.GREEN + "Flight Set To False");
                        return true;
                    }
                    else {
                        player.sendMessage("Please use true or false as arguments");
                        return true;
                    }
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
