package java8professional.chapter04.primitives.functionalinterfaces.java.util.function.others;

@FunctionalInterface
public interface ObjIntConsumer<T> {
    void accept(T t, int value);
}
