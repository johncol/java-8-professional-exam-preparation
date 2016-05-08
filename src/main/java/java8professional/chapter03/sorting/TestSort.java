package java8professional.chapter03.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestSort {

    static class Rabbit {
        int id;
        Rabbit(int id) { this.id = id; }
        public String toString() { return String.valueOf(id); }
    }

    public static void main(String[] args) {
        testCollectionsSortWithComparator();
        System.out.println();
        testBinarySearchWithReverseComparator();
    }

    private static void testCollectionsSortWithComparator() {
        List<Rabbit> rabbits = Arrays.asList(new Rabbit(100), new Rabbit(1), new Rabbit(10));
        System.out.println(rabbits);

        // will not compile because rabbit does not implement comparable:
        // Collections.sort(rabbits);

        Collections.sort(rabbits, (r1, r2) -> r1.id - r2.id);
        System.out.println(rabbits);
    }

    private static void testBinarySearchWithReverseComparator() {
        Comparator<String> reverse = Comparator.reverseOrder();

        List<String> names = Arrays.asList("Fluffy", "Hoppy");
        Comparator<String> c = Comparator.reverseOrder();
        int index = Collections.binarySearch(names, "Fluffy", c);
        System.out.println(index);
    }

}
