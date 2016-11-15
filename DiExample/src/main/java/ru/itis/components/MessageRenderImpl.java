package ru.itis.components;

import ru.itis.Message;
import ru.itis.MessageRenderer;

public class MessageRenderImpl implements MessageRenderer {

    private Message message;

    public MessageRenderImpl(Message message) {
        this.message = message;
    }

    public void render() {
        System.out.println(message.getMessage());
    }
}
