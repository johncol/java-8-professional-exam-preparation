package java8professional.chapter07.syncronizing.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SynchronizedVsNotSynchronizedListWithParallelStreams {


    public static void main(String[] args) {
        synchronizedList();
        System.out.println();
        notSynchronizedList();
    }

    static void synchronizedList() {
        List<Integer> list = IntStream.rangeClosed(1, 1_000).boxed().collect(Collectors.toList());
        System.out.println("List size: " + list.size());

        List<Integer> newList = Collections.synchronizedList(new ArrayList<>());
        list.parallelStream().forEach(newList::add);
        System.out.println("New list size: " + newList.size());
    }

    /**
     * Sample outputs:
     *   -> List size: 1000
     *      New list size: 995
     *   -> List size: 1000
     *      New list size: 997
     *   -> List size: 1000
     *      New list size: 969
     *   -> ArrayIndexOutOfBoundsException
     */
    static void notSynchronizedList() {
        List<Integer> list = IntStream.rangeClosed(1, 1_000).boxed().collect(Collectors.toList());
        System.out.println("List size: " + list.size());

        List<Integer> newList = new ArrayList<>();
        list.parallelStream().forEach(newList::add);
        System.out.println("New list size: " + newList.size());
    }
}
