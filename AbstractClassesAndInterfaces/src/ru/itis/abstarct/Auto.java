package ru.itis.abstarct;


public class Auto extends Transport{

    public Auto(String number, String color) {
        super(number, color);
    }

    @Override
    public void go() {
        System.out.println("GO");
    }
}
