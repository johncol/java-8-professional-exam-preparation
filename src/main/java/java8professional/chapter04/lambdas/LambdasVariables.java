package java8professional.chapter04.lambdas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Supplier;

public class LambdasVariables {

    private static final String CONSTANT = "CONSTANT";

    private String someField = "someField";

    void someMethod(String methodArgument) {
        String someVariable = "someVariable";
        printIt(() -> "string");
        printIt(() -> 10);
        printIt(() -> new StringBuilder("string builder"));
        printIt(() -> new HashMap<>());
        printIt(() -> {
            System.out.println(methodArgument);
            System.out.println(someVariable);
            System.out.println(CONSTANT);
            System.out.println(someField);
            return new ArrayList<>();
        });
    }

    static void printIt(Supplier<?> supplier) {
        System.out.println(supplier.get());
    }

    public static void main(String[] args) {
        new LambdasVariables().someMethod("methodArgument");
    }


}

