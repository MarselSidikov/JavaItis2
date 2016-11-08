package ru.itis;

public class Main {

    public static void main(String[] args) {
        Babushka babushka = new Babushka(91, "Klava", 7);

        babushka.feedGrandchildren();

        BabushkaBatmen babushkaBatmen = new BabushkaBatmen(120, "BATMAN BABUSHK", 10, 90);

        babushkaBatmen.kill();

        // восходящее преобразование
        Babushka babushka1 = new BabushkaBatmen(120, "BATMAN BABUSHK", 10, 90);
        babushka1.feedGrandchildren();

        /**
        BabushkaBatmen babushkaBatmen1 = (BabushkaBatmen)new Babushka(120, "BATMAN BABUSHK", 10);
        babushkaBatmen1.feedGrandchildren();
         **/

        Babushka babushks[] = new Babushka[3];
        babushks[0] = new Babushka(120, "BATMAN BABUSHK", 10);
        babushks[1] = new BabushkaBatmen(120, "BATMAN BABUSHK", 10, 90);
        babushks[2] = new Babushka(120, "BATMAN BABUSHK", 10);

        for (int i = 0; i < babushks.length; i++) {
            babushks[i].feedGrandchildren();
        }
    }
}
