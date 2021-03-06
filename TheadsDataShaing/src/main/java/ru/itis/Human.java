package ru.itis;

public class Human extends Thread {
    private BonusCard bonusCard;
    private String who;

    public Human(BonusCard bonusCard, String who) {
        this.bonusCard = bonusCard;
        this.who = who;
    }

    public synchronized void shoppingWithBonuses(int bonuses) throws InterruptedException {
       // synchronized (bonusCard) {
            Thread.sleep(100);
            // если на карте остались бонусы
            // их хватает
            if (bonusCard.getBonuses() >= bonuses) {
                // говорим, что кто-то собрался покупать
                System.out.println(who + " is gonna" +
                        "buy something");
                // если все прошло успешно
                // говорим, что покупка удалась
                if (bonusCard.use(bonuses)) {
                    System.out.println(who + " bought " +
                            "something");
                }
            } else {
                System.out.println("Sorry, Honey, no money");
            }
    //    }
    }

    public void run() {
        for (int i = 0; i < 100; i++) {

            try {
                shoppingWithBonuses(7);
            } catch (InterruptedException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }
}
