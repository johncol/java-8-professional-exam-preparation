package java8professional.chapter07.livenessissues;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DeadLockExample {
    public static void main(String[] args) throws InterruptedException {
        Food food = new Food();
        Water water = new Water();
        Foxy foxy = new Foxy();
        Tails tails = new Tails();

        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(2);
            service.submit(() -> foxy.eatAndDrink(food, water));
            service.submit(() -> tails.drinkAndEat(food, water));
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }

        boolean finished = service.awaitTermination(10, TimeUnit.SECONDS);
        if (!finished) {
            System.out.println(LocalTime.now() + " " + "Deadlock! Foxy and Tails are being blocked by each other..");
            System.exit(-1);
        }
    }

}

class Food {}
class Water {}

class Fox {

    final String name;

    public Fox(String name) {
        this.name = name;
    }

    void move() {
        try {
            System.out.println(LocalTime.now() + " " + name + " moving..");
            Thread.sleep(2000);
            System.out.println(LocalTime.now() + " " + name + " waiting..");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Foxy extends Fox {

    Foxy() { super("Foxy"); }

    void eatAndDrink(Food food, Water water) {
        synchronized (food) {
            System.out.println(LocalTime.now() + " " + "Foxy eating food!");
            move();
            synchronized (water) {
                System.out.println(LocalTime.now() + " " + "Foxy drinking water!");
            }
        }
    }
}

class Tails extends Fox {

    Tails() { super("Tails"); }

    void drinkAndEat(Food food, Water water) {
        synchronized (water) {
            System.out.println(LocalTime.now() + " " + "Tails drinking water!");
            move();
            synchronized (food) {
                System.out.println(LocalTime.now() + " " + "Tails eating food!");
            }
        }
    }
}