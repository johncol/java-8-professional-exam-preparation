package java8professional.chapter04.optional.functionalInterfaces.java.util.function;

@FunctionalInterface
public interface DoublePredicate {
    boolean test(double value);
}
