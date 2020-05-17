package me.devtarix.devtcbnplugin.Commands.ToolGroup;

import me.devtarix.devtcbnplugin.Storage;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Help implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("devtcbn.help") || player.isOp()) {
                player.sendMessage(ChatColor.GOLD + "-------Help-------");
                player.sendMessage(ChatColor.GOLD + "inp: Debug testing");
                player.sendMessage(ChatColor.GOLD + "test: Debug testing");
                player.sendMessage(ChatColor.GOLD + "pos: Prints position");
                player.sendMessage(ChatColor.GOLD + "tellpos: Broadcasts your position to the server");
                player.sendMessage(ChatColor.GOLD + "otherpos: Gets positions of other players");
                player.sendMessage(ChatColor.GOLD + "gma: Gamemode Adventure");
                player.sendMessage(ChatColor.GOLD + "gms: Gamemode Survival");
                player.sendMessage(ChatColor.GOLD + "gmsp: Gamemode Spectator");
                player.sendMessage(ChatColor.GOLD + "gmc: Gamemode Creative");
                player.sendMessage(ChatColor.GOLD + "cfly: Flight Powers on or off?");
                player.sendMessage(ChatColor.GOLD + "cheal: Heals you");
                player.sendMessage(ChatColor.GOLD + "cfeed: Feeds you");
                player.sendMessage(ChatColor.GOLD + "cwb: Workbench");
                player.sendMessage(ChatColor.GOLD + "staffcheck: Checks current attributes of players");
                player.sendMessage(ChatColor.GOLD + "adminmode: Adminmode");
                player.sendMessage(ChatColor.GOLD + "modmode: Modmode");
                player.sendMessage(ChatColor.GOLD + "------------------");
            }
            else {
                player.sendMessage(Storage.errColor + Storage.noPerms);
            }
        }
        else {
            sender.sendMessage(Storage.errColor + Storage.notPlayer);
        }
        return true;
    }
}
