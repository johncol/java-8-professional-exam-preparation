package java8professional.chapter04.optional;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveOptionals {

    public static void main(String[] args) {

        double asDouble = OptionalDouble.of(4).getAsDouble();
        System.out.println(asDouble);

        int asInt = OptionalInt.of(4).getAsInt();
        System.out.println(asInt);

        long asLong = OptionalLong.of(4L).getAsLong();
        System.out.println(asLong);

        System.out.println();

        System.out.println(OptionalDouble.empty().orElseGet(() -> 4));
        System.out.println(OptionalInt.empty().orElseGet(() -> 4));
        System.out.println(OptionalLong.empty().orElseGet(() -> 4));

        System.out.println();

        System.out.println(IntStream.rangeClosed(1, 10).sum());
        System.out.println(DoubleStream.of(1, 2, 3).sum());
        System.out.println(LongStream.rangeClosed(10000000001L, 10000000010L).sum());

        System.out.println();

        System.out.println(IntStream.rangeClosed(1, 10).average());
        System.out.println(DoubleStream.of(1, 2, 3).average());
        System.out.println(LongStream.rangeClosed(1, 10).average());

        System.out.println();

        System.out.println(IntStream.of(1, 2, 3).max());
        System.out.println(DoubleStream.of(1, 2, 3).max());
        System.out.println(LongStream.of(1, 2, 3).max());

        System.out.println();

        System.out.println(IntStream.of(1, 2, 3).min());
        System.out.println(DoubleStream.of(1, 2, 3).min());
        System.out.println(LongStream.of(1, 2, 3).min());

    }
}
