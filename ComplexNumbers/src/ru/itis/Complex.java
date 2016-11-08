package ru.itis;

public class Complex {
    protected double a;
    protected double b;

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double calcModule() {
        return Math.sqrt(a * a + b * b);
    }

    public String toString() {
        return this.a + " + " + b + "i";
    }
}
