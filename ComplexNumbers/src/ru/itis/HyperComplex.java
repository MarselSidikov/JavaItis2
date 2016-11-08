package ru.itis;

public class HyperComplex extends Complex {
    private double c;

    public HyperComplex(double a, double b, double c) {
        super(a, b);
        this.c = c;
    }

    public double getC() {
        return c;
    }

    public double calcModule() {
        return Math.sqrt(a*a + b*b + c*c);
    }

    public String toString() {
        return this.a + " + " + b + "i" + " + " + c + "j";
    }
}
