package java8professional.all;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Stream;

public class ConcurrentCollections {
    Map<String, String> map = new ConcurrentSkipListMap<>();
    Set<String> set = new ConcurrentSkipListSet<>();


    public static void main(String[] args) {
        Deque<String> deque = new ConcurrentLinkedDeque<>();
        deque.push("1");
        deque.push("2");
        System.out.println(deque);
        Queue<String> queue = new ConcurrentLinkedQueue<>();
        queue.offer("1");
        queue.offer("2");
    }

}
