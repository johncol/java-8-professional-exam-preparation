package java8professional.chapter03.comparison;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

    public static void main(String[] args) {

        List<Dog> dogs = Arrays.asList(
                new Dog("Pluto", 10),
                new Dog("Huesos", 7),
                new Dog("Scooby Doo", 1)
        );

        System.out.println(dogs);

        Collections.sort(dogs);
        System.out.println(dogs);

        Comparator<Dog> byWeight = new Comparator<Dog>() {
            public int compare(Dog dog1, Dog dog2) {
                return dog1.getWeight() - dog2.getWeight();
            }
        };

        Collections.sort(dogs, byWeight);
        System.out.println(dogs);

        Comparator<Dog> byWeightAsLambda = (dog1, dog2) -> dog1.getWeight() - dog2.getWeight();

        Collections.sort(dogs, byWeightAsLambda);
        System.out.println(dogs);
    }

}

class Dog implements Comparable<Dog> {

    private String name;
    private int weight;

    Dog(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Dog other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name;
    }

}