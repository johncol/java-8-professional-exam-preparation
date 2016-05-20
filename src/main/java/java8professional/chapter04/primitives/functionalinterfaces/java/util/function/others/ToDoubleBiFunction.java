package java8professional.chapter04.primitives.functionalinterfaces.java.util.function.others;

@FunctionalInterface
public interface ToDoubleBiFunction<T, U> {
    double apply(T t, U u);
}
