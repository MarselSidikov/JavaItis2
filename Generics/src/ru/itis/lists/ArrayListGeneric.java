package ru.itis.lists;

// T - параметр типа, таким образом
// ArrayListGeneric - обобщенный, параметризированный
// класс
public class ArrayListGeneric<T> {
    private static final int MAX_SIZE = 10;
    private Object elements[];
    private int count;

    public ArrayListGeneric() {
        // this.elements = new T[MAX_SIZE]; - нельзя
        count = 0;
    }
    public void add(T element) {
        if (count <= MAX_SIZE) {
            this.elements[count] = element;
            count++;
        }
    }

    public T getByIndex(int index) {
        if (index <= count) {
            return (T)elements[index];
        } else return null;
    }
}
