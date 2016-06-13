package java8professional.chapter07.concurrentprocesses.forkjoin;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ForkJoinRecursiveActionExample {
    public static void main(String[] args) {
        Double[] weights = new Double[10];

        ForkJoinTask<?> recursiveAction = new WeighAnimalAction(0, weights.length, weights);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(recursiveAction);
        System.out.println();

        System.out.print("Weights: ");
        Arrays.stream(weights).forEach(w -> System.out.print(" " + w));
    }
}

class WeighAnimalAction extends RecursiveAction {

    private static final int MAX_WORKER_CAPACITY = 3;

    private final int start;
    private final int end;
    private final Double[] weights;

    public WeighAnimalAction(int start, int end, Double[] weights) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }

    @Override
    protected void compute() {
        if (end - start <= MAX_WORKER_CAPACITY) {
            for (int i = start; i < end; i++) {
                weights[i] = (double) new Random().nextInt(100);
                System.out.println("Weight added: " + weights[i]);
            }
        } else {
            int middle = start + ((end - start) / 2);
            System.out.println(MessageFormat.format("[start={0} middle={1} end={2}]", start, middle, end));
            WeighAnimalAction subTask1 = new WeighAnimalAction(start, middle, weights);
            WeighAnimalAction subTask2 = new WeighAnimalAction(middle, end, weights);
            invokeAll(subTask1, subTask2);
        }
    }
    
}