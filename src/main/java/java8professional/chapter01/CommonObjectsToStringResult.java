package java8professional.chapter01;

import static java8professional.util.Utils.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class CommonObjectsToStringResult {

    public static void main(String[] args) {
        String[] array = {"a", "b", "c"};
        print("Array: " + array);

        List<String> list = Arrays.asList("a", "b", "c");
        print("List: " + list);

        Set<String> set = new HashSet<>(list);
        print("Set: " + set);

        Queue<String> queue = new PriorityQueue<>(list);
        print("Queue: " + queue);
    }

    @Override
    public String toString() {
        return "awesome";
    }
}
