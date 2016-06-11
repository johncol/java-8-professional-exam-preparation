package java8professional.chapter07.concurrentcollections.blocking.implementations;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public interface MyBlockingQueue<E> {
    boolean offer(E e, long timeout, TimeUnit timeUnit)
            throws InterruptedException;
    E poll(long timeout, TimeUnit timeUnit)
            throws InterruptedException;
}
