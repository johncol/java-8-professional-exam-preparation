package java8professional.chapter07.executors.singlethread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

public class WaitingForAllTasksToFinish {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start!");
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            service.submit(() -> System.out.println(LongStream.rangeClosed(1, 1L).sum()));
            service.submit(() -> System.out.println(LongStream.rangeClosed(1, 1_000L).sum()));
            service.submit(() -> System.out.println(LongStream.rangeClosed(1, 1_000_000L).sum()));
            service.submit(() -> System.out.println(LongStream.rangeClosed(1, 1_000_000_000L).sum()));
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
        if (service != null) {
            service.awaitTermination(1, TimeUnit.SECONDS);
            System.out.println("All tasks finished: " + service.isTerminated());
        }
        System.out.println("End!");
    }
}
