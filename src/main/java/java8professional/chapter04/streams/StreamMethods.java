package java8professional.chapter04.streams;

import java.util.Comparator;
import java.util.stream.Stream;

public class StreamMethods {

    /**
     * Stream:
     *  - count(): int
     *  - min(): Optional<T>
     *  - max(): Optional<T>
     *  - findAny(): Optional<T>
     *  - findFirst(): Optional<T>
     *  - anyMatch(): boolean
     *  - allMatch(): boolean
     *  - noneMatch(): boolean
     *
     */


    public static void main(String[] args) {
        Stream<Integer> stream;

        stream = Stream.iterate(1, x -> x + 1).limit(10);
        stream.forEach(StreamMethods::printWithComma);
        System.out.println();

        // count
        stream = Stream.iterate(1, x -> x + 1).limit(10);
        System.out.println(stream.count());

        Comparator<Integer> naturalOrdering = (x, y) -> x - y;

        // min
        stream = Stream.iterate(1, x -> x + 1).limit(10);
        stream.min(naturalOrdering).ifPresent(System.out::println);

        // max
        stream = Stream.iterate(1, x -> x + 1).limit(10);
        stream.max(naturalOrdering).ifPresent(System.out::println);

        // min
        stream = Stream.empty();
        System.out.println(stream.min(naturalOrdering));

        // max
        stream = Stream.empty();
        System.out.println(stream.max(naturalOrdering));

        // findFirst
        stream = Stream.iterate(1, x -> x + 1);
        stream.findFirst().ifPresent(System.out::println);

        // findAny
        stream = Stream.iterate(1, x -> x + 1);
        stream.findAny().ifPresent(System.out::println);

        // anyMatch
        stream = Stream.iterate(1, x -> x + 1);
        System.out.println(stream.anyMatch(x -> x > 10));

        // allMatch
        stream = Stream.iterate(1, x -> x + 1);
        System.out.println(stream.allMatch(x -> x > 10));

        // noneMatch
        stream = Stream.iterate(1, x -> x + 1);
        System.out.println(stream.noneMatch(x -> x > 10));

    }

    static void printWithComma(int x) {
        System.out.print(x + ",");
    }

}
