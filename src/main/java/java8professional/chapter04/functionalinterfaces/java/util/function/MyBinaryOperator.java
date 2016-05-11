package java8professional.chapter04.functionalinterfaces.java.util.function;

import java.util.function.BinaryOperator;

@FunctionalInterface
public interface MyBinaryOperator<T> extends MyBiFunction<T, T, T> {
    T apply(T t1, T t2);
}

class BinaryOperatorClass {

    public static void main(String[] args) {
        BinaryOperator<String> concat1 = String::concat;
        BinaryOperator<String> concat2 = (s1, s2) -> s1.concat(s2);

        System.out.println(concat1.apply("hello ", "world"));
        System.out.println(concat2.apply("hello ", "world"));
    }
}
