package ru.itis;

import ru.itis.factories.RenderFactory;

public class Program {
    public static void main(String[] args) {
        MessageRenderer render = RenderFactory.getInstance().getRender();
        render.render();
    }
}
