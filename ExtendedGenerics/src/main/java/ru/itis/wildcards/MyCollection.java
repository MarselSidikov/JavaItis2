package ru.itis.wildcards;

import java.util.ArrayList;

public class MyCollection<T> {
    private final static int MAX_SIZE = 5;

    private Object[] elements;

    public int getCount() {
        return count;
    }

    private int count;

    public MyCollection() {
        elements = new Object[MAX_SIZE];
        count = 0;
    }

    public void add(T element) {
        if (count < MAX_SIZE) {
            elements[count] = element;
            count++;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public T get(int index) {
        if (index < count) {
            return (T)elements[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
