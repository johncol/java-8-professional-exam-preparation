package java8professional.chapter03.generics.wildcards.lowerbounded;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LowerBounded {

    public static void main(String[] args) {

        List<? super IOException> list = new ArrayList<Exception>();

        // doesn't compile
        // list.add(new Object());
        // list.add(new Exception());

        list.add(new IOException());
        list.add(new FileNotFoundException());
    }

}
