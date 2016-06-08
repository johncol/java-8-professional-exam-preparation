package java8professional.chapter07.executors.singlethread;

import java.text.NumberFormat;
import java.time.LocalTime;
import java.util.concurrent.*;
import java.util.stream.LongStream;

public class SchedulingTasks {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        System.out.println("SCHEDULE TASK ONE TIME:");
        scheduleTaskOneTime();
        System.out.println();

        System.out.println("SCHEDULE TASK MANY TIMES:");
        scheduleTaskManyTimes();
    }

    static void scheduleTaskOneTime() throws InterruptedException, ExecutionException {
        ScheduledExecutorService service = null;
        try {
            service = Executors.newSingleThreadScheduledExecutor();

            Callable<Long> sum = () -> LongStream.rangeClosed(1, 1_000_000L).sum();
            ScheduledFuture<Long> scheduledFuture = service.schedule(sum, 3, TimeUnit.SECONDS);

            System.out.println("Delay in millis: " + scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
            System.out.println("Delay in seconds: " + scheduledFuture.getDelay(TimeUnit.SECONDS));
            System.out.println("Delay in minutes: " + scheduledFuture.getDelay(TimeUnit.MINUTES));

            String result = NumberFormat.getInstance().format(scheduledFuture.get());
            System.out.println("Result: " + result);
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }

    static void scheduleTaskManyTimes() throws InterruptedException, ExecutionException, TimeoutException {
        ScheduledExecutorService service = null;
        try {
            service = Executors.newSingleThreadScheduledExecutor();

            Runnable task = () -> System.out.println(LocalTime.now());

            System.out.println(LocalTime.now());
            ScheduledFuture<?> scheduledFuture = service.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);
            Object result = scheduledFuture.get(10, TimeUnit.SECONDS);
            System.out.println(result);
        } catch(TimeoutException e) {
            System.out.println("End of scheduled task!");
        } finally {
            if (service!= null) {
                service.shutdown();
            }
        }
        System.out.println("Continue your journey...");
    }
}
