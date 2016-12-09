package ru.itis.components;

import ru.itis.Message;
import ru.itis.MessageRenderer;

public class MessageRenderLovelyImpl implements MessageRenderer {
    private Message message;

    public MessageRenderLovelyImpl(Message message) {
        this.message = message;
    }
    public void render() {
        System.out.println("<3 " + message.getMessage());
    }
}
