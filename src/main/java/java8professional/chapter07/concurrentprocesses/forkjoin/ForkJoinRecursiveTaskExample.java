package java8professional.chapter07.concurrentprocesses.forkjoin;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinRecursiveTaskExample {
    public static void main(String[] args) {
        Double[] weights = new Double[10];

        ForkJoinTask<Double> recursiveAction = new WeighAnimalTask(0, weights.length, weights);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Double total = forkJoinPool.invoke(recursiveAction);
        System.out.println();

        System.out.println("Total: " + total);
        System.out.print("Weights: ");
        Arrays.stream(weights).forEach(w -> System.out.print(" " + w));
    }
}

class WeighAnimalTask extends RecursiveTask<Double> {

    private static final int MAX_WORKER_CAPACITY = 3;

    private final int start;
    private final int end;
    private final Double[] weights;

    public WeighAnimalTask(int start, int end, Double[] weights) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }

    @Override
    protected Double compute() {
        if (end - start <= MAX_WORKER_CAPACITY) {
            double total = 0;
            for (int i = start; i < end; i++) {
                weights[i] = (double) new Random().nextInt(100);
                total += weights[i];
                System.out.println("Weight added: " + weights[i]);
            }
            return total;
        } else {
            int middle = start + ((end - start) / 2);
            System.out.println(MessageFormat.format("[start={0} middle={1} end={2}]", start, middle, end));
            WeighAnimalTask subTask1 = new WeighAnimalTask(start, middle, weights);
            WeighAnimalTask subTask2 = new WeighAnimalTask(middle, end, weights);

            subTask1.fork();
            Double task2Result = subTask2.compute();
            Double task1Result = subTask1.join();
            return task1Result + task2Result;
        }
    }

}