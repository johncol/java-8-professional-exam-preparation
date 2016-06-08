package java8professional.chapter07.threads;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class CommonWaysOfCreatingAThread {
    public static void main(String[] args) {
        Set<Thread> threads = new HashSet<>();
        threads.add(new ThreadExample());
        threads.add(new Thread(new RunnableExample()));
        threads.add(new Thread(() ->
                IntStream.rangeClosed(1, 5).forEach(x -> System.out.println("Lambda runnable " + x))));
        threads.forEach(Thread::start);
    }
}

class RunnableExample implements Runnable {
    @Override
    public void run() {
        IntStream.rangeClosed(1, 5).forEach(x -> System.out.println("Runnable " + x));
    }
}

class ThreadExample extends Thread {
    @Override
    public void run() {
        IntStream.rangeClosed(1, 5).forEach(x -> System.out.println("Thread " + x));
    }
}