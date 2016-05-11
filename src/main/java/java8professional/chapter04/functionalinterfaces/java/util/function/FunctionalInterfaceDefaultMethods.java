package java8professional.chapter04.functionalinterfaces.java.util.function;

import java.util.function.Predicate;

public class FunctionalInterfaceDefaultMethods {

    public static void main(String[] args) {

        Predicate<String> egg = s -> s.contains("egg");
        Predicate<String> brown = s -> s.contains("brown");

        Predicate<String> brownEgg = egg.and(brown);
        Predicate<String> othersEggs = egg.and(brown.negate());

    }

}
