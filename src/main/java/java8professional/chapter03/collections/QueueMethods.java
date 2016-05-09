package java8professional.chapter03.collections;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueMethods {

    public static void main(String[] args) {

        // FIFO
        // offer to insert
        // peek to see but not remove it
        // poll to remove
        arrayDequeAsQueue();

        System.out.println("----------------------------------");

        // LIFO
        // push to insert
        // peek to see but not remove it
        // poll to remove
        arrayDequeAsStack();

    }

    private static void arrayDequeAsQueue() {
        Queue<Integer> queue = new ArrayDeque<>();
        System.out.println(queue);

        System.out.println(queue.offer(1));
        System.out.println(queue);

        System.out.println(queue.offer(2));
        System.out.println(queue);

        System.out.println(queue.offer(3));
        System.out.println(queue);

        System.out.println();

        System.out.println(queue.peek());
        System.out.println(queue);

        System.out.println(queue.peek());
        System.out.println(queue);

        System.out.println();

        System.out.println(queue.poll());
        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue);

        System.out.println(queue.peek());
        System.out.println(queue);
    }

    private static void arrayDequeAsStack() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        System.out.println(queue);

        queue.push(1);
        System.out.println(queue);

        queue.push(2);
        System.out.println(queue);

        queue.push(3);
        System.out.println(queue);

        System.out.println();

        System.out.println(queue.peek());
        System.out.println(queue);

        System.out.println(queue.peek());
        System.out.println(queue);

        System.out.println();

        System.out.println(queue.poll());
        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue);

        System.out.println(queue.peek());
        System.out.println(queue);
    }
}
