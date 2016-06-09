package java8professional.chapter07.syncronizing;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLongArray;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class AtomicClasses {
    public static void main(String[] args) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        System.out.println(atomicBoolean.get());
        atomicBoolean.set(false);
        System.out.println(atomicBoolean);
        System.out.println();

        AtomicInteger atomicInteger = new AtomicInteger(100);
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.addAndGet(49));
        System.out.println(atomicBoolean);
        System.out.println();

        AtomicLong atomicLong = new AtomicLong(10000);
        System.out.println(atomicBoolean.get());
        System.out.println(atomicLong.getAndAdd(-1000));
        System.out.println(atomicLong);
        System.out.println(atomicLong.getAndSet(3000));
        System.out.println(atomicLong.get());
        System.out.println();
    }
}
