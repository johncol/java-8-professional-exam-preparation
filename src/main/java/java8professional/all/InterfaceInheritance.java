package java8professional.all;

public class InterfaceInheritance {
}

interface InterfaceA {
    void someMethod() throws Exception;
}

interface InterfaceB extends InterfaceA {
    @Override
    void someMethod() throws Exception;
}

interface Interface1 {}
interface Interface2 {}
interface Interface3 {}
interface TheInterface extends Interface1, Interface2, Interface3 {}