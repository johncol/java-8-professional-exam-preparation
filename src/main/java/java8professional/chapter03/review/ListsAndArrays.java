package java8professional.chapter03.review;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ListsAndArrays {

    public static void main(String[] args) {
        List<String> list =  new ArrayList<>();
        list.add("Fluffy");
        list.add("Webby");
        System.out.println(list);

        String[] array = new String[list.size()];
        array[0] = list.get(0);
        array[1] = list.get(1);
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        array = new String[] {"gerbil", "mouse"};
        list = Arrays.asList(array);
        System.out.println(Arrays.toString(array));
        System.out.println(list);

        array[0] = "new";
        list.set(1, "test");
        System.out.println(Arrays.toString(array));
        System.out.println(list);

        try {
            list.add("will fail! (UnsupportedOperationException)");
        } catch(UnsupportedOperationException e) {
            System.out.println("failed! UnsupportedOperationException");
        }

        try {
            list.remove(0);
        } catch(UnsupportedOperationException e) {
            System.out.println("failed! UnsupportedOperationException");
        }
    }

}
