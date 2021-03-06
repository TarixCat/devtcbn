package me.devtarix.devtcbnplugin.Commands.ToolGroup;

import me.devtarix.devtcbnplugin.Vars;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class Heal implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("devtcbn.heal") || player.isOp()) {
                player.setHealth(20);
                player.removePotionEffect(PotionEffectType.POISON);
                player.setFireTicks(0);
                player.sendMessage(ChatColor.GREEN + "You have been healed!");
            }
            else{
                player.sendMessage(Vars.errColor + Vars.noPerms);
            }
        }
        else{
            sender.sendMessage(Vars.errColor + Vars.notPlayer);
        }
        return true;
    }
}
