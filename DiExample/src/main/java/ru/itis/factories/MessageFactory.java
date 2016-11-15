package ru.itis.factories;

import ru.itis.Message;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// ПАТТЕРН - СИНГЛТОН - объект, который гарантированно
// существует в единственном экзмепляре
public class MessageFactory {
    // поле, которое хранит единственный экземпляр
    private static MessageFactory instance;

    private Message message;

    private Properties properties;

    static {
        instance = new MessageFactory();
    }

    private MessageFactory() {
        properties = new Properties();
        try {
            properties.load(new
                    FileInputStream("C:\\Users\\admin.WIN-IPM3OA3VQNQ\\Desktop\\JAVA\\JavaItis2\\DiExample\\src\\main\\resources\\components.properties"));

            String messageClassName = properties.getProperty("message.class");

            this.message = (Message)Class.forName(messageClassName).newInstance();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    public Message getMessage() {
        return message;
    }

    public static MessageFactory getInstance() {
        return instance;
    }
}
