package ru.itis;

import static ru.itis.VolatileExample.MY_INT;

public class ChangeListener extends Thread {
    public void run() {
        int localValue = MY_INT;

        while (localValue < 5) {
            if (localValue != MY_INT) {
                System.out.println("Got change for MY_INT: " + MY_INT);
                localValue = MY_INT;
            }
        }
    }

}
