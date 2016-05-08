package java8professional.chapter03.java8new.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapNewMethods {

    public static void main(String[] args) {
        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", null);
        favorites.put("London", null);
        System.out.println(favorites);

        favorites.putIfAbsent("Jenny", "Tram");
        favorites.putIfAbsent("Tom", "Tram");
        favorites.putIfAbsent("Sam", "Tram");
        System.out.println(favorites);

        BiFunction<String, String, String> mapper = (f1, f2) -> f1.length() >= f2.length() ? f1 : f2;

        favorites.merge("Jenny", "Tour", mapper);
        System.out.println(favorites);
        favorites.merge("Tom", "Tram tram", mapper);
        System.out.println(favorites);
        favorites.merge("London", "Whatever", mapper);
        System.out.println(favorites);

        BiFunction<String, String, String> onlyLeaveJenny = (f1, f2) -> f1.equals("Jenny") ? f1 : null;
        // java.util.ConcurrentModificationException
        // favorites.keySet().forEach(k -> favorites.merge(k, "", onlyLeaveJenny));
        // System.out.println(favorites);
        System.out.println();


        Map<String, Integer> counts = new HashMap<>();
        counts.put("Jenny", 1);
        System.out.println(counts);

        BiFunction<String, Integer, Integer> addOne = (k, v) -> v + 1;

        Integer resultForJenny = counts.computeIfPresent("Jenny", addOne);
        Integer resultForJohn = counts.computeIfPresent("John", addOne);
        System.out.println(resultForJenny);
        System.out.println(resultForJohn);
        System.out.println(counts);

        Function<String, Integer> startCounter = (k) -> 1;

        resultForJenny = counts.computeIfAbsent("Jenny", startCounter);
        resultForJohn = counts.computeIfAbsent("John", startCounter);
        System.out.println(resultForJenny);
        System.out.println(resultForJohn);
        System.out.println(counts);



    }
}
