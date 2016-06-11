package java8professional.chapter07.concurrentcollections.blocking;

import java.text.MessageFormat;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.*;

/**
 * Here I use BlockingQueue offer(E e, long timeout, TimeUnit unit) method
 * poll(long timeout, TimeUnit unit) works the same way, just returns null if no element is in the queue when the timeout is reached
 */
public class LinkedBlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {
        int queueCapacity = 2;
        System.out.println("Queue capacity: " + queueCapacity);

        BlockingQueue<String> queue = new LinkedBlockingQueue<>(queueCapacity);
        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        System.out.println("Queue: " + queue);

        byte waitTimeForRemoval = 2;
        removeLastElementAfterTimeout(queue, waitTimeForRemoval, SECONDS);

        byte waitTimeForInsertionAtMost = 5;
        System.out.println(MessageFormat.format("Lets wait {0} {1} at most to add another...", waitTimeForInsertionAtMost, SECONDS));
        queue.offer("bazillion", waitTimeForInsertionAtMost, SECONDS);
        System.out.println("Queue: " + queue);
    }

    static void removeLastElementAfterTimeout(BlockingQueue<String> queue, int waitTime, TimeUnit timeUnit) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            service.submit(() -> {
                try {
                    System.out.println(MessageFormat.format("Lets wait {0} {1} to remove the last element...", waitTime, timeUnit));
                    Thread.sleep(timeUnit.toMillis(waitTime));
                    String element = queue.poll();
                    System.out.println(MessageFormat.format("Element removed after {0} {1}: {2}", waitTime, timeUnit, element));
                    System.out.println("Queue: " + queue);
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
