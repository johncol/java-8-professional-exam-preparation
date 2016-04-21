package java8professional.chapter02.functionalprogramming;

import java.util.function.Predicate;

public class Animal {

    private String species;
    private boolean canHop;
    private boolean canSwim;

    public Animal(String species, boolean canHop, boolean canSwim) {
        this.species = species;
        this.canHop = canHop;
        this.canSwim = canSwim;
    }

    public String getSpecies() {
        return species;
    }

    public boolean isCanHop() {
        return canHop;
    }

    public boolean isCanSwim() {
        return canSwim;
    }

    @Override
    public String toString() {
        return species;
    }
}

@FunctionalInterface
interface CheckTrait {
    boolean test(Animal animal);
}

class FindMatchAnimals {
    static void print1(Animal animal, CheckTrait trait) {
        if (trait.test(animal)) {
            System.out.println(animal + " passes the test");
        } else {
            System.out.println(animal + " DOESN'T passe the test");
        }
    }
    static void print2(Animal animal, Predicate<Animal> trait) {
        if (trait.test(animal)) {
            System.out.println(animal + " passes the test");
        } else {
            System.out.println(animal + " DOESN'T passe the test");
        }
    }
    public static void main(String[] args) {
        Animal fish = new Animal("Fish", false, true);
        print1(fish, a -> a.isCanSwim());
        print1(fish, a -> a.isCanHop());
        print1(fish, a -> true);
        print2(fish, a -> a.isCanSwim());
        print2(fish, a -> a.isCanHop());
        print2(fish, a -> true);
    }
}
