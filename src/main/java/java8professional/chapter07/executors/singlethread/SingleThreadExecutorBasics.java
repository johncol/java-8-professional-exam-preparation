package java8professional.chapter07.executors.singlethread;

import java.text.NumberFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class SingleThreadExecutorBasics {

    public static void main(String[] args) {
        test2();
    }

    static void test1() {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("Start");

            service.execute(() -> System.out.println("Lambda runnable #1"));
            service.execute(() -> IntStream.rangeClosed(1, 5).limit(5).forEach(System.out::println));
            service.execute(() -> System.out.println("Lambda runnable #2"));

            System.out.println("End");
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }

    static void test2() {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            long limit = 1_000_000_000L;
            service.submit(() -> LongStream
                    .rangeClosed(1, limit)
                    .reduce((x, y) -> x + y)
                    .ifPresent(x -> System.out.println(NumberFormat.getInstance().format(x))));
            service.submit(() ->
                    System.out.println(NumberFormat.getInstance().format(LongStream.rangeClosed(1, limit).sum())));
        } finally {
            if (service != null) {
                System.out.println("Shutdown=" + service.isShutdown() + " Terminated=" + service.isTerminated());
                service.shutdownNow();
                System.out.println("Shutdown=" + service.isShutdown() + " Terminated=" + service.isTerminated());
            }
        }

        try {
            service.submit(() -> System.out.println("This won't be printed because the executor service was already shutdown"));
        } catch (RejectedExecutionException e) {
            System.out.println("RejectedExecutionException:\n " + e.getMessage());
        }

        try {
            Thread.sleep(5000);
            System.out.println("Shutdown=" + service.isShutdown() + " Terminated=" + service.isTerminated());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
