package java8professional.chapter04.primitives.functionalinterfaces.java.util.function.others;

@FunctionalInterface
public interface ObjDoubleConsumer<T> {
    void accept(T t, double value);
}
