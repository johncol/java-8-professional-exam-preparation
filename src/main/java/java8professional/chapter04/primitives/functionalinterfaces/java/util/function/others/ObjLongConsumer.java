package java8professional.chapter04.primitives.functionalinterfaces.java.util.function.others;

@FunctionalInterface
public interface ObjLongConsumer<T> {
    void accept(T t, long value);
}
