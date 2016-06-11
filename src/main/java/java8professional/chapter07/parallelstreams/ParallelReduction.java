package java8professional.chapter07.parallelstreams;

import java.text.NumberFormat;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.stream.LongStream;

public class ParallelReduction {

    static final NumberFormat FORMATTER = NumberFormat.getInstance();
    static final long LIMIT = 10_000_000_000L;

    public static void main(String[] args) {
        long serialStream = serialStream();
        System.out.println();
        long parallelStream = parallelStream();
        System.out.println();
        System.out.println("Advantage: " + NumberFormat.getPercentInstance().format((double) parallelStream / serialStream));
    }

    static long  serialStream() {
        LocalTime start = LocalTime.now();
        long sum = LongStream.range(1, LIMIT).sum();
        LocalTime end = LocalTime.now();
        long diffMillis = ChronoUnit.MILLIS.between(start, end);
        System.out.println("Millis elapsed: " + FORMATTER.format(diffMillis));
        return diffMillis;
    }

    static long parallelStream() {
        LocalTime start = LocalTime.now();
        long sum = LongStream.range(1, LIMIT).parallel().sum();
        LocalTime end = LocalTime.now();
        long diffMillis = ChronoUnit.MILLIS.between(start, end);
        System.out.println("Millis elapsed: " + FORMATTER.format(diffMillis));
        return diffMillis;
    }
}
