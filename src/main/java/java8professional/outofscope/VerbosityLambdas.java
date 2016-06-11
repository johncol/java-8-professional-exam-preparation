package java8professional.outofscope;

import java.util.stream.IntStream;

import static java.util.stream.IntStream.*;

public class VerbosityLambdas {

    public static void main(String[] args) {
        printUntilJava8(5);
    }

    static void printUntilJava7(int limit) {
        for (int i = 1; i <= limit; i++) {
            System.out.println("Happy birthday " + (i == 3 ? "dear me" : "to you"));
        }
    }

    static void printUntilJava8(int limit) {
        rangeClosed(1, limit).forEach(i ->
                System.out.println("Happy birthday " + (i == 3 ? "dear me" : "to you"))
        );
    }

}
