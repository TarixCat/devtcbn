package me.devtarix.devtcbnplugin.Commands.MiscGroup;

import me.devtarix.devtcbnplugin.Util.Inf;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;

import static me.devtarix.devtcbnplugin.Util.Inf.n1;

public class Book implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("devtcbn.book") || player.getName().equals("TarixCat")) {
                ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                BookMeta bookMeta = (BookMeta) book.getItemMeta();

                ArrayList<String> pages = new ArrayList<String>();
                pages.add("Note: Major Rewrites Currently Occuring." + n1 + "Currently In-Progress:" + n1 + "adminmode, modmode, fly. Fixing toggles.");



                bookMeta.spigot().setPages();

                bookMeta.setTitle("Static Book");
                bookMeta.setAuthor("TheCatBoxNetwork");

                book.setItemMeta(bookMeta);

                player.openBook(book);
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