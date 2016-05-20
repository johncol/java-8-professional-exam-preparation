package java8professional.chapter04.primitives.functionalinterfaces.java.util.function.others;

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
