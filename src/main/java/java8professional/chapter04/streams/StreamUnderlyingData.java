package java8professional.chapter04.streams;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Stream;

public class StreamUnderlyingData {
    public static void main(String[] args) {
        List<Integer> numbers = Lists.newArrayList(1, 2, 3);
        System.out.println(numbers);

        Stream<Integer> stream = numbers.stream();

        numbers.add(4);
        System.out.println(numbers);

        System.out.println();
        stream.forEach(System.out::println);
    }
}
