package java8professional.chapter04.optional;

import java.util.Optional;

public class FlatMapOptional {
    public static void main(String[] args) {
        Optional<String> string = Optional.of("whatever");

        Optional<Integer> result1 = string.flatMap(FlatMapOptional::calculator1);
        result1.ifPresent(System.out::println);

        Optional<Integer> result2 = string.map(FlatMapOptional::calculator2);
        result2.ifPresent(System.out::println);
    }

    static Optional<Integer> calculator1(String s) {
        return s == null ? Optional.empty() : Optional.of(s.length());
    }

    static Integer calculator2(String s) {
        return s == null ? 0 : s.length();
    }
}
