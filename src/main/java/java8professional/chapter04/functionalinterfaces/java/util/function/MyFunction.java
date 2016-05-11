package java8professional.chapter04.functionalinterfaces.java.util.function;

import java.util.function.Function;

@FunctionalInterface
public interface MyFunction<T, R> {
    R apply(T t);
}

class FunctionTest {

    public static void main(String[] args) {
        Function<String, Integer> length1 = String::length;
        Function<String, Integer> length2 = s -> s.length();

        System.out.println(length1.apply("123"));
        System.out.println(length2.apply(""));
    }
}
