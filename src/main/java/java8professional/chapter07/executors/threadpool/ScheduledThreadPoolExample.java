package java8professional.chapter07.executors.threadpool;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class ScheduledThreadPoolExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService service = null;
        try {
            service = Executors.newScheduledThreadPool(3);

            List<Runnable> tasks = DoubleStream.generate(Math::random)
                    .limit(3)
                    .mapToObj(x -> ((Runnable)() -> System.out.println(x)))
                    .collect(Collectors.toList());

            ScheduledFuture<?> aFuture = null;
            for (Runnable task : tasks) {
                aFuture = service.scheduleAtFixedRate(task, 500, 1000, TimeUnit.MILLISECONDS);
            }
            aFuture.get(8, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            System.out.println("End!!");
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
