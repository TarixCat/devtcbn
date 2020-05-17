package me.devtarix.devtcbnplugin.Util;

public enum ChatMsg {
    NOPERMS(Storage.errColor + Storage.noPerms),
    NOARGS(Storage.errColor + Storage.noArgs),
    NOTPLAYER(Storage.errColor + Storage.notPlayer),
    WRONGARGS(Storage.errColor + Storage.wrongArgs),
    VERSION(Storage.verColor + Storage.verString);

    private final String ChatMsg;

    ChatMsg(String ChatMsg) {
        this.ChatMsg = ChatMsg;
    }
}
