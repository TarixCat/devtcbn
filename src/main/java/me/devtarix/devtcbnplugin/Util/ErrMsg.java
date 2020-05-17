package me.devtarix.devtcbnplugin.Util;

import org.bukkit.ChatColor;

public enum ErrMsg {
    NOPERMS(Storage.errColor + Storage.noPerms),
    NOARGS(Storage.errColor + Storage.noArgs),
    NOTPLAYER(Storage.errColor + Storage.notPlayer),
    WRONGARGS(Storage.errColor + Storage.wrongArgs),
    VERSION(Storage.verColor + Storage.verString);

    private final String errMsg;

    ErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
