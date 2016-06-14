package java8professional.chapter07.chaptertest;

import java.util.Arrays;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ChapterTest {
    {
        Executors.newSingleThreadExecutor();
        Executors.newSingleThreadScheduledExecutor();

        Executors.newFixedThreadPool(10);
        Executors.newScheduledThreadPool(10);

        Executors.newCachedThreadPool();

        Runnable runnable = new Runnable() {
            public void run() {
            }
        };

        Callable<String> callable = new Callable<String>() {
            public String call() throws Exception {
                return null;
            }
        };

        // the atomic classes are located in the java.lang.concurrent.atomic package
        new java.util.concurrent.atomic.AtomicInteger();

        // IF the stream is of type T
        // AND the identity is of type U
        // THEN the accumulator is a BiFunction<U, T, U>
        // AND the combiner a BinaryOperator<U>
        Arrays.asList("a", "bb", "ccc").stream()
                .reduce(0, (total, string) -> total + string.length(), (t1, t2) -> t1 + t2);

        // They all throw an InterruptedException:
        //  - offer(E e, long timeout, TimeUnit timeUnit)
        //  - offerLast(E e, long timeout, TimeUnit timeUnit)
        //  - offerFirst(E e, long timeout, TimeUnit timeUnit)
        //  - poll(long timeout, TimeUnit timeUnit)
        //  - pollFirst(long timeout, TimeUnit timeUnit)
        //  - pollLast(long timeout, TimeUnit timeUnit)
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        try {
            queue.offer("a", 1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // IF a ExecutorService is not shutdown, THEN the application will never end, will run indefinitely
        // remember to look for:
        ExecutorService service = null;
        try {
            service = Executors.newCachedThreadPool();
            service.submit(() -> System.out.println("13"));
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }




    }
}
