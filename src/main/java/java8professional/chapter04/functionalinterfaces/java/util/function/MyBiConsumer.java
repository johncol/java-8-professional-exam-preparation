package java8professional.chapter04.functionalinterfaces.java.util.function;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

@FunctionalInterface
public interface MyBiConsumer<T, U> {
    void accept(T t, U u);
}

class BiConsumerTest {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        System.out.println(map);

        BiConsumer<String, Integer> putInMap1 = map::put;
        BiConsumer<String, Integer> putInMap2 = (k, v) -> map.put(k, v);

        putInMap1.accept("Dracula", 1000);
        putInMap2.accept("Werewolf", 100);

        System.out.println(map);

    }
}
