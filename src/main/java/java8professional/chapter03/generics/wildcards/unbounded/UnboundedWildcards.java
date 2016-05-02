package java8professional.chapter03.generics.wildcards.unbounded;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnboundedWildcards {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "c");
        addNew(strings);
        allowedAndNotAllowed();
    }

    // doesn't compile because of erasure, the compiler result for this two methods will be exactly the same
    //public static void addNew(List<Object> objects) {
    //    objects.stream().forEach(System.out::println);
    //}

    public static void addNew(List<?> objects) {
        objects.stream().forEach(System.out::println);
    }

    public static void allowedAndNotAllowed() {
        //List<Object> objects = new ArrayList<String>();
        Object[] objects = new String[5];
        objects[0] = 4; // it compiles, but throws a java.lang.ArrayStoreException
    }

}
