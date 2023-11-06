package org.trade4life.bot;

import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class ResponseHandler {
    private final SilentSender sender;

    public ResponseHandler(SilentSender sender) {
        this.sender = sender;
    }

    public void replyToStart(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("I'm alive (on Java)");
        sender.execute(message);
//        chatStates.put(chatId, AWAITING_NAME);
    }

}
