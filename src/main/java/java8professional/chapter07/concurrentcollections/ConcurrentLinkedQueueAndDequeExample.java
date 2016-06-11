package java8professional.chapter07.concurrentcollections;

import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueAndDequeExample {
    public static void main(String[] args) {
        queueTest();
        System.out.println();
        dequeTest();
    }

    static void queueTest() {
        Queue<String> queue = new ConcurrentLinkedQueue<>();
        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        System.out.println("Queue: " + queue);

        String notRemoved = queue.peek(); // if empty, returns null, with element() if empty throws exception
        System.out.println("notRemoved: " + notRemoved);
        System.out.println("Queue: " + queue);

        String removed = queue.poll(); // if empty, returns null, with element() if empty throws exception
        System.out.println("removed: " + removed);
        System.out.println("Queue: " + queue);
    }

    static void dequeTest() {
        Deque<String> deque = new ConcurrentLinkedDeque<>();
        deque.offer("one");
        deque.offer("two");
        deque.offer("three");
        deque.offer("four");
        deque.offer("five");
        System.out.println("Deque: " + deque);

        String notRemovedFirst = deque.peek(); // if empty, returns null, with element() if empty throws exception
        System.out.println("notRemoved first: " + notRemovedFirst);
        System.out.println("Deque: " + deque);

        String removedFirst = deque.poll(); // if empty, returns null, with element() if empty throws exception
        System.out.println("removed first: " + removedFirst);
        System.out.println("Deque: " + deque);

        String notRemovedLast = deque.peekLast(); // if empty, returns null, with element() if empty throws exception
        System.out.println("notRemoved first: " + notRemovedLast);
        System.out.println("Deque: " + deque);

        String removedLast = deque.pollLast(); // if empty, returns null, with element() if empty throws exception
        System.out.println("removed first: " + removedLast);
        System.out.println("Deque: " + deque);

        String first = deque.peekFirst();
        System.out.println("first: " + first);
        System.out.println("Deque: " + deque);

        String last = deque.peekLast();
        System.out.println("last: " + last);
        System.out.println("Deque: " + deque);

        deque.offerFirst("one again");
        System.out.println("Deque: " + deque);

        deque.offerLast("five again");
        System.out.println("Deque: " + deque);
    }
}
