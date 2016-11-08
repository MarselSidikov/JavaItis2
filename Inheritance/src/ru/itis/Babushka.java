package ru.itis;

public class Babushka {
    protected int age;
    protected String name;
    protected int countOfGrandchildren;

    public Babushka(int age, String name, int countOfGrandchildren) {
        this.age = age;
        this.name = name;
        this.countOfGrandchildren = countOfGrandchildren;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getCountOfGrandchildren() {
        return countOfGrandchildren;
    }

    public void feedGrandchildren() {
        System.out.println("FEED!!!!!!");
    }
}
