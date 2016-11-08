package ru.itis;


public class BabushkaBatmen extends Babushka {
    private int countOfEnemies;

    public BabushkaBatmen(int age, String name, int countOfGrandchildren, int countOfEnemies) {
        super(age, name, countOfGrandchildren);
        this.countOfEnemies = countOfEnemies;
    }
    public void kill() {
        System.out.println("I KILL YOU!");
    }

    // переопределение - Override
    public void feedGrandchildren() {
        System.out.println("FEED AND KILL!!!!!!");
    }
}
