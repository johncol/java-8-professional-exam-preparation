package java8professional.all;

import java.util.concurrent.*;

public class ExecutorsService {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ScheduledExecutorService service = null;
        try {
            service.invokeAny(null);
            service.isShutdown();
            service.isTerminated();

            service.awaitTermination(1, TimeUnit.DAYS);
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
