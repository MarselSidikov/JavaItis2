package ru.itis.lists;

public class ArrayListObject {
    private static final int MAX_SIZE = 10;
    private Object elements[];
    private int count;

    public ArrayListObject() {
        this.elements = new Object[MAX_SIZE];
        count = 0;
    }
    public void add(Object element) {
        if (count <= MAX_SIZE) {
            this.elements[count] = element;
            count++;
        }
    }

    public Object getByIndex(int index) {
        if (index <= count) {
            return this.elements[index];
        } else return null;
    }
}
