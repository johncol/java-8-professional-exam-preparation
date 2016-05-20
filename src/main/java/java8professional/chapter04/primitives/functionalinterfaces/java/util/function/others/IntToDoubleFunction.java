package java8professional.chapter04.primitives.functionalinterfaces.java.util.function.others;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

@FunctionalInterface
public interface IntToDoubleFunction {

    Double apply(Integer value);

    public static void main(String[] args) {
        DoubleStream stream = IntStream.of(1, 2, 3).mapToDouble(Double::new);
        stream.forEach(System.out::println);
    }

}
