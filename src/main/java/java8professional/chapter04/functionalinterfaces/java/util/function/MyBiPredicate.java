package java8professional.chapter04.functionalinterfaces.java.util.function;

import java.util.function.BiPredicate;

@FunctionalInterface
public interface MyBiPredicate<T, U> {
    boolean test(T t, U u);
}

class BiPredicateTest {

    public static void main(String[] args) {
        BiPredicate<String, String> startsWith1 = String::startsWith;
        BiPredicate<String, String> startsWith2 = (s, p) -> s.startsWith(p);

        System.out.println(startsWith1.test("wololo", "wo"));
        System.out.println(startsWith2.test("wololo", "what?"));
    }
}
