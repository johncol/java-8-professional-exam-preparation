package java8professional.chapter03.comparison;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTestJava8NiceStaticMethods {

    public static void main(String[] args) {
        List<Squirrel> list = Arrays.asList(
                new Squirrel("A", 3),
                new Squirrel("B", 10),
                new Squirrel("A", 2),
                new Squirrel("A", 1),
                new Squirrel("A", 0),
                new Squirrel("C", 0)
        );

        System.out.println(list);

        Collections.sort(list, new SquirrelNameAndWeightComparator());
        System.out.println(list);

        Collections.sort(list, new SquirrelNameAndWeightChainedComparator());
        System.out.println(list);
    }

}

class Squirrel {

    private String name;
    private int weight;

    Squirrel(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name + "(" + weight + ")";
    }
}

class SquirrelNameAndWeightComparator implements Comparator<Squirrel> {

    @Override
    public int compare(Squirrel s1, Squirrel s2) {
        Comparator<Squirrel> comparator = Comparator.comparing(s -> s.getName());
        comparator = comparator.thenComparingInt(s -> s.getWeight());
        return comparator.compare(s1, s2);
    }

}

class SquirrelNameAndWeightChainedComparator implements Comparator<Squirrel> {

    @Override
    public int compare(Squirrel s1, Squirrel s2) {
        return Comparator
                .comparing((Squirrel s) -> s.getName())
                .thenComparingInt((Squirrel s) -> s.getWeight())
                .compare(s1, s2);
    }

}
