package ru.itis.components;

import ru.itis.Message;
import ru.itis.MessageRenderer;

public class MessageRenderHatefulImpl implements MessageRenderer {

    private Message message;

    public MessageRenderHatefulImpl(Message message) {
        this.message = message;
    }

    public void render() {
        System.out.println("inno and sberteh is bad " + message.getMessage());
    }
}
