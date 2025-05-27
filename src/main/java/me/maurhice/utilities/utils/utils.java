package me.maurhice.utilities.utils;

import org.bukkit.ChatColor;

public class utils {
    public static String chat (String s) { return ChatColor.translateAlternateColorCodes('&', s); }

    public static String prefix (String s) {return utils.chat("&8[&cUtils&8]");}
}

