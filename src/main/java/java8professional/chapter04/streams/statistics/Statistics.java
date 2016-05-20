package java8professional.chapter04.streams.statistics;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class Statistics {

    public static void main(String[] args) {
        IntSummaryStatistics statistics = IntStream
                .rangeClosed(0, 10)
                .peek(System.out::print)
                .summaryStatistics();
        System.out.println();
        System.out.println(statistics);
        System.out.println("Average: " + statistics.getAverage());
        System.out.println("Count: " + statistics.getCount());
        System.out.println("Min: " + statistics.getMin());
        System.out.println("Max: " + statistics.getMax());
        System.out.println("Sum: " + statistics.getSum());
        System.out.println();

        IntSummaryStatistics emptyStatistics = IntStream.empty().summaryStatistics();
        System.out.println(emptyStatistics);
        System.out.println("Average: " + emptyStatistics.getAverage());
        System.out.println("Count: " + emptyStatistics.getCount());
        System.out.println("Min: " + emptyStatistics.getMin());
        System.out.println("Max: " + emptyStatistics.getMax());
        System.out.println("Sum: " + emptyStatistics.getSum());
        System.out.println();

    }

}
