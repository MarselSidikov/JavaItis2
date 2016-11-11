package ru.itis.interfaces;

public class AutoTransportInterfaceImpl implements TransportInterface {
    @Override
    public void go() {
        System.out.println("AUTO GO");
    }

    @Override
    public void stop() {
        System.out.println("AUTO STOP");
    }

    @Override
    public void breakDown() {
        System.out.println("AUTO BREAK");
    }
}
