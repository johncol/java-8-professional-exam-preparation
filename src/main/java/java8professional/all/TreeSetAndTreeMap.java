package java8professional.all;

import java.util.*;

public class TreeSetAndTreeMap {
    public static void main(String[] args) {
        Comparator<Leon> leonComparator = (leon1, leon2) -> leon2.victims - leon1.victims;

        Set<Leon> set = new TreeSet<>(leonComparator);
        set.add(new Leon(1));
        set.add(new Leon(10));
        set.add(new Leon(5));
        System.out.println(set);

        Map<Leon, String> map = new TreeMap<>(leonComparator);
        map.put(new Leon(1), "Child");
        map.put(new Leon(10), "Cool");
        map.put(new Leon(100), "Amazing");
        System.out.println(map);
    }
}

class Leon {
    int victims;
    public Leon(int victims) { this.victims = victims; }
    public String toString() { return String.valueOf(victims); }
}
