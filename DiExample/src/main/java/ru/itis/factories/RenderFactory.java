package ru.itis.factories;

import ru.itis.Message;
import ru.itis.MessageRenderer;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class RenderFactory {
    // поле, которое хранит единственный экземпляр
    private static RenderFactory instance;

    private MessageRenderer renderer;

    private Properties properties;

    static {
        instance = new RenderFactory();
    }

    private RenderFactory() {
        properties = new Properties();
        try {
            properties.load(new
                    FileInputStream("C:\\Users\\admin.WIN-IPM3OA3VQNQ\\Desktop\\JAVA\\JavaItis2\\DiExample\\src\\main\\resources\\components.properties"));

            String renderClassName = properties.getProperty("render.class");

            Class renderClass = Class.forName(renderClassName);

            Constructor constructor = renderClass.getConstructor(Message.class);

            Message message = MessageFactory.INSTANCE.getMessage();

            this.renderer = (MessageRenderer)constructor.newInstance(message);

        } catch (IOException e) {
            throw new IllegalStateException(e);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        } catch (InvocationTargetException e) {
            throw new IllegalStateException(e);
        }
    }

    public MessageRenderer getRender() {
        return renderer;
    }

    public static RenderFactory getInstance() {
        return instance;
    }
}
