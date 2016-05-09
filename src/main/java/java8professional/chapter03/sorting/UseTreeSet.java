package java8professional.chapter03.sorting;

import java.util.Set;
import java.util.TreeSet;

public class UseTreeSet {

    static class Rabbit { int id; }

    public static void main(String[] args) {
        Set<Rabbit> rabbits = new TreeSet<>();
        rabbits.add(new Rabbit());
    }

}
