package java8professional.chapter04.streams.functional.intarces.java.util.function.doublestreams.to.others;

import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

@FunctionalInterface
public interface DoubleToLongFunction {

    Long apply(Double value);

    public static void main(String[] args) {
        LongStream stream = DoubleStream.of(1, 2, 3).mapToLong(x -> (long) x);
        stream.forEach(System.out::println);
    }
}
