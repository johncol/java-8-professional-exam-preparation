package java8professional.chapter07.parallelstreams;

import java.text.NumberFormat;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class ParallelCollect {

    static final int QUANTITY = 100_000;

    static final List<String> STRINGS = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa");

    static final NumberFormat FORMATTER = NumberFormat.getInstance();

    public static void main(String[] args) {
        List<String> sizeFixedStrings = createSizeFixedStringList();

        collectSerialStream(sizeFixedStrings);
        System.out.println();
        collectParallelStream(sizeFixedStrings);
    }

    static void collectSerialStream(List<String> sizeFixedStrings) {
        LocalTime start = LocalTime.now();
        Map<Integer, List<String>> serialGroupBy = sizeFixedStrings.stream().collect(Collectors.groupingBy(String::length));
        LocalTime end = LocalTime.now();
        long diffMillis = ChronoUnit.MILLIS.between(start, end);
        System.out.println("Map size: " + serialGroupBy.size());
        System.out.println("Millis elapsed in serial collect: " + FORMATTER.format(diffMillis));
    }

    static void collectParallelStream(List<String> sizeFixedStrings) {
        List<String> syncSizeFixedStrings = Collections.synchronizedList(sizeFixedStrings);
        LocalTime start = LocalTime.now();
        ConcurrentMap<Integer, List<String>> serialGroupBy = syncSizeFixedStrings.parallelStream().collect(Collectors.groupingByConcurrent(String::length));
        LocalTime end = LocalTime.now();
        long diffMillis = ChronoUnit.MILLIS.between(start, end);
        System.out.println("Map size: " + serialGroupBy.size());
        System.out.println("Millis elapsed in parallel collect: " + FORMATTER.format(diffMillis));
    }

    static List<String> createSizeFixedStringList() {
        List<String> sizeFixedStrings = new ArrayList<>();
        STRINGS.forEach(s -> {
            for (int i = 0; i < QUANTITY; i++) {
                sizeFixedStrings.add(s);
            }
        });
        System.out.println("List size: " + sizeFixedStrings.size());
        System.out.println();
        return sizeFixedStrings;
    }
}
