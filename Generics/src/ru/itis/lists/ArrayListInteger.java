package ru.itis.lists;

public class ArrayListInteger {
    private static final int MAX_SIZE = 10;
    private int elements[];
    private int count;

    public ArrayListInteger() {
        this.elements = new int[MAX_SIZE];
        count = 0;
    }
    public void add(int element) {
        if (count <= MAX_SIZE) {
            this.elements[count] = element;
            count++;
        }
    }

    public int getByIndex(int index) {
        if (index <= count) {
            return this.elements[index];
        } else return -1;
    }
}
