package ru.itis;

public class ToBeDecorated {
    public void randomSleep() {
        try {
            int delay = (int) (Math.random() * 10);
            System.out.println("longLoop: Delay time : " + delay);
            Thread.sleep(delay * 1000);
        } catch (InterruptedException e) {
            throw new IllegalArgumentException(e);
        }
    }

    // Мы хотим отслеживать только printInteger
    // при этом только тогда, когда аргумент больше 10
    public void printInteger(int n) {
        System.out.println("method printInteger: " + n);
    }
}
