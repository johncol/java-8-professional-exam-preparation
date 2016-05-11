package java8professional.chapter04.optional;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalTest {

    static Optional<Double> average(int... scores) {
        if (scores.length == 0) {
            return Optional.empty();
        }
        int total = 0;
        for (int score: scores) {
            total += score;
        }
        return Optional.of((double) total / scores.length);
    }

    static Object callSomeMethod() { return null; }

    public static void main(String[] args) {
        System.out.println(average(1, 2, 3, 4, 5));
        System.out.println(average());

        Optional<Double> average = average(10, 100, 1000);
        if (average.isPresent()) {
            System.out.println(average.get());
        }
        System.out.println();

        try {
            average().get();
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException!");
        }
        System.out.println();

        Optional<Object> optional;

        optional = Optional.ofNullable(callSomeMethod());
        System.out.println(optional);

        try {
            Optional.of(callSomeMethod());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException!");
        }
        System.out.println();

        System.out.println(average(50, 40).orElse(0.0));
        System.out.println(average().orElse(0.0));

        System.out.println();

        System.out.println(average(50, 40).orElseGet(() -> 0.0));
        System.out.println(average().orElseGet(() -> 0.0));

        System.out.println();

        System.out.println(average(50, 40).orElseThrow(() -> new NoAverageException()));
        System.out.println(average().orElseThrow(() -> new NoAverageException()));

    }

}

class NoAverageException extends RuntimeException {}
