package java8professional.chapter07.concurrent.collections.blocking.implementations;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

public interface MyBlockingDeque<E> extends MyBlockingQueue<E> {
    boolean offerFirst(E e, long timeout, TimeUnit timeUnit)
            throws InterruptedException;
    boolean offerLast(E e, long timeout, TimeUnit timeUnit)
            throws InterruptedException;
    E pollFirst(long timeout, TimeUnit timeUnit)
            throws InterruptedException;
    E pollLast(long timeout, TimeUnit timeUnit)
            throws InterruptedException;
}
