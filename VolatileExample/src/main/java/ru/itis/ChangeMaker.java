package ru.itis;

import java.beans.IntrospectionException;

import static ru.itis.VolatileExample.MY_INT;

public class ChangeMaker extends Thread {
    public void run() {
        int localValue = MY_INT;

        while (MY_INT < 5) {
            System.out.println("Incrementing MY_INT to " + (localValue + 1));
            MY_INT = ++localValue;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

        }

    }
}
