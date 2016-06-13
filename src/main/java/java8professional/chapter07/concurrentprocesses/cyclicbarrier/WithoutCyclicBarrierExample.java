package java8professional.chapter07.concurrentprocesses.cyclicbarrier;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WithoutCyclicBarrierExample {

    public static final int WORKERS = 4;

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(WORKERS);
            LionPenManager1 lionPenManager = new LionPenManager1();
            for (int i = 0; i < WORKERS; i++) {
                service.submit(() -> lionPenManager.performTask());
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}

class LionPenManager1 {

    private void removeAnimals() { System.out.println("Removing animals"); }
    private void cleanPen() { System.out.println("Cleaning the pen"); }
    private void addAnimals() { System.out.println("Adding animals"); }

    public void performTask() {
        removeAnimals();
        cleanPen();
        addAnimals();
    }
}