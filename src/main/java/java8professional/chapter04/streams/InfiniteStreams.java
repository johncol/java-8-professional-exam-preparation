package java8professional.chapter04.streams;

import java.util.stream.Stream;

public class InfiniteStreams {

    public static class Randoms {
        public static void main(String[] args) {
            Stream<Double> randoms = Stream.generate(Math::random);
            randoms.forEach(System.out::println);
        }
    }

    public static class OddNumbers {
        public static void main(String[] args) {
            Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
            oddNumbers.forEach(System.out::println);
        }
    }

    public static class ConcatStreams {
        public static void main(String[] args) {
            Stream<Integer> stream1 = Stream.of(4, 5, 6);
            Stream<Integer> stream2 = Stream.iterate(1, x -> x + 1).limit(3);
            Stream<Integer> concat = Stream.concat(stream1, stream2);
            concat.forEach(System.out::println);
        }
    }

}
