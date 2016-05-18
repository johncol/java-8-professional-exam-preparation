package java8professional.chapter04.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class StreamCommonIntermediateOperations {

    /**
     * Intermediate operations
     *  - filter()
     *  - distinct()
     *  - limit()
     *  - skip()
     *  - map()
     *  - flatMap()
     *  - sorted()
     *  - peek()
     */

    public static void main(String[] args) {

        Stream<Integer> numbers;

        // filter
        // Stream<T> filter(Predicate<T> predicate)
        numbers = Stream.iterate(0, x -> x + 1).limit(10);
        numbers
                .filter(x -> x % 2 == 0)
                .forEach(System.out::print);
        System.out.println();
        System.out.println();

        // distinct
        // Stream<T> distinct()
        numbers = Stream.concat(Stream.iterate(0, x -> x + 1).limit(10), Stream.iterate(0, x -> x + 1).limit(10));
        numbers.forEach(System.out::print);
        System.out.println();
        numbers = Stream.concat(Stream.iterate(0, x -> x + 1).limit(10), Stream.iterate(0, x -> x + 1).limit(10));
        numbers.distinct().forEach(System.out::print);
        System.out.println();
        System.out.println();

        // limit
        // Stream<T> limit(int maxSize)
        Stream.iterate(1, x -> x + 1).limit(4).forEach(System.out::print);
        System.out.println();

        // skip
        // Stream<T> skip(int n)
        Stream.iterate(1, x -> x + 1).limit(9).skip(3).forEach(System.out::print);
        System.out.println();
        Stream.iterate(1, x -> x + 1).skip(3).limit(9).forEach(System.out::print);
        System.out.println();
        System.out.println();

        // map
        // <R> Stream<R> map(Function<? super T, ? extends R> mapper)
        Stream.of("a", "bb", "ccc").map(String::length).forEach(System.out::print);
        System.out.println();

        // flatMap
        // <R> Stream<R> flatMap(Function<? super T, ? extends Stream<R>> mapper)
        List<String> zero = Arrays.asList();
        List<String> one = Arrays.asList("a");
        List<String> two = Arrays.asList("b", "c");
        Stream<List<String>> listStream = Stream.of(zero, one, two);
        listStream.flatMap(l -> l.stream()).forEach(System.out::print);
        System.out.println();
        System.out.println();

        // sorted
        // Stream<T> sorted()
        // Stream<T> sorted(Comparator<? extends T> comparator)
        Random random = new Random();
        Stream.generate(() -> random.nextInt(20))
                .limit(10)
                .sorted()
                .forEach(s -> System.out.print(s + ","));
        System.out.println();
        Stream.generate(() -> random.nextInt(20))
                .limit(10)
                .sorted(Comparator.reverseOrder())
                .forEach(s -> System.out.print(s + ","));
        System.out.println();
        System.out.println();

        // peek
        // Stream<T> peek(Consumer<? super T> action)
        numbers = Stream.iterate(1, x -> x + 1).limit(3);
        //numbers;
        numbers
                .peek(x -> System.out.print("You're about to process input " + x + ": "))
                .forEach(x -> System.out.println(x * 2));
        System.out.println();
        System.out.println();





    }

}
