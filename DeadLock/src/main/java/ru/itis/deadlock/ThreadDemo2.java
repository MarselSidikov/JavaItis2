package ru.itis.deadlock;


public class ThreadDemo2 extends Thread {
    public void run() {
        synchronized (TestThread.Lock2) {
            System.out.println("Thread2: Holding lock2");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }

            System.out.println("Thread2 waiting for lock1");

            synchronized (TestThread.Lock1) {
                System.out.println("Thread2: holding lock1 & lock2");
            }
        }

    }

}
