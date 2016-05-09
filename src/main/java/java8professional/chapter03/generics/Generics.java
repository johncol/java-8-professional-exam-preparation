package java8professional.chapter03.generics;

public class Generics<T> {

    //static T type;      // DOES NOT COMPILE

    T[] field;

    Generics(T input) {
        System.out.println("Generic class with parameter type " + input.getClass().getSimpleName());
        // input = new T();                 // DOES NOT COMPILE
        // if (input instanceof T) { }      // DOES NOT COMPILE
        // new Generics<int>(1);            // DOES NOT COMPILE
    }

    public static void main(String[] args) {
        new Generics<>(new Object());
    }

}

class NewGenerics<String> extends Generics<String> {

    public NewGenerics(String input) {
        super(input);
    }
}