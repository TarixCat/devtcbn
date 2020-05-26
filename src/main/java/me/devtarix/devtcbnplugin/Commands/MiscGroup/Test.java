package me.devtarix.devtcbnplugin.Commands.MiscGroup;

import me.devtarix.devtcbnplugin.DevTCBNPlugin;
import me.devtarix.devtcbnplugin.Util.Inf;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Level;

public class Test implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("devtcbndebug.debug1") || player.getName().equals("TarixCat")) {
                sender.sendMessage("Testing Direct Chat");
                DevTCBNPlugin.log(Level.INFO, "Testing Logging");
            } else {
                sender.sendMessage(Inf.errColor + Inf.noPerms);
            }
        }
        else {
            sender.sendMessage(Inf.errColor + Inf.notPlayer);
        }
        return true;
    }
}
