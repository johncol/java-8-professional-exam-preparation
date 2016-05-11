package java8professional.chapter04.functionalinterfaces.java.util.function;

import java.util.function.UnaryOperator;

@FunctionalInterface
public interface MyUnaryOperator<T> extends MyFunction<T, T> {
    T apply(T t);
}

class UnaryOperatorTest {

    public static void main(String[] args) {
        UnaryOperator<String> lowerCase1 = String::toLowerCase;
        UnaryOperator<String> lowerCase2 = s -> s.toLowerCase();

        System.out.println(lowerCase1.apply("ABC"));
        System.out.println(lowerCase2.apply("ABC"));
    }
}
