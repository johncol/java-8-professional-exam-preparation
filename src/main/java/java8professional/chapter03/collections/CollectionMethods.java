package java8professional.chapter03.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionMethods {

    void test() {
        Collection<String> collection = new ArrayList<>();
        boolean add =       collection.add("");
        boolean remove =    collection.remove("");
        boolean empty =     collection.isEmpty();
        int size =          collection.size();
        boolean contains =  collection.contains("");
                            collection.clear();
    }

    public static void main(String[] args) {

        Collection<String> list = new ArrayList<>();
        System.out.println(list.add("hawk"));
        System.out.println(list.add("hawk"));
        System.out.println(list);
        System.out.println();

        Collection<String> set = new HashSet<>();
        System.out.println(set.add("hawk"));
        System.out.println(set.add("hawk"));
        System.out.println(set);
        System.out.println();

        System.out.println(list.remove("hawk"));
        System.out.println(list);
        System.out.println(set.remove("hawk"));
        System.out.println(set.remove("hawk"));
        System.out.println(set);
        System.out.println();

        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println(set.isEmpty());
        System.out.println(set.size());
        System.out.println();

        list.clear();
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println();

        System.out.println(list.contains("hawk"));
        list.add("hawk");
        System.out.println(list.contains("hawk"));
        System.out.println();

    }
}
