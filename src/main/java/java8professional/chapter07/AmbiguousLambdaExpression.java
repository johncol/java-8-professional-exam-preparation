package java8professional.chapter07;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class AmbiguousLambdaExpression {

    static void callable(Callable<Integer> callable) {
        System.out.println("callable");
    }

    static void supplier(Supplier<Integer> supplier) {
        System.out.println("supplier");
    }

    static void both(Supplier<Integer> supplier) {
        System.out.println("both->supplier");
    }

    static void both(Callable<Integer> callable) {
        System.out.println("both->callable");
    }

    public static void main(String[] args) {
        callable(() -> 1);
        supplier(() -> 1);
        //both(() -> 1); // doesn't compile: ambiguous method call
        both((Callable<Integer>) () -> 1);
        both((Supplier<Integer>) () -> 1);

        System.out.println();

        callable(() -> { throw new Exception(""); });
        supplier(() -> { throw new RuntimeException(""); });
        //both(() -> { throw new Exception(""); }); // doesn't compile: ambiguous method call even though only the callable one can throw a checked exception
        both((Callable<Integer>) () -> { throw new Exception(""); });
        both((Supplier<Integer>) () -> { throw new RuntimeException(""); });
    }

}
