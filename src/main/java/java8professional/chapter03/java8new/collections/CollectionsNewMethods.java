package java8professional.chapter03.java8new.collections;

import com.google.common.collect.Lists;

import java.util.List;

public class CollectionsNewMethods {

    public static void main(String[] args) {
        removeIf();
        replaceAll();
        forEach();
    }

    private static void removeIf() {
        List<String> strings = Lists.newArrayList("", "a", "b", "c", "aa", "bb", "cc", "");
        System.out.println(strings);

        strings.removeIf(String::isEmpty);
        System.out.println(strings);

        strings.removeIf(s -> s.startsWith("a"));
        System.out.println(strings);

        System.out.println();
    }

    private static void replaceAll() {
        List<String> strings = Lists.newArrayList("a", "b", "c");
        System.out.println(strings);

        strings.replaceAll(s -> s + s);
        System.out.println(strings);

        System.out.println();
    }

    private static void forEach() {
        List<String> strings = Lists.newArrayList("a", "b", "c");
        strings.forEach(System.out::print);

        System.out.println();
    }
}
