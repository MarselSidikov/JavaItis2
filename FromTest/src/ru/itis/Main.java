package ru.itis;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // List<A> list = new ArrayList<B>(); потому что ArrayList<B>  не потомок List<A>
        List<?> list = new ArrayList<A>();
        ArrayList<?> list1 = new ArrayList<A>();
        // ArrayList<A> list2 = new ArrayList<B>();
        List<? extends A> list2 = new ArrayList<B>();
        List<? extends A> list3 = new ArrayList<A>();
        List<? super B> list4 = new ArrayList<A>();
    }
}
