package java8professional.chapter04;

import java.util.OptionalDouble;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestQuestions {

    public static void main(String[] args) {
        Predicate<? super String> predicate = s -> s.startsWith("c");

        // all average() methods (IntStream, LongStream, DoubleStream) return a OptionalDouble
        OptionalDouble average = IntStream.empty().average();

        // won't print anything because intermediate operations on streams don't run until a terminate operation is declared
        Stream.of("a", "b", "c").peek(System.out::println);

        // collectors.joining has one signature without any parameters, and it's always expecting a stream of strings
        IntStream.of(1, 2, 3).mapToObj(String::valueOf).collect(Collectors.joining());

        // mapToDouble, mapToInt, mapToLong are not terminal operations
        Stream<Integer> stream = Stream.of(1, 2, 3);
        IntStream intStream1 = stream.mapToInt(x -> x);
        DoubleStream doubleStream = stream.mapToDouble(x -> x); // will throw an exception
        IntStream intStream2 = doubleStream.mapToInt(x -> (int) x);
        intStream2.forEach(System.out::println);

        // Boolean Supplier exists!!
        BooleanSupplier booleanSupplier = () -> false;
    }
}
