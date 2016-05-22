package java8professional.chapter04.collectors;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SomeCollectors {
    public static void main(String[] args) {
        String result1 = Stream.of("a", "b", "c").collect(Collectors.joining(", "));
        System.out.println(result1);
        System.out.println();

        Double averageLength = Stream.of("a", "bb", "ccc").collect(Collectors.averagingInt(String::length));
        System.out.println(averageLength);
        System.out.println();

        System.out.println(Stream.of("a", "bb").count());
        System.out.println(Stream.of("a", "bb").collect(Collectors.counting()));
        System.out.println();

        Optional<String> max = Stream.of("aaa", "bb", "c").collect(Collectors.maxBy(Comparator.comparingInt(String::length)));
        max.ifPresent(System.out::println);
        Optional<String> min = Stream.of("aaa", "bb", "c").collect(Collectors.minBy(Comparator.comparingInt(String::length)));
        min.ifPresent(System.out::println);
        System.out.println();

        IntSummaryStatistics intSummaryStatistics1 = IntStream.rangeClosed(0, 10).summaryStatistics();
        System.out.println(intSummaryStatistics1);
        IntSummaryStatistics intSummaryStatistics2 = IntStream.rangeClosed(0, 10).mapToObj(x -> x).collect(Collectors.summarizingInt((x) -> x));
        System.out.println(intSummaryStatistics2);
        System.out.println();

        double sum1 = DoubleStream.of(1, 2, 3).sum();
        System.out.println(sum1);
        Double sum2 = DoubleStream.of(1, 2, 3).mapToObj(x -> x).collect(Collectors.summingDouble(x -> x));
        System.out.println(sum2);
        System.out.println();

        List<String> list = Stream.of("a", "b", "a").collect(Collectors.toList());
        System.out.println(list);
        Set<String> set = Stream.of("a", "b", "a").collect(Collectors.toSet());
        System.out.println(set);
        System.out.println();

        LinkedList<String> linkedList = Stream.of("a", "b", "a").collect(Collectors.toCollection(LinkedList::new));
        System.out.println(linkedList);
        LinkedHashSet<String> linkedHashSet = Stream.of("a", "b", "a").collect(LinkedHashSet::new, LinkedHashSet::add, LinkedHashSet::addAll);
        System.out.println(linkedHashSet);

        Stream<String> animals = Stream.of("lions", "tigers", "bears", "sharks");
        Map<String, Integer> animalsMap = animals.collect(Collectors.toMap(x -> x, x -> x.length()));
        System.out.println(animalsMap);
        System.out.println();

        animals = Stream.of("lions", "tigers", "bears", "sharks");
        animalsMap = animals.collect(Collectors.toMap(Function.identity(),x -> x.length()));
        System.out.println(animalsMap);
        System.out.println();

        animals = Stream.of("lions", "tigers", "bears", "sharks", "cats", "dogs", "bees");
        Map<Integer, String> lengthMap = animals.collect(Collectors.toMap(String::length, Function.identity(), (v1, v2) -> v1 + "-" + v2));
        System.out.println(lengthMap);
        System.out.println(lengthMap.getClass());
        System.out.println();

        animals = Stream.of("lions", "tigers", "bears", "sharks", "cats", "dogs", "bees");
        Function<String, Integer> keyFunction = String::length;
        Function<String, String> valueFunction = Function.identity();
        BinaryOperator<String> severalValuesBinaryOperator = (v1, v2) -> v1 + "-" + v2;
        Supplier<LinkedHashMap<Integer, String>> mapImplementationSupplier = LinkedHashMap::new;
        lengthMap = animals.collect(Collectors.toMap(keyFunction, valueFunction, severalValuesBinaryOperator, mapImplementationSupplier));
        System.out.println(lengthMap);
        System.out.println(lengthMap.getClass());
        System.out.println();

        animals = Stream.of("lions", "tigers", "bears", "sharks", "cats", "dogs", "bees", "bees");
        Map<Integer, List<String>> nameLengthToNamesMap = animals.collect(Collectors.groupingBy(String::length));
        System.out.println(nameLengthToNamesMap);
        System.out.println(nameLengthToNamesMap.getClass().getSimpleName());
        System.out.println();

        animals = Stream.of("lions", "tigers", "bears", "sharks", "cats", "dogs", "bees", "bees");
        Map<Integer, Set<String>> nameLengthToNamesSetMap = animals.collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println(nameLengthToNamesSetMap);
        System.out.println(nameLengthToNamesSetMap.getClass().getSimpleName());
        System.out.println();

        animals = Stream.of("lions", "tigers", "bears", "sharks", "cats", "dogs", "bees", "bees");
        nameLengthToNamesSetMap = animals.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
        System.out.println(nameLengthToNamesSetMap);
        System.out.println(nameLengthToNamesSetMap.getClass().getSimpleName());
        System.out.println();

        animals = Stream.of("lions", "tigers", "bears", "sharks", "cats", "dogs", "bees", "bees");
        Map<Integer, Long> nameLengthToQuantityMap = animals.collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(nameLengthToQuantityMap);
        System.out.println();

        animals = Stream.of("lions", "tigers", "bears", "sharks", "cats", "dogs", "bees", "bees");
        Map<Boolean, List<String>> fourLetterAnimal = animals.collect(Collectors.partitioningBy(a -> a.length() == 4));
        System.out.println(fourLetterAnimal);
        System.out.println();

        animals = Stream.of("lions", "tigers", "bears", "sharks", "cats", "dogs", "bees", "bees");
        Map<Integer, Optional<Character>> lengthToFirstCharacterMap =
                animals.collect(
                        Collectors.groupingBy(
                                String::length,
                                Collectors.mapping((String s) -> s.charAt(0), Collectors.minBy(Comparator.naturalOrder()))));
        System.out.println(lengthToFirstCharacterMap);
        System.out.println();
    }
}
