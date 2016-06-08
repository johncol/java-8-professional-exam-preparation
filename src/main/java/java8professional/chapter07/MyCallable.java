package java8professional.chapter07;

@FunctionalInterface
public interface MyCallable<T> {
    T call() throws Exception;
}
