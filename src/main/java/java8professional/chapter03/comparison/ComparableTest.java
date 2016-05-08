package java8professional.chapter03.comparison;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparableTest {

    public static void main(String[] args) {
        List<Duck> ducks = Arrays.asList(
                new Duck("Hugo"),
                new Duck("Paco"),
                new Duck("Lucas")
        );
        System.out.println(ducks);
        Collections.sort(ducks);
        System.out.println(ducks);
    }

}

class Duck implements Comparable<Duck> {

    private String name;

    Duck(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Duck other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name;
    }

}