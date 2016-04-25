package java8professional.chapter02.designpatterns.builder;

import java8professional.chapter02.designpatterns.inmmutable.Animal;

import java.util.Arrays;
import java.util.List;

public class AnimalBuilder {

    private String species;
    private int age;
    private List<String> favoriteFoods;

    private AnimalBuilder() {}

    public static AnimalBuilder anAnimal() {
        return new AnimalBuilder();
    }

    public AnimalBuilder withSpecies(String species) {
        this.species = species;
        return this;
    }

    public AnimalBuilder withAge(int age) {
        this.age = age;
        return this;
    }

    public AnimalBuilder withFavoriteFoods(List<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
        return this;
    }

    public Animal build() {
        return new Animal(species, age, favoriteFoods);
    }

    public static void main(String[] args) {
        Animal animal = AnimalBuilder.anAnimal()
                .withSpecies("Dog")
                .withAge(10)
                .withFavoriteFoods(Arrays.asList("Meat", "Sausages", "Chicken"))
                .build();
        System.out.println(animal);
    }

}
