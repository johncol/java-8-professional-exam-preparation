package java8professional.chapter07.concurrent.collections;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArrayListAndSetExample {
    public static void main(String[] args) {
        copyOnWriteArrayListTest();
        System.out.println();
        copyOnWriteArraySetTest();
    }

    static void copyOnWriteArrayListTest() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("fish");
        list.add("cat");
        list.add("dog");

        System.out.println(list.size() + " elements: ");
        list.forEach(e -> {
            System.out.print(e + " ");
            list.add("bird");
        });
        System.out.println();

        System.out.println(list.size() + " elements: ");
        list.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    static void copyOnWriteArraySetTest() {
        Set<String> set = new CopyOnWriteArraySet<>();
        set.add("fish");
        set.add("cat");
        set.add("dog");

        System.out.println(set.size() + " elements: ");
        set.forEach(e -> {
            System.out.print(e + " ");
            set.add("bird");
        });
        System.out.println();

        System.out.println(set.size() + " elements: ");
        set.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}
