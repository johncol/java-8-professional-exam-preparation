package java8professional.chapter04.functionalinterfaces.java.util.function;

import java.util.function.BiFunction;

@FunctionalInterface
public interface MyBiFunction<T, U, R> {
    R apply(T t, U u);
}

class BiFunctionTest {

    public static void main(String[] args) {
        BiFunction<String, Integer, String> substring1 = String::substring;
        BiFunction<String, Integer, String> substring2 = (s, i) -> s.substring(i);

        System.out.println(substring1.apply("012345", 3));
        System.out.println(substring2.apply("012345", 3));
    }
}
