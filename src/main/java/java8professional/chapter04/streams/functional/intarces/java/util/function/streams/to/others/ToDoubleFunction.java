package java8professional.chapter04.streams.functional.intarces.java.util.function.streams.to.others;

import java.util.stream.DoubleStream;
import java.util.stream.Stream;

@FunctionalInterface
public interface ToDoubleFunction<X> {

    Double apply(X x);

    public static void main(String[] args) {
        DoubleStream stream = Stream.of(1, 2, 3).mapToDouble(x -> x / 2.0);
        stream.forEach(System.out::println);
    }

}