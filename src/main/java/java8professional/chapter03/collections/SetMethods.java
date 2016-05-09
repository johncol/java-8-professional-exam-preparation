package java8professional.chapter03.collections;

import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class SetMethods {

    public static void main(String[] args) {

        Set<Integer> set;

        set = new HashSet<>();
        System.out.println(set.add(1));
        System.out.println(set.add(10));
        System.out.println(set.add(5));
        System.out.println(set.add(10));
        System.out.println(set.add(66));
        System.out.println(set.add(null));
        System.out.println(set);
        System.out.println();

        set = new TreeSet<>();
        System.out.println(set.add(1));
        System.out.println(set.add(10));
        System.out.println(set.add(5));
        System.out.println(set.add(10));
        System.out.println(set.add(66));
        // System.out.println(set.add(null)); // throws null pointer exception
        System.out.println(set);
        System.out.println();

        // TreeSet implements NavigableSet
        NavigableSet<Integer> navigableSet = new TreeSet<>();
        for (int i = 1; i <= 20; i++) {
            navigableSet.add(i);
        }
        System.out.println(navigableSet.lower(1));      // null
        System.out.println(navigableSet.floor(1));      // 1
        System.out.println(navigableSet.lower(10));     // 9
        System.out.println(navigableSet.floor(10));     // 10

        System.out.println(navigableSet.ceiling(10));   // 10
        System.out.println(navigableSet.higher(10));    // 11
        System.out.println(navigableSet.ceiling(20));   // 20
        System.out.println(navigableSet.higher(20));    // null


    }

}
