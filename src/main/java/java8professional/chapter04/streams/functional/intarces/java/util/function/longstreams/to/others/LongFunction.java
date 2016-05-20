package java8professional.chapter04.streams.functional.intarces.java.util.function.longstreams.to.others;

import java.util.OptionalLong;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@FunctionalInterface
public interface LongFunction<Y> {

    Y apply(Long value);

    public static void main(String[] args) {
        Stream<OptionalLong> stream = LongStream.of(1, 2, 3).mapToObj(OptionalLong::of);
        stream.forEach(System.out::println);
    }
}
