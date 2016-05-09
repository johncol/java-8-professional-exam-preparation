package java8professional.chapter03.generics;

import java8professional.chapter02.functionalprogramming.Animal;

import java.util.List;

public class MethodGenerics {
}

class Whatever {

    static <T> T identity(T t) {
        System.out.println("identity:" + t + ", " + t.getClass().getSimpleName());
        return t;
    }

    static <T> void printIt(T t) {
        System.out.println("input :" + t);
    }

    <T> void nonStaticMethod(T t) {
        System.out.println("non static method input:" + t);
    }

    public static void main(String[] args) {
        Whatever.identity("hi1");
        Whatever.<String>identity("hi1");

        new Whatever().nonStaticMethod(false);
        new Whatever().<Integer>nonStaticMethod(5);
    }

}

abstract class WhateverAbstract<T> {

    T instance;

    public WhateverAbstract(T instance) {
        this.instance = instance;
    }

    abstract <U> void getClone(U whatever);

    abstract <U extends T> void getClone2(U whatever);

    // does not compile
    // abstract <V super T> void getClone3(V whatever);

    abstract void doSomething(List<? super T> list);

}