package ru.itis.generics.types;

import ru.itis.lists.ArrayListA;
import ru.itis.lists.ArrayListGeneric;
import ru.itis.lists.ArrayListInteger;
import ru.itis.lists.ArrayListObject;
import ru.itis.model.A;

public class Main {

    public static void main(String[] args) {
        ArrayListInteger arrayListInteger = new ArrayListInteger();
        arrayListInteger.add(4);
        arrayListInteger.add(5);
        arrayListInteger.add(1);

        int elementFromList = arrayListInteger.getByIndex(2);

        System.out.println(elementFromList);

        ArrayListA arrayListA = new ArrayListA();

        arrayListA.add(new A());
        arrayListA.add(new A());
        arrayListA.add(new A());

        A a = arrayListA.getByIndex(2);

        a.showSomeMessage();

        ArrayListObject arrayListObjectOfIntegers = new ArrayListObject();
        arrayListObjectOfIntegers.add(12);
        arrayListObjectOfIntegers.add(10);

        int numberFromObjectList = (int)arrayListObjectOfIntegers.getByIndex(1);

        ArrayListObject arrayListObjectOfA = new ArrayListObject();
        arrayListObjectOfA.add(new A());
        arrayListObjectOfA.add(new A());

        A aFromObjectList = (A)arrayListObjectOfA.getByIndex(1);

        aFromObjectList.showSomeMessage();

        ArrayListObject list = new ArrayListObject();
        list.add(12);
        list.add(new A());

        int intElement = (int)list.getByIndex(0);
        A aElement = (A)list.getByIndex(1);

        System.out.println(intElement);
        aElement.showSomeMessage();

        intElement = (int)list.getByIndex(1);
        aElement = (A)list.getByIndex(0);

        ArrayListGeneric<A> aArrayListGeneric = new ArrayListGeneric<>();
        aArrayListGeneric.add(new A());
        a = aArrayListGeneric.getByIndex(0);
        // aArrayListGeneric.add(5);

        ArrayListGeneric<Integer> integerArrayListGeneric = new ArrayListGeneric<>();
        integerArrayListGeneric.add(10);

    }
}
