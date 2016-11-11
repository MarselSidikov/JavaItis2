package ru.itis.generics.methods;

import ru.itis.model.*;

public class Main {

    public static <T extends B> void show(T x, T y) {
        x.show();
        y.show();
    }

    public static <T> void someDoing(T a, T y) {
        System.out.println(a);
        System.out.println(y);
    }

    public static void main(String[] args) {
        C c = new C();
        D d = new D();

        show(c, d);

        F f = new F();

        P a = new P();
        a.value = 10;
        P b = new P();
        b.value = 12;

        // show(f, c);

        someDoing(a, f);
    }

}
