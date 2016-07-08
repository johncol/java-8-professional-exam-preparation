package java8professional.all;

public class FunctionalInterfaceExample {}

@java.lang.FunctionalInterface
interface SomeFunctionalInterface {

    /**
     * This one remains hte only abstract method of the interface
     */
    void method1();

    static void method2() {
        System.out.println("Static method in functional interface");
    }

    default void method3() {
        System.out.println("Default method implementation for interface method");
    }

}