package java8professional.all;

import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.Collectors;

public class ParallelReductions {
    public static void main(String[] args) {
        System.out.println(Arrays.asList('w', 'o', 'l', 'f')
                .stream()
                .parallel()
                .reduce("a",
                        (c,s1) -> c + s1,
                        (s2,s3) -> {
                            System.out.println("fdsfgsdf");
                            return s2 + s3;
                        }));
    }
}
