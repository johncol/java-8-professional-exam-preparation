package java8professional.all;

import java.util.function.BiFunction;

public class BiFunctionExample {
    BiFunction<String, Integer, MyClass> biFunction = MyClass::new;
}


class MyClass {

    String string;
    Integer integer;

    public MyClass(String string, Integer integer) {
        this.string = string;
        this.integer = integer;
    }
}