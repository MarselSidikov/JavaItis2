package ru.itis.multiineritance;

public class Human implements Cooker, Letuchaya {
    @Override
    public void cook() {
        System.out.println("Human Cook");
    }

    @Override
    public void critic() {
        System.out.println("Human Critic");
    }
}
