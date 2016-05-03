package java8professional.chapter03.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListMethods {

    void test() {
        List<String> list = new ArrayList<>();
                                list.add(0, "");
        String get =            list.get(0);
        String remove =         list.remove(0);
        int indexOf =           list.indexOf("");
        int lastIndexOf =       list.lastIndexOf("");
        String set =            list.set(0, "");
    }

    void test2() {
        List<String> list = new ArrayList<>();

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
        }

        
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        System.out.println(list.add("hi"));
        list.add(1, "hi2");
        list.add(1, "hi2");
        System.out.println(list);

        System.out.println(list.indexOf("hi"));
        System.out.println(list.indexOf("hi3"));

        System.out.println(list.indexOf("hi2"));
        System.out.println(list.lastIndexOf("hi2"));

        System.out.println(list.remove(2));
        System.out.println(list);

        System.out.println(list.set(1, "hi44"));
        System.out.println(list);

    }
}
