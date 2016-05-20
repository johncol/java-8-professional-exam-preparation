package java8professional.chapter04.streams;

import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreams {

    public static void main(String[] args) {

        // sum using a stream
        int sum1 = Stream.of(1, 2, 3).reduce(0, (x, y) -> x + y);
        System.out.println(sum1);

        // sum using a stream mapped to an int stream
        int sum2 = Stream.of(1, 2, 3).mapToInt(x -> x).sum();
        System.out.println(sum2);

        // sum using the sum() method of an int stream
        int sum3 = IntStream.of(1, 2, 3).sum();
        System.out.println(sum3);

        // average with a double stream
        OptionalDouble average = DoubleStream.of(1, 2, 3).average();
        average.ifPresent(System.out::println);

        // long stream created using an array of values
        LongStream.of(new long[]{1, 2, 3}).limit(2).forEach(System.out::print);
        System.out.println();

        // generating random numbers with double stream generate() method
        DoubleStream random = DoubleStream.generate(Math::random);
        random.limit(3).forEach(x -> System.out.print(x + ", "));
        System.out.println();

        // iterating double values got from dividing over 2 each time
        DoubleStream fractions = DoubleStream.iterate(10, x -> x/2);
        fractions.limit(10).forEach(x -> System.out.print(x + ", "));
        System.out.println();

        // range of numbers using iterate
        IntStream.iterate(1, x -> x + 1).limit(5).forEach(System.out::print);
        System.out.println();

        // range of numbers with range()
        IntStream.range(1, 6).forEach(System.out::print);
        System.out.println();

        // range of numbers with rangeClosed
        IntStream.rangeClosed(1, 5).forEach(System.out::print);
        System.out.println();

        IntStream intStream = Stream.of(1, 2, 3).mapToInt(x -> x);
        DoubleStream doubleStream = Stream.of(1, 2, 3).mapToDouble(x -> x);
        LongStream longStream = Stream.of(1, 2, 3).mapToLong(x -> x);
        Stream<Integer> objStream = intStream.mapToObj(x -> x);
    }
}
