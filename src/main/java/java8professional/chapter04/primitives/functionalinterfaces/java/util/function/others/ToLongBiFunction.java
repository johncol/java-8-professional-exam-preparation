package java8professional.chapter04.primitives.functionalinterfaces.java.util.function.others;

@FunctionalInterface
public interface ToLongBiFunction<T, U> {
    long apply(T t, U u);
}
