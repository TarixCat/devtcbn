package me.devtarix.devtcbnplugin.Util;

import org.bukkit.ChatColor;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Storage {

    //Chat Colors
    public static final ChatColor errColor = ChatColor.RED;
    public static final ChatColor warnColor = ChatColor.YELLOW;
    public static final ChatColor successColor = ChatColor.GREEN;
    public static final ChatColor verColor = ChatColor.AQUA;

    //Chat Messages
    public static final String noPerms = "You do not have permission to run this command";
    public static final String notPlayer = "You must be a player to run this command";
    public static final String wrongArgs = "You haven't entered a valid argument";
    public static final String noArgs = "You haven' entered an argument";
    public static final String verString = "Current Plugin Version is 0.3.5!";

    //Boolean
    public static Boolean FSenabled;

    //Toggles (For commands)
    public static List<UUID> flyToggle = new ArrayList<UUID>();
    public static List<UUID> modModeToggle = new ArrayList<UUID>();
    public static List<UUID> adminModeToggle = new ArrayList<UUID>();
}
