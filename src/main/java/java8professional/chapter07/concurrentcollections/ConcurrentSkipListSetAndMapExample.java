package java8professional.chapter07.concurrentcollections;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentSkipListSetAndMapExample {
    public static void main(String[] args) {
        Set<String> concurrentTreeSet = new ConcurrentSkipListSet<>();
        concurrentTreeSet.add("one");
        concurrentTreeSet.add("two");
        concurrentTreeSet.add("three");
        concurrentTreeSet.add("four");
        System.out.println("ConcurrentSkipListSet: " + concurrentTreeSet);

        System.out.println();

        Map<String, Integer> concurrentTreeMap = new ConcurrentSkipListMap<>();
        concurrentTreeMap.put("one", 1);
        concurrentTreeMap.put("two", 2);
        concurrentTreeMap.put("three", 3);
        concurrentTreeMap.put("four", 4);
        System.out.println("ConcurrentSkipListMap: " + concurrentTreeMap);
    }
}
