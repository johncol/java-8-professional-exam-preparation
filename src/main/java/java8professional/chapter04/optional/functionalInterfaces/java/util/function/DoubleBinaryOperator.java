package java8professional.chapter04.optional.functionalInterfaces.java.util.function;

@FunctionalInterface
public interface DoubleBinaryOperator {
    double apply(double value1, double value2);
}
