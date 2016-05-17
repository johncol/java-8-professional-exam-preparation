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
     *  - forEach() : void
     *  - reduce() : T
     *  - reduce() : Optional<T>
     */


    public static void main(String[] args) {
        Stream<Integer> stream;

        stream = Stream.iterate(1, x -> x + 1).limit(10);
        stream.forEach(StreamMethods::printWithComma);
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
        System.out.println(stream.reduce(1, (x, y) -> x * y));

        System.out.println(Stream.of("a", "b", "c").reduce("", String::concat));

        // reduce
        // Optional<T> reduce(BinaryOperator<T> accumulator)

        stream = Stream.iterate(1, x -> x + 1).limit(4);
        stream.reduce((x, y) -> x + y).ifPresent(System.out::println);

        stream = Stream.iterate(1, x -> x + 1).limit(4);
        stream.reduce((x, y) -> x * y).ifPresent(System.out::println);

        Stream.of("a", "b", "c").reduce((x, y) -> x + y).ifPresent(System.out::println);

        System.out.println(Stream.empty().reduce((x, y) -> x));
        System.out.println(Stream.of(1).reduce((x, y) -> x + y));
        System.out.println(Stream.of(1, 2, 3).reduce((x, y) -> x + y));

    }

    static void printWithComma(int x) {
        System.out.print(x + ",");
    }

}
