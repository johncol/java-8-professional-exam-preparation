package java8professional.chapter07.concurrentprocesses.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WithCyclicBarrierExample {

    public static final int WORKERS = 4;

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(WORKERS);
            CyclicBarrier waitForTheAnimalsToBeOut = new CyclicBarrier(4);
            CyclicBarrier waitForThePenToBeCleaned = new CyclicBarrier(4, () -> System.out.println("The pen was cleaned!"));
            LionPenManager2 lionPenManager = new LionPenManager2();
            for (int i = 0; i < WORKERS; i++) {
                service.submit(() -> lionPenManager.performTask(waitForTheAnimalsToBeOut, waitForThePenToBeCleaned));
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}

class LionPenManager2 {

    private void removeAnimals() { System.out.println("Removing animals"); }
    private void cleanPen() { System.out.println("Cleaning the pen"); }
    private void addAnimals() { System.out.println("Adding animals"); }

    public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
        try {
            removeAnimals();
            c1.await();
            cleanPen();
            c1.await();
            addAnimals();
        } catch (BrokenBarrierException | InterruptedException e) {
            System.out.println(e.getClass().getSimpleName() + " -> " + e.getMessage());
        }
    }
}