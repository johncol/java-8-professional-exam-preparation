package java8professional.chapter03.review;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sorting {

    public static void main(String[] args) {
        int[] numbers = {9, 3, 6, 7, 4, 2, 9, 8};
        System.out.println(Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        System.out.println(Arrays.binarySearch(numbers, 3));
        System.out.println(Arrays.binarySearch(numbers, 9));
        System.out.println(Arrays.binarySearch(numbers, 10));

        List<Integer> numbersList = Arrays.asList(9, 3, 6, 7, 4, 2, 9, 8);
        System.out.println(numbersList);
        Collections.sort(numbersList);
        System.out.println(numbersList);

        System.out.println(Collections.binarySearch(numbersList, 3));
        System.out.println(Collections.binarySearch(numbersList, 9));
        System.out.println(Collections.binarySearch(numbersList, 10));
    }

}
