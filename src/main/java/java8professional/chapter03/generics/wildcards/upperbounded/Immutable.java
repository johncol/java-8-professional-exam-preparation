package java8professional.chapter03.generics.wildcards.upperbounded;

import java.util.ArrayList;
import java.util.List;

public class Immutable {

    public static void main(String[] args) {
        List<? extends Bird> birds = new ArrayList<>();
        // birds.add(new Bird());     // doesn't compile
        // birds.add(new Sparrow());  // doesn't compile
    }

}

class Bird {}
class Sparrow extends Bird {}


