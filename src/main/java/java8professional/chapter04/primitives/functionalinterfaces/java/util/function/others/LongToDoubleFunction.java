package java8professional.chapter04.primitives.functionalinterfaces.java.util.function.others;

import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

@FunctionalInterface
public interface LongToDoubleFunction {

    Double apply(Long value);

    public static void main(String[] args) {
        DoubleStream stream = LongStream.of(1, 2, 3).mapToDouble(x -> x / 5.0);
        stream.forEach(System.out::println);
    }
}
