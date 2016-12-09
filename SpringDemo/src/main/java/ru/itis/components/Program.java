package ru.itis.components;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.components.messages.CustomMessage;
import ru.itis.components.renders.MessageRenderer;

public class Program {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "ru.itis.components\\application-context.xml"
        );

        MessageRenderer renderer = (MessageRenderer)context.getBean("render");
        renderer.render();

        CustomMessage message = (CustomMessage)context.getBean("customMessage");
        System.out.println(message.getMessage());
        CustomMessage message1 = (CustomMessage)context.getBean("customMessage");
        message1.setMessage("Bye");

        System.out.println(message.getMessage());
        System.out.println(message1.getMessage());
    }
}
