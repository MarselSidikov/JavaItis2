package ru.itis;

public class ContainingLongRunningMethodClass {
    // метод случайным образом задерживает главный поток
    public void longLoop() {
        try {
            int delay = (int) (Math.random() * 10);
            System.out.println("longLoop: Delay time : " + delay);
            Thread.sleep(delay * 1000);
        } catch (InterruptedException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void veryLongLoop() {
        try {
            int delay = (int) (Math.random() * 100);
            System.out.println("VeryLongLoop: Delay time : " + delay);
            Thread.sleep(delay * 1000);
        } catch (InterruptedException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void forErrors() {
        // throw new IllegalArgumentException("SOME ERROR");
    }
}
