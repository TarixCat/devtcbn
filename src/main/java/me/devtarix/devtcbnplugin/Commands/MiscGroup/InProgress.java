package me.devtarix.devtcbnplugin.Commands.MiscGroup;

import me.devtarix.devtcbnplugin.Util.Inf;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;

public class InProgress implements CommandExecutor {
    String n1 = "\n";
    private final String test = "Currently In-Progress: bed, setbed, advanced adminmode, opme, enforcer commands";

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("devtcbn.futureupdate") || player.isOp()) {
                player.sendMessage(ChatColor.GOLD + test);
            }
            else {
                player.sendMessage(Inf.errColor + Inf.noPerms);
            }
        }
        else{
            sender.sendMessage(Inf.errColor + Inf.notPlayer);
        }
        return true;
    }
}
