package java8professional.chapter04.optional;

import java.util.Optional;

public class ChainingOptionals {
    public static void main(String[] args) {
        threeDigitNumber(Optional.empty());
        threeDigitNumber(Optional.of(1));
        threeDigitNumber(Optional.of(123));
        threeDigitNumber(Optional.of(12345));
    }

    static void threeDigitNumber(Optional<Integer> optionalInt) {
        optionalInt
                .map(String::valueOf)
                .filter(x -> x.length() == 3)
                .ifPresent(System.out::println);
    }
}
