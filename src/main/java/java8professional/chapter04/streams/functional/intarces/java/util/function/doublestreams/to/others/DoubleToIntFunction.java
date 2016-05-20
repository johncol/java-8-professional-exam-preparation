package java8professional.chapter04.streams.functional.intarces.java.util.function.doublestreams.to.others;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

@FunctionalInterface
public interface DoubleToIntFunction {

    Integer apply(Double value);

    public static void main(String[] args) {
        IntStream stream = DoubleStream.of(1, 2, 3).mapToInt(x -> (int) x);
        stream.forEach(System.out::println);
    }
}
