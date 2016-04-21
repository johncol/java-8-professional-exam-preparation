package java8professional.chapter02.functionalprogramming;

public class FunctionalInterfaceAnnotation {}

@FunctionalInterface
interface Sprint {
    void sprint(String animal);
}

class Tiger implements Sprint {
    public void sprint(String animal) {
        System.out.println(animal + " is sprinting fast!");
    }
}

@FunctionalInterface
interface Run extends Sprint {}

@FunctionalInterface
interface SprintFaster extends Sprint {
    void sprint(String animal);
}

@FunctionalInterface
interface Skip extends Sprint {
    default void stop() {}
    static void skip() {
        System.out.println("Skip!!");
    }
}
