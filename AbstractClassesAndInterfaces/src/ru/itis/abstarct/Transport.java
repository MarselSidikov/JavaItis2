package ru.itis.abstarct;

// абстрактный класс, это класс в котором хотя бы
// один метод абстрактный
// абстрактный метод - метод без реализации
public abstract class Transport {
    private String number;
    private String color;

    public Transport(String number, String color) {
        this.number = number;
        this.color = color;
    }

    public void killAll() {
        System.out.println("KILL ALL");
    }

    public abstract void go();
}
