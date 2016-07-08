package java8professional.all;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class LazyEvaluation {

    public static void main(String[] args) {
        link();
        filterOptional();
    }

    static void link() {
        List<String> animals = Lists.newArrayList("dog", "cat");
        IntStream lengths = animals.stream().mapToInt(String::length);
        animals.add("horse");
        animals.add("elephant");
        lengths.forEach(System.out::println);
    }

    static void filterOptional() {
        Optional.of(3)
                .filter(x -> x % 2 == 0)
                .map(x -> "Yeah, the result is: " + x)
                .ifPresent(System.out::println);
    }
}
