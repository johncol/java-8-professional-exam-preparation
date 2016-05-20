package java8professional.chapter04.primitives.functionalinterfaces.java.util.function.others;

import java.util.stream.Stream;

@FunctionalInterface
public interface Function<X, Y> {

    Y apply(X x);

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3).map(x -> x * 2);
        stream.forEach(System.out::println);
    }

}
