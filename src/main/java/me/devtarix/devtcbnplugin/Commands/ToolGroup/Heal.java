package me.devtarix.devtcbnplugin.Commands.ToolGroup;

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
                player.sendMessage("No Permission Given");
            }
        }
        else{
            sender.sendMessage("This command cannot be run from console");
        }
        return true;
    }
}
