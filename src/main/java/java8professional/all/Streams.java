package java8professional.all;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.function.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Streams {
    void method(Collection<String> collection) {
        collection.stream().forEach(System.out::println);

        Supplier<Integer> supplier = () -> new Random().nextInt();
        Stream<Integer> integerStream = Stream.generate(supplier);

        String start = "a";
        UnaryOperator<String> unaryOperator = s -> s + s;
        Stream<String> stringStream = Stream.iterate(start, unaryOperator);
    }

    static void minAndMax() {
        Stream.of(1, 2, 3)
                .min(Comparator.naturalOrder())
                .ifPresent(System.out::println);
        System.out.println(Stream.empty().max((a, b) -> 0));
    }

    public static void main(String[] args) {
        minAndMax();
        TreeSet<Object> objects = toCollection(TreeSet::new);
        System.out.println(Stream.of("a", "aa", "aaa").reduce("", (count, string) -> count + string.length()));
        System.out.println(Stream.of("a", "aa", "aaa").reduce((str1, str2) -> str1 + str2));
        System.out.println(Stream.of("a", "aa", "aaa").reduce(0, (sum, string) -> sum + string.length(), (sum1, sum2) -> sum1 + sum2));
        System.out.println(Stream.of("a", "aa", "aaa").map(String::length).reduce(0, (a, b) -> a + b));
        flatMap();

        SillyClass one = new SillyClass();
        SillyClass two = new SillyClass();
        SillyClass three = new SillyClass();
        Stream<SillyClass> stream = Stream.of(one, two, three);
        stream.sorted().forEach(System.out::print);
    }

    public static <U extends Collection<? extends T>, T> U toCollection(Supplier<U> supplier) {
        return null;
    }

    static class SillyClass {}

    static void flatMap() {
        SillyClass one = new SillyClass();
        SillyClass two = new SillyClass();
        SillyClass three = new SillyClass();
        Stream<SillyClass> stream = Stream.of(one, two, three);
        stream.flatMap(sillyClass -> Stream.of(1, 2, 3)).forEach(System.out::print);
        System.out.println();
    }

    {
        IntSummaryStatistics intSummaryStatistics = Stream.of(1).mapToInt(x -> x).summaryStatistics();
    }

}
