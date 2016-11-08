package ru.itis;

public class Main {
    public static void main(String[] args) {
        Complex a = new Complex(3, 4);
        Complex b = new Complex(2, 1);
        HyperComplex c = new HyperComplex(3, 2, 1);
        HyperComplex d = new HyperComplex(1, 2, 3);

        Complex numbers[] = {a, b, c, d};

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i].calcModule());
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
