package java8professional.chapter07.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("Start");

            service.execute(() -> System.out.println("Lambda runnable #1"));

            service.execute(() ->
                    IntStream.rangeClosed(1, 5).limit(5).forEach(System.out::println)
            );

            service.execute(() -> System.out.println("Lambda runnable #2"));

            System.out.println("End");
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
