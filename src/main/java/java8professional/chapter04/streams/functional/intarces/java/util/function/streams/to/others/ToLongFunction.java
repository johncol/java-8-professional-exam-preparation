package java8professional.chapter04.streams.functional.intarces.java.util.function.streams.to.others;

import java.util.stream.LongStream;
import java.util.stream.Stream;

@FunctionalInterface
public interface ToLongFunction<X> {

    Long apply(X x);

    public static void main(String[] args) {
        LongStream stream = Stream.of(1, 2, 3).mapToLong(x -> x + 10000000000000L);
        stream.forEach(System.out::println);
    }

}