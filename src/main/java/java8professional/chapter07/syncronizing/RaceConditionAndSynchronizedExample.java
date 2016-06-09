package java8professional.chapter07.syncronizing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionAndSynchronizedExample {
    public static void main(String[] args) {
        SheepManager sheepManager = new ImprovedSynchronizedSheepManager();
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(3);
            for (int i = 0; i < 20; i++) {
                service.submit(() -> sheepManager.incrementAndReport());
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}

interface SheepManager {
    void incrementAndReport();
}

class PrimitiveSheepManager implements SheepManager {
    private int count;
    public void incrementAndReport() {
        System.out.print(++count + "-");
    }
}

class AtomicSheepManager implements SheepManager {
    private AtomicInteger count = new AtomicInteger();
    public void incrementAndReport() {
        System.out.print(count.incrementAndGet() + "-");
    }
}

/**
 * Uses a synchronized block
 */
class SynchronizedSheepManager implements SheepManager {
    private int count;
    public void incrementAndReport() {
        synchronized(this) {
            System.out.print(++count + "-");
        }
    }
}

/**
 * Uses a synchronized method
 */
class ImprovedSynchronizedSheepManager implements SheepManager {
    private int count;
    public synchronized void incrementAndReport() {
        System.out.print(++count + "-");
    }
}

/**
 * Synchronized static method
 */
class StaticSheepManager {
    private static int count;
    public static synchronized void incrementAndReport() {
        System.out.print(++count + "-");
    }
}