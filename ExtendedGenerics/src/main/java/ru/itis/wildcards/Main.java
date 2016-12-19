package ru.itis.wildcards;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        MyCollection<Integer> collection = new MyCollection<Integer>();
        collection.add(1);
        collection.add(2);
        collection.add(5);

        Number number = new Number() {
            @Override
            public int intValue() {
                return 0;
            }

            @Override
            public long longValue() {
                return 0;
            }

            @Override
            public float floatValue() {
                return 0;
            }

            @Override
            public double doubleValue() {
                return 0;
            }
        };

        MyCollection<Number> numberMyCollection1 = new MyCollection<Number>();
        numberMyCollection1.add(number);
        showAll(numberMyCollection1);
        // Integer и Number

        /**
        MyCollection<Number> numberMyCollection =
                new MyCollection<Integer>();

        **/

        // upper bound
        MyCollection<? extends Number> numberMyCollection =
                new MyCollection<Integer>();

        showAll(collection);

        // lower bound
        MyCollection<? super Integer> integerMyCollection =
                new MyCollection<Number>();

        integerMyCollection.add(new Integer(12));
        integerMyCollection.add(new Integer(12));

        Object o = integerMyCollection.get(1);
        Number n = (Number)integerMyCollection.get(2);

        addToCollection(10, numberMyCollection1);

    }

    public static void showAll(MyCollection<? extends Number> collection) {
        for (int i = 0; i < collection.getCount(); i++) {
            System.out.println(collection.get(i));
        }
    }

    public static void addToCollection(Integer integer,
                                       MyCollection<? super Integer> collection) {
        collection.add(integer);
    }
}
