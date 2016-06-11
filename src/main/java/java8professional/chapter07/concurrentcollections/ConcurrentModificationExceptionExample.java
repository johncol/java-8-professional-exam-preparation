package java8professional.chapter07.concurrentcollections;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentModificationExceptionExample {

    public static void main(String[] args) {
        tryAHashMap();
        System.out.println();
        tryAConcurrentHashMap();
    }

    static void tryAHashMap() {
        Map<String, String> map = new HashMap<>();
        map.put("phineas", "creative");
        map.put("phonlee", "non-existent");
        map.put("ferb", "smart");
        try {
            for (String character: map.keySet()) {
                System.out.println(character + " is " + map.get(character));
                if (character.startsWith("p")) {
                    map.remove(character);
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException!");
        }
        System.out.println("Map: " + map);
    }

    static void tryAConcurrentHashMap() {
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("phineas", "creative");
        map.put("phonlee", "non-existent");
        map.put("ferb", "smart");
        for (String character: map.keySet()) {
            System.out.println(character + " is " + map.get(character));
            if (character.startsWith("p")) {
                map.remove(character);
            }
        }
        System.out.println("Map: " + map);
    }
}
