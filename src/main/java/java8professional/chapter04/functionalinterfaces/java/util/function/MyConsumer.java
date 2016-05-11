package java8professional.chapter04.functionalinterfaces.java.util.function;

import java.util.function.Consumer;

@FunctionalInterface
public interface MyConsumer<T> {
    void accept(T t);
}

class ConsumerTest {

    public static void main(String[] args) {
        Consumer<String> println1 = System.out::println;
        Consumer<String> println2 = s -> System.out.println(s);

        println1.accept("hi");
        println2.accept("hi again");
    }
}
