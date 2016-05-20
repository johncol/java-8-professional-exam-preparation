package java8professional.chapter04.optional.functionalInterfaces.java.util.function;

@FunctionalInterface
public interface LongBinaryOperator {
    long apply(long value1, long value2);
}
