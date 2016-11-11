package ru.itis.lists;

import ru.itis.model.A;

public class ArrayListA {
    private static final int MAX_SIZE = 10;
    private A elements[];
    private int count;

    public ArrayListA() {
        this.elements = new A[MAX_SIZE];
        count = 0;
    }
    public void add(A element) {
        if (count <= MAX_SIZE) {
            this.elements[count] = element;
            count++;
        }
    }

    public A getByIndex(int index) {
        if (index <= count) {
            return this.elements[index];
        } else return null;
    }
}
