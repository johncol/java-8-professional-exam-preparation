package java8professional.chapter04.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SimpleStreams {

    public static void main(String[] args) {

        Stream<String> empty = Stream.empty();
        System.out.println(empty);
        System.out.println(empty.count());

        Stream<String> empty2 = Stream.of();
        System.out.println(empty2);
        System.out.println(empty2.count());

        Stream<Integer> oneElement = Stream.of(6);
        System.out.println(oneElement);
        System.out.println(oneElement.count());

        Stream<Integer> severalElements = Stream.of(1, 2, 3);
        System.out.println(severalElements);
        System.out.println(severalElements.count());


        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        Stream<Integer> listStream = list.stream();
        System.out.println(listStream);
        System.out.println(listStream.count());

        Stream<Integer> parallelListStream = list.parallelStream();
        System.out.println(parallelListStream);
        System.out.println(parallelListStream.count());

    }

}
