package java8professional.chapter03.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapMethods {

    public static void main(String[] args) {
        hashMap();
        System.out.println("----------------");
        treeMap();
        System.out.println("----------------");
        general();
    }

    static void hashMap() {
        Map<String, String> map = new HashMap<>();
        System.out.println(map.put("koala", "bamboo"));
        System.out.println(map.put("lion", "meat"));
        System.out.println(map.put("giraffe", "leaf"));
        System.out.println(map.put("giraffe", "leaf"));
        System.out.println();

        System.out.println(map.get("koala"));

        System.out.println("keys:");
        map.keySet().forEach(k -> System.out.print(k + ", "));
        System.out.println();

        System.out.println("values:");
        map.values().forEach(v -> System.out.print(v + ", "));
        System.out.println();
    }

    static void treeMap() {
        Map<String, String> map = new TreeMap<>();
        System.out.println(map.put("koala", "bamboo"));
        System.out.println(map.put("lion", "meat"));
        System.out.println(map.put("giraffe", "leaf"));
        System.out.println(map.put("giraffe", "leaf"));
        System.out.println();

        System.out.println(map.get("koala"));

        System.out.println("keys:");
        map.keySet().forEach(k -> System.out.print(k + ", "));
        System.out.println();

        System.out.println("values:");
        map.values().forEach(v -> System.out.print(v + ", "));
        System.out.println();
    }

    static void general() {
        Map<String, String> map = new TreeMap<>();
        map.put("koala", "bamboo");
        map.put("lion", "meat");
        map.put("giraffe", "leaf");

        System.out.println(map.size());
        System.out.println(map.containsKey("lion"));
        System.out.println(map.containsValue("lion"));
    }
}
