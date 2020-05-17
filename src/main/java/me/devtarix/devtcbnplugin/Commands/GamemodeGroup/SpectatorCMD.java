package me.devtarix.devtcbnplugin.Commands.GamemodeGroup;

import me.devtarix.devtcbnplugin.Util.Storage;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpectatorCMD implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("devtcbn.gamemode.spectator") || player.isOp()){
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(ChatColor.GREEN + "Gamemode set to Spectator");
            }
            else {
                sender.sendMessage(Storage.errColor + Storage.noPerms);
            }
        }
        else {
            sender.sendMessage(Storage.errColor + Storage.notPlayer);
        }
        return true;
    }
}
