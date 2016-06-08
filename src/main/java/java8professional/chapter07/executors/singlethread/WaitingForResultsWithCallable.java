package java8professional.chapter07.executors.singlethread;

import java.text.NumberFormat;
import java.util.concurrent.*;
import java.util.stream.LongStream;

public class WaitingForResultsWithCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("Start!");

            Future<Long> future = service.submit(() -> LongStream.rangeClosed(1, 1_000_000_000L).sum());
            long sum = future.get(1000, TimeUnit.MILLISECONDS);
            System.out.println("Sum: " + NumberFormat.getInstance().format(sum));

            System.out.println("End!");
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
