package java8professional.chapter03.generics;

import java.util.ArrayList;
import java.util.List;

public class RawCollections {
}

class Cat {}
class Dog {}

class Test {
    public static void main(String[] args) {
        List cats = new ArrayList();
        cats.add(new Cat());
        printCats(cats);
        printDogs(cats);
    }
    static void printDogs(List<Dog> dogs) {
        for (Dog dog: dogs) {
            System.out.println("dog");
        }
    }
    static void printCats(List<Cat> cats) {
        for (Cat cat: cats) {
            System.out.println("cat");
        }
    }
}

class Test2 {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());
        addCat(cats);
        Cat cat1 = cats.get(0);
        Cat cat2 = cats.get(1);

    }
    static void addCat(List cats) {
        cats.add(new Dog());
    }

}