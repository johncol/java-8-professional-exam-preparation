package java8professional.chapter03.generics.wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllTogether {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        AllTogether.<Number>getIt(integers);
    }

    static void test() {
        List<?> list1 = new ArrayList<A>();
        List<? extends A> list2 = new ArrayList<A>();
        List<? super A> list3 = new ArrayList<A>();
    }

    static <T> T getIt(List<? extends T> list) {
        return list.get(0);
    }

    static <T extends A> T method3(List<T> list) {
        return list.get(0);
    }

    static <X extends A> void some(List<? extends A> list) {}

}

class A {}
class B extends A {}
class C extends B {}
