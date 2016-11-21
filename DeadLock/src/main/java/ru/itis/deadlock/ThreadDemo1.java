package ru.itis.deadlock;


public class ThreadDemo1 extends Thread {
    public void run() {
        synchronized (TestThread.Lock1) {
            System.out.println("Thread1: Holding lock1");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }

            System.out.println("Thread1 waiting for lock2");

            synchronized (TestThread.Lock2) {
                System.out.println("Thread1: holding lock1 & lock2");
            }
        }

    }

}
