package me.devtarix.devtcbnplugin.Commands.MiscGroup;

import me.devtarix.devtcbnplugin.Util.Inf;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestWorldCreator implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("devtcbn.createtestworld") || player.isOp()){
                WorldCreator wc = new WorldCreator("DevTestWorld");

                wc.environment(World.Environment.NORMAL);
                wc.type(WorldType.NORMAL);

                wc.createWorld();
            }

            else {
                player.sendMessage(Inf.E + Inf.noPerms);
            }
        }

        else {
            sender.sendMessage(Inf.E + Inf.notPlayer);
        }
        return false;
    }
}
