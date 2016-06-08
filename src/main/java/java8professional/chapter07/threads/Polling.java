package java8professional.chapter07.threads;

import java.util.stream.IntStream;

public class Polling {

    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        //PollingWithoutSleep.poll();
        PollingWithSleep.poll();
    }
}

class PollingWithoutSleep {

    static void poll() {
        Thread thread = new Thread(() -> IntStream.rangeClosed(1, 500).forEach((x) -> Polling.counter++));
        thread.start();

        while (Polling.counter < 100) {
            System.out.println("not reached yet");
        }
        System.out.println("reached!");
    }
}

class PollingWithSleep {

    static final long REST_TIME = 100;

    static void poll() throws InterruptedException {
        Thread thread = new Thread(() -> IntStream.rangeClosed(1, 500).forEach((x) -> Polling.counter++));
        thread.start();

        while (Polling.counter < 100) {
            System.out.println("not reached yet");
            Thread.sleep(REST_TIME);
        }
        System.out.println("reached!");
    }
}
