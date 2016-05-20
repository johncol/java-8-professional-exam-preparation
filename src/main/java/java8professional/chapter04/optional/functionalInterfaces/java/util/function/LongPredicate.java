package java8professional.chapter04.optional.functionalInterfaces.java.util.function;

@FunctionalInterface
public interface LongPredicate {
    boolean test(long value);
}
