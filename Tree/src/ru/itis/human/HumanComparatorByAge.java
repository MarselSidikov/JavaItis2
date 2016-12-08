package ru.itis.human;

import ru.itis.human.Human;

import java.util.Comparator;

public class HumanComparatorByAge implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getAge() - o2.getAge();
    }
}
