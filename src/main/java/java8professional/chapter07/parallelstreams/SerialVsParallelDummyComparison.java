package java8professional.chapter07.parallelstreams;

import java.text.NumberFormat;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SerialVsParallelDummyComparison {

    public static final int PROCESSING_TIME = 5;

    public static void main(String[] args) {
        List<Integer> list = IntStream.rangeClosed(1, 1_000).boxed().collect(Collectors.toList());
        System.out.println("List size: " + NumberFormat.getInstance().format(list.size()));
        processElementInSerial(list);
        processElementInParallel(list);
    }

    static void processElementInSerial(List<Integer> list) {
        LocalTime start = LocalTime.now();
        list.stream().forEach(SerialVsParallelDummyComparison::processElement);
        LocalTime end = LocalTime.now();
        printResults("serial", start, end);
    }

    static void processElementInParallel(List<Integer> list) {
        LocalTime start = LocalTime.now();
        list.parallelStream().forEach(SerialVsParallelDummyComparison::processElement);
        LocalTime end = LocalTime.now();
        printResults("parallel", start, end);
    }

    private static void printResults(String streamType, LocalTime start, LocalTime end) {
        System.out.println("Millis elapsed in " + streamType + ": " + NumberFormat.getInstance().format(ChronoUnit.MILLIS.between(start, end)));
    }

    static void processElement(Integer element) {
        try {
            Thread.sleep(PROCESSING_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
