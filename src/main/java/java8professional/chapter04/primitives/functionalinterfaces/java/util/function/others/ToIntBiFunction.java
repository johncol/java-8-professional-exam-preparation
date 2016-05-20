package java8professional.chapter04.primitives.functionalinterfaces.java.util.function.others;

@FunctionalInterface
public interface ToIntBiFunction<T, U> {
    int apply(T t, U u);
}
