package java8professional.chapter03.sorting;

import java.util.Set;
import java.util.TreeSet;

public class UseTreeSet {

    static class Rabbit { int id; }

    public static void main(String[] args) {
        Set<Rabbit> rabbits = new TreeSet<>((r1, r2) -> r1.id - r2.id);
        rabbits.add(new Rabbit());
    }

}
