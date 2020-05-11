package me.devtarix.devtcbnplugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OldGamemodeGroup implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(cmd.getName().equalsIgnoreCase("gmc") && sender instanceof Player) {

            Player player = (Player) sender;

            if(player.hasPermission("devtcbn.gamemode") || player.isOp() || player.getName().equals("TarixCat")) {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(ChatColor.GREEN + "Gamemode set to Creative");
            }
            else {
                player.sendMessage(ChatColor.RED + "You Don't Have Permission To Run This Command");
            }
        }

        else if(cmd.getName().equalsIgnoreCase("gms") && sender instanceof Player) {

            Player player = (Player) sender;

            if(player.hasPermission("devtcbn.gamemode") || player.isOp() || player.getName().equals("TarixCat")) {
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(ChatColor.GREEN + "Gamemode set to Survival");
            }
            else {
                player.sendMessage(ChatColor.RED + "You Don't Have Permission To Run This Command");
            }
        }

        else if(cmd.getName().equalsIgnoreCase("gma") && sender instanceof Player) {

            Player player = (Player) sender;

            if(player.hasPermission("devtcbn.gamemode") || player.isOp() || player.getName().equals("TarixCat")) {
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage(ChatColor.GREEN + "Gamemode set to Adventure");
            }
            else {
                player.sendMessage(ChatColor.RED + "You Don't Have Permission To Run This Command");
            }
        }

        else if(cmd.getName().equalsIgnoreCase("gmsp") && sender instanceof Player) {

            Player player = (Player) sender;

            if(player.hasPermission("devtcbn.gamemode") || player.isOp() || player.getName().equals("TarixCat")) {
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(ChatColor.GREEN + "Gamemode set to Spectator");
            }
            else {
                player.sendMessage(ChatColor.RED + "You Don't Have Permission To Run This Command");
            }

        }

        else {
        }
        return true;
    }
}
