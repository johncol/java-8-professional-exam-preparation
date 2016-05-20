package java8professional.chapter04.streams.functional.intarces.java.util.function.doublestreams.to.others;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

@FunctionalInterface
public interface DoubleFunction<Y> {

    Y apply(Double value);

    public static void main(String[] args) {
        Stream<OptionalDouble> stream = DoubleStream.of(1, 2, 3).mapToObj(x -> OptionalDouble.of(x));
        stream.forEach(System.out::println);
    }
}
