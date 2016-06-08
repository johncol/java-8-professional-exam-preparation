package java8professional.chapter07.executors.singlethread;

import java.util.concurrent.*;
import java.util.stream.LongStream;

public class WaitingForResultsWIthRunnable {

    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("Start");
            System.out.println("--------------------------");

            Future<?> future = service.submit(() ->
                    System.out.println("Sum: " + LongStream.rangeClosed(1, 1_000_000_000L).sum()));

            Object result = future.get(3, TimeUnit.SECONDS);
            System.out.println("Result: " + result);

            System.out.println("Done:               " + future.isDone());
            System.out.println("Cancelled:          " + future.isCancelled());
            System.out.println("Success cancelling: " + future.cancel(true));
            System.out.println("Done:               " + future.isDone());
            System.out.println("Cancelled:          " + future.isCancelled());

            System.out.println("--------------------------");
            System.out.println("End");
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }

}
