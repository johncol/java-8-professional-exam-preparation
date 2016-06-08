package java8professional.chapter07.executors.threadpool;

import java.text.NumberFormat;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class CachedAndFixedThreadPoolExample {

    static final NumberFormat FORMATTER = NumberFormat.getInstance();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LocalTime start;
        LocalTime end;
        ExecutorService service = null;
        try {
            // service = Executors.newFixedThreadPool(5);
            service = Executors.newCachedThreadPool();

            List<Callable<Long>> tasks = new ArrayList<>();
            tasks.add(() -> LongStream.rangeClosed(            1L, 1_000_000_000L).sum());
            tasks.add(() -> LongStream.rangeClosed(1_000_000_001L, 2_000_000_000L).sum());
            tasks.add(() -> LongStream.rangeClosed(2_000_000_001L, 3_000_000_000L).sum());
            tasks.add(() -> LongStream.rangeClosed(3_000_000_001L, 4_000_000_000L).sum());

            start = LocalTime.now();
            List<Future<Long>> futures1 = tasks.stream().map(service::submit).collect(Collectors.toList());
            printResults(futures1);
            end = LocalTime.now();
            printDiff(ChronoUnit.MILLIS, start, end);

            System.out.println();

            start = LocalTime.now();
            List<Future<Long>> futures2 = service.invokeAll(tasks);
            printResults(futures2);
            end = LocalTime.now();
            printDiff(ChronoUnit.MILLIS, start, end);
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }

    static void printResults(List<Future<Long>> futures) throws InterruptedException, ExecutionException {
        for (Future<Long> future : futures) {
            System.out.println("Result: " + FORMATTER.format(future.get()));
        }
    }

    static void printDiff(ChronoUnit chronoUnit, LocalTime start, LocalTime end) {
        System.out.println(chronoUnit + ": " + FORMATTER.format(chronoUnit.between(start, end)));
    }
}
