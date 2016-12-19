package ru.itis.methods;

public class Main {

    public static <T> T someMethod(T a, T b) {
        return a;
    }

    public static <T, E> T someMethod2(T a, E b) {
        return a;
    }

    public static void main(String[] args) {
        Integer i1 = 193;
        Integer i2 = 193;

        Integer result = someMethod(i1, i2);
        // String  stringResult = someMethod(i1, i2);
        String stringResult = someMethod("Hello", "My friend");
        stringResult = someMethod2("Hello", 1);
        result = someMethod2(1, "Hello");
        result = someMethod2(1, 1);
        // stringResult = someMethod2(1, "Result");
    }
}
