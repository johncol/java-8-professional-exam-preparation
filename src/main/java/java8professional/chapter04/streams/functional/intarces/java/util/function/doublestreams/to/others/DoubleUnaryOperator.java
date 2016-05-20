package java8professional.chapter04.streams.functional.intarces.java.util.function.doublestreams.to.others;

import java.util.stream.DoubleStream;

@FunctionalInterface
public interface DoubleUnaryOperator {

    Double apply(Double value);

    public static void main(String[] args) {
        DoubleStream stream = DoubleStream.of(1, 2, 3).map(x -> x / 2);
        stream.forEach(System.out::println);
    }
}
