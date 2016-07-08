package java8professional.all;

import java.util.Arrays;
import java.util.List;

public class FromArrayToList {
}

class ArraysAsList {
    public static void main(String[] args) {
        String[] array = { "a", "b" };
        List<String> list = Arrays.asList(array);

        System.out.println(Arrays.toString(array));
        System.out.println(list);

        array[0] = "c";
        list.set(1, "d");

        System.out.println(Arrays.toString(array));
        System.out.println(list);

        String[] newArray = list.toArray(new String[2]);
        System.out.println(array.equals(newArray));
        System.out.println(array == newArray);
    }
}
