package java8professional.tests;

public class InheritedStaticMethods {
    public static void main(String[] args) {
        B.hi();
    }
}

class A {
    public static void hi() {
        System.out.println("hi");
    }
}

class B extends A {}