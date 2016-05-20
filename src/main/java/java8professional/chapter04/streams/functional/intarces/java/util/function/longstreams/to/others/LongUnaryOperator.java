package java8professional.chapter04.streams.functional.intarces.java.util.function.longstreams.to.others;

import java.util.stream.LongStream;

@FunctionalInterface
public interface LongUnaryOperator {

    Long apply(Long value);

    public static void main(String[] args) {
        LongStream stream = LongStream.of(1, 2, 3).map(x -> x * 2);
        stream.forEach(System.out::println);
    }
}
