package me.devtarix.devtcbnplugin.Util;

public enum ChatMsg {
    NOPERMS(Inf.errColor + Inf.noPerms),
    NOARGS(Inf.errColor + Inf.noArgs),
    NOTPLAYER(Inf.errColor + Inf.notPlayer),
    WRONGARGS(Inf.errColor + Inf.wrongArgs),
    VERSION(Inf.verColor + Inf.verString);

    private final String ChatMsg;

    ChatMsg(String ChatMsg) {
        this.ChatMsg = ChatMsg;
    }
}
