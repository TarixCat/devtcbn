package me.devtarix.devtcbnplugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MiscGroup implements CommandExecutor {

    private String test = "Currently In-Progress: bed, setbed, advanced adminmode, opme, enforcer commands";

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(cmd.getName().equalsIgnoreCase("test") && sender instanceof Player) {

            Player player = (Player) sender;

            player.sendMessage(ChatColor.GOLD + "Hello, " + player.getDisplayName() + "! This Is A Test!");
        }

        else if(cmd.getName().equalsIgnoreCase("inp") && sender instanceof Player) {

            Player player = (Player) sender;

            if(player.hasPermission("devtcbn.futureupdate")) {
                player.sendMessage(ChatColor.DARK_RED + "" + test);
            }
            else {
                player.sendMessage("No Permission Given");
            }
        }

        else if(cmd.getName().equalsIgnoreCase("update") && sender instanceof Player) {

            Player player = (Player) sender;

            if(player.hasPermission("devtcbn.update") || player.getName().equals("TarixCat") || player.isOp()) {
                player.getServer().broadcastMessage(ChatColor.RED + "Warning: " + ChatColor.YELLOW + "Reloading Plugins Expect Lag...");
                player.getServer().reload();
                player.getServer().broadcastMessage(ChatColor.RED + "Reloaded plugins...");
            }
        }
        return true;
    }

}
