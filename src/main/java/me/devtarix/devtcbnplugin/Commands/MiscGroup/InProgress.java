package me.devtarix.devtcbnplugin.Commands.MiscGroup;

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
                player.sendMessage(ChatColor.DARK_RED + "Info Book Opened");
                player.sendMessage(ChatColor.GOLD + test);

                ItemStack UpdateBook = new ItemStack(Material.WRITTEN_BOOK);

                BookMeta bookMeta = (BookMeta) UpdateBook.getItemMeta();
                bookMeta.setAuthor("DevTCBN");
                bookMeta.setTitle("Updates!");

                ArrayList<String> pages = new ArrayList<String>();

                pages.add("Note: Major Rewrites Currently Occuring." + n1 + "Currently In-Progress:" + n1 + "adminmode, modmode, fly. Fixing toggles.");


                player.openBook(UpdateBook);
            }
            else {
                player.sendMessage("No Permission Given");
            }
        }
        else{
            System.out.println("Please run command In-Game. Thanks!");
        }
        return true;
    }
}
