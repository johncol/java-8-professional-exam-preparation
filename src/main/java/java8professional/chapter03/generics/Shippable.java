package java8professional.chapter03.generics;

public interface Shippable<T> {

    void ship(T content);

}

class ShippableString implements Shippable<String> {

    public void ship(String content) {
        System.out.println("Shipping string: " + content);
    }

}

class ShippableSomething<U> implements Shippable<U> {

    public void ship(U content) {
        System.out.println("Shipping something: " + content);
    }

}

class ShippableObject implements Shippable {

    public void ship(Object content) {
        System.out.println("Shipping object: " + content);
    }

}

