package java8professional.chapter07.syncronizing.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SynchronizedCollections {
    public static void main(String[] args) {
        List<Integer> list = IntStream.range(1, 11).boxed().collect(Collectors.toList());
        List<Integer> synchronizedList = Collections.synchronizedList(list);

        System.out.println(synchronizedList);
        synchronized (synchronizedList) {
            for (Integer integer : synchronizedList) {
                System.out.print(integer + " ");
            }
        }
    }
}
