package com.jetpacker06.CreateBrokenBad;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

import java.text.MessageFormat;

public class FakeChat {
    public static void SendFakeChat(ServerPlayer target, String msg) {
        var chatMsg = Component.literal(MessageFormat.format("<{0}> {1}", target.getName().getString(), msg));
        var players = target.getServer().getPlayerList().getPlayers();
        for (var p : players) {
            p.sendSystemMessage(chatMsg);
        }
    }
}
