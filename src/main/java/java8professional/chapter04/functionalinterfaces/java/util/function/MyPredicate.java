package java8professional.chapter04.functionalinterfaces.java.util.function;

import java.util.function.Predicate;

@FunctionalInterface
public interface MyPredicate<T> {
    boolean test(T t);
}

class PredicateTest {

    public static void main(String[] args) {
        Predicate<String> isEmpty1 = String::isEmpty;
        Predicate<String> isEmpty2 = s -> s.isEmpty();

        System.out.println(isEmpty1.test(""));
        System.out.println(isEmpty2.test("a"));
    }
}
