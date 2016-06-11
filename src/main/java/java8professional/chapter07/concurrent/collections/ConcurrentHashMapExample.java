package java8professional.chapter07.concurrent.collections;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class ConcurrentHashMapExample {

    public static void main(String[] args) throws InterruptedException {
        Map<String, Integer> zoo = new ConcurrentHashMap<>();
        zoo.put("zebras", 10);
        zoo.put("elephants", 100);
        zoo.put("cats", 1_000);
        zoo.put("dogs", 10_000);
        zoo.put("birds", 100_000);

        Callable<Integer> removeZebras = createAnimalsRemovalTask(zoo, "zebras");
        Callable<Integer> removeElephants = createAnimalsRemovalTask(zoo, "elephants");
        Callable<Integer> removeBirds = createAnimalsRemovalTask(zoo, "birds");
        List<Callable<Integer>> tasks = Arrays.asList(removeZebras, removeElephants, removeBirds);

        List<Future<Integer>> animalsRemoved;
        ExecutorService service = null;
        try {
            service = Executors.newCachedThreadPool();
            System.out.println("Zoo initial state: " + zoo);

            animalsRemoved = service.invokeAll(tasks);
        } finally {
            if (service!= null) {
                service.shutdownNow();
            }
        }

        service.awaitTermination(20, TimeUnit.SECONDS);
        System.out.println("Zoo ending state: " + zoo);

        int totalAnimalsRemoved = animalsRemoved.stream().map(f -> {
            try { return f.get(); }
            catch (ExecutionException | InterruptedException e) { return 0; }
        }).mapToInt(x -> x).sum();
        System.out.println(MessageFormat.format("Total animals removed from zoo: {0}", totalAnimalsRemoved));
    }

    static Callable<Integer> createAnimalsRemovalTask(Map<String, Integer> zoo, String animal) {
        return () -> {
            Integer quantity = zoo.remove(animal);
            System.out.println(MessageFormat.format(" -> We had {0} {1}.\n    Zoo state: {2}", quantity, animal, zoo));
            return quantity;
        };
    }

}
