package java8professional.all;

public class Overloading {

    static void method(Integer value) {
        System.out.println("Integer");
    }

    static void method(Number value) {
        System.out.println("Number");
    }

    static void method(int value) {
        System.out.println("int");
    }

    static void method(long value) {
        System.out.println("long");
    }

    static void method(int... value) {
        System.out.println("int varargs");
    }

    static void method(int value, int... values) {
        System.out.println("int varargs");
    }

    public static void main(String[] args) {
        Integer value = 10;
    }

}

class IDontCare {}