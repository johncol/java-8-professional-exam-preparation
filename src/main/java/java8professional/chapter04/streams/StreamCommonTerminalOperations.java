package java8professional.chapter04.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCommonTerminalOperations {

    /**
     * Stream:
     *  - count(): int
     *  - min(Comparator<? super T>): Optional<T>
     *  - max(Comparator<? super T>): Optional<T>
     *  - findAny(): Optional<T>
     *  - findFirst(): Optional<T>
     *  - anyMatch(): boolean
     *  - allMatch(): boolean
     *  - noneMatch(): boolean
     *  - forEach() : void
     *  - reduce() : T
     *  - reduce() : Optional<T>
     *  - collect() : T
     */


    public static void main(String[] args) {
        Stream<Integer> stream;
        Stream<String> strings;

        stream = Stream.iterate(1, x -> x + 1).limit(10);
        stream.forEach(StreamCommonTerminalOperations::printWithComma);
        System.out.println();

        // count
        // long count()
        stream = Stream.iterate(1, x -> x + 1).limit(10);
        System.out.println(stream.count());

        Comparator<Integer> naturalOrdering = (x, y) -> x - y;

        // min
        // Optional<T> min(Comparator<? super T> comparator)
        stream = Stream.iterate(1, x -> x + 1).limit(10);
        stream.min(naturalOrdering).ifPresent(System.out::println);

        // max
        // Optional<T> max(Comparator<? super T> comparator)
        stream = Stream.iterate(1, x -> x + 1).limit(10);
        stream.max(naturalOrdering).ifPresent(System.out::println);

        // min
        // Optional<T> min(Comparator<? super T> comparator)
        stream = Stream.empty();
        System.out.println(stream.min(naturalOrdering));

        // max
        // Optional<T> max(Comparator<? super T> comparator)
        stream = Stream.empty();
        System.out.println(stream.max(naturalOrdering));

        // findFirst
        // Optional<T> findFirst()
        stream = Stream.iterate(1, x -> x + 1);
        stream.findFirst().ifPresent(System.out::println);

        // findAny
        // Optional<T> findAny()
        stream = Stream.iterate(1, x -> x + 1);
        stream.findAny().ifPresent(System.out::println);

        // anyMatch
        // boolean anyMatch(Predicate<? super T> predicate)
        stream = Stream.iterate(1, x -> x + 1);
        System.out.println(stream.anyMatch(x -> x > 10));

        // allMatch
        // boolean allMatch(Predicate<? super T> predicate)
        stream = Stream.iterate(1, x -> x + 1);
        System.out.println(stream.allMatch(x -> x > 10));

        // noneMatch
        // boolean noneMatch(Predicate<? super T> predicate)
        stream = Stream.iterate(1, x -> x + 1);
        System.out.println(stream.noneMatch(x -> x > 10));

        // forEach
        // void forEach(Consumer<? super T> consumer)
        stream = Stream.iterate(1, x -> x +1).limit(3);
        stream.forEach(System.out::println);

        // reduce
        // T reduce(T identity, BinaryOperator<T> accumulator)
        stream = Stream.iterate(1, x -> x + 1).limit(4);
        System.out.println(stream.reduce(0, (x, y) -> x + y));

        stream = Stream.iterate(1, x -> x + 1).limit(4);
        Integer reduceResult1 = stream.reduce(1, (x, y) -> x * y);
        System.out.println(reduceResult1);

        System.out.println(Stream.of("a", "b", "c").reduce("", String::concat));

        // reduce
        // Optional<T> reduce(BinaryOperator<T> accumulator)
        stream = Stream.iterate(1, x -> x + 1).limit(4);
        Optional<Integer> reduceResult2 = stream.reduce((x, y) -> x + y);
        reduceResult2.ifPresent(System.out::println);

        stream = Stream.iterate(1, x -> x + 1).limit(4);
        stream.reduce((x, y) -> x * y).ifPresent(System.out::println);

        Stream.of("a", "b", "c").reduce((x, y) -> x + y).ifPresent(System.out::println);

        System.out.println(Stream.empty().reduce((x, y) -> x));
        System.out.println(Stream.of(1).reduce((x, y) -> x + y));
        System.out.println(Stream.of(1, 2, 3).reduce((x, y) -> x + y));

        // collect
        // T collect(Supplier<T> supplier, BiConsumer<T, U> accumulator, BiConsumer<T, T> combiner)
        // T collect(Collector<T> collector)
        strings = Stream.of("a", "b", "c", "A", "B", "C");
        StringBuilder collect1 = strings.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(collect1);

        strings = Stream.of("a", "b", "c", "A", "B", "C");
        Set<String> collect2 = strings.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        System.out.println(collect2);

        strings = Stream.of("a", "b", "c", "A", "B", "C");
        Set<String> collect3 = strings.collect(Collectors.toSet());
        System.out.println(collect3);

        strings = Stream.of("a", "b", "c", "A", "B", "C");
        List<String> collect4 = strings.collect(Collectors.toList());
        System.out.println(collect4);

    }

    static void printWithComma(int x) {
        System.out.print(x + ",");
    }

}
