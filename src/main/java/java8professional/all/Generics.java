package java8professional.all;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Generics {
    static class First extends Second {}
    static class Second {}
}

class Crate<Crate> {
    Crate t;
    Crate(Crate t) { this.t = t; }
    Crate get() { return this.t; }
}

interface Shippable<T> {}
class A implements Shippable {}
class B<T> implements Shippable<T> {}
class C implements Shippable<String> {}
class D<T> implements Shippable<String> {}

class GenericsMethods {
    protected static <T> T staticMethod(T t) { return t; }
    public <U> void instanceMethod(U u) { }
}

class InputRecorder<T extends InputStream> {}
class IDoNotKnow {
    <T extends Writer> void one() {}

    void print0(List<?> list) {}
    void print1(List<? extends FileWriter> list) {}
    void print2(List<? super FileWriter> list) {}

    {
        //List<Number> nums1 = new ArrayList<Integer>(); // will not work
        List<? extends Number> nums2 = new ArrayList<Integer>();
    }
}


interface Flayer { void fly(); }
class Goose implements Flayer { public void fly() {} }
class Some {
    static void anyFlayer(List<Flayer> flayer) {}
    static void groupOfFlayers(List<? extends Flayer> flayer) {}
    static {
        List<Flayer> flayers = new ArrayList<>();
        anyFlayer(flayers);
        groupOfFlayers(flayers);

        List<Goose> gooses = new ArrayList<>();
        //anyFlayer(gooses); // will not work
        groupOfFlayers(gooses);
    }
}

class LowerBoundedWildcardsGenerics {
    {
        List<? super IOException> exceptions = new ArrayList<Exception>();

        // will not work because the type pf the list is unknown, and for java, it could be a list of IOExceptions and
        // an Exception cannot be added to a list of IOExceptions
        // exceptions.add(new Exception());

        exceptions.add(new IOException());
        exceptions.add(new FileNotFoundException());
    }
}