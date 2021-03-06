package ru.itis.undeadlock;


import static ru.itis.undeadlock.TestThread.Lock1;
import static ru.itis.undeadlock.TestThread.Lock2;

public class ThreadDemo2 extends Thread {
    public void run() {
        synchronized (Lock1) {
            System.out.println("Thread2: Holding lock1");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }

            System.out.println("Thread2 waiting for lock2");

            synchronized (Lock2) {
                System.out.println("Thread2: holding lock1 & lock2");
            }
        }

    }

}
