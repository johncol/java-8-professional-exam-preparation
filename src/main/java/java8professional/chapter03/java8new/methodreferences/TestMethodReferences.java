package java8professional.chapter03.java8new.methodreferences;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestMethodReferences {

    public static void main(String[] args) {

        List<Cat> cats = Arrays.asList(
                new Cat("cc", 60),
                new Cat("aa", 50),
                new Cat("bb", 20),
                new Cat("dd", 10),
                new Cat("ee", 30)
        );
        System.out.println(cats);

        Comparator<Cat> byName = (c1, c2) -> CatHelper.compareByName(c1, c2);
        Collections.sort(cats, byName);
        System.out.println(cats);

        Comparator<Cat> byWeight = CatHelper::compareByWeight;
        Collections.sort(cats, byWeight);
        System.out.println(cats);

        // ------------------------------------------------
        System.out.println();

        Consumer<List<String>> methodReference1 = Collections::sort;
        Consumer<List<String>> lambda1 = (list) -> Collections.sort(list);

        List<String> someLetters;

        someLetters = Arrays.asList("c", "a", "b");
        methodReference1.accept(someLetters);
        System.out.println(someLetters);

        someLetters = Arrays.asList("c", "a", "b");
        lambda1.accept(someLetters);
        System.out.println(someLetters);

        // ------------------------------------------------
        System.out.println();

        String someString = "adsdas";
        Predicate<String> methodReference2 = someString::startsWith;
        Predicate<String> lambda2 = s -> someString.startsWith(s);

        System.out.println(methodReference2.test("a"));
        System.out.println(methodReference2.test("d"));
        System.out.println(lambda2.test("a"));
        System.out.println(lambda2.test("d"));

        // ------------------------------------------------
        System.out.println();

        Predicate<String> methodReference3 = String::isEmpty;
        Predicate<String> lambda3 = s -> s.isEmpty();

        System.out.println(methodReference3.test(""));
        System.out.println(methodReference3.test("a"));
        System.out.println(lambda3.test(""));
        System.out.println(lambda3.test("a"));

        // ------------------------------------------------
        System.out.println();

        Supplier<Cat> methodReference4 = Cat::new;
        Supplier<Cat> lambda4 = () -> new Cat();
        Supplier<Animal> methodReference5 = Cat::new;
        Supplier<Animal> lambda5 = () -> new Cat();

        System.out.println(methodReference4.get());
        System.out.println(lambda4.get());
        System.out.println(methodReference5.get());
        System.out.println(lambda5.get());
    }

}

interface Animal {}

class Cat implements Animal {

    private String name;
    private int weight;

    public Cat() {}

    public Cat(String name) {
        this(name, 0);
    }

    public Cat(String name, int weight) {
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
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}

class CatHelper {

    public static int compareByName(Cat c1, Cat c2) {
        return c1.getName().compareTo(c2.getName());
    }

    public static int compareByWeight(Cat c1, Cat c2) {
        return c1.getWeight() - c2.getWeight();
    }

}
