package ru.itis;

public class BabushkaBatmanComposition {
    private Babushka babushka;

    public BabushkaBatmanComposition() {
        babushka = new Babushka(91, "Klava", 7);
    }

    public void feed() {
        babushka.feedGrandchildren();
    }
}
