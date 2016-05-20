package java8professional.chapter04.primitives.functionalinterfaces.java.util.function.others;

import java.util.stream.DoubleStream;
import java.util.stream.Stream;

@FunctionalInterface
public interface ToDoubleFunction<X> {

    double apply(X x);

    public static void main(String[] args) {
        DoubleStream stream = Stream.of(1, 2, 3).mapToDouble(x -> x / 2.0);
        stream.forEach(System.out::println);
    }

}
