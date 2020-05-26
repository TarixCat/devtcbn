package me.devtarix.devtcbnplugin.Commands.GamemodeGroup;

import me.devtarix.devtcbnplugin.Util.Inf;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdventureCMD implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("devtcbn.gamemode.adventure") || player.isOp()){
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage(ChatColor.GREEN + "Gamemode set to Adventure");
            }
            else {
                sender.sendMessage(Inf.errColor + Inf.noPerms);
            }
        }
        else {
            sender.sendMessage(Inf.errColor + Inf.notPlayer);
        }
        return true;
    }
}
