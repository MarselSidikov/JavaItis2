package ru.itis;

import ru.itis.abstarct.Auto;
import ru.itis.abstarct.Transport;
import ru.itis.interfaces.TransportInterface;
import ru.itis.multiineritance.Cooker;
import ru.itis.multiineritance.Human;
import ru.itis.multiineritance.Letuchaya;

public class Main {

    public static void main(String[] args) {
	    Transport transport;
        // transport = new Transport("A001AA", "GREEN");

        transport = new Auto("A001AA", "GREEN");

        transport = new Transport("A001AA", "GREEN") {
            @Override
            public void go() {
                System.out.println("ANONIM IMPLEMENT");
            }
        };

        System.out.println(transport.getClass().getName());

        TransportInterface transportInterface = new TransportInterface() {
            @Override
            public void go() {

            }

            @Override
            public void stop() {

            }

            @Override
            public void breakDown() {

            }
        };

        Human human = new Human();
        Letuchaya letuchaya = human;
        letuchaya.critic();
        Cooker cooker = human;
        cooker.cook();
    }
}
