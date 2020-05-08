package me.devtarix.devtcbnplugin.Commands.MiscGroup;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.logging.Level;

public class Test implements CommandExecutor {

    public static void log(Level level, String msg) {
        System.out.println(msg);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        sender.sendMessage("Testing Direct Chat");
        log(Level.INFO, "Testing Logging");
        return true;
    }
}
