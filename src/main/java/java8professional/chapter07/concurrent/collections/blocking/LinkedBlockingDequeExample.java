package java8professional.chapter07.concurrent.collections.blocking;

import java.text.MessageFormat;
import java.util.concurrent.*;

import static java.time.LocalTime.*;
import static java.util.concurrent.TimeUnit.SECONDS;

public class LinkedBlockingDequeExample  {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<String> deque = new LinkedBlockingDeque<>();
        System.out.println(MessageFormat.format("{1} Deque: {0}", deque, now()));

        byte waitTimeForInsertion = 2;
        insertElementAfterTimeout(deque, "football", waitTimeForInsertion, SECONDS);

        byte waitTimeForRemovalAtMost = 5;
        System.out.println(MessageFormat.format("{2} Lets wait {0} {1} at most to get one element...", waitTimeForRemovalAtMost, SECONDS, now()));
        String first = deque.pollFirst(waitTimeForRemovalAtMost, SECONDS);
        System.out.println(MessageFormat.format("{1} Element retrieved from the head of the deque: {0}", first, now()));
        System.out.println(MessageFormat.format("{1} Deque: {0}", deque, now()));
    }

    static void insertElementAfterTimeout(BlockingDeque<String> deque, String element, byte waitTime, TimeUnit timeUnit) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            service.submit(() -> {
                try {
                    System.out.println(MessageFormat.format("{2} Lets wait {0} {1} to insert one element...", waitTime, timeUnit, now()));
                    Thread.sleep(timeUnit.toMillis(waitTime));
                    deque.offerLast(element);
                    System.out.println(MessageFormat.format("{3} Element added after {0} {1}: {2}", waitTime, timeUnit, element, now()));
                    System.out.println(MessageFormat.format("{1} Deque: {0}", deque, now()));
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException!");
                };
            });
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
