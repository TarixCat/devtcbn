package me.devtarix.devtcbnplugin.Util;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Inf {

    //Chat Colors
    public static final ChatColor E = ChatColor.RED;
    public static final ChatColor W = ChatColor.YELLOW;
    public static final ChatColor S = ChatColor.GREEN;
    public static final ChatColor I = ChatColor.AQUA;
    public static final ChatColor C = ChatColor.DARK_RED;

    //Chat Messages
    public static final String noPerms = "You do not have permission to run this command";
    public static final String notPlayer = "You must be a player to run this command";
    public static final String wrongArgs = "You haven't entered a valid argument";
    public static final String noArgs = "You haven' entered an argument";
    public static final String verString = "Current Plugin Version is 0.3.5!";
    public static final String notFound = "Player was not found/isn't online";
    public static final String n1 = "\n";

    //Boolean
    public static Boolean FSenabled;

    //Toggles (For commands)
    public static List<UUID> flyToggle = new ArrayList<UUID>();
    public static List<UUID> modModeToggle = new ArrayList<UUID>();
    public static List<UUID> adminModeToggle = new ArrayList<UUID>();
}
